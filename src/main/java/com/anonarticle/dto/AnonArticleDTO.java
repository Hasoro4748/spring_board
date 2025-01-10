package com.anonarticle.dto;

import com.anonarticle.entity.AnonArticle;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AnonArticleDTO {
    int articleId;
    String articleTitle;
    String articleAuthor;
    String articleContent;

    public AnonArticle toEntity(){
        return AnonArticle.builder()
                .articleId(articleId)
                .articleTitle(articleTitle)
                .articleAuthor(articleAuthor)
                .articleContent(articleContent)
                .build();
    }
}
