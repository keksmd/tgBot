package com.alexkekiy.telegram;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Data

public class UserInfoDTO {
    String name; //Имя
     String sex; //Пол
     String age; //Возраст
     String city; //Город
     String occupation; //Профессия
     String hobby; //Хобби
     String handsome; //Красота, привлекательность
     String wealth; //Доход, богатство
     String annoys; //Меня раздражает в людях
     String goals; //Цели знакомства

    private String fieldToString(String value, String description) {
        if (value != null && !value.isEmpty())
            return description + ": " + value + "\n";
        else
            return "";
    }

    @Override
    public String toString() {

        String result = "";

        result += fieldToString(name, "Имя");
        result += fieldToString(sex, "Пол");
        result += fieldToString(age, "Возраст");
        result += fieldToString(city, "Город");
        result += fieldToString(occupation, "Профессия");
        result += fieldToString(hobby, "Хобби");
        result += fieldToString(handsome, "Красота, привлекательность в баллах (максимум 10 баллов)");
        result += fieldToString(wealth, "Доход, богатство");
        result += fieldToString(annoys, "В людях раздражает");
        result += fieldToString(goals, "Цели знакомства");

        return result;
    }
}
