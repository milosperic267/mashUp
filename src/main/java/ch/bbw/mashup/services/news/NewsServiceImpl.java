package ch.bbw.mashup.services.news;

import ch.bbw.mashup.RequestResponseLoggingInterceptor;
import ch.bbw.mashup.models.newsmodels.News;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class NewsServiceImpl implements NewsService{
    private final String mediastockKey = "0de48865af45a874a53eec3ae41c6145";
    private String urlSearchNews = "http://api.mediastack.com/v1/news?access_key=";
    private String searchFunction = "&languages=de&keywords=";
    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;

    public NewsServiceImpl(){
        restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder.build();
        this.restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
    }


    @Override
    public News getSearchedNews(String keyword) {
        String urlSearchNewsComplete = urlSearchNews + mediastockKey +searchFunction+ keyword;
        return restTemplate.getForObject(urlSearchNewsComplete, News.class);
    }
}
