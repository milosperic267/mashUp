package ch.bbw.mashup.models.stockmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    @JsonProperty("bestMatches")
    private List<SearchResultStockModel> bestMatches = new ArrayList<>();
  


	public SearchResult(){

    }

    public List<SearchResultStockModel> getBestMatches() {
        return bestMatches;
    }

    public void setBestMatches(List<SearchResultStockModel> bestMatches) {
        this.bestMatches = bestMatches;
    }
}
