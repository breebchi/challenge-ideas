package com.ideas.challengeideas.service.newsarticle;

import com.ideas.challengeideas.dataaccessobject.NewsArticleRepository;
import com.ideas.challengeideas.domainobject.NewsArticleDO;
import com.ideas.challengeideas.exception.EntityNotFoundException;
import com.ideas.challengeideas.service.NewsArticleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DefaultNewsArticleService implements NewsArticleService
{
    private final NewsArticleRepository newsArticleRepository;


    public DefaultNewsArticleService(NewsArticleRepository newsArticleRepository)
    {
        this.newsArticleRepository = newsArticleRepository;
    }


    @Override
    public NewsArticleDO find(Long id) throws EntityNotFoundException
    {
        return this.newsArticleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
    }


    @Override
    public NewsArticleDO find(String title) throws EntityNotFoundException
    {
        return this.newsArticleRepository.findByTitle(title).orElseThrow(() -> new EntityNotFoundException("Could not find entity with identifier: " + title));
    }


    @Override
    public Set<NewsArticleDO> find()
    {
        return this.newsArticleRepository.findAll();
    }


    @Override
    public NewsArticleDO create(NewsArticleDO newsArticle)
    {
        return this.newsArticleRepository.save(newsArticle);
    }


    @Override public void updateTitle(Long id, String title) throws EntityNotFoundException
    {
        NewsArticleDO newsArticleDO = this.newsArticleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
        newsArticleDO.setTitle(title);
        this.newsArticleRepository.save(newsArticleDO);
    }


    @Override public void updateText(Long id, String text) throws EntityNotFoundException
    {
        NewsArticleDO newsArticleDO = this.newsArticleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + id));
        newsArticleDO.setTitle(text);
        this.newsArticleRepository.save(newsArticleDO);
    }

}
