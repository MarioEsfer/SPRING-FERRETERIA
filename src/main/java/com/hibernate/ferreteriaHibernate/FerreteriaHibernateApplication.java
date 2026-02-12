package com.hibernate.ferreteriaHibernate;

import com.hibernate.ferreteriaHibernate.repositorio.I_RepoArticulos;
import com.hibernate.ferreteriaHibernate.entity.Articulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FerreteriaHibernateApplication implements CommandLineRunner {

	@Autowired
	private I_RepoArticulos repositorio;

	public static void main(String[] args) {
		SpringApplication.run(FerreteriaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion iniciada correctamente");
		List<Articulos>articulos = repositorio.findAll();
		articulos.stream().forEach(System.out::println);

	}
}
