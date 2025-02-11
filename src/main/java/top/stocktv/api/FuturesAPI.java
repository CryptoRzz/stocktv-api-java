package top.stocktv.api;


import top.stocktv.utils.ApiUtils;

import java.io.IOException;

public class FuturesAPI {
    private ApiUtils apiUtils;

    public FuturesAPI(String apiKey) {
        this.apiUtils = new ApiUtils(apiKey);
    }

    public String getFuturesList() throws IOException {
        return apiUtils.get("futures/list", null);
    }

    public String getFuturesMarket(String symbol) throws IOException {
        String queryParams = "symbol=" + symbol;
        return apiUtils.get("futures/querySymbol", queryParams);
    }

    public String getFuturesKline(String symbol, String interval) throws IOException {
        String queryParams = "symbol=" + symbol + "&interval=" + interval;
        return apiUtils.get("futures/kline", queryParams);
    }
}