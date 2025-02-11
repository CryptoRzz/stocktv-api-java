package top.stocktv.utils;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ApiUtils {
    private static final String BASE_URL = "https://api.stocktv.top";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    private String apiKey;

    public ApiUtils(String apiKey) {
        this.apiKey = apiKey;
    }

    public String get(String endpoint, String queryParams) throws IOException {
        String url = BASE_URL + "/" + endpoint + "?key=" + apiKey + (queryParams != null ? "&" + queryParams : "");
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public <T> T get(String endpoint, String queryParams, Class<T> responseType) throws IOException {
        String json = get(endpoint, queryParams);
        return gson.fromJson(json, responseType);
    }
}