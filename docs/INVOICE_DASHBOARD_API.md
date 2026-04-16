# 📊 API Dashboard de Facturas - Documentación

## Descripción General

API REST de **solo consulta** que retorna un dashboard completo de facturas para un periodo
de fechas seleccionado. Usa **una sola consulta SQL** que trae las facturas con JOIN a la
tabla cliente, y luego procesa los tres bloques de datos en Java.

---

## 🔗 Endpoint

```
GET /api/v1/invoices/dashboard?fechaInicio={yyyy-MM-dd}&fechaFin={yyyy-MM-dd}
```

### Parámetros

| Parámetro     | Tipo   | Requerido | Formato    | Ejemplo      | Descripción                    |
|---------------|--------|-----------|------------|--------------|--------------------------------|
| `fechaInicio` | String | ✅ Sí     | yyyy-MM-dd | `2026-01-01` | Fecha inicio del periodo       |
| `fechaFin`    | String | ✅ Sí     | yyyy-MM-dd | `2026-01-31` | Fecha fin del periodo          |

---

## 📦 Respuesta JSON

La respuesta contiene **tres bloques de datos**:

```json
{
  "message": "Operación realizada con éxito",
  "results": {
    "registros": [ ... ],
    "clienteMayorFacturacion": { ... },
    "ventasPorDia": [ ... ]
  }
}
```

### 1️⃣ `registros` — Tabla de facturas del periodo

Todos los registros encontrados en el periodo seleccionado (incluye Activas y Anuladas).

| Campo           | Tipo    | Descripción                         |
|-----------------|---------|-------------------------------------|
| `factId`        | Integer | Número de factura (No)              |
| `factFecha`     | String  | Fecha de la factura (yyyy-MM-dd)    |
| `clienteNombre` | String  | Razón social del cliente            |
| `factTotal`     | Integer | Valor total de venta                |
| `factEstado`    | String  | Estado (Activo, Anulada, etc.)      |

```json
"registros": [
  { "factId": 1, "factFecha": "2026-01-01", "clienteNombre": "FUNDIMOS TYC", "factTotal": 50000, "factEstado": "Activo" },
  { "factId": 2, "factFecha": "2026-01-01", "clienteNombre": "FUNDIMOS TYC", "factTotal": 23000, "factEstado": "Activo" },
  { "factId": 5, "factFecha": "2026-01-01", "clienteNombre": "Bronalco", "factTotal": 52000, "factEstado": "Anulada" }
]
```

### 2️⃣ `clienteMayorFacturacion` — Cliente con mayor facturación (solo Activas)

El cliente con el mayor valor total facturado, considerando **solo facturas con estado "Activo"**.

| Campo            | Tipo   | Descripción                               |
|------------------|--------|-------------------------------------------|
| `clienteNombre`  | String | Razón social del cliente                  |
| `totalFacturado` | Long   | Suma total de facturas activas del cliente|

```json
"clienteMayorFacturacion": {
  "clienteNombre": "Bronalco",
  "totalFacturado": 286000
}
```

### 3️⃣ `ventasPorDia` — Ventas consolidadas por día (solo Activas, para gráfica)

Ventas agrupadas por día, sumando `fact_total` de **solo facturas con estado "Activo"**.
Datos pensados para alimentar una gráfica en el frontend.

| Campo        | Tipo   | Descripción                            |
|--------------|--------|----------------------------------------|
| `fecha`      | String | Fecha del día (yyyy-MM-dd)             |
| `totalVenta` | Long   | Suma de fact_total activas de ese día  |

```json
"ventasPorDia": [
  { "fecha": "2026-01-01", "totalVenta": 178000 },
  { "fecha": "2026-01-02", "totalVenta": 119000 },
  { "fecha": "2026-01-03", "totalVenta": 286000 }
]
```

---

## 🗄️ Consulta SQL (Una Sola)

