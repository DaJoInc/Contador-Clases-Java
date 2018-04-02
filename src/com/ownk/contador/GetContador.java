package com.ownk.contador;

import java.io.File;

public class GetContador {
	//¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦Standart¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦
	private int metodoLineaInicial;
	private int metodoLineaFinal;
	private int numeroMetodos;
	private String nombreMetodo;
	private String nombreClase;
	//¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦lineas de metodo¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦
	private int lineaFinalDeMetodo;
	private int lineasFueraDeMetodo;
	//¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦Es una Linea lineaInvalida¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦
	private int lineasNormalizadas;
	private int lineaDeclase;
	//¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦GettersAndSetters¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦
	
	public int getLineasNormalizadas() {
		return lineasNormalizadas;
	}
	public int getLineaDeclase() {
		return lineaDeclase;
	}
	public void setLineaDeclase(int lineaDeclase) {
		this.lineaDeclase = lineaDeclase;
	}
	public int getLineasFueraDeMetodo() {
		return lineasFueraDeMetodo;
	}
	public void setLineasFueraDeMetodo(int lineasFueraDeMetodo) {
		this.lineasFueraDeMetodo = lineasFueraDeMetodo;
	}
	public void setLineasNormalizadas(int lineasNormalizadas) {
		this.lineasNormalizadas = lineasNormalizadas;
	}
	public int getLineaFinalDeMetodo() {
		return lineaFinalDeMetodo;
	}
	public void setLineaFinalDeMetodo(int lineaFinalDeMetodo) {
		this.lineaFinalDeMetodo = lineaFinalDeMetodo;
	}
	public String getNombreMetodo() {
		return nombreMetodo;
	}
	public void setNombreMetodo(String nombreMetodo) {
		this.nombreMetodo = nombreMetodo;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public int getMetodoLineaInicial() {
		return metodoLineaInicial;
	}
	public void setMetodoLineaInicial(int metodoLineaInicial) {
		this.metodoLineaInicial = metodoLineaInicial;
	}
	public int getMetodoLineaFinal() {
		return metodoLineaFinal;
	}
	public void setMetodoLineaFinal(int metodoLineaFinal) {
		this.metodoLineaFinal = metodoLineaFinal;
	}
	public int getNumeroMetodos() {
		return numeroMetodos;
	}
	public void setNumeroMetodos(int numeroMetodos) {
		this.numeroMetodos = numeroMetodos;
	}
	
	
}