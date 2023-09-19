package ru.t1consulting.myApp.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Validated

public class FrequencyResponse {
    @JsonProperty("output")
    @Valid
    private List<Map<Character, Integer>> output = new ArrayList<>();

    public FrequencyResponse output(List<Map<Character, Integer>> output) {
        this.output = output;
        return this;
    }

    public FrequencyResponse addOutputItem(Map<Character, Integer> outputItem) {
        this.output.add(outputItem);
        return this;
    }

    public List<Map<Character, Integer>> getOutput() {
        return output;
    }

    public void setOutput(List<Map<Character, Integer>> output) {
        this.output = output;
    }

}