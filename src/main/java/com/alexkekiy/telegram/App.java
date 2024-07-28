package com.alexkekiy.telegram;


import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
@SpringBootApplication
@Component
public class App {
    private final TinderBot tinderBot;

    public App(TinderBot tinderBot) {
        this.tinderBot = tinderBot;
    }

    @PostConstruct
    public void init() throws TelegramApiException {
        new TelegramBotsApi(DefaultBotSession.class).registerBot(tinderBot);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

}
