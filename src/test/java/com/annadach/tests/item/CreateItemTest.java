package com.annadach.tests.item;

import com.annadach.allure.Layer;
import com.annadach.allure.Microservice;
import com.annadach.model.request.ItemRequest;
import com.annadach.model.response.ItemResponse;
import com.annadach.tests.TestBase;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.annadach.specs.Specs.request;
import static com.annadach.specs.Specs.successfulResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Microservice("Shop Bugred")
@Layer("API")
@Owner("Dyachenko Anna")
public class CreateItemTest extends TestBase {

    private ItemRequest itemRequest = new ItemRequest();

    @Test
    @AllureId("24190")
    @DisplayName("Добавление нового товара в каталог с минимум параметров")
    @Tags({@Tag("api"), @Tag("critical"), @Tag("itemTest")})
    void createItemMinParam() {
        step("Создать новый товар", () -> {
            ItemResponse item = given()
                    .spec(request)
                    .body(itemRequest.itemRequestMin().toString())
                    .when()
                    .post("create/")
                    .then()
                    .spec(successfulResponse())
                    .extract().as(ItemResponse.class);

            step("Проверить соответствие параметров товара", () -> {
                assertEquals(itemRequest.getTestData().name, item.getResult().getName());
                assertEquals(itemRequest.getTestData().section, item.getResult().getSection());
                assertEquals(itemRequest.getTestData().description, item.getResult().getDescription());
            });
        });
    }

    @Test
    @AllureId("24304")
    @DisplayName("Добавление нового товара в каталог с максимум параметров")
    @Tags({@Tag("api"), @Tag("normal"), @Tag("itemTest")})
    void createItemMaxParam() {
        step("Создать новый товар", () -> {
            ItemResponse item = given()
                    .spec(request)
                    .body(itemRequest.itemRequestMax().toString())
                    .when()
                    .post("create/")
                    .then()
                    .spec(successfulResponse())
                    .extract().as(ItemResponse.class);

            step("Проверить соответствие параметров товара", () -> {
                assertEquals(itemRequest.getTestData().name, item.getResult().getName());
                assertEquals(itemRequest.getTestData().section, item.getResult().getSection());
                assertEquals(itemRequest.getTestData().description, item.getResult().getDescription());
                assertEquals(itemRequest.getTestData().color, item.getResult().getColor());
                assertEquals(itemRequest.getTestData().price, item.getResult().getPrice());
                assertEquals(itemRequest.getTestData().params, item.getResult().getParams());
            });
        });
    }
}
