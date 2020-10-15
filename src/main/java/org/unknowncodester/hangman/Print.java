package org.unknowncodester.hangman;

public class Print {

    public void welcome() {
        System.out.println("\n" +
            " __      __       .__                                  __           .__                                               ._.\n" +
            "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   _/  |_  ____   |  |__ _____    ____    ____   _____ _____    ____| |\n" +
            "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\  \\   __\\/  _ \\  |  |  \\\\__  \\  /    \\  / ___\\ /     \\\\__  \\  /    \\ |\n" +
            " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |  | (  <_> ) |   Y  \\/ __ \\|   |  \\/ /_/  >  Y Y  \\/ __ \\|   |  \\|\n" +
            "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |__|  \\____/  |___|  (____  /___|  /\\___  /|__|_|  (____  /___|  /_\n" +
            "       \\/       \\/          \\/            \\/     \\/                      \\/     \\/     \\//_____/       \\/     \\/     \\/\\/\n"
        );
    }

    public void loser() {
        System.out.println("\n" +
            "   ___     _     ____  ____  _____ ____   \n" +
            "__/ _/    / \\   /  _ \\/ ___\\/  __//  __\\  \n" +
            "\\/|/      | |   | / \\||    \\|  \\  |  \\/|  \n" +
            "__|\\_     | |_/\\| \\_/|\\___ ||  /_ |    /  \n" +
            "\\/\\__\\    \\____/\\____/\\____/\\____\\\\_/\\_\\  \n" +
            "                                          \n"
        );
    }

    public void winner() {
        System.out.println("\n" +
            " _  _    _      _  _      _      _____ ____    _  _ \n" +
            "/ \\/ \\  / \\  /|/ \\/ \\  /|/ \\  /|/  __//  __\\  / \\/ \\\n" +
            "| || |  | |  ||| || |\\ ||| |\\ |||  \\  |  \\/|  | || |\n" +
            "\\_/\\_/  | |/\\||| || | \\||| | \\|||  /_ |    /  \\_/\\_/\n" +
            "(_)(_)  \\_/  \\|\\_/\\_/  \\|\\_/  \\|\\____\\\\_/\\_\\  (_)(_)\n" +
            "                                                    \n"
        );
    }

    public void clue(Word word) {
        System.out.println("___________TIPS_____________");
        System.out.println("Topic = " + word.getTopic());
        System.out.println("Word Length = " +  word.getName().length());
    }

    public void instructions() {
        System.out.println("______________GAME________________");
        System.out.println("Enter a letter and press enter");
    }

    public void gallow(int lives){
        switch (lives){
            case 6:
                System.out.println(
                    "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "========="
                );
                break;
            case 5:
                System.out.println(
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "========="
                );
                break;
            case 4:
                System.out.println(
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "========="
                );
                break;
            case 3:
                System.out.println(
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "========="
                );
                break;
            case 2:
                System.out.println(
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "  |    |\n" +
                    "      |\n" +
                    "========="
                );
                break;
            case 1:
                System.out.println(
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "========="
                );
                break;
            case 0:
                System.out.println(
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========="
                );
                break;
        }
    }

    public void mask(String mask){
        StringBuilder maskedOutput = new StringBuilder("");

        for (int i = 0; i < mask.length(); i++) {
            if(mask.charAt(i) == '_') {
                maskedOutput.append(" _ ");
            } else {
                maskedOutput.append(" "+ mask.charAt(i) + " ");
            }
        }

        System.out.println(maskedOutput);
    }

    public void word(Word word) {
        System.out.println("Word was = " + word.getName());
    }
}
