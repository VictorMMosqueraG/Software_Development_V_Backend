package development.v.development.application.features.DiningTable.CreateDiningTable.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear una mesa")
public class CreateDiningTableRequestDto {

    @NotNull(message = "El sede_id es requerido")
    @Schema(description = "ID de la sede", example = "1")
    private Long sedeId;

    @Schema(description = "ID del area (opcional)", example = "1")
    private Long areaId;

    @NotBlank(message = "El numero de mesa es requerido")
    @Size(max = 10, message = "El numero de mesa no puede superar 10 caracteres")
    @Schema(description = "Numero de la mesa", example = "M01")
    private String mesaNumero;

    @NotNull(message = "La capacidad es requerida")
    @Schema(description = "Capacidad de la mesa", example = "4")
    private Integer capacidad;

    @NotNull(message = "La posicion X es requerida")
    @Schema(description = "Posicion X en el plano", example = "100")
    private Integer xPos;

    @NotNull(message = "La posicion Y es requerida")
    @Schema(description = "Posicion Y en el plano", example = "200")
    private Integer yPos;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "DISPONIBLE|OCUPADA|RESERVADA|INACTIVA", message = "El estado debe ser DISPONIBLE, OCUPADA, RESERVADA o INACTIVA")
    @Schema(description = "Estado de la mesa", example = "DISPONIBLE", allowableValues = {"DISPONIBLE", "OCUPADA", "RESERVADA", "INACTIVA"})
    private String estado;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }
    public String getMesaNumero() { return mesaNumero; }
    public void setMesaNumero(String mesaNumero) { this.mesaNumero = mesaNumero; }
    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
    public Integer getXPos() { return xPos; }
    public void setXPos(Integer xPos) { this.xPos = xPos; }
    public Integer getYPos() { return yPos; }
    public void setYPos(Integer yPos) { this.yPos = yPos; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
