package com.alexkekiy.telegram;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Data
@Component
public class BotDTO {
    @Value("${bot.name}")
    private String name;
    @Value("${bot.token}")
    private String token ;
    @Value("${ai.token}")
    private String OPEN_AI_TOKEN = "chat-gpt-token";
}
