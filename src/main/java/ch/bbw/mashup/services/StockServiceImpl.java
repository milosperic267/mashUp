package ch.bbw.mashup.services;

import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.models.stockmodels.StockModelDetails;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockServiceImpl implements StockService {
    public final RestTemplate restTemplate ;
    private final String apikey = "YL9BPUBSUPEV4TQI";
    String urlForSearch;
    String urlForDetailedInformation;
    String url = "https://www.alphavantage.co/query?function=";
    String searchFunction = "SYMBOL_SEARCH&keywords=";
    String timeSeriesDailyFunction = "TIME_SERIES_DAILY&interval=5min&";
    String PROXY_SERVER_HOST = "http://s8023735:Ihdlida2019.@webproxy.sr.allianz-suisse.ch";
    int PROXY_SERVER_PORT = 8080;
    

    public StockServiceImpl(RestTemplateBuilder restTemplateBuilder) {
    	Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(PROXY_SERVER_HOST, PROXY_SERVER_PORT));
    	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    	requestFactory.setProxy(proxy);
        //this.restTemplate = restTemplateBuilder.build();
        restTemplate = new RestTemplate(requestFactory);
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
