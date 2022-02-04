package ch.bbw.mashup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.services.stocks.StockService;

@Controller
public class SearchController {
	    @Autowired
	    private StockService stockService;
	    
	    @GetMapping("/search")
	    public ModelAndView showSearch(){
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("search");
	        return mv;
	    }
	   
	    @PostMapping("/search")
	    public ModelAndView searchStocks(@RequestParam("input") String input){
	    	SearchResult searchResults = stockService.getSearchedStocks(input);
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("search");
	        mv.getModel().put("BestMatches", searchResults.getBestMatches());
	        return mv;
	    }

}
