package com.ideas.challengeideas.domainobject;

import com.ideas.challengeideas.domainvalue.Relevance;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
    private LocalDateTime dateCreated;


    public NewsArticleDO()
    {
    }


    public NewsArticleDO(Long id, String title, String text, LocalDateTime dateCreated)
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


    public LocalDateTime getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(LocalDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    private long countOccurrence(Character character)
    {
        return text.chars().filter(ch -> ch == character).count();
    }


    private boolean moreExplanationMarksThanFullStops()
    {
        return countOccurrence('!') > countOccurrence('.');
    }


    private boolean moreCommasThanFullStops()
    {
        return countOccurrence(',') > countOccurrence('.');
    }


    private boolean createdWithinTheLastMinute()
    {
        return dateCreated.isAfter(LocalDateTime.now().minus(1, ChronoUnit.MINUTES));
    }


    private boolean createdWithinTheLastFiveMinutes()
    {
        return dateCreated.isAfter(LocalDateTime.now().minus(5, ChronoUnit.MINUTES));
    }


    public Relevance getRelevance()
    {
        if (moreExplanationMarksThanFullStops() && createdWithinTheLastMinute())
        {
            return Relevance.HOT;
        }
        else if (moreCommasThanFullStops() && createdWithinTheLastFiveMinutes())
        {
            return Relevance.BORING;
        }
        else
        {
            return Relevance.STANDARD;
        }
    }
}
