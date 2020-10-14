package org.unknowncodester.hangman;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGenerator {
    private List<Word> words = new ArrayList<Word>();
    private Random randomiser;

    public WordGenerator() {
        this.randomiser = new Random();
        generateWords();
    }

    private void generateWords() {
        try {
            String fileName = "words.json";
            ClassLoader classLoader = getClass().getClassLoader();

            File file = new File(classLoader.getResource(fileName).getFile());
            BufferedReader json = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Word>>(){}.getType();

            this.words = gson.fromJson(json, listType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Word> getWords() {
        return words;
    }

    public Word getWord(){
        int randomWordIndex = randomiser.nextInt(words.size());

        return this.getWords().get(randomWordIndex);
    }
}
