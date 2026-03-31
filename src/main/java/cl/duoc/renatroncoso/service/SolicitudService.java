package cl.duoc.renatroncoso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.renatroncoso.model.Solicitud;
import cl.duoc.renatroncoso.repository.SolicitudRepository;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository){
        this.solicitudRepository = solicitudRepository;
    }
    public List<Solicitud> getAllSolicituds(){
        return solicitudRepository.findAll();
    }
    public Optional<Solicitud> getSolicitudById(Long id){
        return solicitudRepository.findById(id);
    }
    public Solicitud createSolicitud(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }

    public Optional<Solicitud> updateSolicitud(Long id, Solicitud solicitud){
        if(solicitudRepository.existsById(id)){
            solicitud.setId(id);
            return Optional.of(solicitudRepository.save(solicitud));
        }
        return Optional.empty();
    }

    public boolean deleteSolicitud(Long id){
        if(solicitudRepository.existsById(id)){
            solicitudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
