package com.dh.trabajoIntegrador.service;

import com.dh.trabajoIntegrador.Dao.IDAO;
import com.dh.trabajoIntegrador.Dao.TurnoDaoLista;
import com.dh.trabajoIntegrador.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private IDAO<Turno> turnoIDAO;

    public TurnoService() {
       turnoIDAO = new TurnoDaoLista();
    }

    public List<Turno> listarTurnos(){
        return turnoIDAO.buscarTodos();
    }

    public Turno buscarTurno(Integer id){
        return turnoIDAO.buscar(id);
    }

    public Turno guardarTurno(Turno turno){
        return turnoIDAO.guardar(turno);
    }

    public void eliminarTurno(Integer id){
        turnoIDAO.eliminar(id);
    }

    public void actualizarTurno(Turno turno){
        turnoIDAO.actualizar(turno);
    }


}
