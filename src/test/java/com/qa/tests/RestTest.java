package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestTest {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static void main(String[] args) {
//        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");
        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users/1");

////        List<String> jsonResponse = response.jsonPath().getList("$");
//        List<String> jsonResponse = response.jsonPath().getList("username");
//        String usernames = response.jsonPath().getString("username"); // listing all usernames 
//        String username = response.jsonPath().getString("username[0]"); //listing first username
//        System.out.println(jsonResponse.size());
//        System.out.println(usernames);
//        System.out.println(jsonResponse.get(0));
       
        Map<String, String> company = response.jsonPath().getMap("company");
        System.out.println(company.get("name"));
        //=================================
//        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users/");
//        List<Map<String, String>> companies = response.jsonPath().getList("company");
//        System.out.println(companies.get(0).get("name"));
//        // ========================================
//        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users/");
//        Map<String, String> company = response.jsonPath().getMap("company[0]");
//        System.out.println(company.get("name"));

    }
}