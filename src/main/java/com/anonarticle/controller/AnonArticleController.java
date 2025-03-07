package com.anonarticle.controller;

import com.anonarticle.dto.AnonArticleDTO;
import com.anonarticle.dto.PageRequestDTO;
import com.anonarticle.dto.PageResponseDTO;
import com.anonarticle.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AnonArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String articleList(Model model,PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("articleId");
        PageResponseDTO pageResponseDTO = new PageResponseDTO(articleService.getAllArticlePage(pageable));
        model.addAttribute("articlePage", pageResponseDTO);
        return "article/list";
    }

    @GetMapping("/article/write")
    public String write(){
        return "article/write";
    }

    @PostMapping("/article/write")
    public String writePost(AnonArticleDTO articleDTO){
        articleService.insertArticle(articleDTO);

        return "redirect:/article/list";
    }

    @GetMapping("/article/modify/{id}")
    public String ModifyArticle( @PathVariable String id, Model model){
       articleService.getArticleById(Integer.parseInt(id));
       model.addAttribute("article", articleService.getArticleById(Integer.parseInt(id)));
       return "article/modify";
    }

    @PostMapping("/article/modify")
    public String updateArticle(AnonArticleDTO articleDTO){
        articleService.updateArticle(articleDTO);
        return "redirect:/article/list";
    }

    @GetMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable String id){
        articleService.deleteArticleById(Integer.parseInt(id));
        return "redirect:/article/list";
    }
}
