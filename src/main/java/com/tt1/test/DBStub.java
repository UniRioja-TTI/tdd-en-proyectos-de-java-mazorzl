package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub {
	private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    public void guardarTarea(ToDo tarea) {
    	this.tareas.add(tarea);
    	}
    public ToDo buscarTarea(String nombre) {
    	for (ToDo t : tareas) {
            if (t.getNombre().equals(nombre)) { 
            	return t;
            }
        }
        return null;
        }
    public void guardarEmail(String email) {
        this.agendaEmails.add(email);
    }

    public List<String> obtenerEmails() {
        return this.agendaEmails;
    }

    public List<ToDo> obtenerTodasLasTareas() {
        return this.tareas;
    }
}
