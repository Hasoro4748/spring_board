package com.anonarticle.repository;

import com.anonarticle.entity.AnonArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<AnonArticle, Integer> {
}
