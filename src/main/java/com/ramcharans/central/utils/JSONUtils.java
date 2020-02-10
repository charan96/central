package com.ramcharans.central.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class JSONUtils {
    public static Map readJSONFile(String filename) throws IOException {
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new FileReader(filename));
        Map map = gson.fromJson(jsonReader, Map.class);

        return map;
    }

    public static void writeJSONFile(Map data, String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(data);

        FileWriter writer = new FileWriter(filename);
        writer.write(json);
        writer.close();
    }
}