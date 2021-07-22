/*
 * Copyright (c) 2021. Rodolfo Bollmann Checura
 */

package cl.ucn.disc.dsm.rbollmann.newsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * The class.
 *
 * @author Rodolfo Bollmann Checura
 */
@Builder
@Getter
@NoArgsConstructor
@Entity
public final class News {

    /**
     * Unique id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore //Remove from the convertion to JSON
    private Long id;

    /**
     * The Title.
     * Restrictions:
     * not null.
     * -size >2
     */
    private String title;

    /**
     * The Source.
     */
    @Embedded
    private Source source;

    /**
     * The Author.
     */
    private String author;

    /**
     * The url.
     */
    private String url;

    /**
     * The ulrImage.
     */
    private String urlImage;

    /**
     * The description.
     */
    private String description;

    /**
     * The content.
     */
    private String content;

    /**
     * The Date of Publish.
     */
    private ZonedDateTime publishedAt;

    /**
     * The Constructor.
     *
     * @param id to use.
     * @param title to use.
     * @param source to use.
     * @param author to use.
     * @param url to use.
     * @param urlImage to use.
     * @param description to use.
     * @param publishedAt to use.
     */
    public News(
                final Long id,
                final String title,
                final Source source,
                final String author,
                final String url,
                final String urlImage,
                final String description,
                final String content,
                final ZonedDateTime publishedAt) {

        //The id.
        this.id = id;

        //Title replace
       this.title = (title != null && title.length() > 0) ? title : "No Title";

        // Source validation
        if(source == null) {
            throw new IllegalArgumentException("Source was null");
        }
        if (source.getName().length() < 2){
            throw new IllegalArgumentException("Source size < 2 [" + source.getName() + "]");
        }
        this.source = source;

        //Author
        this.author = (author != null && author.length() > 0) ? author : "No Author";

        this.url = url;
        this.urlImage = urlImage;
        this.description = description;
        this.content = content;

        //publishedAt validation
        if  (publishedAt == null){
            throw new IllegalArgumentException("The publishedAt needed!");
        }
        this.publishedAt = publishedAt;
    }

}
