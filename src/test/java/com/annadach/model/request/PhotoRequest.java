package com.annadach.model.request;

import com.annadach.tests.TestData;
import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class PhotoRequest {

    private JsonObject itemData = new JsonObject();
    private TestData testData = new TestData();

    public JsonObject withPhotoRequest() {
        itemData.addProperty("name", testData.name);
        itemData.addProperty("section", testData.section);
        itemData.addProperty("description", testData.description);
        itemData.addProperty("color", testData.color);
        itemData.addProperty("size", testData.size);
        itemData.addProperty("price", testData.price);
        itemData.addProperty("params", testData.params);
        itemData.addProperty("photo", testData.photo);
        return itemData;
    }
}
