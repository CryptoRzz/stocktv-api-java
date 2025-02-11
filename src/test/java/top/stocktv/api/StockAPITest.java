package top.stocktv.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StockAPITest {
    private StockAPI stockAPI;

    @BeforeEach
    public void setUp() {
        String apiKey = "your_api_key_here";
        stockAPI = new StockAPI(apiKey);
    }

    @Test
    public void testGetStockList() throws Exception {
        String response = stockAPI.getStockList(14, 10, 1);
        assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testGetIndices() throws Exception {
        String response = stockAPI.getIndices(14, null);
        assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testGetKline() throws Exception {
        String response = stockAPI.getKline(7310, "PT1M");
        assertNotNull(response);
        System.out.println(response);
    }
}