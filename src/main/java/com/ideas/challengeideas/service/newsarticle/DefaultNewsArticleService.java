package com.ideas.challengeideas.service.newsarticle;

import com.ideas.challengeideas.dataaccessobject.NewsArticleRepository;
import com.ideas.challengeideas.domainobject.NewsArticleDO;
import com.ideas.challengeideas.exception.ConstraintsViolationException;
import com.ideas.challengeideas.exception.EntityNotFoundException;
import com.ideas.challengeideas.service.NewsArticleService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultNewsArticleService implements NewsArticleService
{
    private final NewsArticleRepository newsArticleRepository;


    public DefaultNewsArticleService(NewsArticleRepository newsArticleRepository)
    {
        this.newsArticleRepository = newsArticleRepository;
    }


    @Override
    @Transactional
    public NewsArticleDO find(Long id) throws EntityNotFoundException
    {
        return this.newsArticleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
    }


    @Override
    @Transactional
    public NewsArticleDO find(String title) throws EntityNotFoundException
    {
        return this.newsArticleRepository.findByTitle(title).orElseThrow(() -> new EntityNotFoundException("Could not find entity with identifier: " + title));
    }


    @Override
    @Transactional
    public List<NewsArticleDO> find()
    {
        return this.newsArticleRepository.findAll();
    }


    @Override
    @Transactional(rollbackFor = {ConstraintsViolationException.class})
    public NewsArticleDO create(NewsArticleDO newsArticle) throws ConstraintsViolationException
    {
        try
        {
            return this.newsArticleRepository.save(newsArticle);

        }
        catch (DataIntegrityViolationException e)
        {
            throw new ConstraintsViolationException(String.format("ConstraintsViolationException while creating a contact: %s", newsArticle.toString()), e);
        }
    }


    @Override
    @Transactional
    public void updateTitle(Long id, String title) throws EntityNotFoundException
    {
        NewsArticleDO newsArticleDO = this.newsArticleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
        newsArticleDO.setTitle(title);
        this.newsArticleRepository.save(newsArticleDO);
    }


    @Override
    @Transactional
    public void updateText(Long id, String text) throws EntityNotFoundException
    {
        NewsArticleDO newsArticleDO = this.newsArticleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
        newsArticleDO.setTitle(text);
        this.newsArticleRepository.save(newsArticleDO);
    }

}
