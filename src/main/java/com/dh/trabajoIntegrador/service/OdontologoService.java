package com.dh.trabajoIntegrador.service;

import com.dh.trabajoIntegrador.Dao.IDAO;
import com.dh.trabajoIntegrador.Dao.OdontologoDaoH2;
import com.dh.trabajoIntegrador.model.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OdontologoService {
    private IDAO<Odontologo> odonologoIDao;

    @Autowired
    public OdontologoService(IDAO<Odontologo> odonologoIDao) {
        this.odonologoIDao = odonologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odonologoIDao.guardar(odontologo);
    }

    public Odontologo buscar(Integer id){
        return odonologoIDao.buscar(id);
    }

    public void actualizar(Odontologo odontologo){
        odonologoIDao.actualizar(odontologo);
    }

    public void eliminar(Integer id){
        odonologoIDao.eliminar(id);
    }

    public List<Odontologo> buscarTodos(){
        return odonologoIDao.buscarTodos();
    }
}
