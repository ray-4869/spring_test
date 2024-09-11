package com.sbb.basic;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    @Autowired
    private final ArticleService articleService;
    @GetMapping("/article/list")
    public String list(Model model){
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }
    @GetMapping("/article/detail/{id}")
    public String detail (Model model, @PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        model.addAttribute("articleList");
        return "article_detail";
    }
    @GetMapping("/article/create")
    public String create () {
        return "article_form";
    }

    @PostMapping("/article/create")
    public String create(@Valid ArticleForm articleForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "article_form";
        }
        this.articleService.create(articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list";
    }
}
