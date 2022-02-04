package ch.bbw.mashup.database;

import ch.bbw.mashup.models.stockmodels.SimpleStockModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockSymbolRepository extends CrudRepository<StockSymbol, Long> {
    List<StockSymbol> findBySymbol(String symbol);

}
