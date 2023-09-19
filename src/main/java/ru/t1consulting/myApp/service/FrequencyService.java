
package ru.t1consulting.myApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class FrequencyService {

    @Autowired
    public FrequencyService() {

    }

    public List<Map<Character, Integer>> calculateFrequency(List<String> inputStrings) {

        List<Map<Character, Integer>> frequencyList = new ArrayList<>();

        for (String text : inputStrings) {
            Map<Character, Integer> frequencyMap = new HashMap<>();

            // Подсчет частоты символов в строке
            for (char c : text.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }

            // Сортировка по убыванию частоты
            frequencyList.add(frequencyMap.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)));
        }

        return frequencyList;
    }
}