```sql
SELECT f.fact_id            AS factId,
       f.fact_fecha         AS factFecha,
       c.cli_razon_social   AS clienteNombre,
       f.fact_total         AS factTotal,
       f.fact_estado        AS factEstado
FROM   factura f
INNER JOIN cliente c ON f.cli_nit = c.cli_nit
WHERE  f.fact_fecha BETWEEN :fechaInicio AND :fechaFin
ORDER BY f.fact_fecha, f.fact_id
```

A partir de **esta única consulta**, el servicio Java calcula los tres bloques:

1. **Registros**: Se mapean directamente todos los registros.
2. **Cliente mayor facturación**: Se filtran Activas → agrupan por cliente → suman totales → max.
3. **Ventas por día**: Se filtran Activas → agrupan por fecha → suman totales.

---

## 🏗️ Arquitectura - Archivos Creados

El proyecto sigue una **arquitectura limpia** (Clean Architecture) con capas separadas:

```
src/main/java/development/v/development/
│
├── infrastruture/
│   ├── controller/
│   │   └── InvoiceController.java            ← REST Controller (endpoint GET)
│   ├── entities/
│   │   └── FacturaEntity.java                ← Entidad JPA (tabla factura)
│   └── repositories/
│       └── Invoice/
│           ├── FacturaJpaRepository.java     ← JPA Repository (query nativa)
│           ├── InvoiceRecordProjection.java  ← Proyección (interface-based)
│           └── InvoiceRepositoryImpl.java    ← Implementación del repositorio
│
├── application/
│   └── cases/
│       └── Invoice/
│           └── GetInvoiceDashboard/
│               ├── GetInvoiceDashboardUseCase.java  ← Caso de uso (orquestador)
│               └── Dtos/
│                   └── InvoiceDashboardQuery.java   ← DTO de consulta (fechas)
│
└── domain/
    ├── models/
    │   ├── InvoiceDashboard.java   ← Modelo de respuesta (agrupa los 3 bloques)
    │   ├── InvoiceRecord.java      ← Modelo de registro de factura
    │   ├── TopClient.java          ← Modelo de cliente con mayor facturación
    │   └── DailySales.java         ← Modelo de ventas consolidadas por día
    └── repositories/
        └── InvoiceRepository.java  ← Interface del repositorio (contrato)
```

### Flujo de la petición

```
HTTP GET /api/v1/invoices/dashboard?fechaInicio=...&fechaFin=...
    │
    ▼
InvoiceController.getDashboard(query)
    │
    ▼
GetInvoiceDashboardUseCase.execute(query)
    │
    ▼
InvoiceRepository.getDashboard(fechaInicio, fechaFin)   [interface de dominio]
    │
    ▼
InvoiceRepositoryImpl.getDashboard(...)                  [implementación]
    │
    ├── PASO 1: Ejecuta UNA SOLA consulta SQL (FacturaJpaRepository)
    │           → SELECT factura JOIN cliente WHERE fecha BETWEEN ...
    │
    ├── PASO 2: Mapea todos los registros → List<InvoiceRecord>
    │
    ├── PASO 3: Filtra solo "Activo"
    │
    ├── PASO 4: Agrupa por cliente + suma → TopClient (max facturado)
    │
    ├── PASO 5: Agrupa por fecha + suma → List<DailySales> (para gráfica)
    │
    └── PASO 6: Retorna InvoiceDashboard (3 bloques)
        │
        ▼
    DataResultDto<InvoiceDashboard> → JSON Response
```

---

## ⚙️ Configuración de Base de Datos

El endpoint trabaja con la base de datos **bd_factura**. Verifica que `application.properties` tenga:

```properties
spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:bd_factura}
spring.datasource.username=${DB_USER:root}
spring.datasource.password=${DB_PASSWORD:}
spring.jpa.hibernate.ddl-auto=none
```

> **IMPORTANTE**: `ddl-auto=none` para que Hibernate NO modifique el esquema de la BD
> (ya que es una API de solo consulta).

### Tablas utilizadas de bd_factura

