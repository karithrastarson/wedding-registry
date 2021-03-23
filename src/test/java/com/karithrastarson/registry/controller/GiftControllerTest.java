package com.karithrastarson.registry.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karithrastarson.registry.exception.NoGiftFoundException;
import com.karithrastarson.registry.service.GiftService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(GiftController.class)
public class GiftControllerTest {
    @MockBean
    GiftService giftService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

/*    @Test
    public void get_endpoint_should_return_a_fact() throws Exception {
        when(giftService.getFact(anyString())).thenReturn("fact");
        this.mockMvc.perform(get("/fact/fact")).andExpect(status().isOk())
                .andExpect(content().string(containsString("fact")));
    }

    @Test
    public void post_endpoint_should_return_status_created() throws Exception {
        this.mockMvc.perform(post("/fact")
        .content(mapper.writeValueAsString("ok")))
                .andExpect(status().isCreated());
    }

    @Test
    public void get_endpoint_should_return_404_when_empty_db() throws Exception {
        when(giftService.getFact(anyString())).thenThrow(new NoGiftFoundException("ok"));
        this.mockMvc.perform(get("/fact/fact")).andExpect(status().isNotFound());
    }*/
}
