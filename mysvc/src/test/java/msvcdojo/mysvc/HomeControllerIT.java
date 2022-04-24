package msvcdojo.mysvc;

import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


import java.net.URL;

import static org.junit.gen5.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MysvcApplication.class })

public class HomeControllerIT {
    @Value("${local.server.port}")
    private int port;

    private  URL base;
    private TestRestTemplate template;

    @BeforeAll
    public  void setUp() throws Exception {
        base = new URL("http://localhost:" + port + "/");
        template = new TestRestTemplate();
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertEquals(response.getBody(), "Hello World!");

    }
}
