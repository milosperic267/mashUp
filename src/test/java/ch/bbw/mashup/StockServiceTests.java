package ch.bbw.mashup;

import ch.bbw.mashup.models.stockmodels.SearchResult;
import ch.bbw.mashup.services.stocks.StockServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class StockServiceTests {
    private StockServiceImpl stockService = new StockServiceImpl();

    @Test
     void getStocksFromJsonTest(){
        String expected = "{\n" +
                "    \"bestMatches\": [\n" +
                "        {\n" +
                "            \"1. symbol\": \"TSCO.LON\",\n" +
                "            \"2. name\": \"Tesco PLC\",\n" +
                "            \"3. type\": \"Equity\",\n" +
                "            \"4. region\": \"United Kingdom\",\n" +
                "            \"5. marketOpen\": \"08:00\",\n" +
                "            \"6. marketClose\": \"16:30\",\n" +
                "            \"7. timezone\": \"UTC+00\",\n" +
                "            \"8. currency\": \"GBX\",\n" +
                "            \"9. matchScore\": \"0.7273\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"1. symbol\": \"TSCDF\",\n" +
                "            \"2. name\": \"Tesco plc\",\n" +
                "            \"3. type\": \"Equity\",\n" +
                "            \"4. region\": \"United States\",\n" +
                "            \"5. marketOpen\": \"09:30\",\n" +
                "            \"6. marketClose\": \"16:00\",\n" +
                "            \"7. timezone\": \"UTC-04\",\n" +
                "            \"8. currency\": \"USD\",\n" +
                "            \"9. matchScore\": \"0.7143\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"1. symbol\": \"TSCDY\",\n" +
                "            \"2. name\": \"Tesco plc\",\n" +
                "            \"3. type\": \"Equity\",\n" +
                "            \"4. region\": \"United States\",\n" +
                "            \"5. marketOpen\": \"09:30\",\n" +
                "            \"6. marketClose\": \"16:00\",\n" +
                "            \"7. timezone\": \"UTC-04\",\n" +
                "            \"8. currency\": \"USD\",\n" +
                "            \"9. matchScore\": \"0.7143\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        SearchResult actual = stockService.getSearchedStocks("tesco");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ignoreAdditionalAttribute(){
        String expected = "{\n" +
                "    \"bestMatches\": [\n" +
                "        {\n" +
                "            \"1. symbol\": \"TSCO.LON\",\n" +
                "            \"2. name\": \"Tesco PLC\",\n" +
                "            \"3. type\": \"Equity\",\n" +
                "            \"4. region\": \"United Kingdom\",\n" +
                "            \"5. marketOpen\": \"08:00\",\n" +
                "            \"6. marketClose\": \"16:30\",\n" +
                "            \"7. timezone\": \"UTC+00\",\n" +
                "            \"8. currency\": \"GBX\",\n" +
                "            \"9. matchScore\": \"0.7273\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"1. symbol\": \"TSCDF\",\n" +
                "            \"2. name\": \"Tesco plc\",\n" +
                "            \"3. type\": \"Equity\",\n" +
                "            \"4. region\": \"United States\",\n" +
                "            \"5. marketOpen\": \"09:30\",\n" +
                "            \"6. marketClose\": \"16:00\",\n" +
                "            \"7. timezone\": \"UTC-04\",\n" +
                "            \"8. currency\": \"USD\",\n" +
                "            \"9. matchScore\": \"0.7143\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"1. symbol\": \"TSCDY\",\n" +
                "            \"2. name\": \"Tesco plc\",\n" +
                "            \"3. type\": \"Equity\",\n" +
                "            \"4. region\": \"United States\",\n" +
                "            \"5. marketOpen\": \"09:30\",\n" +
                "            \"6. marketClose\": \"16:00\",\n" +
                "            \"7. timezone\": \"UTC-04\",\n" +
                "            \"8. currency\": \"USD\",\n" +
                "            \"9. matchScore\": \"0.7143\"\n" +
                "            \"10. matchSasdcore\": \"0.7143\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        SearchResult actual = stockService.getSearchedStocks("tesco");
        assertThat(actual).isEqualTo(expected);
    }

    //wenn nichts zurückkommt, technischer Grund (proxy)


}
