package com.dh.trabajoIntegrador;

import com.dh.trabajoIntegrador.Dao.BD;
import com.dh.trabajoIntegrador.Dao.OdontologoDaoH2;
import com.dh.trabajoIntegrador.Dao.PacienteDaoH2;
import com.dh.trabajoIntegrador.model.Odontologo;
import com.dh.trabajoIntegrador.model.Paciente;
import com.dh.trabajoIntegrador.service.OdontologoService;
import com.dh.trabajoIntegrador.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TrabajoIntegradorApplicationTests {

	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private OdontologoService odontologoService;


	@Test
	public void testbuscar(){
		//dado
		BD.crearTablas();
		//OdontologoService odontologoService=new OdontologoService();
		Odontologo odontologo=new Odontologo("1231321","Damian","Cano");
		Odontologo odontologo2=new Odontologo("1251451321","Carlos","Cano");
		odontologoService.guardar(odontologo);
		odontologoService.guardar(odontologo2);
		//cuando
		List<Odontologo> odontologos=odontologoService.buscarTodos();
		//entonces
		Assertions.assertEquals(2,odontologos.size());
	}

	@Test
	public void buscarPacienteId1(){
		BD.crearTablas();
		//PacienteService pacienteService=new PacienteService();
		Paciente pacienteBuscado=pacienteService.buacarPaciente(1);
		Assertions.assertEquals("Baspineiro",pacienteBuscado.getApellido());
	}


	@Test
	public void buscarOdontologo(){
		BD.crearTablas();
		//OdontologoService odontologoService=new OdontologoService();
		Odontologo odontologoBusacdo=odontologoService.buscar(1);
		Assertions.assertEquals("Muelas",odontologoBusacdo.getApellido());
	}


}
