package ch.bbw.mashup.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockSymbol {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String symbol;

    protected StockSymbol(){}

    public String getSymbol() {
        return symbol;
    }

    public StockSymbol(String symbol){
        this.symbol = symbol;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StockSymbol{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
