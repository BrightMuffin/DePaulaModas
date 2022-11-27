package com.finalcurso.modas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.finalcurso.modas.entidade.Roupa;
import com.finalcurso.modas.repositorio.RoupaRepositorio;


@SpringBootApplication
public class ModasApplication implements CommandLineRunner {

	@Autowired
	private RoupaRepositorio roupaRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(ModasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Roupa roupa1 = new Roupa();
		roupa1.setNome("Camiseta Spray It");
		roupa1.setMarca("Fúria");
		roupa1.setPreco(140.90);
		roupa1.setTamanho("M");
		roupa1.setEstoque(110);
	
		roupaRepositorio.save(roupa1);
	
	}
}