package com.pedidos.pe.datos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedidos.pe.datos.entidades.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	//@Query("From Pedido p where p.cliente.idcliente = :idCliente")
	//List<Pedido> obtenerPedidoPorIdCliente(@Param("idCliente") Integer idCliente);
}
