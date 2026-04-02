package cl.duoc.renatroncoso.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import cl.duoc.renatroncoso.model.Solicitud;
import org.springframework.stereotype.Repository;

@Repository
public class SolicitudRepository {
    private final Map<Long, Solicitud> solicitudes = new HashMap<>();
    
    public List<Solicitud> findAll(){
        return new ArrayList<>(solicitudes.values());
    }
    public Optional<Solicitud> findById(Long id){
        return Optional.ofNullable(solicitudes.get(id));
    }
    public Solicitud findByFecha(Date fecha){
        for (Solicitud solicitud : solicitudes.values()) {
            if (solicitud.getFechaRegistro().equals(fecha)) {
                return solicitud;
            }
        }
        return null;
    }
    public Solicitud save(Solicitud solicitud){
        solicitudes.put(solicitud.getId(), solicitud);
        return solicitud;
    }
    public void deleteById(Long id){
        solicitudes.remove(id);
    }
    public boolean existsById(Long id){
        return solicitudes.containsKey(id);
    }
}
