package com.comprent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachishin.comprente.ComprentApplication;
import com.sachishin.comprente.DTO.AuthRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ComprentApplication.class)
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValuesInLogin() throws Exception {
        var rr = new AuthRequest();
        rr.setLogin("ww");
        rr.setPassword("ww");
        mockMvc.perform(post("http://localhost:8080/api/auth/login").content(asJsonString(rr)).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testUnAuthorizedSuccess() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/bill/getCommonBills?pageNum=0&pageSize=5")).andDo(print()).andExpect(status().isForbidden());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
