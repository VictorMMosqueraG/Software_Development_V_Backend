package development.v.development.application.features.DiningArea.UpdateDiningArea.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateDiningAreaRequest {

    @NotNull(message = "El sede_id es requerido")
    @Schema(description = "ID de la sede", example = "1")
    private Long sedeId;

    @NotBlank(message = "El nombre del area es requerido")
    @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
    @Schema(description = "Nombre del area", example = "Terraza")
    private String areaNombre;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del area", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String areaEstado;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getAreaNombre() { return areaNombre; }
    public void setAreaNombre(String areaNombre) { this.areaNombre = areaNombre; }
    public String getAreaEstado() { return areaEstado; }
    public void setAreaEstado(String areaEstado) { this.areaEstado = areaEstado; }
}
