package ch.bbw.mashup.controller;
import ch.bbw.mashup.database.StockSymbol;
import ch.bbw.mashup.database.StockSymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    StockSymbolRepository stockSymbolRepository;
   
    @GetMapping("/home")
    public ModelAndView showStock(@RequestParam("symbol") String symbol){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        stockSymbolRepository.save(new StockSymbol(symbol));
        return mv;

    }





}
