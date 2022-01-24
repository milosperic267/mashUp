package ch.bbw.mashup.services;

import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.models.stockmodels.StockModelDetails;

public interface StockService {

    public SearchResult getSearchedStocks(String keyword);

    public StockModelDetails getDetailedStockInformation(String symbol);



}
