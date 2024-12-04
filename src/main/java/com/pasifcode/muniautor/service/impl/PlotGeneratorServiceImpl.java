package com.pasifcode.muniautor.service.impl;

import com.pasifcode.muniautor.domain.entity.AiAnswer;
import com.pasifcode.muniautor.domain.entity.AiQuestion;
import com.pasifcode.muniautor.service.PlotGeneratorService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class PlotGeneratorServiceImpl implements PlotGeneratorService {

    private final ChatClient chatClient;

    public PlotGeneratorServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public AiAnswer generatePlot(AiQuestion question) {
        return new AiAnswer(getMessage(question.getQuetion()).getResult().getOutput().getContent());
    }

    private ChatResponse getMessage(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .chatResponse();
    }
}
