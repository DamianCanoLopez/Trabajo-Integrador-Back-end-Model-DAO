package com.dh.trabajoIntegrador.Dao;

import com.dh.trabajoIntegrador.model.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoDaoH2 implements IDAO<Odontologo>{
    private static final Logger LOGGER=Logger.getLogger(OdontologoDaoH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, "+
            "APELLIDO) VALUES (?,?,?)";
    private static final String SQL_SELECT="SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_UPDATE="UPDATE ODONTOLOGOS SET MATRICULA=?,NOMBRE=?,"+
            "APELLIDO=? WHERE ID=?";
    private static final String SQL_DELETE="DELETE FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Se inicia la operacion de guardado de "+ odontologo.getNombre());
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement psInsert=connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getMatricula());
            psInsert.setString(2,odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();
            ResultSet rs=psInsert.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        LOGGER.info("Se inicia la operacion de busqueda del odontologo con id= "+id);
        Odontologo odontologo =null;
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement psSelect=connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1,id);
            ResultSet rs=psSelect.executeQuery();
            while (rs.next()){
                odontologo=new Odontologo(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        LOGGER.info("Se inicia la operacion de actualizacion del odontologo con id=  "+ odontologo.getId());
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement psUpdate=connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,odontologo.getMatricula());
            psUpdate.setString(2,odontologo.getNombre());
            psUpdate.setString(3,odontologo.getApellido());
            psUpdate.setInt(4,odontologo.getId());
            psUpdate.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(Integer id) {
        LOGGER.info("Se inicia la operacion de eliminacion del odontologo con id= "+id);
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement psDelete=connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1,id);
            psDelete.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        LOGGER.info("Iniciando una operacion de buequeda total de los odontologos");
        List<Odontologo> odontologos =new ArrayList<>();
        Odontologo odontologo =null;
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement psSelectAll=connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSelectAll.executeQuery();
            while (rs.next()){
                odontologo=new Odontologo(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4));
                odontologos.add(odontologo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologos;
    }

    @Override
    public Odontologo buscarPorString(String valor) {
        return null;
    }
}
