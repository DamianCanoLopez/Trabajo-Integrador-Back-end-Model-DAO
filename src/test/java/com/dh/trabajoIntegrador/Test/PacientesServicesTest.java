package com.dh.trabajoIntegrador.Test;

import com.dh.trabajoIntegrador.Dao.BD;
import com.dh.trabajoIntegrador.Dao.PacienteDaoH2;
import com.dh.trabajoIntegrador.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.dh.trabajoIntegrador.service.PacienteService;

import java.util.List;


public class PacientesServicesTest {
   @Test
   public void testBuscarTodo(){
      //dado
      BD.crearTablas();
      PacienteService pacienteService=new PacienteService();
      //cuando
      List<Paciente> pacientes =pacienteService.buscarPacientes();
      //entonces
      Assertions.assertEquals(2,pacientes.size());

   }

}
