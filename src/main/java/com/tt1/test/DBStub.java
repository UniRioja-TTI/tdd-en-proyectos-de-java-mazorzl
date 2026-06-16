package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que simula el comportamiento de una base de datos en memoria para los tests unitarios (Stub).
 * Almacena las tareas y los correos electrónicos utilizando listas de Java durante la ejecución.
 */
public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    /**
     * Guarda una nueva tarea en la base de datos simulada.
     * * @param tarea El objeto ToDo que se desea almacenar.
     */
    public void guardarTarea(ToDo tarea) {
        this.tareas.add(tarea);
    }

    /**
     * Busca una tarea en la base de datos simulada por su nombre.
     * * @param nombre El nombre exacto de la tarea a buscar.
     * @return El objeto ToDo si se encuentra, o null si no existe ninguna tarea con ese nombre.
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
     * Guarda una nueva dirección de correo electrónico en la agenda simulada.
     * * @param email La dirección de correo a almacenar.
     */
    public void guardarEmail(String email) {
        this.agendaEmails.add(email);
    }

    /**
     * Recupera toda la lista de correos electrónicos guardados en la agenda.
     * * @return Una lista de cadenas de texto (String) con los emails.
     */
    public List<String> obtenerEmails() {
        return this.agendaEmails;
    }

    /**
     * Recupera todas las tareas (ToDo) que han sido almacenadas en la base de datos simulada.
     * * @return Una lista que contiene todas las tareas.
     */
    public List<ToDo> obtenerTodasLasTareas() {
        return this.tareas;
    }
}