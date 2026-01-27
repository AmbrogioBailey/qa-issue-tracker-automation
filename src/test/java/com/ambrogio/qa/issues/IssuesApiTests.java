package com.ambrogio.qa.issues;

import com.ambrogio.qa.config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IssuesApiTests {

    private static int createdIssueId;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.PORT;
    }

    @Test
    @Order(1)
    void createIssue_shouldReturn201() {

        String body = """
                {
                "title": "automation-test",
                "description": "created by Rest Assured",
                "priority": "HIGH"
                }
                """;
        createdIssueId =
                given()
                .contentType("application/json")
                        .body(body)
                        .when()
                        .post(TestConfig.ISSUES_PATH)
                        .then()
                        .statusCode(201)
                        .body("id", notNullValue())
                        .extract()
                        .path("id");
    }
    @Test
    @Order(2)
    void getAllIssues_shouldReturn200() {
        when()
                .get(TestConfig.ISSUES_PATH)
                .then()
                .statusCode(200);
    }
}
