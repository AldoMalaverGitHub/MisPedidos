package com.pedidos.pe.main;

import java.util.List;

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

@SpringBootApplication
@EntityScan(basePackages = "com.pedidos.pe.datos.entidades")
@ComponentScan(basePackages = "com.pedidos.pe")
@EnableJpaRepositories(basePackages = "com.pedidos.pe.datos.repository")
public class PedidosMain implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PedidosMain.class);
		application.run();
	}

	@Override
	public void run(String... arg0) throws Exception {
//		Cliente cliente = new Cliente();
//		cliente.setNombres("Aldo");
//		cliente.setApellidos("Malaver");
//		cliente.setCodigo("C0001");
//		cliente.setEstado('1');
//		clienteRepository.save(cliente);
		
		//programación declarativa
		List<Cliente> clientes = clienteRepository.findAll();
		for(Cliente cli: clientes){
			System.out.println(cli.getIdcliente() + " " + cli.getNombres());
		}
		
		//Programacion funcional -> flecha o arrow (se utiliza para lambdas)
		clienteRepository.findAll().parallelStream().forEach(cl -> System.out.println(cl.getIdcliente() + " " + cl.getNombres()));
		
		clienteRepository.obtenerClientesPorCodigo("CLI00001", 'A').forEach(cl -> 
		System.out.println(cl.getIdcliente() + " " + cl.getNombres()));
		
		pedidoRepository.obtenerPedidoPorIdCliente(1).forEach(pe ->
		System.out.println(pe.getIdpedido() + "Nombre de cliente " +  pe.getCliente().getNombres()));
	}
}
