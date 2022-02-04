package ch.bbw.mashup.services.news;

import ch.bbw.mashup.models.newsmodels.News;

public interface NewsService {
    public News getSearchedNews(String keyword);
}
