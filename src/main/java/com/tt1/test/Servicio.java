package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
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
        if (email != null && email.contains("@")) { 
            this.repo.almacenarEmail(email);
        } else {
            throw new IllegalArgumentException("Email no válido");
        }
    }

    public void finalizarTarea(String nombre) {
        this.repo.marcarCompletado(nombre);
        verificarYAlertarExpiradas();
    }

    public List<ToDo> consultarPendientes() {
        List<ToDo> todas = this.repo.obtenerTodas();
        List<ToDo> pendientes = new ArrayList<>();
        
        for (ToDo t : todas) {
            if (!t.getCompletado()) { 
                pendientes.add(t);
            }
        }
        verificarYAlertarExpiradas();
        return pendientes;
    }

    public void verificarYAlertarExpiradas() {
        List<ToDo> todas = this.repo.obtenerTodas();
        List<String> emails = this.repo.obtenerEmails();
        LocalDate hoy = LocalDate.now();

        for (ToDo t : todas) {
            
            if (!t.getCompletado() && t.getFechaLimite().isBefore(hoy)) {
                for (String email : emails) {
                    this.mailer.enviarCorreo(email, "¡Alerta! La tarea '" + t.getNombre() + "' ha expirado.");
                }
            }
        }
    }
}
