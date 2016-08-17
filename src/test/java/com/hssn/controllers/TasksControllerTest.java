package com.hssn.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value= {"/clean-database.sql"})
public class TasksControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 9001;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    // get /api/tasks
    public void GetAllTasks() throws Exception {
        get("/api/tasks")
                .then()
                .statusCode(200)
                .body("numberOfElements", is(3));
    }

    @Test
    // get /api/task/id
    public void GetASingleTask() throws Exception {
        get("/api/tasks/1")
                .then()
                .statusCode(200)
                .body("name", is("Get Milk"));
    }

    @Test
    // POST /api/task
    public void ShouldCreateATask() throws Exception {

        Map<String, Object> json = new HashMap<>();
        json.put("name", "Add new task");
        json.put("due", "2016-09-01");
        json.put("category", "testing");

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                    .post("/api/tasks")
                .then()
                    .statusCode(200)
                    .body("id", is(5));
    }

    @Test
    // DELETE /api/task
    public void ShouldDeleteATask() throws Exception {
        when()
                .delete("/api/tasks/1")
                .then()
                .statusCode(200);
    }

    @Test
    // PATCH /api/task/{id}/complete
    public void ShouldChangeTheTaskStatus() throws Exception {
              when()
                    .patch("/api/tasks/1/complete")
                .then()
                .statusCode(200)
                .body("isComplete", is(false));
    }
}