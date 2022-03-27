package com.liga.internship.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "@OldSlavSeeker_bot";
    }

    @Override
    public String getBotToken() {
        return "5292525424:AAF-YazXKt31FzfqQMPm-6KuHh-Eo7QwA7o";
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            handleMessage(update.getMessage());
        }
    }

    @SneakyThrows
    private void handleMessage(Message message) {
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (commandEntity.isPresent()) {
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                switch (command) {
                    case "/sign_up":

                    case "/sign_in":
                        execute(SendMessage.builder()
                                .text("Пожалуйста, введите логин и пароль: \n" +
                                        "Пример: david@gmail.com Origin1243")
                                .chatId(message.getChatId().toString())
                                .build());
                        break;
                    case "/log_out":
                        execute(SendMessage.builder()
                                .text("Вы вышли.")
                                .chatId(message.getChatId().toString())
                                .build());
                        break;
                }

            }
        }
    }
}
