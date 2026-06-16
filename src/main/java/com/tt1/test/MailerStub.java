package com.tt1.test;

/**
 * Clase que simula el servicio de envío de correos electrónicos para entornos de prueba (Stub).
 * En lugar de enviar correos reales, imprime los mensajes por consola.
 */
public class MailerStub {

    /**
     * Simula el envío de un correo electrónico.
     * * @param direccion La dirección de correo electrónico del destinatario.
     * @param mensaje El contenido del mensaje a enviar.
     * @return true si el correo se "envió" correctamente (siempre devuelve true en esta simulación).
     */
    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando correo a [" + direccion + "]: " + mensaje);
        return true;
    }
}