package com.dh.trabajoIntegrador.controller;

import com.dh.trabajoIntegrador.model.Paciente;
import com.dh.trabajoIntegrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }




    /*@GetMapping
    public String buscarPorEmail(Model model, @RequestParam("email") String  email){
        Paciente paciente=pacienteService.buacarXemail(email);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        //devolver el nombre del template
        return "index";
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Paciente>  buscarPaciente(@PathVariable Integer id){
        Paciente buscarPacient=pacienteService.buacarPaciente(id);
        if (buscarPacient !=null) {
            return ResponseEntity.ok(pacienteService.buacarPaciente(id));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Paciente>  registarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<String>  actualizarPaciente(@RequestBody Paciente paciente){
        //preguntar si existe el paciente
        Paciente buscarpaciente=pacienteService.buacarPaciente(paciente.getId());
        if (buscarpaciente != null){
            pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok("se actualizo el paciente con id= "+paciente.getId());
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  eliminarPaciente(@PathVariable Integer id){
        Paciente buscarpaciente=pacienteService.buacarPaciente(id);
        if (buscarpaciente != null){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("se elimino el paciente con id= "+id);
        }
        else {
            return ResponseEntity.badRequest().body("No se encontro el paciente con id= "+id);
        }

    }

    @GetMapping
    public ResponseEntity<List<Paciente>>  buscarTodosLosPacientes(){
        return  ResponseEntity.ok(pacienteService.buscarPacientes());
    }

}
