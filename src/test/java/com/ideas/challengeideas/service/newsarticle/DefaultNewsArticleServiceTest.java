package com.ideas.challengeideas.service.newsarticle;

import com.ideas.challengeideas.dataaccessobject.NewsArticleRepository;
import com.ideas.challengeideas.domainobject.NewsArticleDO;
import com.ideas.challengeideas.exception.ConstraintsViolationException;
import com.ideas.challengeideas.exception.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.*;

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
    private Validator validator;


    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
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
        List<NewsArticleDO> newsArticles = new ArrayList<>();
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
        when(newsArticleRepository.findAll()).thenReturn(Collections.emptyList());
        // Here we compare the results we got to the expected values.
        assertEquals(0, newsArticleService.find().size());
    }


    @Test
    public void create() throws ConstraintsViolationException
    {
        NewsArticleDO newsArticle = new NewsArticleDO(1L, "Title example", "Text example", LocalDate.now());
        when(newsArticleRepository.save(newsArticle)).thenReturn(newsArticle);
        assertEquals(newsArticle, newsArticleService.create(newsArticle));
    }


    @Test
    public void createShouldThrowConstraintsViolationExceptionWhenFieldValueNotValid() throws ConstraintsViolationException
    {

        NewsArticleDO newsArticle = new NewsArticleDO(1L, null, "Text example", LocalDate.now());
        when(newsArticleRepository.save(newsArticle)).thenReturn(newsArticle);
        Set<ConstraintViolation<NewsArticleDO>> violations = validator.validate(newsArticleService.create(newsArticle));
        assertEquals(1, violations.size());
    }

}
