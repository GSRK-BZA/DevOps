package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the Demo Application.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Verifies that the context loads successfully.
     */
    @Test
    void contextLoads() {
    }

    /**
     * Verifies that the hello endpoint returns the expected greeting.
     */
    @Test
    void helloEndpointReturnsGreeting() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Hello from Secure CI/CD Pipeline!");
    }

}