**factura:**
| Columna            | Tipo         | Descripción           |
|--------------------|--------------|-----------------------|
| `fact_id`          | int(11) PK   | Número de factura     |
| `fact_fecha`       | date         | Fecha de factura      |
| `cli_nit`          | varchar(15)  | NIT del cliente (FK)  |
| `fact_total`       | int(11)      | Valor total           |
| `fact_estado`      | varchar(10)  | Estado                |

**cliente:**
| Columna            | Tipo          | Descripción           |
|--------------------|---------------|-----------------------|
| `cli_nit`          | varchar(15) PK| NIT del cliente       |
| `cli_razon_social` | varchar(100)  | Razón social          |

---

## 🧪 Ejemplo de prueba

### Solicitud
```
GET http://localhost:8080/api/v1/invoices/dashboard?fechaInicio=2026-01-01&fechaFin=2026-01-31
```

### Respuesta esperada (con datos de bd_factura)
```json
{
  "message": "Operación realizada con éxito",
  "results": {
    "registros": [
      { "factId": 1,  "factFecha": "2026-01-01", "clienteNombre": "FUNDIMOS TYC",                                  "factTotal": 50000,  "factEstado": "Activo" },
      { "factId": 2,  "factFecha": "2026-01-01", "clienteNombre": "FUNDIMOS TYC",                                  "factTotal": 23000,  "factEstado": "Activo" },
      { "factId": 3,  "factFecha": "2026-01-01", "clienteNombre": "SIDERURGICA DEL OCCIDENTE S.A.S SIDOC S.A.S.",  "factTotal": 56000,  "factEstado": "Activo" },
      { "factId": 4,  "factFecha": "2026-01-01", "clienteNombre": "Bronalco",                                      "factTotal": 49000,  "factEstado": "Activo" },
      { "factId": 5,  "factFecha": "2026-01-01", "clienteNombre": "Bronalco",                                      "factTotal": 52000,  "factEstado": "Anulada" },
      { "factId": 6,  "factFecha": "2026-01-01", "clienteNombre": "Bronalco",                                      "factTotal": 55000,  "factEstado": "Activo" },
      { "factId": 7,  "factFecha": "2026-01-02", "clienteNombre": "FUNDIMOS TYC",                                  "factTotal": 58000,  "factEstado": "Activo" },
      { "factId": 8,  "factFecha": "2026-01-02", "clienteNombre": "FUNDIMOS TYC",                                  "factTotal": 61000,  "factEstado": "Activo" },
      { "factId": 9,  "factFecha": "2026-01-02", "clienteNombre": "SIDERURGICA DEL OCCIDENTE S.A.S SIDOC S.A.S.",  "factTotal": 64000,  "factEstado": "Anulada" },
      { "factId": 10, "factFecha": "2026-01-03", "clienteNombre": "Bronalco",                                      "factTotal": 67000,  "factEstado": "Activo" },
      { "factId": 11, "factFecha": "2026-01-03", "clienteNombre": "Bronalco",                                      "factTotal": 70000,  "factEstado": "Activo" },
      { "factId": 12, "factFecha": "2026-01-03", "clienteNombre": "Bronalco",                                      "factTotal": 73000,  "factEstado": "Activo" },
      { "factId": 13, "factFecha": "2026-01-03", "clienteNombre": "Bronalco",                                      "factTotal": 76000,  "factEstado": "Activo" }
    ],
    "clienteMayorFacturacion": {
      "clienteNombre": "Bronalco",
      "totalFacturado": 390000
    },
    "ventasPorDia": [
      { "fecha": "2026-01-01", "totalVenta": 233000 },
      { "fecha": "2026-01-02", "totalVenta": 119000 },
      { "fecha": "2026-01-03", "totalVenta": 286000 }
    ]
  }
}
```

---

## 📝 Swagger UI

Disponible en: `http://localhost:8080/swagger-ui.html`

El endpoint aparece bajo la tag **"Invoice Dashboard"** con documentación interactiva.

