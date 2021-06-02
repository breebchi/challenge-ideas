package com.ideas.challengeideas.service;

import com.ideas.challengeideas.domainobject.NewsArticleDO;
import com.ideas.challengeideas.exception.EntityNotFoundException;

import java.util.Set;

public interface NewsArticleService
{
    NewsArticleDO find(Long id) throws EntityNotFoundException;

    NewsArticleDO find(String title) throws EntityNotFoundException;

    Set<NewsArticleDO> find();

    NewsArticleDO create(NewsArticleDO newsArticle);

    void updateTitle(Long id, String title) throws EntityNotFoundException;

    void updateText(Long id, String texst) throws EntityNotFoundException;
}
