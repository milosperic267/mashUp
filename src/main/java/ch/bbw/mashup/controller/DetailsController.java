package ch.bbw.mashup.controller;

import ch.bbw.mashup.models.stockmodels.StockModelDetails;
import ch.bbw.mashup.services.stocks.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailsController {
    @Autowired
    private StockService stockService;

    @GetMapping("/details")
    public ModelAndView showSearch(@RequestParam("symbol") String symbol){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("details");
        StockModelDetails stockModelDetails = stockService.getDetailedStockInformation(symbol);
        mv.getModel().put("StockDetails", stockModelDetails);
        return mv;
    }


}
