package ch.bbw.mashup.controller;
import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.services.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    @Autowired
    private StockServiceImpl stockService = new StockServiceImpl(restTemplateBuilder);

    @GetMapping("/home")
    public ModelAndView showStock(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        SearchResult tesco = stockService.getSearchedStocks("apple");
        mv.getModel().put("StockModelSimple", tesco.getBestMatches());
        return mv;

    }

    @GetMapping("/")
    public ModelAndView showHomer(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;

    }




}
