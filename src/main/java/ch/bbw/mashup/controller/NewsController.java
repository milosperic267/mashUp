package ch.bbw.mashup.controller;

import ch.bbw.mashup.models.newsmodels.News;
import ch.bbw.mashup.services.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public ModelAndView searchNews(@RequestParam("keyword") String keyword){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("news");News news = newsService.getSearchedNews(keyword);
        for(int i = 0; i < news.getArticles().size(); i++){
            mv.getModel().put("SearchedNews", news.getArticles().get(i));
        }
        return mv;
    }

}
