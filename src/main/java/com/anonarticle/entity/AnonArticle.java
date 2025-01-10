package com.anonarticle.entity;

import com.anonarticle.dto.AnonArticleDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "article")
public class AnonArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleId;
    private String articleTitle;
    private String articleAuthor;
    private String articleContent;

    public AnonArticleDTO toDTO(){
        return AnonArticleDTO.builder()
                .articleId(articleId)
                .articleTitle(articleTitle)
                .articleAuthor(articleAuthor)
                .articleContent(articleContent)
                .build();
    }
}
