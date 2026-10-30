package com.javarush.zimina.repository;

import com.javarush.zimina.entity.Quest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class QuestRepository {
    private final Map<Long, Quest> quests = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public void save(Quest quest) {
        quest.setId(nextId.getAndIncrement());
        quests.put(quest.getId(), quest);
    }

    public Quest findById(Long questId) {
        return quests.get(questId);
    }

    public List<Quest> findAll() {
        return new ArrayList<>(quests.values());
    }
}
