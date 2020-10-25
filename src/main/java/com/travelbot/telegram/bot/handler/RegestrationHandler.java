package com.travelbot.telegram.bot.handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import com.travelbot.telegram.data.DataController;
import java.io.Serializable;
import java.util.List;

@Component
public class RegestrationHandler implements Handler {
    public static final String INFO_ACCEPT = "/countries";
    DataController data;

    @Autowired
    public RegestrationHandler(DataController data) {
        this.data = data;
    }

    public RegestrationHandler() {}

    @Override
    public List<PartialBotApiMethod<? extends Serializable>> handle(int chatId,String message) {
        SendMessage infomessage = new SendMessage().setChatId(String.valueOf(chatId));
        try {
            infomessage.setText(data.read(message).getBody());
        } catch (NullPointerException e) {
            infomessage.setText("Cant find");
        }
        return List.of(infomessage);
    }

    @Override
    public List<String> operatedCallBackQuery() {
        return List.of(INFO_ACCEPT);
    }
}
