package com.annadach.tests.photo;

import com.annadach.model.request.IdRequest;
import com.annadach.tests.TestBase;
import com.annadach.tests.TestData;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.annadach.specs.Specs.successfulResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class UploadPhotoTest extends TestBase {

    private IdRequest idRequest = new IdRequest();
    private TestData testData = new TestData();

    @Test
    @AllureId("24310")
    @DisplayName("Получение ошибки при загрузке большого файла")
    @Tags({@Tag("api"), @Tag("critical"), @Tag("photoTest")})
    void getItem() {
        step("Найти товар по айди и добавить фото", () -> {
            given()
                    .multiPart("photo", testData.imageFile)
                    .multiPart("id", idRequest.newItemId)
                    .when()
                    .post("upload_photo/")
                    .then()
                    .spec(successfulResponse())
                    .body("status", is("error"))
                    .body("message", is("Ширина должна быть не более 500px"));
        });
    }

    @Test
    @AllureId("24311")
    @DisplayName("Загрузка фотографии к товару")
    @Tags({@Tag("api"), @Tag("critical"), @Tag("photoTest")})
    void uploadPhoto() {
        step("Найти товар по айди и добавить фото", () -> {
            given()
                    .multiPart("photo", testData.imageFile)
                    .multiPart("id", idRequest.newItemId)
                    .when()
                    .post("upload_photo/")
                    .then()
                    .spec(successfulResponse())
                    .body("result", is("Фотография для товара " + idRequest.newItemId + " успешно загружена!"));
        });
    }
}
