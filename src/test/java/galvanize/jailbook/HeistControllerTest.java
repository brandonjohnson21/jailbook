package galvanize.jailbook;

import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.repositories.HeistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HeistControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    HeistRepository heistRepo;

    @Test
    @Transactional
    @Rollback
    public void testCreateHeist() throws Exception {

        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/latestHits/heist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mastermind", equalTo(4)));
    }

    @Test
    public void getHeistTest() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/heist")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].heistId", instanceOf(Number.class)))
                .andExpect(jsonPath("$[0].mastermind", equalTo(4)));
    }
    @Test
    public void getHeistByIDTest() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/heist/17")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.heistId",  equalTo(17)));
    }

    @Test
    public void getHeistByMasterMindID() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/heist?mastermind=4")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].mastermind",  equalTo(4)));
    }

    @Test
    public void getHeistByScore() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/heist?score=life")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].score",  equalTo("A life")));
    }


    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
