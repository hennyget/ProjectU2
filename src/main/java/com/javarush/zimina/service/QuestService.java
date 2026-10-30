package com.javarush.zimina.service;

import com.javarush.zimina.entity.Quest;
import com.javarush.zimina.repository.QuestRepository;

import java.util.List;

public class QuestService {
    private final QuestRepository questRepository;

    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public List<Quest> getAll() {
        return questRepository.findAll();
    }
}
