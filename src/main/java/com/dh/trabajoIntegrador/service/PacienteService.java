package com.dh.trabajoIntegrador.service;

import com.dh.trabajoIntegrador.Dao.PacienteDaoH2;
import com.dh.trabajoIntegrador.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private PacienteDaoH2 pacienteIDAO;

    public PacienteService() {
        pacienteIDAO = new PacienteDaoH2();
    }

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteIDAO.guardar(paciente);
    }

    public Paciente buacarPaciente(Integer id){
        return pacienteIDAO.buscar(id);
    }

    public void eliminarPaciente(Integer id){
        pacienteIDAO.eliminar(id);
    }

    public void actualizarPaciente(Paciente paciente){
        pacienteIDAO.actualizar(paciente);
    }
    public List<Paciente> buscarPacientes(){
        return pacienteIDAO.buscarTodos();
    }
    public Paciente buacarXemail(String email){
        return pacienteIDAO.buscarPorString(email);
    }
}
