package com.alexkekiy.telegram;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class TinderBot extends MultiSessionTelegramBot {
    public static final String ANSWER_PROMT = "придумай небольшой смешной ответ из 2-5 слов на следующее сообщение или отправь \"...\", если не хочешь отвечать";
    ChatGPTService chatGPTService;


    public TinderBot(BotDTO botDTO, ChatGPTService chatGPTService) {
        super(botDTO.getName(), botDTO.getToken());
        this.chatGPTService = chatGPTService;
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        String lastName = update.getMessage().getFrom().getLastName() == null ? "" :(  " "+update.getMessage().getFrom().getLastName());
        String userName = update.getMessage().getFrom().getFirstName() + lastName;
        log.info("получено сообщение \"{}\" от {}", this.getMessageText(), userName);
        String answer = "";
        if (this.getMessageText().equals("/start")) {
            answer=(userName + "  лох");
        } else {
            try {
                answer = chatGPTService.sendMessage(ANSWER_PROMT, this.getMessageText());
            }catch(Exception ignored) {
                answer = "ладно,я пошутил..";
            }
        }
        this.sendTextMessage(answer);
        log.info("ответил \"{}\"-у: {}",userName, answer);
    }


    @java.lang.Override
    public void onUpdatesReceived(java.util.List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @java.lang.Override
    public void onRegister() {
        super.onRegister();
    }
}
