package com.annadach.tests.item;

import com.annadach.model.request.IdRequest;
import com.annadach.model.request.ItemRequest;
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
import static org.hamcrest.Matchers.is;

public class GetItemTest extends TestBase {

    private ItemRequest itemRequest = new ItemRequest();
    private IdRequest idRequest = new IdRequest();

    @Test
    @AllureId("24307")
    @DisplayName("Получение информации о созданном товаре")
    @Tags({@Tag("api"), @Tag("normal"), @Tag("itemTest")})
    void getItem() {

        step("Найти товар по айди", () -> {
            given()
                    .spec(request)
                    .body(idRequest.getRequestId().toString())
                    .when()
                    .post("get/")
                    .then()
                    .spec(successfulResponse())
                    .body("result.id", is(idRequest.newItemId));
        });
    }

    @Test
    @AllureId("24308")
    @DisplayName("Отображение ошибки при поиске информации о несуществующем товаре")
    @Tags({@Tag("api"), @Tag("normal"), @Tag("itemTest")})
    void getNoItem() {
        step("Найти товар по несуществующему айди", () -> {
            given()
                    .spec(request)
                    .body(itemRequest.itemRequestNoId().toString())
                    .when()
                    .post("get/")
                    .then()
                    .spec(successfulResponse())
                    .body("status", is("error"))
                    .body("message", is("Товар с ID " + itemRequest.getTestData().noId + " не найден!"));
        });
    }
}
