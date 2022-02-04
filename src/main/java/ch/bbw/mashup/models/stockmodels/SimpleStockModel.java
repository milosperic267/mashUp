package ch.bbw.mashup.models.stockmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class SimpleStockModel {

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("Name")
    private String name;




    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleStockModel{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

