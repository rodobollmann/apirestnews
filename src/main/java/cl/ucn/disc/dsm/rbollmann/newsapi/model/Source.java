/*
 * Copyright (c) 2021. Desarrollo de Soluciones Moviles.
 * Departamento de Ingenieria de Sistemas y Computacion.
 * Facultad de Ingenieria y Ciencias Geologicas.
 * Universidad Catolica del Norte.
 */

package cl.ucn.disc.dsm.rbollmann.newsapi.model;

import com.github.slugify.Slugify;
import lombok.*;

import javax.persistence.Embeddable;

/**
 * The Source
 *
 * @author Rodolfo Bollmann Checura
 */
@AllArgsConstructor
@Getter
@Embeddable
@NoArgsConstructor
public class Source {

    /**
     * The Slugify
     */
    private static final Slugify SLUGIFY = new Slugify();

    /**
     * The name of source
     */
    private String name;

    /**
     *
     * @return the id of the name
     */
    public String getId(){
        return SLUGIFY.slugify(this.name);
    }
}
