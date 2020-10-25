package com.travelbot.telegram.bot.handler;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;

import java.io.Serializable;
import java.util.List;

public interface Handler {
    List<PartialBotApiMethod<? extends Serializable>> handle(int chatId, String message);

    List<String> operatedCallBackQuery();
}
