package com.ideas.challengeideas.domainobject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(name = "uc_title", columnNames = {"title"})
)
public class NewsArticleDO
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    @NotNull(message = "Title can not be null!")
    private String title;
    @Column(nullable = false)
    @NotNull(message = "Text can not be null!")
    private String text;
    @Column(nullable = false)
    @NotNull(message = "Creation date can not be null!")
    private LocalDate dateCreated;


    public NewsArticleDO()
    {
    }


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
