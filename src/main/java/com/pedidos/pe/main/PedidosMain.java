package com.pedidos.pe.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pedidos.pe.datos.entidades.Cliente;
import com.pedidos.pe.datos.repository.ClienteRepository;
import com.pedidos.pe.datos.repository.PedidoRepository;
import com.pedidos.pe.negocio.ClienteNegocio;
import com.pedidos.pe.negocio.dto.ClienteNegocioDTO;

@SpringBootApplication
@EntityScan(basePackages = "com.pedidos.pe.datos.entidades")
@ComponentScan(basePackages = "com.pedidos.pe")
@EnableJpaRepositories(basePackages = "com.pedidos.pe.datos.repository")
public class PedidosMain implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(PedidosMain.class);
	@Autowired
	private ClienteNegocio clienteNegocio;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PedidosMain.class);
		application.run();
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("ingresando");
		
		ClienteNegocioDTO clienteNegocioDTO = new ClienteNegocioDTO();
		clienteNegocioDTO.setCodigo("CLI00002");
		clienteNegocioDTO.setNombres("Carmen");
		clienteNegocioDTO.setApellidos("Lezama");
		clienteNegocio.guardarCliente(clienteNegocioDTO);
		log.info("finalizado");
	
	}
}
