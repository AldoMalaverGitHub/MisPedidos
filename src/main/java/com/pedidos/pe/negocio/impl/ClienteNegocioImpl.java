package com.pedidos.pe.negocio.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.pe.datos.entidades.Cliente;
import com.pedidos.pe.datos.repository.ClienteRepository;
import com.pedidos.pe.negocio.ClienteNegocio;
import com.pedidos.pe.negocio.dto.ClienteNegocioDTO;

@Service
public class ClienteNegocioImpl implements ClienteNegocio {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional
	public void guardarCliente(ClienteNegocioDTO clienteNegocioDTO) {
		
		Cliente cliente = new Cliente();
		cliente.setNombres(clienteNegocioDTO.getNombres());
		cliente.setApellidos(clienteNegocioDTO.getApellidos());
		cliente.setCodigo(clienteNegocioDTO.getCodigo());
		cliente.setEstado('A');
		
		if(existeCodigoCliente(clienteNegocioDTO.getCodigo())){
			return;
		}
		clienteRepository.save(cliente);

	}

	@Override
	public boolean existeCodigoCliente(String codigo) {
		List<Cliente> clientes = 
				clienteRepository.obtenerClientesPorCodigo(codigo, 'A');
		System.out.println("tamanio:::" + clientes.size());
		return clientes.isEmpty() ? false: true;
		
	}

}
