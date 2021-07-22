/*
 * Copyright (c) 2021. Desarrollo de Soluciones Moviles.
 * Departamento de Ingenieria de Sistemas y Computacion.
 * Facultad de Ingenieria y Ciencias Geologicas.
 * Universidad Catolica del Norte.
 */

package cl.ucn.disc.dsm.rbollmann.newsapi;

import cl.ucn.disc.dsm.rbollmann.newsapi.model.News;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * The Response of our API
 *
 * @author Rodolfo Bollmann Checura
 */
@Builder
@Getter
public final class NewsResponse {

    /**
     * The Status
     */
    private final String status;

    /**
     * The results size
     */
    private final int totalResults;

    /**
     * The News (articles)
     */

    private final List<News> articles;

}
