package ru.t1consulting.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharFrequenciesServiceImpl implements CharFrequenciesService {

    @Override
    public Map<Character,Integer> getCharFrequencies(String str) {
        if (str == null || str.isBlank())
            return new HashMap<>();

        Map<Character,Integer> frequencies = new HashMap<>();
        for (char ch : str.toCharArray())
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);

        return frequencies.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
