package com.tt1.test;

public class MailerStub {
	public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando correo a [" + direccion + "]: " + mensaje);
        return true; 
    }
}
