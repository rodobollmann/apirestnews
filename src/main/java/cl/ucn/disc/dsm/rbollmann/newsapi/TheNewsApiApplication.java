/*
 * Copyright (c) 2021. Desarrollo de Soluciones Moviles.
 * Departamento de Ingenieria de Sistemas y Computacion.
 * Facultad de Ingenieria y Ciencias Geologicas.
 * Universidad Catolica del Norte.
 */

package cl.ucn.disc.dsm.rbollmann.newsapi;

import cl.ucn.disc.dsm.rbollmann.newsapi.model.News;
import cl.ucn.disc.dsm.rbollmann.newsapi.model.Source;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZonedDateTime;

/**
 * The NewsAPI Application.
 * @author Rodolfo Bollmann Checura
 */
@SpringBootApplication
public class TheNewsApiApplication {

    /**
     * The News Repo initialize the database
     */
    @Autowired
    private NewsRepository newsRepository;

    /**
     * The Starting point.
     * @param args to use.
     */
    public static void main(final String[] args) {
        SpringApplication.run(TheNewsApiApplication.class, args);
    }

    /**
     * Initialize the database
     *
     * @return the initializingBean
     */
    @Bean
    protected InitializingBean initializingDatabase(){
        return () -> {
            newsRepository.save(News.builder()
                    .title("titulo equis de equis noticia")
                    .description("descripcion equis de la noticia equis")
                    .content("Contenido equs de la nopticia equis")
                    .author("Marcod Godoy")
                    .publishedAt(ZonedDateTime.now())
                    .source(new Source("Universidad Catolica del norte"))
                    .url("http://www.noticias.ucn.cl/destacado/continua-ciclo-de-reuniones-de-rectoria-con-unidades-academicas/")
                    .urlImage("http://www.noticias.ucn.cl/wp-content/files_mf/cache/th_7445c7bc99903fe147f3c84bdb82a492_ntacreditacion202201.jpg")
                    .build()
            );
        };
    }
}
