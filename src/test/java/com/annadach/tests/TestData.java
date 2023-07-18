package com.annadach.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class TestData {

    public static Faker faker = new Faker();

    //ItemData
    public String
            name = faker.name().firstName(),
            section = sectionMath(),
            description = faker.lorem().characters(4, 10),
            color = colorMath(),
            params = paramsMath();

    public int
            size = faker.number().numberBetween(40, 60),
            noId = faker.number().numberBetween(1000, 10000);

    public double
            price = faker.number().randomDouble(2, 100, 1000);

    public String paramsMath() {
        int randomN = faker.number().numberBetween(0, 7);
        String section = "";
        switch (randomN) {
            case 0:
                section = "dress";
                break;
            case 1:
                section = "shorts";
                break;
            case 2:
                section = "outerwear";
                break;
            case 3:
                section = "pants";
                break;
            case 4:
                section = "shirt";
                break;
            case 5:
                section = "t-shirt";
                break;
        }
        return section;
    }

    public String sectionMath() {
        int randomN = faker.number().numberBetween(0, 7);
        String section = "";
        switch (randomN) {
            case 0:
                section = "Платья";
                break;
            case 1:
                section = "Шорты";
                break;
            case 2:
                section = "Верхняя одежда";
                break;
            case 3:
                section = "Брюки";
                break;
            case 4:
                section = "Рубашки";
                break;
            case 5:
                section = "Футболки";
                break;
        }
        return section;
    }

    public String colorMath() {
        int randomN = faker.number().numberBetween(0, 7);
        String color = "";
        switch (randomN) {
            case 0:
                color = "Черный";
                break;
            case 1:
                color = "Красный";
                break;
            case 2:
                color = "Синий";
                break;
            case 3:
                color = "Белый";
                break;
            case 4:
                color = "Фиолетовый";
                break;
            case 5:
                color = "Коричневый";
                break;
        }
        return color;
    }

    //PhotoData
    public File imageFile = new File("src/test/resources/Фиолетовое платье.png");
    public String photo = convertPhoto();

    public String convertPhoto() {
        byte[] imageBytes = new byte[0];
        try {
            imageBytes = Files.readAllBytes(Paths.get("src/test/resources/Фиолетовое платье.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
