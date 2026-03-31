package cl.duoc.renatroncoso.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Solicitud {
    private Long id;
    private String informacionCliente;
    private String tipoAtencion;
    private String estado;
    private Date fechaRegistro;
    private int nivelPrioridad;
}
