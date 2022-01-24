package ch.bbw.mashup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.services.StockService;
import ch.bbw.mashup.services.StockServiceImpl;

@Controller
public class SearchController {
	
	 	RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
	 
	    @Autowired
	    private StockService stockService = new StockServiceImpl(restTemplateBuilder);
	    
	    @GetMapping("/search")
	    public ModelAndView showStock(){
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("search");
	        return mv;
	    }
	   
	    @PostMapping("/search")
	    public ModelAndView showStock(@RequestParam("input") String input){
	    	SearchResult searchResults = stockService.getSearchedStocks(input);
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("search");
	        mv.getModel().put("StockModelSimple", searchResults.getBestMatches());
	        return mv;
	    }

}
