package com.ideas.challengeideas.domainobject;

import org.springframework.lang.NonNull;

import java.time.LocalDate;

public class NewsArticleDO
{
    @NonNull
    private Long id;

    @NonNull
    private String title;

    private String text;

    @NonNull
    private LocalDate dateCreated;


    public NewsArticleDO(Long id, String title, String text, LocalDate dateCreated)
    {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }


    public String getText()
    {
        return text;
    }


    public void setText(String text)
    {
        this.text = text;
    }


    public LocalDate getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(LocalDate dateCreated)
    {
        this.dateCreated = dateCreated;
    }
}
