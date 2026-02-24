package com.tt1.test;

import java.time.LocalDate;

public class ToDo {
	private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    public ToDo(String nombre, String descripcion, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = false;
    }
    public String getNombre() {
    	return this.nombre;
    }
    public String getDescripcion() {
    	return this.descripcion;
    }
    public void setNombre(String n) {
    	this.nombre=n;
    }
    public void setDescripcion(String d) {
    	this.descripcion=d;
    }
    public LocalDate getFechaLimite() {
    	return this.fechaLimite;
    }
    public void setFechaLimite(LocalDate fl) {
    	this.fechaLimite=fl;
    }
    public boolean getCompletado() {
    	return this.completado;
    }
    public void setCompletado(boolean c) {
    	this.completado=c;
    }
}
