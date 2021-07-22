/*
 * Copyright (c) 2021. Desarrollo de Soluciones Moviles.
 * Departamento de Ingenieria de Sistemas y Computacion.
 * Facultad de Ingenieria y Ciencias Geologicas.
 * Universidad Catolica del Norte.
 */

package cl.ucn.disc.dsm.rbollmann.newsapi;

import cl.ucn.disc.dsm.rbollmann.newsapi.exceptions.NewsNotFoundException;
import cl.ucn.disc.dsm.rbollmann.newsapi.model.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The News Controller
 * @author Rodolfo Bollmann Checura
 */
@Slf4j
@RestController
public class NewsController {

    /**
     * The Repo of News
     */
    private final NewsRepository newsRepository;

    /**
     * The Constructor
     * @param newsRepository the repo to use
     */
    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    /**
     * @return the list of news in the backend
     */
    @GetMapping("/v1/news")
    public NewsResponse all(){

        //Hit the backend
        final List<News> news = this.newsRepository.findAll();

        // Get all the news
        return NewsResponse.builder()
                .status("ok")
                .totalResults(news.size())
                .articles(news)
                .build();
    }

    /**
     *
     * @param id of the news to retrieve from the backend
     * @return the news
     */
    @GetMapping("/v1/news/{id}")
    public News one(@PathVariable final Long id){
        return this.newsRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException("News Not Found :("));
    }


}
