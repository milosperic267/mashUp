package ch.bbw.mashup.models.stockmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    @JsonProperty("bestMatches")
    private List<StockModelSimple> bestMatches = new ArrayList<>();

    public SearchResult(){

    }

    public List<StockModelSimple> getBestMatches() {
        return bestMatches;
    }

    public void setBestMatches(List<StockModelSimple> bestMatches) {
        this.bestMatches = bestMatches;
    }
}
