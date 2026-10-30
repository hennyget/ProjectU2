package com.javarush.zimina.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.zimina.entity.Answer;
import com.javarush.zimina.entity.Quest;
import com.javarush.zimina.entity.Question;
import com.javarush.zimina.repository.QuestRepository;
import com.javarush.zimina.repository.QuestionRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class QuestLoader {
    private final QuestRepository questRepository;
    private final QuestionRepository questionRepository;

    public QuestLoader(QuestRepository questRepository, QuestionRepository questionRepository) {
        this.questRepository = questRepository;
        this.questionRepository = questionRepository;
    }

    public void load(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(path)) {
            if (input == null) {
                throw new RuntimeException("Файл квеста не найден: " + path);
            }
            QuestData data = mapper.readValue(input, QuestData.class);

            // 1. Вопросы: создаём, сохраняем, запоминаем по метке
            Map<String, Question> byKey = new HashMap<>();
            for (QuestionData questionData : data.getQuestions()) {
                Question question = new Question();
                question.setTitle(questionData.getTitle());
                question.setText(questionData.getText());
                question.setGameState(questionData.getState());
                question.setImage(questionData.getImage());
                questionRepository.save(question);
                byKey.put(questionData.getKey(), question);
            }

            // 2. Ответы: метку "next" превращаем в номер вопроса
            for (QuestionData questionData : data.getQuestions()) {
                Question question = byKey.get(questionData.getKey());
                for (AnswerData answerData : questionData.getAnswers()) {
                    Question next = byKey.get(answerData.getNext());
                    if (next == null) {
                        throw new RuntimeException("Нет вопроса с меткой: " + answerData.getNext());
                    }
                    Answer answer = new Answer(null, answerData.getText(), next.getId());
                    question.getAnswers().add(answer);
                }
            }

            // 3. Квест: с какого вопроса начинать
            Question start = byKey.get(data.getStart());
            Quest quest = new Quest(null, data.getName(), data.getDescription(), start.getId());
            questRepository.save(quest);

        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать квест: " + path, e);
        }
    }
}