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
public class HeistPositionControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    HeistRepository heistRepo;

    @Test
    public void testCreateHeist() throws Exception {

        String json = getJSON("/positionData.json");

        MockHttpServletRequestBuilder request = post("/latestHits/position")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.positionName", equalTo("Storm Trooper")));
    }


    @Test
    public void getPositionByName() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/position?positionName=Storm")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].positionName",  equalTo("Storm Trooper")));
    }

    @Test
    public void getPositionByDescription() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/position?positionDescription=Main")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].positionDescription",  equalTo("Main Forces")));
    }

    @Test
    public void getByIDTest() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/position/1")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.positionId",  equalTo(1)));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
