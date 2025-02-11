package top.stocktv;

import top.stocktv.api.StockAPI;

public class Main {
    public static void main(String[] args) {
        String apiKey = "your_api_key_here";
        StockAPI stockAPI = new StockAPI(apiKey);

        try {
            String stockList = stockAPI.getStockList(14, 10, 1);
            System.out.println(stockList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}