package com.tt1.test;
/**
 * Clase que simula el servicio de envío de correos electrónicos para entornos de prueba (Stub).
 * Nota: Al ser una clase de apoyo para los tests, normalmente no se incluye en el Javadoc de producción.
 */
public class MailerStub {

    /**
     * Simula el envío de un correo imprimiendo un mensaje por la consola del sistema.
     * @param direccion La dirección de correo electrónico del destinatario.
     * @param mensaje El cuerpo del correo a enviar.
     * @return Siempre devuelve true simulando un envío exitoso.
     */
    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando correo a [" + direccion + "]: " + mensaje);
        return true;
    }
}
