package com.tt1.test;

import java.time.LocalDate;

/**
 * Representa una tarea (ToDo) dentro del sistema.
 * Almacena la información básica de la tarea, sus fechas clave y su estado de finalización.
 */
public class ToDo {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    /**
     * Construye una nueva tarea con los datos proporcionados.
     * Por defecto, la tarea se inicializa como no completada (false).
     * @param nombre El nombre o título corto de la tarea.
     * @param descripcion Los detalles descriptivos de la tarea.
     * @param fechaLimite La fecha tope para finalizar la tarea.
     */
    public ToDo(String nombre, String descripcion, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = false;
    }

    /**
     * Obtiene el nombre de la tarea.
     * @return El nombre de la tarea.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la descripción de la tarea.
     * @return La descripción detallada.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Modifica el nombre de la tarea.
     * @param n El nuevo nombre que se asignará.
     */
    public void setNombre(String n) {
        this.nombre = n;
    }

    /**
     * Modifica la descripción de la tarea.
     * @param d La nueva descripción detallada.
     */
    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    /**
     * Obtiene la fecha límite fijada para la tarea.
     * @return La fecha límite.
     */
    public LocalDate getFechaLimite() {
        return this.fechaLimite;
    }

    /**
     * Modifica la fecha límite de la tarea.
     * @param fl La nueva fecha límite a establecer.
     */
    public void setFechaLimite(LocalDate fl) {
        this.fechaLimite = fl;
    }

    /**
     * Comprueba si la tarea ha sido completada.
     * @return true si está completada, false en caso contrario.
     */
    public boolean getCompletado() {
        return this.completado;
    }

    /**
     * Establece el estado de finalización de la tarea.
     * @param c true para marcarla como completada, false para marcarla como pendiente.
     */
    public void setCompletado(boolean c) {
        this.completado = c;
    }
}
