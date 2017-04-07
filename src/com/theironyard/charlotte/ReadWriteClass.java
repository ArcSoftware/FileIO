package com.theironyard.charlotte;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Jake on 4/7/17.
 */
public class ReadWriteClass {
    public static void save() throws IOException {
        //Write to Json
        JsonSerializer serializer = new JsonSerializer();
        serializer.deep(true);
        String json = serializer.serialize(Main.repository);
        File f = new File("game.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static GameRepository load() throws FileNotFoundException {
        //Read from Json
        File f = new File("game.json");

        if (f.exists()) {
            Scanner s = new Scanner(f);
            s.useDelimiter("\\Z");
            String contents = s.next();
            JsonParser p = new JsonParser();

            GameRepository repo = p.parse(contents, GameRepository.class);
            return repo;
        } else {
            return null;
        }

    }
}
