package com.tt1.test;

import java.time.LocalDate;

/**
 * Representa una tarea (ToDo) dentro del sistema.
 * Contiene la información básica de una tarea, como su nombre, descripción,
 * fecha límite y su estado de finalización.
 */
public class ToDo {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    /**
     * Construye una nueva tarea con los datos especificados.
     * Por defecto, la tarea se inicializa como no completada.
     * * @param nombre El nombre o título de la tarea.
     * @param descripcion Los detalles o descripción de la tarea.
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
     * @return La descripción de la tarea.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece un nuevo nombre para la tarea.
     * @param n El nuevo nombre.
     */
    public void setNombre(String n) {
        this.nombre=n;
    }

    /**
     * Establece una nueva descripción para la tarea.
     * @param d La nueva descripción.
     */
    public void setDescripcion(String d) {
        this.descripcion=d;
    }

    /**
     * Obtiene la fecha límite de la tarea.
     * @return La fecha límite.
     */
    public LocalDate getFechaLimite() {
        return this.fechaLimite;
    }

    /**
     * Establece una nueva fecha límite para la tarea.
     * @param fl La nueva fecha límite.
     */
    public void setFechaLimite(LocalDate fl) {
        this.fechaLimite=fl;
    }

    /**
     * Comprueba si la tarea está completada.
     * @return true si la tarea está completada, false en caso contrario.
     */
    public boolean getCompletado() {
        return this.completado;
    }

    /**
     * Cambia el estado de completado de la tarea.
     * @param c true para marcarla como completada, false para pendiente.
     */
    public void setCompletado(boolean c) {
        this.completado=c;
    }
}