package com.dh.trabajoIntegrador.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    private static final String SQL_DROP_CREATE_ODONTOLOGO="DROP TABLE IF EXISTS ODONTOLOGOS; "+
            "CREATE TABLE ODONTOLOGOS ("+
            "ID INT AUTO_INCREMENT PRIMARY KEY,"+
            "MATRICULA VARCHAR(100) NOT NULL,"+
            "NOMBRE VARCHAR(100) NOT NULL,"+
            "APELLIDO VARCHAR(100) NOT NULL"+
            ")";
    private static final String SQL_DROP_CREATE_DOMICILIO="DROP TABLE IF EXISTS DOMICILIOS; "+
            "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY,CALLE VARCHAR(100) NOT NULL,"+
            "NUMERO INT NOT NULL,LOCALIDAD VARCHAR(100) NOT NULL,"+
            "PROVINCIA VARCHAR(100) NOT NULL"+
            ")";
    private static final String SQL_DROP_CREATE_PACIENTE="DROP TABLE IF EXISTS PACIENTES;"+
            "CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY,NOMBRE VARCHAR(100) NOT NULL,"+
            "APELLIDO VARCHAR(100) NOT NULL,"+
            "CEDULA VARCHAR(100) NOT NULL,"+
            "FECHA_INGRESO DATE NOT NULL,"+
            "DOMICILIO_ID INT NOT NULL,"+
            "EMAIL VARCHAR(100) NOT NULL"+
            ")";
    private static final String SQL_PRUEBAS="INSERT INTO DOMICILIOS (CALLE," +
            "NUMERO, LOCALIDAD, PROVINCIA) VALUES ('Calle a',58,'Salta Capital','Salta')," +
            "('Calle b',841,'Cafayate','Salta'); INSERT INTO PACIENTES (NOMBRE, APELLIDO," +
            "CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES ('Rodolfo','Baspineiro','841'," +
            "'2022-11-2',1,'PRUEBA@GMAIL.COM'), ('Ezequiel','Baspineiro','871','2022-11-2',2,'correo@gmail.com'); "+
            "INSERT INTO ODONTOLOGOS (MATRICULA,NOMBRE,APELLIDO) VALUES ('MN847','Pedro','Muelas')";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c4clase15_16","sa","sa");
    }


    public static void crearTablas(){
        Connection connection=null;
        try {
            connection=getConnection();
            Statement statement=connection.createStatement();
            statement.execute(SQL_DROP_CREATE_DOMICILIO);
            statement.execute(SQL_DROP_CREATE_PACIENTE);
            statement.execute(SQL_DROP_CREATE_ODONTOLOGO);
            //agregar
            statement.execute(SQL_PRUEBAS);
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
}
