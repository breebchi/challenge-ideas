package com.ideas.challengeideas.dataaccessobject.impl;

import com.ideas.challengeideas.dataaccessobject.NewsArticleRepository;
import com.ideas.challengeideas.domainobject.NewsArticleDO;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class NewsArticleRepositoryImpl implements NewsArticleRepository
{
    Set<NewsArticleDO> newsArticleStore = new HashSet<>();


    @Override
    public Set<NewsArticleDO> findAll()
    {
        return this.newsArticleStore;
    }


    @Override
    public Optional<NewsArticleDO> findByTitle(String title)
    {
        return this.newsArticleStore.stream().filter(newsArticle -> newsArticle.getTitle().equals(title)).findFirst();
    }


    @Override
    public Optional<NewsArticleDO> findById(Long id)
    {
        return this.newsArticleStore.stream().filter(newsArticle -> newsArticle.getId().equals(id)).findFirst();
    }


    @Override
    public NewsArticleDO save(NewsArticleDO newsArticle)
    {
        this.newsArticleStore.add(newsArticle);
        return newsArticle;
    }

}
