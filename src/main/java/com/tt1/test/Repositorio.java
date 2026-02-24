package com.tt1.test;

public class Repositorio {
	private DBStub db;

    public Repositorio(DBStub db) {
        this.db = db;
    }

    public void almacenarToDo(ToDo todo) {
    	this.db.guardarTarea(todo);
    	}
    public ToDo encontrarToDo(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void marcarCompletado(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void almacenarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
