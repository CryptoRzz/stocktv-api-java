package top.stocktv.api;


import top.stocktv.utils.ApiUtils;

import java.io.IOException;

public class StockAPI {
    private ApiUtils apiUtils;

    public StockAPI(String apiKey) {
        this.apiUtils = new ApiUtils(apiKey);
    }

    public String getStockList(int countryId, int pageSize, int page) throws IOException {
        String queryParams = "countryId=" + countryId + "&pageSize=" + pageSize + "&page=" + page;
        return apiUtils.get("stock/stocks", queryParams);
    }

    public String getIndices(int countryId, String flag) throws IOException {
        String queryParams = "countryId=" + countryId + (flag != null ? "&flag=" + flag : "");
        return apiUtils.get("stock/indices", queryParams);
    }

    public String getKline(int pid, String interval) throws IOException {
        String queryParams = "pid=" + pid + "&interval=" + interval;
        return apiUtils.get("stock/kline", queryParams);
    }

    public String getIpoCalendar(int countryId) throws IOException {
        String queryParams = "countryId=" + countryId;
        return apiUtils.get("stock/getIpo", queryParams);
    }

    public String getUpdownList(int countryId, int type) throws IOException {
        String queryParams = "countryId=" + countryId + "&type=" + type;
        return apiUtils.get("stock/updownList", queryParams);
    }

    public String getCompanyInfo(int countryId, int pageSize, int page) throws IOException {
        String queryParams = "countryId=" + countryId + "&pageSize=" + pageSize + "&page=" + page;
        return apiUtils.get("stock/companies", queryParams);
    }

    public String getCompanyInfoByUrl(String url) throws IOException {
        String queryParams = "url=" + url;
        return apiUtils.get("stock/companyUrl", queryParams);
    }

    public String getNews(int pageSize, int page) throws IOException {
        String queryParams = "pageSize=" + pageSize + "&page=" + page;
        return apiUtils.get("stock/news", queryParams);
    }
}