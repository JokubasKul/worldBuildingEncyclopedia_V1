package worldBuildingEncyclopedia_V1.models;

public class Article {

    private int article_id;
    private String title;
    private String content;

    public Article(int article_id, String title, String content){
        this.article_id=article_id;
        this.title=title;
        this.content=content;
    }

    public int getArticleId() {
        return article_id;
    }
    public void setArticleId(int article_id) {
        this.article_id = article_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
