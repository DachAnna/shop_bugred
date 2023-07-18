package com.annadach.tests.photo;

import com.annadach.model.request.PhotoRequest;
import com.annadach.model.response.ItemResponse;
import com.annadach.tests.TestBase;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


import static com.annadach.specs.Specs.request;
import static com.annadach.specs.Specs.successfulResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateWithPhotoTest extends TestBase {

    private PhotoRequest photoRequest = new PhotoRequest();

    @Test
    @AllureId("24309")
    @DisplayName("Добавление нового товара в каталог с картинкой")
    @Tags({@Tag("api"), @Tag("normal"), @Tag("photoTest")})
    void createItemMaxParam() {
        step("Создать новый товар с картинкой в формате base64", () -> {
            ItemResponse item = given()
                    .spec(request)
                    .body(photoRequest.withPhotoRequest().toString())
                    .when()
                    .post("create/")
                    .then()
                    .spec(successfulResponse())
                    .extract().as(ItemResponse.class);

            step("Проверить соответствие параметров товара", () -> {
                assertEquals(photoRequest.getTestData().name, item.getResult().getName());
                assertEquals(photoRequest.getTestData().section, item.getResult().getSection());
                assertEquals(photoRequest.getTestData().description, item.getResult().getDescription());
                assertEquals(photoRequest.getTestData().color, item.getResult().getColor());
                assertEquals(photoRequest.getTestData().price, item.getResult().getPrice());
                assertEquals(photoRequest.getTestData().params, item.getResult().getParams());
            });
        });
    }
}
