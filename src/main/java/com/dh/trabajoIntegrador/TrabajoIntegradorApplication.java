package com.dh.trabajoIntegrador;

import com.dh.trabajoIntegrador.Dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabajoIntegradorApplication {

	public static void main(String[] args) {

		BD.crearTablas();
		SpringApplication.run(TrabajoIntegradorApplication.class, args);
	}

}
