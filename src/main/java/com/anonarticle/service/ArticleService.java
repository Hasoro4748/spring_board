package com.anonarticle.service;

import com.anonarticle.dto.AnonArticleDTO;
import com.anonarticle.entity.AnonArticle;
import com.anonarticle.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<AnonArticleDTO> getArticleList(){
        articleRepository.findAll();

        List<AnonArticleDTO> articleDTOList = new ArrayList<>();
        articleRepository.findAll().forEach(article -> {
            AnonArticleDTO articleDTO = article.toDTO();
            articleDTOList.add(articleDTO);
        });
        return articleDTOList;
    }
    public void insertArticle(AnonArticleDTO articleDTO){
        articleRepository.save(articleDTO.toEntity());
    }

    public Page<AnonArticleDTO> getAllArticlePage(Pageable pageable){
        Page<AnonArticle> anonArticlePage = articleRepository.findAllByOrderByArticleIdDesc(pageable);

        return anonArticlePage.map(AnonArticle::toDTO);
    }


    public AnonArticleDTO getArticleById(int id){
        Optional<AnonArticle> anonArticleOpt = articleRepository.findById(id);
        if (anonArticleOpt.isPresent()){
            return anonArticleOpt.get().toDTO();
        }else {
            return null;
        }
    }

    public void deleteArticleById(int id){
        articleRepository.deleteById(id);
    }

    public void updateArticle(AnonArticleDTO articleDTO){
        articleRepository.save(articleDTO.toEntity());
    }
}
