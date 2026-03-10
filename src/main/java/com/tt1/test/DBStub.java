package com.tt1.test;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que simula el comportamiento de una base de datos en memoria para los tests unitarios (Stub).
 * Permite almacenar y recuperar tareas y correos electrónicos sin necesidad de una conexión real.
 */
public class DBStub {
	private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();
    /**
     * Guarda una nueva tarea en la base de datos simulada.
     * @param tarea El objeto de tipo ToDo que se desea almacenar.
     */
    public void guardarTarea(ToDo tarea) {
    	this.tareas.add(tarea);
    	}
    /**
     * Busca una tarea en la base de datos simulada utilizando su nombre exacto.
     * @param nombre El nombre o título de la tarea que se quiere buscar.
     * @return El objeto ToDo si se encuentra en la lista, o null si no existe ninguna tarea con ese nombre.
     */
    public ToDo buscarTarea(String nombre) {
    	for (ToDo t : tareas) {
            if (t.getNombre().equals(nombre)) {
            	return t;
            }
        }
        return null;
    }
    /**
     * Registra un correo electrónico en la agenda simulada.
     * @param email La dirección de correo electrónico en formato de texto.
     */
    public void guardarEmail(String email) {
        this.agendaEmails.add(email);
    }
    /**
     * Recupera la lista completa de correos electrónicos almacenados.
     * @return Una lista de cadenas de texto (String) con todos los emails.
     */
    public List<String> obtenerEmails() {
        return this.agendaEmails;
    }
    /**
     * Recupera todas las tareas almacenadas en la base de datos simulada.
     * @return Una lista con todos los objetos ToDo guardados.
     */
    public List<ToDo> obtenerTodasLasTareas() {
        return this.tareas;
    }
}
