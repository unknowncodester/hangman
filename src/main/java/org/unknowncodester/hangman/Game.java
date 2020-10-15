package org.unknowncodester.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        WordGenerator wordGenerator = new WordGenerator();
        Scanner in = new Scanner(System.in);
        Print print = new Print();
        int lives = 6;
        int correctLetterCount = 0;

        StringBuilder maskedWord = new StringBuilder("");
        Word word = wordGenerator.getWord();

        print.welcome();
        print.clue(word);

        for (int i = 0; i < word.getName().length(); i++) {
            maskedWord.append("_");
        }

        while (lives > 0 && correctLetterCount != word.getName().length()) {
            print.gallow(lives);
            print.mask(maskedWord.toString());
            print.instructions();

            while (! in.hasNext("[a-z]")) {
                in.nextLine();
            }

            char guess = in.nextLine().charAt(0);
            ArrayList<Integer> matches = new ArrayList<Integer>();

            for (int i = 0; i < word.getName().length(); i++) {
                if (word.getName().charAt(i) == guess) {
                    matches.add(i);
                }
            }

            if (matches.size() > 0) {
                for(int i = 0; i < matches.size(); i++) {
                    correctLetterCount++;
                    maskedWord.setCharAt(matches.get(i), word.getName().charAt(matches.get(i)));
                }
            } else {
                lives--;
            }
        }

        if(correctLetterCount == word.getName().length()){
            print.winner();
        } else {
            print.loser();
            print.gallow(lives);
        }

        print.word(word);
    }
}
