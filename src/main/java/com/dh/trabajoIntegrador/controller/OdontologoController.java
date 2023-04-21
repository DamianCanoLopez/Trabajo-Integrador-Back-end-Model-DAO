package com.dh.trabajoIntegrador.controller;

import com.dh.trabajoIntegrador.model.Odontologo;
import com.dh.trabajoIntegrador.model.Turno;
import com.dh.trabajoIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Odontologo> registarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarOdontologos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PutMapping
    public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo buscarOdontologo=odontologoService.buscar(odontologo.getId());
        if (buscarOdontologo !=null){
            odontologoService.actualizar(odontologo);
            return ResponseEntity.ok("Se actualizo el odontologo con id= "+odontologo.getId());
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologoId(@PathVariable Integer id){
        Odontologo busacarOdontologo=odontologoService.buscar(id);
        if (busacarOdontologo !=null){
            return ResponseEntity.ok(odontologoService.buscar(id));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id){
        Odontologo buscarOdontologo=odontologoService.buscar(id);
        if (buscarOdontologo !=null){
            odontologoService.eliminar(id);
            return ResponseEntity.ok("Se elimino el Odontologo con id= "+ id);
        }
        else {
            return ResponseEntity.badRequest().body("No se encontro el odontologo con id= "+id);
        }
    }

    /*
    @GetMapping
    public String buscarOdontologo(Model model, @RequestParam("id") Integer id){
        Odontologo odontologoBuscado=odontologoService.buscar(id);
        model.addAttribute("nombre",odontologoBuscado.getNombre());
        model.addAttribute("apellido",odontologoBuscado.getApellido());
        return "busodontologo";
    }*/
}
