package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PollingTests {
/*
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl() { return "http://localhost:" + 8080; }

    private static String user1Id;
    private static String user2Id;
    private static String pollId;

    @Test
    @Order(1)
    void createUser1() {
        Map<String, String> req = Map.of("username", "user1");
        ResponseEntity<Map> res = restTemplate.postForEntity(baseUrl() + "/users", req, Map.class);
        assertEquals(HttpStatus.CREATED, res.getStatusCode());
        user1Id = res.getBody().get("id").toString();
    }

    @Test
    @Order(2)
    void listUsersAfterUser1() {
        ResponseEntity<Map[]> res = restTemplate.getForEntity(baseUrl() + "/users", Map[].class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertTrue(java.util.Arrays.stream(res.getBody())
                .anyMatch(u -> u.get("username").equals("user1")));
    }

    @Test
    @Order(3)
    void createUser2() {
        Map<String, String> req = Map.of("username", "user2");
        ResponseEntity<Map> res = restTemplate.postForEntity(baseUrl() + "/users", req, Map.class);
        assertEquals(HttpStatus.CREATED, res.getStatusCode());
        user2Id = res.getBody().get("id").toString();
    }

    @Test
    @Order(4)
    void listUsersAfterUser2() {
        ResponseEntity<Map[]> res = restTemplate.getForEntity(baseUrl() + "/users", Map[].class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertTrue(java.util.Arrays.stream(res.getBody())
                .anyMatch(u -> u.get("username").equals("user1")));
        assertTrue(java.util.Arrays.stream(res.getBody())
                .anyMatch(u -> u.get("username").equals("user2")));
    }

    @Test
    @Order(5)
    void user1CreatesPoll() {
        Map<String, String> req = Map.of(
                "title", "Favorite color?",
                "createdBy", user1Id
        );
        ResponseEntity<Map> res = restTemplate.postForEntity(baseUrl() + "/polls", req, Map.class);
        assertEquals(HttpStatus.CREATED, res.getStatusCode());
        pollId = res.getBody().get("id").toString();
    }

    @Test
    @Order(6)
    void listPolls() {
        ResponseEntity<Map[]> res = restTemplate.getForEntity(baseUrl() + "/polls", Map[].class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertTrue(java.util.Arrays.stream(res.getBody())
                .anyMatch(p -> p.get("title").equals("Favorite color?")));
    }

    @Test
    @Order(7)
    void user2Votes() {
        Map<String, String> req = Map.of(
                "userId", user2Id,
                "choice", "blue"
        );
        ResponseEntity<Map> res = restTemplate.postForEntity(baseUrl() + "/polls/" + pollId + "/votes", req, Map.class);
        assertEquals(HttpStatus.CREATED, res.getStatusCode());
    }

    @Test
    @Order(8)
    void user2ChangesVote() {
        Map<String, String> req = Map.of(
                "userId", user2Id,
                "choice", "red"
        );
        ResponseEntity<Map> res = restTemplate.postForEntity(baseUrl() + "/polls/" + pollId + "/votes", req, Map.class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    @Order(9)
    void listVotes() {
        ResponseEntity<Map[]> res = restTemplate.getForEntity(baseUrl() + "/polls/" + pollId + "/votes", Map[].class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        boolean user2VoteCorrect = java.util.Arrays.stream(res.getBody())
                .anyMatch(v -> v.get("userId").equals(user2Id) && v.get("choice").equals("red"));
        assertTrue(user2VoteCorrect);
    }

    @Test
    @Order(10)
    void deletePoll() {
        restTemplate.delete(baseUrl() + "/polls/" + pollId);
    }

    @Test
    @Order(11)
    void listVotesAfterDelete() {
        ResponseEntity<Map[]> res = restTemplate.getForEntity(baseUrl() + "/polls/" + pollId + "/votes", Map[].class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals(0, res.getBody().length);
    }

 */
}
