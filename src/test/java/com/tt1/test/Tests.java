package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


class Tests {
    @Test
    void testCrearToDoFuncionaCorrectamente() {
        DBStub db = new DBStub();
        Repositorio repo = new Repositorio(db);
        MailerStub mailer = new MailerStub();
        Servicio servicio = new Servicio(repo, mailer);
        
        String nombreEsperado = "Aprobar TDD";
        LocalDate fechaEsperada = LocalDate.now().plusDays(5);
        servicio.crearToDo(nombreEsperado, fechaEsperada);
        ToDo tareaGuardada = db.buscarTarea(nombreEsperado);
        assertNotNull(tareaGuardada, "La tarea debería haberse guardado en la base de datos");
        assertEquals(nombreEsperado, tareaGuardada.getNombre(), "El nombre de la tarea debe coincidir");
        assertEquals(fechaEsperada, tareaGuardada.getFechaLimite(), "La fecha debe coincidir");
    }
  
}
