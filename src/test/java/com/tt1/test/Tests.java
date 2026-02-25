package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Tests {
	private DBStub db;
    private Repositorio repo;
    private MailerStub mailerstub;
    private Servicio servicio;

    @BeforeEach
    void setUp() {
        db = new DBStub();
        repo = new Repositorio(db);
        mailerstub = new MailerStub(); 
        servicio = new Servicio(repo, mailerstub);
    }

    @Test
    void testCrearToDoFuncionaCorrectamente() {
        String nombre = "Aprobar TDD";
        servicio.crearToDo(nombre, LocalDate.now().plusDays(5));
        ToDo tareaGuardada = db.buscarTarea(nombre);
        assertNotNull(tareaGuardada, "La tarea se debe haber guardado");
        assertEquals(nombre, tareaGuardada.getNombre());
    }

    @Test
    void testAgregarEmailValido() {
        servicio.agregarEmail("alumno@unirioja.es");
        assertTrue(db.obtenerEmails().contains("alumno@unirioja.es"), "El email debería estar en la agenda");
    }

    @Test
    void testAgregarEmailInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            servicio.agregarEmail("correo_sin_arroba");
        }, "Debería lanzar excepción si el email no es válido");
    }

    @Test
    void testFinalizarTarea() {
        String nombre = "Tarea a completar";
        servicio.crearToDo(nombre, LocalDate.now().plusDays(2));
        servicio.finalizarTarea(nombre);
        ToDo tarea = db.buscarTarea(nombre);
        assertTrue(tarea.getCompletado(), "La tarea debería estar marcada como completada");
    }

    @Test
    void testConsultarPendientes() {
        servicio.crearToDo("Tarea 1", LocalDate.now().plusDays(1));
        servicio.crearToDo("Tarea 2", LocalDate.now().plusDays(2));
        servicio.finalizarTarea("Tarea 1");
        List<ToDo> pendientes = servicio.consultarPendientes();
        assertEquals(1, pendientes.size(), "Solo debería haber 1 tarea pendiente en la lista");
        assertEquals("Tarea 2", pendientes.get(0).getNombre(), "La tarea pendiente debe ser la Tarea 2");
    }
  
}
