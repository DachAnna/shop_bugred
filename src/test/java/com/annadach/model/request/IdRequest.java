package com.annadach.model.request;

import com.annadach.tests.TestBase;
import com.google.gson.JsonObject;
import io.restassured.response.Response;

import static com.annadach.specs.Specs.request;
import static com.annadach.specs.Specs.successfulResponse;
import static io.restassured.RestAssured.given;

public class IdRequest extends TestBase {

    private ItemRequest itemRequest = new ItemRequest();

    public String newItemId = getItemId();
    private JsonObject requestBody = new JsonObject();
    //public String requestBody = getRequestId();

    public String getItemId() {
        Response response = given()
                .spec(request)
                .body(itemRequest.itemRequestMin().toString())
                .when()
                .post("create/")
                .then()
                .spec(successfulResponse())
                .extract().response();

        return response.path("result.id");
    }

    public JsonObject getRequestId() {
        requestBody.addProperty("id", newItemId);
        return requestBody;
        //return "{ \"id\": \"" + newItemId + "\" }";
    }
}
