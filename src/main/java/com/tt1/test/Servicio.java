package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Maneja la lógica de negocio principal del sistema de gestión de tareas.
 * Coordina las operaciones entre el almacenamiento (Repositorio) y el sistema de notificaciones (Mailer).
 */
public class Servicio {
    private Repositorio repo;
    private MailerStub mailer;

    /**
     * Construye un nuevo Servicio con sus dependencias inyectadas.
     * @param repo El repositorio para acceder a los datos.
     * @param mailer El servicio de envío de correos electrónicos.
     */
    public Servicio(Repositorio repo, MailerStub mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }

    /**
     * Crea una nueva tarea en el sistema y la almacena.
     * @param nombre El título de la tarea. No puede ser nulo ni estar vacío.
     * @param fechaLimite La fecha límite para completar la tarea.
     * @throws IllegalArgumentException Si el nombre proporcionado es nulo o está vacío.
     */
    public void crearToDo(String nombre, LocalDate fechaLimite) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la tarea no puede estar vacío");
        }
        ToDo nuevaTarea = new ToDo(nombre, "", fechaLimite);
        this.repo.almacenarToDo(nuevaTarea);
    }

    /**
     * Añade un nuevo correo electrónico al sistema para futuras notificaciones.
     * @param email La dirección de correo a añadir. Debe contener el símbolo '@'.
     * @throws IllegalArgumentException Si el formato del correo no es válido.
     */
    public void agregarEmail(String email) {
        if (email != null && email.contains("@")) {
            this.repo.almacenarEmail(email);
        } else {
            throw new IllegalArgumentException("Email no válido");
        }
    }

    /**
     * Marca una tarea específica como completada y verifica si existen otras tareas expiradas.
     * @param nombre El nombre de la tarea que se ha finalizado.
     */
    public void finalizarTarea(String nombre) {
        this.repo.marcarCompletado(nombre);
        verificarYAlertarExpiradas();
    }

    /**
     * Consulta y devuelve una lista de las tareas que aún no han sido completadas.
     * Además, verifica si alguna de las tareas pendientes está expirada y envía las alertas correspondientes.
     * @return Una lista conteniendo exclusivamente las tareas marcadas como no completadas.
     */
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

    /**
     * Inspecciona todas las tareas para localizar aquellas que están pendientes y cuya fecha límite ha pasado.
     * Por cada tarea expirada detectada, envía un correo de alerta a todas las direcciones registradas.
     */
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
