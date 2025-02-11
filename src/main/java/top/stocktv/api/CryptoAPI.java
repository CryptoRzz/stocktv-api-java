package top.stocktv.api;


import top.stocktv.utils.ApiUtils;

import java.io.IOException;

public class CryptoAPI {
    private ApiUtils apiUtils;

    public CryptoAPI(String apiKey) {
        this.apiUtils = new ApiUtils(apiKey);
    }

    public String getCoinInfo() throws IOException {
        return apiUtils.get("crypto/getCoinInfo", null);
    }

    public String getCoinList(int start, int limit) throws IOException {
        String queryParams = "start=" + start + "&limit=" + limit;
        return apiUtils.get("crypto/getCoinList", queryParams);
    }

    public String getTickerPrice(String symbols) throws IOException {
        String queryParams = "symbols=" + symbols;
        return apiUtils.get("crypto/tickerPrice", queryParams);
    }

    public String getLastPrice(String symbols) throws IOException {
        String queryParams = "symbols=" + symbols;
        return apiUtils.get("crypto/lastPrice", queryParams);
    }

    public String getKlines(String symbol, String interval) throws IOException {
        String queryParams = "symbol=" + symbol + "&interval=" + interval;
        return apiUtils.get("crypto/getKlines", queryParams);
    }

    public String getTrades(String symbol) throws IOException {
        String queryParams = "symbol=" + symbol;
        return apiUtils.get("crypto/getTrades", queryParams);
    }
}