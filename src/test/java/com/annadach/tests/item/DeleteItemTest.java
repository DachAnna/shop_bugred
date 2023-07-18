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

public class DeleteItemTest extends TestBase {

    private ItemRequest itemRequest = new ItemRequest();
    private IdRequest idRequest = new IdRequest();

    @Test
    @AllureId("24305")
    @DisplayName("Отображение ошибки при удалении несуществующего товара")
    @Tags({@Tag("api"), @Tag("critical"), @Tag("itemTest")})
    void deleteNoItem() {
        step("Удалить товар по несуществующему айди", () -> {
            given()
                    .spec(request)
                    .body(itemRequest.itemRequestNoId().toString())
                    .when()
                    .post("delete/")
                    .then()
                    .spec(successfulResponse())
                    .body("status", is("error"))
                    .body("message", is("Товар с ID " + itemRequest.getTestData().noId + " не найден!"));
        });
    }

    @Test
    @AllureId("24306")
    @DisplayName("Удаление товара")
    @Tags({@Tag("api"), @Tag("critical"), @Tag("itemTest")})
    void getItem() {
        step("Удалить товар по айди", () -> {
            given()
                    .spec(request)
                    .body(idRequest.getRequestId().toString())
                    .when()
                    .post("delete/")
                    .then()
                    .spec(successfulResponse())
                    .body("result", is("Товар с ID " + idRequest.newItemId + " успешно удален"));
        });
    }
}
