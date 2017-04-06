package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Game> games = new HashMap<>();
    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        System.out.println("Welcome to the Game Database. \n Here you can store information about video games.");
        while (true) {
            System.out.println("Main Menu: \n 1. Add a game \n 2. Update a game \n 3. List all items in database. \n 4. Info on a game.");
            String rootEntry = inputScanner.nextLine();

            if (rootEntry.equals("1")) {
                System.out.println("Please enter the name of the game you would like to add to the database:");
                String newName = Main.inputScanner.nextLine();
                if (Main.games.containsKey(newName)) {
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
                    Main.games.put(newGame.name, newGame);
                    System.out.println("A new game has been added to the database.");
                }
            } else if (rootEntry.equals("2")) {
                System.out.println("What is the name of the game you wish to update?");
                String updateEntry = inputScanner.nextLine();
                if (games.containsKey(updateEntry)) {
                    System.out.println("Game found for " + updateEntry + ". \n What would you like to update?");
                    String updateKey = inputScanner.nextLine();
                    if (updateKey.equalsIgnoreCase("name")) {
                        System.out.println("Please enter the new name:");
                        String nameChange = inputScanner.nextLine();
                        Game g = games.get(updateEntry);
                        g.name = nameChange;
                    } else if (updateKey.equalsIgnoreCase("genre")) {
                        System.out.println("Please enter the new genre:");
                        String genreChange = inputScanner.nextLine();
                        Game g = games.get(updateEntry);
                        g.genre = genreChange;
                    } else if (updateKey.equalsIgnoreCase("console")) {
                        System.out.println("Please enter the new console:");
                        String consoleChange = inputScanner.nextLine();
                        Game g = games.get(updateEntry);
                        g.console = consoleChange;
                    } else if (updateKey.equalsIgnoreCase("year")) {
                        System.out.println("Please enter the new year:");
                        String yearChange = inputScanner.nextLine();
                        Game g = games.get(updateEntry);
                        g.year = Integer.valueOf(yearChange);
                    } else if (updateKey.equalsIgnoreCase("rating")) {
                        System.out.println("Please enter the new rating:");
                        String ratingChange = inputScanner.nextLine();
                        Game g = games.get(updateEntry);
                        g.rating = Integer.valueOf(ratingChange);
                    } else {
                        System.err.println("I'm sorry but the entry entred was not valid.");
                    }
                } else {
                    System.err.println("Sorry, game not found in database.");
                }
            } else if (rootEntry.equals("3")) {
                System.out.println("Here are the games in the database:");
                System.out.println(games.keySet()+ "\n");
            } else if (rootEntry.equals("4")) {
                System.out.println("Please enter the name of the game.");
                String infoInquiry = inputScanner.nextLine();
                System.out.printf("Here is the info from the server: \n Name = %s \n Genre = %s \n Console = %s \n Release Date = %d \n Rating = %d \n ",games.get(infoInquiry).name, games.get(infoInquiry).genre, games.get(infoInquiry).console, games.get(infoInquiry).year, games.get(infoInquiry).rating);
            } else {
            System.err.println("Invalid entry, human.");
        }

        }
    }
}
