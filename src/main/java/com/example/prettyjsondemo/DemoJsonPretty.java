package com.example.prettyjsondemo;

import com.example.prettyjson.PrettyJson;

public class DemoJsonPretty {
    public static void main(String[] args) {
        String json = "{\"name\":\"John Doe\",\"age\":30,\"isStudent\":false,\"address\":{\"street\":\"123 Main St\",\"city\":\"New York\",\"coordinates\":{\"lat\":40.7128,\"lng\":-74.0060}},\"hobbies\":[\"reading\",\"gaming\",\"coding\"],\"courses\":[{\"name\":\"Math\",\"grade\":\"A\"},{\"name\":\"Physics\",\"grade\":\"B+\"}],\"metadata\":{\"created\":\"2024-01-15\",\"version\":1.2}}";

        System.out.println("=== ИСХОДНЫЙ JSON ===");
        System.out.println(json);
        System.out.println("\n=== КРАСИВЫЙ JSON ===");

        try {
            String prettyJson = PrettyJson.prettyPrint(json);
            System.out.println(prettyJson);
        } catch (Exception e) {
            System.out.println("Ошибка при форматировании JSON: " + e.getMessage());
            System.out.println(json);
        }
    }
}