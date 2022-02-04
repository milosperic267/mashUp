package ch.bbw.mashup.controller;
import ch.bbw.mashup.database.StockSymbol;
import ch.bbw.mashup.database.StockSymbolRepository;
import ch.bbw.mashup.models.stockmodels.SimpleStockModel;
import ch.bbw.mashup.services.stocks.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    @Autowired
    StockSymbolRepository stockSymbolRepository;

    @Autowired
    private StockService stockService;

    static Logger logger = Logger.getLogger(HomeController.class.getName());
   
    @GetMapping("/home")
    public ModelAndView showStock(@RequestParam("symbol") String symbol){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");

        //Prüfen ob es das Symbol schon in der DB gibt
        List<StockSymbol> symbols = stockSymbolRepository.findBySymbol(symbol);
        logger.info("Symbol: " + symbol +"Ergebnis: " + Arrays.toString(symbols.toArray()));

        if(symbols.isEmpty()){
            stockSymbolRepository.save(new StockSymbol(symbol));
        }
        //Buttons auf der linken Seite
        //alle Symbols holend
        Iterable<StockSymbol> symbolsFromDB = stockSymbolRepository.findAll();
        logger.info("symnolsFromDB" + symbolsFromDB);
        Iterator<StockSymbol> sybolsFromDBit = symbolsFromDB.iterator();
        List<SimpleStockModel> simpleStockModel = new ArrayList<>();
        while (sybolsFromDBit.hasNext()){
            simpleStockModel.add(stockService.getSimpleStockInformation(sybolsFromDBit.next().getSymbol()));
        }
        logger.info("simpleStockModelList: " + Arrays.toString(simpleStockModel.toArray()));
        mv.getModel().put("SimpleStockModelList", simpleStockModel);
        return mv;

    }





}
