package cl.duoc.renatroncoso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.renatroncoso.model.Solicitud;
import cl.duoc.renatroncoso.service.SolicitudService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> getAll(){
        return ResponseEntity.ok(solicitudService.getAllSolicituds());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSolicitudById(@PathVariable Long id){
        return solicitudService.getSolicitudById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<?> createSolicitud(@Valid @RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(solicitudService.createSolicitud(solicitud));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSolicitud(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        return solicitudService.updateSolicitud(id, solicitud)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSolicitud(@PathVariable Long id) {
        return solicitudService.deleteSolicitud(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
