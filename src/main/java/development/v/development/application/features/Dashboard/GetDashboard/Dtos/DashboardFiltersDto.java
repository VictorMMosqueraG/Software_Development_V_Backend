package development.v.development.application.features.Dashboard.GetDashboard.Dtos;

import java.util.ArrayList;
import java.util.List;

public class DashboardFiltersDto {

    private List<CatalogItemDto> meseros = new ArrayList<>();
    private List<CatalogItemDto> platos = new ArrayList<>();
    private List<CatalogItemDto> estados = new ArrayList<>();
    private List<CatalogItemDto> sedes = new ArrayList<>();

    public List<CatalogItemDto> getMeseros() {
        return meseros;
    }

    public void setMeseros(List<CatalogItemDto> meseros) {
        this.meseros = meseros;
    }

    public List<CatalogItemDto> getPlatos() {
        return platos;
    }

    public void setPlatos(List<CatalogItemDto> platos) {
        this.platos = platos;
    }

    public List<CatalogItemDto> getEstados() {
        return estados;
    }

    public void setEstados(List<CatalogItemDto> estados) {
        this.estados = estados;
    }

    public List<CatalogItemDto> getSedes() {
        return sedes;
    }

    public void setSedes(List<CatalogItemDto> sedes) {
        this.sedes = sedes;
    }

    public static class CatalogItemDto {
        private String id;
        private String nombre;

        public CatalogItemDto() {
        }

        public CatalogItemDto(String id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
}

