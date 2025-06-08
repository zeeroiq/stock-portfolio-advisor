package com.shri.spring.stock.advisor.assistant;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface StockAdvisorAssistant {
    @SystemMessage("""
            You are an expert stocks advisor assistant, who provides extensive stock advices.
            """)
    String chat(String message);
}
