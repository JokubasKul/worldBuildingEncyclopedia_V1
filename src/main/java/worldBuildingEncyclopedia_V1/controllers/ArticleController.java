package worldBuildingEncyclopedia_V1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import worldBuildingEncyclopedia_V1.database_operations.ArticleDatabase;
import worldBuildingEncyclopedia_V1.models.Article;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ArticleController {

    private final ArticleDatabase articleDatabase;

    public ArticleController(ArticleDatabase articleDatabase){
        this.articleDatabase=articleDatabase;
    }

    @GetMapping("/article/{article_id}")
    public String getArticle(@PathVariable int article_id, Model model) throws SQLException{
        Article article = articleDatabase.getArticle(article_id);

        if (article == null) {
            return "error";
        }
        model.addAttribute("article", article);

        return "article";
    }
}
