package com.ideas.challengeideas.controller;

import com.ideas.challengeideas.controller.mapper.NewsArticleMapper;
import com.ideas.challengeideas.datatransferobject.NewsArticleDTO;
import com.ideas.challengeideas.domainobject.NewsArticleDO;
import com.ideas.challengeideas.exception.ConstraintsViolationException;
import com.ideas.challengeideas.exception.EntityNotFoundException;
import com.ideas.challengeideas.service.NewsArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/news-articles")
public class NewsArticleController
{
    private final NewsArticleService newsArticleService;


    public NewsArticleController(NewsArticleService newsArticleService)
    {
        this.newsArticleService = newsArticleService;
    }


    @GetMapping
    public List<NewsArticleDTO> findNewsArticles()
    {
        return NewsArticleMapper.makeNewsArticleDTOList(this.newsArticleService.find());
    }


    @GetMapping("/{id}")
    public NewsArticleDTO findNewsArticle(@PathVariable long id) throws EntityNotFoundException
    {
        return NewsArticleMapper.makeNewsArticleDTO(this.newsArticleService.find(id));
    }


    @GetMapping("/title")
    public NewsArticleDTO findNewsArticle(@RequestParam String title) throws EntityNotFoundException
    {
        return NewsArticleMapper.makeNewsArticleDTO(this.newsArticleService.find(title));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsArticleDTO createNewsArticle(@RequestBody NewsArticleDTO newsArticleDTO) throws ConstraintsViolationException
    {
        NewsArticleDO newsArticleDO = NewsArticleMapper.makeNewsArticleDO(newsArticleDTO);
        return NewsArticleMapper.makeNewsArticleDTO(newsArticleService.create(newsArticleDO));
    }


    @PutMapping("/{id}/title")
    public void updateTitle(@PathVariable Long id, @RequestParam String title) throws EntityNotFoundException
    {
        this.newsArticleService.updateTitle(id, title);
    }


    @PutMapping("/{id}/text")
    public void updateText(@PathVariable Long id, @RequestParam String text) throws EntityNotFoundException
    {
        this.newsArticleService.updateTitle(id, text);
    }
}
