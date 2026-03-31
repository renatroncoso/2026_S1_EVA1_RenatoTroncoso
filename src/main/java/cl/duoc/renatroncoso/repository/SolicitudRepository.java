package cl.duoc.renatroncoso.repository;

import java.util.HashMap;
import java.util.Map;
import cl.duoc.renatroncoso.model.Solicitud;
import org.springframework.stereotype.Repository;

@Repository
public class SolicitudRepository {
    private final Map<Long, Solicitud> solicitudes = new HashMap<>();
    
}
