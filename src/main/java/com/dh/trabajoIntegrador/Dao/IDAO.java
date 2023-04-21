package com.dh.trabajoIntegrador.Dao;

import java.util.List;

public interface IDAO<T> {
    T guardar(T t); //INSERT
    T buscar(Integer id);//SELECT
    void actualizar(T t);//UPDATE
    void eliminar(Integer id);//DELETE
    List<T> buscarTodos();//SELECT
    T buscarPorString(String valor);
}
