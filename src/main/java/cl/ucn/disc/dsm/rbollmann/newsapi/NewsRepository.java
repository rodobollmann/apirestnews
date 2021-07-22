/*
 * Copyright (c) 2021. Desarrollo de Soluciones Moviles.
 * Departamento de Ingenieria de Sistemas y Computacion.
 * Facultad de Ingenieria y Ciencias Geologicas.
 * Universidad Catolica del Norte.
 */

package cl.ucn.disc.dsm.rbollmann.newsapi;

import cl.ucn.disc.dsm.rbollmann.newsapi.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The news repository
 *
 * @author Rodolfo Bollmann Checura
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
