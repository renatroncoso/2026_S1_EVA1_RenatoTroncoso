package cl.duoc.renatroncoso.model;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Solicitud {
    @NotNull(message = "El id no puede ser nulo")
    private Long id;
    @NotBlank(message = "la informacion no puede estar vacia")
    private String informacionCliente;
    @NotBlank(message = "no puede estar vacio el campo del tipo de atencion")
    private String tipoAtencion;
    @NotBlank(message = "Debe tener un estado")
    private String estado;
    @PastOrPresent(message = "La fecha de registro no puede ser futura")
    private Date fechaRegistro;
    @NotNull(message = "EL nivel de prioridad no puede ser nulo")
    private int nivelPrioridad;
}
