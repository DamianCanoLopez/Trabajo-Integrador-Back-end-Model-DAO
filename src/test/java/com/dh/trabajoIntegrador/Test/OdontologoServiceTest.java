package com.dh.trabajoIntegrador.Test;

import com.dh.trabajoIntegrador.Dao.BD;
import com.dh.trabajoIntegrador.Dao.OdontologoDaoH2;
import com.dh.trabajoIntegrador.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.dh.trabajoIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OdontologoServiceTest {
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

}
