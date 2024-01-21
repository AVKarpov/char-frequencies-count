package ru.t1consulting.test;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CharFrequenciesController {

    private final CharFrequenciesService charFrequenciesService;

    /**
     * Подсчёт количества вхождений символов в строке
     * @param str входная строка
     * @return Список символов и количество вхождений в убывающем порядке
     */

    @GetMapping("/frequencies")
    public Map<Character,Integer> getCharFrequencies(@RequestBody
                                                         @NotNull
                                                         @NotBlank String str) {
        return charFrequenciesService.getCharFrequencies(str);
    }

}
