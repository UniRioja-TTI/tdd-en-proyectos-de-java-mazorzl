package com.tt1.test;

import java.util.List;

/**
 * Actúa como intermediario (capa de acceso a datos) entre la lógica de negocio y la base de datos.
 * Proporciona los métodos necesarios para buscar, almacenar y actualizar tareas y correos electrónicos.
 */
public class Repositorio {
    private DBStub db;

    /**
     * Construye un nuevo Repositorio inyectando la base de datos a utilizar.
     * * @param db La instancia de la base de datos (simulada por DBStub).
     */
    public Repositorio(DBStub db) {
        this.db = db;
    }

    /**
     * Busca una tarea en la base de datos por su nombre.
     * * @param nombre El nombre de la tarea a buscar.
     * @return El objeto ToDo correspondiente, o null si no se encuentra.
     */
    public ToDo encontrarToDo(String nombre) {
        return this.db.buscarTarea(nombre);
    }

    /**
     * Busca una tarea por su nombre y la marca como completada en la base de datos.
     * * @param nombre El nombre de la tarea a completar.
     */
    public void marcarCompletado(String nombre) {
        ToDo tarea = this.db.buscarTarea(nombre);
        if (tarea != null) {
            tarea.setCompletado(true);
        }
    }

    /**
     * Almacena una nueva dirección de correo electrónico en la agenda.
     * * @param email La dirección de correo electrónico a guardar.
     */
    public void almacenarEmail(String email) {
        this.db.guardarEmail(email);
    }

    /**
     * Recupera todas las tareas almacenadas en la base de datos.
     * * @return Una lista con todas las tareas (ToDo).
     */
    public List<ToDo> obtenerTodas() {
        return this.db.obtenerTodasLasTareas();
    }

    /**
     * Recupera todos los correos electrónicos almacenados en la agenda.
     * * @return Una lista de cadenas de texto con los emails.
     */
    public List<String> obtenerEmails() {
        return this.db.obtenerEmails();
    }

    /**
     * Almacena una nueva tarea en la base de datos.
     * * @param t El objeto ToDo a guardar.
     */
    public void almacenarToDo(ToDo t) {
        this.db.guardarTarea(t);
    }
}