# StockTV API Java 客户端

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-8%2B-orange)](https://www.oracle.com/java/)

StockTV API 的 Java 客户端实现，提供全球股票、外汇、期货和加密货币市场数据的接入能力。

## 📦 功能特性

- 完整的 API 端点覆盖（股票/外汇/期货/加密货币）
- 同步 HTTP 请求支持（基于 OkHttp）
- WebSocket 实时数据支持
- 类型安全的 JSON 解析（基于 Gson）
- 模块化设计，易于扩展

## 🚀 快速开始

### 环境要求
- Java 8+
- Maven 3.6+

### 安装步骤

1. 克隆仓库
```bash
git clone https://github.com/CryptoRzz/stocktv-api-java.git
```

2. 构建项目

```bash
mvn clean install
```

3. 添加依赖到您的项目

```xml
<dependency>
    <groupId>top.stocktv</groupId>
    <artifactId>stocktv-api-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 🔧 配置使用

### 初始化客户端

```java
String apiKey = "your_api_key_here"; // 通过官方渠道申请
StockAPI stockAPI = new StockAPI(apiKey);
```

### 调用股票API示例

```java
// 获取印度股票列表
try {
    String response = stockAPI.getStockList(
        14,   // 国家ID（印度）
        10,    // 每页数量
        1      // 页码
    );
    System.out.println("股票列表: \n" + response);
} catch (IOException e) {
    System.err.println("API调用失败: " + e.getMessage());
}

// 获取Nifty50指数数据
String indicesData = stockAPI.getIndices(14, "IN");
```

### WebSocket 实时数据

```java
WebSocketClient wsClient = new WebSocketClient(
    URI.create("wss://ws-api.stocktv.top/connect?key=" + apiKey)) {

    @Override
    public void onMessage(String message) {
        System.out.println("实时数据: " + message);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
};

wsClient.connect();
```

## 📚 API 模块概览

| 模块           | 功能描述         | 关键方法示例                              |
| -------------- | ---------------- | ----------------------------------------- |
| **StockAPI**   | 股票市场数据     | `getKline()`, `getUpdownList()`           |
| **ForexAPI**   | 外汇汇率与交叉盘 | `getSparkData()`, `getChartData()`        |
| **FuturesAPI** | 期货合约行情     | `getFuturesMarket()`, `getFuturesKline()` |
| **CryptoAPI**  | 加密货币实时数据 | `getKlines()`, `getTickerPrice()`         |

## 🧪 运行测试

```bash
mvn test -Dtest=StockAPITest#testGetStockList
```

完整测试套件：

```bash
mvn test
```

## 🛠️ 开发指南

### 项目结构

```
src/
├── main/java/top/stocktv/api/
│   ├── StockAPI.java       # 股票接口实现
│   ├── ForexAPI.java       # 外汇接口实现
│   ├── FuturesAPI.java     # 期货接口实现
│   ├── CryptoAPI.java      # 加密货币接口
│   └── utils/
│       └── ApiUtils.java   # HTTP客户端工具类
```

### 扩展自定义实现

```java
public class CustomAPI extends ApiUtils {
    public CustomAPI(String apiKey) {
        super(apiKey);
    }
    
    public CustomResponse getCustomData() throws IOException {
        String json = get("custom/endpoint", "param=value");
        return new Gson().fromJson(json, CustomResponse.class);
    }
}
```

## 🤝 贡献代码

1. Fork 项目仓库
2. 创建特性分支 (`git checkout -b feature/awesome-feature`)
3. 提交修改 (`git commit -m 'Add awesome feature'`)
4. 推送分支 (`git push origin feature/awesome-feature`)
5. 创建 Pull Request

## 📄 许可证

本项目采用 [MIT 许可证](LICENSE)

---

**技术支持**：访问 [StockTV 官方文档](https://stocktv.top/) 或 [联系StockTV客服](https://t.me/CryptoRzz)