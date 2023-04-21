package com.dh.trabajoIntegrador.controller;

import com.dh.trabajoIntegrador.Dao.OdontologoDaoH2;
import com.dh.trabajoIntegrador.Dao.PacienteDaoH2;
import com.dh.trabajoIntegrador.model.Turno;
import com.dh.trabajoIntegrador.service.OdontologoService;
import com.dh.trabajoIntegrador.service.PacienteService;
import com.dh.trabajoIntegrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;


    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }




    @GetMapping
    public ResponseEntity<List<Turno>> buscarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        //si el odontologo o paciente no existe error
        //OdontologoService odontologoService=new OdontologoService();
        //PacienteService pacienteService=new PacienteService();
        if (odontologoService.buscar(turno.getOdontologo().getId())!=null
        &&pacienteService.buacarPaciente(turno.getPaciente().getId())!=null){
            //ambos existen, se retorna el turno
            return  ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurnoId(@PathVariable Integer id){
        Turno buscarTurno=turnoService.buscarTurno(id);
        if (buscarTurno !=null) {
            return ResponseEntity.ok(turnoService.buscarTurno(id));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody Turno turno){
        //preguntar si el turno existe
        Turno buscarTurno=turnoService.buscarTurno(turno.getId());
        if (buscarTurno !=null){
            turnoService.actualizarTurno(turno);
            return ResponseEntity.ok("Se a actualizado el turno con id= "+turno.getId());
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimarTurno(@PathVariable Integer id){
        Turno buscarTurno=turnoService.buscarTurno(id);
        if (buscarTurno !=null){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se elimino el turno con id= "+id);
        }
        else {
            return ResponseEntity.badRequest().body("No se puede eliminar el turno con id= "+id);
        }
    }

}
