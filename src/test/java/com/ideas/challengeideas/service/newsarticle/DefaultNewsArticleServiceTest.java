package com.ideas.challengeideas.service.newsarticle;

import com.ideas.challengeideas.dataaccessobject.NewsArticleRepository;
import com.ideas.challengeideas.domainobject.NewsArticleDO;
import com.ideas.challengeideas.exception.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * This class implements unit tests for the service class.
 * Other unit tests should be implemented for the util package classes.
 */
public class DefaultNewsArticleServiceTest
{

    // Here we tell Mockito to mock DefaultNewsArticleService and to inject NewsArticleRepository into it.
    @InjectMocks
    DefaultNewsArticleService newsArticleService;
    @Mock
    NewsArticleRepository newsArticleRepository;


    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void findById() throws EntityNotFoundException
    {
        // Here we initialize a NewsArticleDO object
        NewsArticleDO newsArticle = new NewsArticleDO(1L, "Title example", "Text example", LocalDate.now());
        // Here we tell Mockito what to we want the repository method that we call to return.
        when(newsArticleRepository.findById(newsArticle.getId())).thenReturn(Optional.of(newsArticle));
        // Here we compare the results we got to the expected values.
        assertEquals(newsArticle, newsArticleService.find(newsArticle.getId()));
    }


    @Test(expected = EntityNotFoundException.class)
    public void findByIdShouldThrowEntityNotFoundExceptionWhenNewsArticleIsNotFound() throws EntityNotFoundException
    {
        // Since we do not tell Mockito what we want the repository method to return, it returns nothing, hence the EntityNotFoundException exception.
        newsArticleService.find(1L);
    }


    @Test
    public void findAll()
    {
        // Here we initialize NewsArticleDO objects
        Set<NewsArticleDO> newsArticles = new HashSet<>();
        newsArticles.add(new NewsArticleDO(1L, "Title example", "Text example", LocalDate.now()));
        newsArticles.add(new NewsArticleDO(2L, "Title example 2", "Text example", LocalDate.now()));
        newsArticles.add(new NewsArticleDO(3L, "Title example 3", "Text example", LocalDate.now()));
        // Here we tell Mockito what to we want the repository method that we call to return.
        when(newsArticleRepository.findAll()).thenReturn(newsArticles);
        // Here we compare the results we got to the expected values.
        assertEquals(3, newsArticleService.find().size());
        assertEquals(newsArticles, newsArticleService.find());
    }


    @Test
    public void findShouldReturnEmptyListWhenNoFeatureWasSpecified()
    {
        // Here we tell Mockito what to we want the repository method that we call to return
        when(newsArticleRepository.findAll()).thenReturn(Collections.emptySet());
        // Here we compare the results we got to the expected values.
        assertEquals(0, newsArticleService.find().size());
    }


    @Test
    public void create()
    {
        NewsArticleDO newsArticle = new NewsArticleDO(1L, "Title example", "Text example", LocalDate.now());
        when(newsArticleRepository.save(newsArticle)).thenReturn(newsArticle);
        when(newsArticleRepository.save(newsArticle)).thenReturn(newsArticle);
        assertEquals(newsArticle, newsArticleService.create(newsArticle));
    }


}
