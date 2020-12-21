package galvanize.jailbook;

import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.repositories.HeistItemRepository;
import galvanize.jailbook.repositories.HeistPositionRepository;
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
public class HeistItemControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    HeistItemRepository heistItemRepo;

    @Test
    public void testCreateItem() throws Exception {
        String json = getJSON("/itemData.json");
        MockHttpServletRequestBuilder request = post("/latestHits/heistItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itemName", equalTo("E-11")));
    }


    @Test
    public void getByHeistId() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/heistItem?heistId=1")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].heistId", equalTo(1)));
    }

    @Test
    public void getByBringerID() throws Exception {
        MockHttpServletRequestBuilder request = get("/latestHits/heistItem?bringer=4")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].bringer", equalTo(4)));
    }



    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
