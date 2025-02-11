package top.stocktv.api;


import top.stocktv.utils.ApiUtils;

import java.io.IOException;

public class ForexAPI {
    private ApiUtils apiUtils;

    public ForexAPI(String apiKey) {
        this.apiUtils = new ApiUtils(apiKey);
    }

    public String getCurrencyList() throws IOException {
        return apiUtils.get("market/currencyList", null);
    }

    public String getRealTimeRates(String countryType) throws IOException {
        String queryParams = countryType != null ? "countryType=" + countryType : "";
        return apiUtils.get("market/currency", queryParams);
    }

    public String getTodayMarket(String symbol) throws IOException {
        String queryParams = "symbol=" + symbol;
        return apiUtils.get("market/todayMarket", queryParams);
    }

    public String getSparkData(String symbol, String interval) throws IOException {
        String queryParams = "symbol=" + symbol + "&interval=" + interval;
        return apiUtils.get("market/spark", queryParams);
    }

    public String getChartData(String symbol, String interval, String startTime, String endTime) throws IOException {
        String queryParams = "symbol=" + symbol + "&interval=" + interval;
        if (startTime != null) {
            queryParams += "&startTime=" + startTime;
        }
        if (endTime != null) {
            queryParams += "&endTime=" + endTime;
        }
        return apiUtils.get("market/chart", queryParams);
    }
}