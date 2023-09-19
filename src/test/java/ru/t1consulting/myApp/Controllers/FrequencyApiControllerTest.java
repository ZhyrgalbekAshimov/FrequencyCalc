package ru.t1consulting.myApp.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.t1consulting.myApp.Dto.FrequencyRequest;
import ru.t1consulting.myApp.service.FrequencyService;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class FrequencyApiControllerTest {
    @Autowired
    WebApplicationContext context;

    @Autowired
    FrequencyService frequencyService;

    MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        MockitoAnnotations.openMocks(this);

    }

    @Test
    void bookmarkGetAll_WhenValidUser_ThenReturnIsOk() throws Exception {

        String expectedResponseContent = IOUtils.toString(
                Objects.requireNonNull(this.getClass().getResourceAsStream("/json/responseJson.json")), StandardCharsets.UTF_8.toString());
        List<String> inputTexts = Arrays.asList(
                "ABCaabc123",
                "test-string-123",
                "NNN", "...",
                "!@#$%^!@#$");

        // Подготовка запроса
        FrequencyRequest request = new FrequencyRequest();
        request.setInput(inputTexts);

        String response = mvc.perform(MockMvcRequestBuilders
                        .post("/calculate-frequency")
                        .characterEncoding("utf-8")
                        .content(new ObjectMapper().writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(expectedResponseContent, response);

    }

}