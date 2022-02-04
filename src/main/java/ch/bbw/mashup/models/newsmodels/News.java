package ch.bbw.mashup.models.newsmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties
public class News {

    @JsonProperty("data")
    private List<Article> news = new ArrayList();

    public List<Article> getArticles() {
        return news;
    }

    public void setNews(List<Article> news) {
        this.news = news;
    }
}
