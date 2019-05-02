package com.pedidos.pe.datos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedidos.pe.datos.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	//CrudRepository
	//PagingAndSortingReposit
	@Query("From Cliente c where c.codigo = :codigo and c.estado = :estado")
	List<Cliente> obtenerClientesPorCodigo(@Param("codigo") String codigo,
			@Param("estado") char estado);
	
}
