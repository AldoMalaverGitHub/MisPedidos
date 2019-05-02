package com.pedidos.pe.negocio;

import com.pedidos.pe.negocio.dto.ClienteNegocioDTO;

public interface ClienteNegocio {
	
	void guardarCliente(ClienteNegocioDTO clienteNegocioDTO);
	
	boolean existeCodigoCliente(String codigo);

}
