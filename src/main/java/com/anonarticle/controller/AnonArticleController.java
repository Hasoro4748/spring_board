package com.anonarticle.controller;

import com.anonarticle.dto.AnonArticleDTO;
import com.anonarticle.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class AnonArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String articleList(Model model){
        model.addAttribute("articleList", articleService.getArticleList());
        return "article/list";
    }

    @GetMapping("/article/write")
    public String write(){
        return "/article/write";
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

    @DeleteMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable String id){
        articleService.deleteArticleById(Integer.parseInt(id));
        return "redirect:/article/list";
    }
}
