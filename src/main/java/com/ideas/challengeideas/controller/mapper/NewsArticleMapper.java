package com.ideas.challengeideas.controller.mapper;

import com.ideas.challengeideas.datatransferobject.NewsArticleDTO;
import com.ideas.challengeideas.domainobject.NewsArticleDO;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class NewsArticleMapper
{
    private NewsArticleMapper()
    {
    }


    public static NewsArticleDO makeNewsArticleDO(NewsArticleDTO newsArticleDTO)
    {
        return new NewsArticleDO(newsArticleDTO.getId(), newsArticleDTO.getTitle().trim(), newsArticleDTO.getText().trim(), newsArticleDTO.getDateCreated());
    }


    public static NewsArticleDTO makeNewsArticleDTO(NewsArticleDO newsArticleDO)
    {
        return NewsArticleDTO.newBuilder()
            .setId(newsArticleDO.getId())
            .setTitle(newsArticleDO.getTitle())
            .setText(newsArticleDO.getText())
            .setDateCreated(newsArticleDO.getDateCreated())
            .createNewsArticleDTO();

    }


    public static Set<NewsArticleDTO> makeNewsArticleDTOList(Collection<NewsArticleDO> newsArticles)
    {
        return newsArticles.stream()
            .map(NewsArticleMapper::makeNewsArticleDTO)
            .collect(Collectors.toSet());
    }
}
