package com.theironyard.charlotte;

import java.util.Scanner;

public class Main {

    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        System.out.println("Welcome to the Game Database. \n Here you can store information about video games.");
        GameRepository repository = ReadWriteClass.load();

        while (true) {
            int selection = Menu.getMainMenuSelection();

            switch (selection) {
                case 1:
                    // if game exists, don't do this step.
                    Game g = Menu.addGame(repository);
                    if (g != null) {
                        repository.addGame(g);
                    }
                    break;
                case 2:
                    Game g2 = Menu.updateGame(repository);

                    if (g2 != null) {
                        repository.updateGame(g2);
                    }
                    break;
                case 3:
                    Menu.listGames(repository);
                    break;
                case 4:
                    Menu.displayGameContents(repository);
                    break;
                case 5:
                    ReadWriteClass.save(repository);
                    System.out.println("Changes saved to database. \n");
                    break;

            }
        }
    }
}
