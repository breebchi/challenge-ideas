package com.ideas.challengeideas.dataaccessobject;

import com.ideas.challengeideas.domainobject.NewsArticleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticleDO, Long>
{
    Optional<NewsArticleDO> findByTitle(String title);
}
