package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Maneja la lógica de negocio principal del sistema de gestión de tareas.
 * Se encarga de validar los datos, procesar las acciones del usuario y
 * coordinar el repositorio de datos y el servicio de notificaciones.
 */
public class Servicio {
    private Repositorio repo;
    private MailerStub mailer;

    /**
     * Construye un nuevo Servicio con sus dependencias.
     * * @param repo El repositorio para el acceso a datos.
     * @param mailer El servicio encargado del envío de correos.
     */
    public Servicio(Repositorio repo, MailerStub mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }

    /**
     * Crea una nueva tarea y la almacena en el sistema tras validar sus datos.
     * * @param nombre El nombre de la tarea. No puede estar vacío.
     * @param fechaLimite La fecha tope de la tarea.
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío.
     */
    public void crearToDo(String nombre, LocalDate fechaLimite) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la tarea no puede estar vacío");
        }
        ToDo nuevaTarea = new ToDo(nombre, "", fechaLimite);
        this.repo.almacenarToDo(nuevaTarea);
    }

    /**
     * Valida y agrega una dirección de correo electrónico a la agenda.
     * * @param email El correo electrónico a agregar.
     * @throws IllegalArgumentException Si el email es nulo o no contiene un carácter '@'.
     */
    public void agregarEmail(String email) {
        if (email != null && email.contains("@")) {
            this.repo.almacenarEmail(email);
        } else {
            throw new IllegalArgumentException("Email no válido");
        }
    }

    /**
     * Marca una tarea específica como completada y posteriormente verifica
     * si hay tareas expiradas para enviar alertas.
     * * @param nombre El nombre de la tarea a finalizar.
     */
    public void finalizarTarea(String nombre) {
        this.repo.marcarCompletado(nombre);
        verificarYAlertarExpiradas();
    }

    /**
     * Consulta y devuelve la lista de tareas que aún no han sido completadas.
     * Como efecto secundario, verifica y lanza alertas para las tareas expiradas.
     * * @return Una lista con los objetos ToDo pendientes.
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
     * Recorre todas las tareas pendientes y, si su fecha límite es anterior al día de hoy,
     * envía un correo electrónico de alerta a todas las direcciones de la agenda.
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