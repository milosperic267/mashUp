package ch.bbw.mashup.services;

import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.models.stockmodels.StockModelDetails;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockServiceImpl implements StockService {
    public final RestTemplate restTemplate;
    private final String apikey = "YL9BPUBSUPEV4TQI";
    String urlForSearch;
    String urlForDetailedInformation;
    String url = "https://www.alphavantage.co/query?function=";
    String searchFunction = "SYMBOL_SEARCH&keywords=";
    String timeSeriesDailyFunction = "TIME_SERIES_DAILY&interval=5min&";

    public StockServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public SearchResult getSearchedStocks(String keyword) {
        urlForSearch = url +  searchFunction  + keyword + "&apikey=" + apikey;
        return this.restTemplate.getForObject(urlForSearch, SearchResult.class);
    }

    public StockModelDetails getDetailedStockInformation(String symbol){
        urlForDetailedInformation = url + timeSeriesDailyFunction + "apikey=" + apikey +"&symbol=" + symbol;
        return this.restTemplate.getForObject(urlForSearch, StockModelDetails.class);
    }

}
