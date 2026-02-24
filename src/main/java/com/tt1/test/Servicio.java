package com.tt1.test;

import java.time.LocalDate;
import java.util.List;

public class Servicio {
	private Repositorio repo;
    private MailerStub mailer;

    public Servicio(Repositorio repo, MailerStub mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }

    public void crearToDo(String nombre, LocalDate fechaLimite) {
    	if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la tarea no puede estar vacío");
        }
        ToDo nuevaTarea = new ToDo(nombre, "", fechaLimite);
        this.repo.almacenarToDo(nuevaTarea);
    }
    public void agregarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void finalizarTarea(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public List<ToDo> consultarPendientes() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
    public void verificarYAlertarExpiradas() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
