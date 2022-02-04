package ch.bbw.mashup.services.stocks;
import ch.bbw.mashup.RequestResponseLoggingInterceptor;
import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.models.stockmodels.SimpleStockModel;
import ch.bbw.mashup.models.stockmodels.StockModelDetails;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.logging.Logger;

@Service
public class StockServiceImpl implements StockService {
    private final RestTemplate restTemplate;
    private final String apikey = "&apikey=YL9BPUBSUPEV4TQI";
    private String urlForSearch;
    private String urlForDetailedInformation;
    private String urlForSimpleStock;
    private String url = "https://www.alphavantage.co/query?function=";
    private String searchFunction = "SYMBOL_SEARCH&keywords=";
    private String timeSeriesDailyFunction = "TIME_SERIES_DAILY&interval=5min&";
    private String overview = "OVERVIEW";
    static Logger logger = Logger.getLogger(StockServiceImpl.class.getName());
    private RestTemplateBuilder restTemplateBuilder;


    public StockServiceImpl(){
        restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder.build();
        this.restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));

    }

    public SearchResult getSearchedStocks(String keyword) {
        urlForSearch = url +  searchFunction  + keyword + apikey;
        return restTemplate.getForObject(urlForSearch, SearchResult.class);
    }

    public StockModelDetails getDetailedStockInformation(String symbol){
        logger.info("getDetailedStockInformation:  " + symbol);
        urlForDetailedInformation = url + timeSeriesDailyFunction + apikey +"&symbol=" + symbol;
        logger.info("urlForDetailedInfromation: " + urlForDetailedInformation);
        StockModelDetails stockModelDetails = restTemplate.getForObject(urlForDetailedInformation, StockModelDetails.class);
        logger.info("stockModelDetails: " + stockModelDetails);
        return stockModelDetails;
    }

    public SimpleStockModel getSimpleStockInformation(String symbol){
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        logger.info("getSimpleStockInformation:  " + symbol);
        urlForSimpleStock = url + overview + "&symbol="+ symbol + apikey;
        logger.info("urlForSimpleStock: " + urlForSimpleStock);
        SimpleStockModel simpleStockModel = restTemplate.getForObject(urlForSimpleStock, SimpleStockModel.class);
        logger.info("simpleStockModel: " + simpleStockModel);
        return simpleStockModel;

    }

}
