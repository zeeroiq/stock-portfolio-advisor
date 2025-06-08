package com.shri.spring.stock.advisor.service;

import com.shri.spring.stock.advisor.config.FMGApiConfig;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockInformationService {

    private final FMGApiConfig fmgApiConfig;
    private final RestClient restClient;

    @Tool("Returns the stock price for asked/provided stock code/symbol")
    public String getStockPrice(@P("Stock code/symbol which can be separated by comma (,)") String stockCode){
        log.info("Fetching stock price for stock symbol : {}", stockCode);
        return fetchData("/quote/" + stockCode);
    }

    @Tool("Returns the company profile for asked/provided stock code/symbol")
    public String getCompanyProfile(@P("Stock code/symbol which can be separated by comma (,)") String stockCode){
        log.info("Fetching company profile for stock symbol : {}", stockCode);
        return fetchData("/profile/" + stockCode);
    }

    @Tool("Returns the balance sheets for asked/provided stock code/symbol")
    private List<String> getBalanceSheetStatement(@P("Stock code/symbol which can be separated by comma (,)") String stockCode){
        log.info("Fetching balance sheet for stock code : {}", stockCode);
        return fetchDataForSymbols(stockCode, "/balance-sheet-statement/");
    }

    @Tool("Returns income statements for asked/provided stock code/symbol")
    private List<String> getIncomeStatement(@P("Stock code/symbol which can be separated by comma (,)") String stockCode){
        log.info("Fetching income for stock code : {}", stockCode);
        return fetchDataForSymbols(stockCode, "/income-statement/");
    }

    @Tool("Returns cash flow statements for asked/provided stock code/symbol")
    private List<String> getCashFlowStatement(@P("Stock code/symbol which can be separated by comma (,)") String stockCode){
        log.info("Fetching cash flow for stock code : {}", stockCode);
        return fetchDataForSymbols(stockCode, "/cash-flow-statement/");
    }

    private List<String> fetchDataForSymbols(String stockCode, String path) {
        return Arrays.stream(stockCode.split(","))
                .map(code -> fetchData(path.concat(code)))
                .toList();
    }

    private String fetchData(String api) {
        return restClient.get()
                .uri(api.concat("?apikey=").concat(fmgApiConfig.getFmgApiKey()))
                .retrieve()
                .body(String.class);
    }


}
