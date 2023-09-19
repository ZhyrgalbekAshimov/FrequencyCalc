package ru.t1consulting.myApp.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class FrequencyRequest {
    @JsonProperty("input")
    @Valid
    @NotEmpty(message = "input cannot be empty")
    private List<String> input = new ArrayList<>();

    public FrequencyRequest input(List<String> input) {
        this.input = input;
        return this;
    }

    public FrequencyRequest addInputItem(String inputItem) {
        this.input.add(inputItem);
        return this;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

}
