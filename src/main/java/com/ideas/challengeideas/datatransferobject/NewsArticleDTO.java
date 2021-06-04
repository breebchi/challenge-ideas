package com.ideas.challengeideas.datatransferobject;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class NewsArticleDTO
{

    @NonNull
    @ApiModelProperty(value = "Id of the news article.")
    private Long id;

    @NonNull
    @ApiModelProperty(value = "Title of the news article.")
    private String title;

    @ApiModelProperty(value = "Text of the news article.")
    private String text;

    @NonNull
    @ApiModelProperty(value = "Date of creation of the news article.")
    private LocalDateTime dateCreated;


    private NewsArticleDTO(@NonNull Long id, @NonNull String title, String text, @NonNull LocalDateTime dateCreated)
    {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
    }


    public NewsArticleDTO()
    {
    }


    // This is to acquire a builder
    public static NewsArticleDTO.NewsArticleDTOBuilder newBuilder()
    {
        return new NewsArticleDTO.NewsArticleDTOBuilder();
    }


    @NonNull public Long getId()
    {
        return id;
    }


    @NonNull public String getTitle()
    {
        return title;
    }


    public String getText()
    {
        return text;
    }


    @NonNull public LocalDateTime getDateCreated()
    {
        return dateCreated;
    }


    public static final class NewsArticleDTOBuilder
    {
        private Long id;
        private String title;
        private String text;
        private LocalDateTime dateCreated;


        private NewsArticleDTOBuilder()
        {
        }


        public static NewsArticleDTOBuilder aNewsArticleDTO()
        {
            return new NewsArticleDTOBuilder();
        }


        public NewsArticleDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public NewsArticleDTOBuilder setTitle(String title)
        {
            this.title = title;
            return this;
        }


        public NewsArticleDTOBuilder setText(String text)
        {
            this.text = text;
            return this;
        }


        public NewsArticleDTOBuilder setDateCreated(LocalDateTime dateCreated)
        {
            this.dateCreated = dateCreated;
            return this;
        }


        public NewsArticleDTO createNewsArticleDTO()
        {
            return new NewsArticleDTO(id, title, text, dateCreated);
        }
    }
}
