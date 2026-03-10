package com.tt1.test;

import java.util.List;
/**
 * Actúa como intermediario entre la lógica de negocio (Servicio) y la base de datos (DBStub).
 * Proporciona métodos para almacenar, buscar y actualizar tareas y correos.
 */
public class Repositorio {
    private DBStub db;

    /**
     * Construye un nuevo Repositorio inyectando la base de datos a utilizar.
     * @param db La instancia de la base de datos simulada (DBStub).
     */
    public Repositorio(DBStub db) {
        this.db = db;
    }

    /**
     * Busca una tarea específica utilizando su nombre.
     * @param nombre El nombre exacto de la tarea a buscar.
     * @return El objeto ToDo correspondiente, o null si no se encuentra.
     */
    public ToDo encontrarToDo(String nombre) {
        return this.db.buscarTarea(nombre);
    }

    /**
     * Busca una tarea por su nombre y la marca como completada.
     * Si la tarea no existe, no realiza ninguna acción.
     * @param nombre El nombre de la tarea a completar.
     */
    public void marcarCompletado(String nombre) {
        ToDo tarea = this.db.buscarTarea(nombre);
        if (tarea != null) {
            tarea.setCompletado(true);
        }
    }

    /**
     * Guarda una nueva dirección de correo electrónico en el registro.
     * @param email La dirección de correo a almacenar.
     */
    public void almacenarEmail(String email) {
        this.db.guardarEmail(email);
    }

    /**
     * Recupera el listado completo de todas las tareas existentes.
     * @return Una lista con todas las tareas almacenadas.
     */
    public List<ToDo> obtenerTodas() {
        return this.db.obtenerTodasLasTareas();
    }

    /**
     * Recupera el listado completo de correos electrónicos guardados.
     * @return Una lista de cadenas con los correos electrónicos.
     */
    public List<String> obtenerEmails() {
        return this.db.obtenerEmails();
    }

    /**
     * Guarda una nueva tarea en el sistema de almacenamiento.
     * @param t El objeto ToDo que se desea almacenar.
     */
    public void almacenarToDo(ToDo t) {
        this.db.guardarTarea(t);
    }
}
