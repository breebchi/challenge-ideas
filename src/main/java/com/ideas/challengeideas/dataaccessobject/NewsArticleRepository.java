package com.ideas.challengeideas.dataaccessobject;

import com.ideas.challengeideas.domainobject.NewsArticleDO;

import java.util.Optional;
import java.util.Set;

public interface NewsArticleRepository
{
    Set<NewsArticleDO> findAll();

    Optional<NewsArticleDO> findByTitle(String title);

    Optional<NewsArticleDO> findById(Long id);

    NewsArticleDO save(NewsArticleDO newsArticle);
}
