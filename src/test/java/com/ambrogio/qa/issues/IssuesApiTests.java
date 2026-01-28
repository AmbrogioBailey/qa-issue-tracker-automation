package com.ambrogio.qa.issues;

import com.ambrogio.qa.config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Tag;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IssuesApiTests {

    private static int createdIssueId;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = TestConfig.BASE_URL;
        RestAssured.port = TestConfig.PORT;
    }

    @Tag("smoke")
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
                .contentType(ContentType.JSON)
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
    @Test
    @Order(3)
    void getIssueById_shouldReturn200_andMatchCreatedIssue() {
        given()
                .when()
                .get(TestConfig.ISSUES_PATH + "/" + createdIssueId)
                .then()
                .statusCode(200)
                .body("id", equalTo(createdIssueId))
                .body("title", equalTo("automation-test"))
                .body("priority", equalTo("HIGH"));
    }
    @Test
    @Order(4)
    void createIssue_missingTitle_shouldReturn400() {

        String body = """
            {
            "description": "TITLE MISSING!",
            "priority": "HIGH"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(TestConfig.ISSUES_PATH)
                .then()
                .statusCode(400);
    }
    @Test
    @Order(5)
    void getIssueById_notFound_shouldReturn404() {
        int missingId = 999999999;

        when()
                .get(TestConfig.ISSUES_PATH + "/" + missingId)
                .then()
                .statusCode(404);
    }








}
