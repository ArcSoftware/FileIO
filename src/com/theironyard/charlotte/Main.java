package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Game> Games = new HashMap<>();
    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Game Database. \n Here you can store information about video games.");
        while (true) {
            System.out.println("Main Menu: \n 1. Add a game \n 2. Update a game \n 3. List all items in database. \n 4. Info on a game.");
            String rootEntry = inputScanner.nextLine();

            if (rootEntry.equals("1")) {
                System.out.println("Please enter the name of the game you would like to add to the database:");
                String newName = Main.inputScanner.nextLine();
                if (Main.Games.containsKey(newName)) {
                    System.out.println("I'm sorry, but that game is already in the database. \n Returning to main menu... \n");
                } else {
                    System.out.println("Please enter the genre:");
                    String enteredGenre = inputScanner.nextLine();
                    System.out.println("Please enter the console the game is on:");
                    String enteredConsole = inputScanner.nextLine();
                    System.out.println("Please enter the year the game was released:");
                    String enteredYear = inputScanner.nextLine();
                    System.out.println("Please enter the rating of the game [1-5] star:");
                    String enteredRating = inputScanner.nextLine();
                    Game newGame = new Game(newName, enteredGenre, enteredConsole, Integer.valueOf(enteredYear), Integer.valueOf(enteredRating));
                    newGame.name = newName;
                    Main.Games.put(newGame.name, newGame);
                    System.out.println("A new game has been added to the database.");
                }
            } else if (rootEntry.equals("2")) {
                System.out.println("What is the name of the game you wish to update?");
            } else if (rootEntry.equals("3")) {
                System.out.println("Here are the games in the database:");
                System.out.println(Games.keySet());
            } else if (rootEntry.equals("4")) {
                System.out.println("Please enter the name of the game.");
                String infoInquiry = inputScanner.nextLine();
                System.out.printf("Here is the info from the server: \n Name = %s \n Genre = %s \n Console = %s \n Release Date = %d \n Rating = %d \n ",Games.get(infoInquiry).name, Games.get(infoInquiry).genre, Games.get(infoInquiry).console, Games.get(infoInquiry).year, Games.get(infoInquiry).rating);
            } else {
            System.err.println("Invalid entry, human.");
        }

        }
    }
}
