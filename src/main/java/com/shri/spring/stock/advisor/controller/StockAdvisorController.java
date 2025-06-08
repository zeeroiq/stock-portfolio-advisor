package com.shri.spring.stock.advisor.controller;

import com.shri.spring.stock.advisor.assistant.StockAdvisorAssistant;
import dev.langchain4j.model.chat.ChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StockAdvisorController {

    private final ChatModel chatModel;
    private final StockAdvisorAssistant stockAdvisorAssistant;

    @GetMapping("/chat")
    public String model(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        return chatModel.chat(message);
    }

    @GetMapping("/assistant/chat")
    public String chat(String message) {
        return stockAdvisorAssistant.chat(message);
    }
}
