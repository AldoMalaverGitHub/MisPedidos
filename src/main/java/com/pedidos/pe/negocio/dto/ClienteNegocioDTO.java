package com.pedidos.pe.negocio.dto;

public class ClienteNegocioDTO {

	private String codigo;
	private String nombres;
	private String apellidos;	
	
	public ClienteNegocioDTO() {
		
	}

	public ClienteNegocioDTO(String codigo, String nombres, String apellidos) {
		
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
