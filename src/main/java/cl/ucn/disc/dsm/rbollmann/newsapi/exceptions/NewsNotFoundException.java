/*
 * Copyright (c) 2021. Desarrollo de Soluciones Moviles.
 * Departamento de Ingenieria de Sistemas y Computacion.
 * Facultad de Ingenieria y Ciencias Geologicas.
 * Universidad Catolica del Norte.
 */

package cl.ucn.disc.dsm.rbollmann.newsapi.exceptions;

/**
 * News Not Found: 404!!
 * @author Rodolfo Bollmann Checura
 */
public class NewsNotFoundException extends RuntimeException {

    /**
     * The constructor
     *
     * @param message to use.
     */
    public NewsNotFoundException(String message) {
        super(message);

    }
}
