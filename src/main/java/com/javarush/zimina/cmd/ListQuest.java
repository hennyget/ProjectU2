package com.javarush.zimina.cmd;

import com.javarush.zimina.service.QuestService;
import com.javarush.zimina.util.Key;
import jakarta.servlet.http.HttpServletRequest;

public class ListQuest implements Command {
    private final QuestService questService;

    public ListQuest(QuestService questService) {
        this.questService = questService;
    }

    @Override
    public String doGet(HttpServletRequest request) {
        request.setAttribute(Key.QUESTS, questService.getAll());
        return getView();
    }
}
