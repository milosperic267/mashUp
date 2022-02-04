package ch.bbw.mashup.models.stockmodels;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties
public class StockModelDetails {

    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (Daily)")
    private Map<String,TimeSeriesModel> timeSeriesModels = new HashMap();

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Map<String, TimeSeriesModel> getTimeSeriesModels() {
        return timeSeriesModels;
    }

    public void setTimeSeriesModels(Map<String, TimeSeriesModel> timeSeriesModels) {
        this.timeSeriesModels = timeSeriesModels;
    }
}
