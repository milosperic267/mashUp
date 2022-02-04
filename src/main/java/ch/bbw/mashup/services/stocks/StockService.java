package ch.bbw.mashup.services.stocks;

import ch.bbw.mashup.database.StockSymbol;
import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.models.stockmodels.SimpleStockModel;
import ch.bbw.mashup.models.stockmodels.StockModelDetails;

public interface StockService {

    public SearchResult getSearchedStocks(String keyword);

    public StockModelDetails getDetailedStockInformation(String symbol);

    public SimpleStockModel getSimpleStockInformation(String symbol);



}
