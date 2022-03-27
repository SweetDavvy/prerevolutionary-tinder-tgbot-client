package com.liga.internship;

import com.liga.internship.bot.Bot;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class PrerevolutionaryTinderTgbotClientApplication {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(PrerevolutionaryTinderTgbotClientApplication.class, args);
        Bot bot = new Bot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }

}
