package worldBuildingEncyclopedia_V1.database_operations;

import org.springframework.stereotype.Repository;
import worldBuildingEncyclopedia_V1.models.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleDatabase {

    public List<Article> getAllArticles() throws SQLException {

        List<Article> articles = new ArrayList<>();

        String sql = "SELECT * FROM articles";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)){

            try(ResultSet result = statement.executeQuery()){
                while(result.next()){
                    Article article = new Article(
                            result.getInt("article_id"),
                            result.getString("title"),
                            result.getString("content")
                    );
                    articles.add(article);
                }
            }
        }
        return articles;
    }

    public Article getArticle(int article_id) throws SQLException {

        String sql = "SELECT * FROM articles WHERE article_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, article_id);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    return new Article(
                            result.getInt("article_id"),
                            result.getString("title"),
                            result.getString("content")
                    );
                }
            }
        }

        return null;
    }

    public List<Article> getArticlesLike(String title) throws SQLException{

        List<Article> articles = new ArrayList<>();

        String sql = "SELECT * FROM articles WHERE title LIKE ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,  "%" + title + "%");

            try(ResultSet result = statement.executeQuery()){

                while(result.next()){
                    Article game = new Article(
                            result.getInt("article_id"),
                            result.getString("title"),
                            result.getString("content")
                    );

                    articles.add(game);
                }
            }
        }
        return articles;
    }
}
