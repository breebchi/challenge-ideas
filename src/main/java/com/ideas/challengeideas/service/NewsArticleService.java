package com.ideas.challengeideas.service;

import com.ideas.challengeideas.domainobject.NewsArticleDO;
import com.ideas.challengeideas.exception.ConstraintsViolationException;
import com.ideas.challengeideas.exception.EntityNotFoundException;

import java.util.List;

public interface NewsArticleService
{
    NewsArticleDO find(Long id) throws EntityNotFoundException;

    NewsArticleDO find(String title) throws EntityNotFoundException;

    List<NewsArticleDO> find();

    NewsArticleDO create(NewsArticleDO newsArticle) throws ConstraintsViolationException;

    void updateTitle(Long id, String title) throws EntityNotFoundException;

    void updateText(Long id, String texst) throws EntityNotFoundException;
}
