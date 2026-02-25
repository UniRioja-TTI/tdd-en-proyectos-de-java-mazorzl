package com.tt1.test;

import java.util.List;

public class Repositorio {
	private DBStub db;

    public Repositorio(DBStub db) {
        this.db = db;
    }

    public ToDo encontrarToDo(String nombre) {
        return this.db.buscarTarea(nombre);
    }

    public void marcarCompletado(String nombre) {
        ToDo tarea = this.db.buscarTarea(nombre);
        if (tarea != null) {
            tarea.setCompletado(true);
        }
    }

    public void almacenarEmail(String email) {
        this.db.guardarEmail(email);
    }
    
    public List<ToDo> obtenerTodas() {
        return this.db.obtenerTodasLasTareas();
    }
    public List<String> obtenerEmails() {
        return this.db.obtenerEmails();
    }
    public void almacenarToDo(ToDo t) {
        this.db.guardarTarea(t);
    }
}
