package org.unknowncodester.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {


    public static void main(String[] args) {
        WordGenerator wordGenerator = new WordGenerator();
        Scanner in = new Scanner(System.in);
        int lives = 5;
        int correctLetterCount = 0;

        StringBuilder maskedWord = new StringBuilder("");
        Word word = wordGenerator.getWord();

        printWelcome();

        for (int i = 0; i < word.getName().length(); i++) {
            maskedWord.append("?");
        }

        while (lives > 0 && correctLetterCount != word.getName().length()) {
            printInfo(lives, word, maskedWord.toString());

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
            System.out.println("\n" +
                    " _  _    _      _  _      _      _____ ____    _  _ \n" +
                    "/ \\/ \\  / \\  /|/ \\/ \\  /|/ \\  /|/  __//  __\\  / \\/ \\\n" +
                    "| || |  | |  ||| || |\\ ||| |\\ |||  \\  |  \\/|  | || |\n" +
                    "\\_/\\_/  | |/\\||| || | \\||| | \\|||  /_ |    /  \\_/\\_/\n" +
                    "(_)(_)  \\_/  \\|\\_/\\_/  \\|\\_/  \\|\\____\\\\_/\\_\\  (_)(_)\n" +
                    "                                                    \n");
        } else {
            System.out.println("\n" +
                    "   ___     _     ____  ____  _____ ____   \n" +
                    "__/ _/    / \\   /  _ \\/ ___\\/  __//  __\\  \n" +
                    "\\/|/      | |   | / \\||    \\|  \\  |  \\/|  \n" +
                    "__|\\_     | |_/\\| \\_/|\\___ ||  /_ |    /  \n" +
                    "\\/\\__\\    \\____/\\____/\\____/\\____\\\\_/\\_\\  \n" +
                    "                                          \n");
        }

        System.out.println("Word was = " + word.getName());

    }

    private static void printWelcome() {
        System.out.println("Welcome to hangman");
    }

    private static void printInfo(int lives, Word word, String maskedWord) {
        System.out.println("___________INFORMATION_____________");
        System.out.println("Topic = " + word.getTopic());
        System.out.println("Lives = " + lives);
        System.out.println("Answer = " + maskedWord);
        System.out.println("Word length = " + word.getName().length());
        System.out.println("______________GAME________________");
        System.out.println("Enter a letter and press enter");
    }

}
