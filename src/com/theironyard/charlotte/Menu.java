package com.theironyard.charlotte;

import java.io.IOException;

/**
 * Created by Jake on 4/7/17.
 */
public class Menu {
    public static void mainMenu() throws IOException{
        while (true) {
            System.out.println("Main Menu: \n 1. Add a game \n 2. Update a game \n 3. List all items in database. \n 4. Info on a game. \n 5. Save changes.");
            String rootEntry = Main.inputScanner.nextLine();

            if (rootEntry.equals("1")) {
                addGame();
            } else if (rootEntry.equals("2")) {
                updateGame();
            } else if (rootEntry.equals("3")) {
                listGames();
            } else if (rootEntry.equals("4")) {
                infoGame();
            } else if (rootEntry.equals("5")) {
                System.err.println("Your changes have been saved.");
                ReadWriteClass.save();
            } else {
                System.err.println("Invalid entry, human.");
            }
        }

    }



    public static void addGame() {
        System.out.println("Please enter the name of the game you would like to add to the database:");
        String newName = Main.inputScanner.nextLine();
        if (Main.repository.getGames().containsKey(newName)) {
            System.out.println("I'm sorry, but that game is already in the database. \n Returning to main menu... \n");
        } else {
            System.out.println("Please enter the genre:");
            String enteredGenre = Main.inputScanner.nextLine();
            System.out.println("Please enter the console the game is on:");
            String enteredConsole = Main.inputScanner.nextLine();
            System.out.println("Please enter the year the game was released:");
            String enteredYear = Main.inputScanner.nextLine();
            System.out.println("Please enter the rating of the game [1-5] star:");
            String enteredRating = Main.inputScanner.nextLine();
            Game newGame = new Game(newName, enteredGenre, enteredConsole, Integer.valueOf(enteredYear), Integer.valueOf(enteredRating));
            newGame.name = newName;
            Main.repository.getGames().put(newGame.name, newGame);
            System.out.println("A new game has been added to the database.");
        }
    }
    public static void updateGame() {
    System.out.println("What is the name of the game you wish to update?");
    String updateEntry = Main.inputScanner.nextLine();
    if (Main.repository.getGames().containsKey(updateEntry)) {
        System.out.println("Game found for " + updateEntry + ". \n What would you like to update?");
        String updateKey = Main.inputScanner.nextLine();
        if (updateKey.equalsIgnoreCase("name")) {
            System.out.println("Please enter the new name:");
            String nameChange = Main.inputScanner.nextLine();
            Game g = Main.repository.getGames().get(updateEntry);
            g.name = nameChange;
        } else if (updateKey.equalsIgnoreCase("genre")) {
            System.out.println("Please enter the new genre:");
            String genreChange = Main.inputScanner.nextLine();
            Game g = Main.repository.getGames().get(updateEntry);
            g.genre = genreChange;
        } else if (updateKey.equalsIgnoreCase("console")) {
            System.out.println("Please enter the new console:");
            String consoleChange = Main.inputScanner.nextLine();
            Game g = Main.repository.getGames().get(updateEntry);
            g.console = consoleChange;
        } else if (updateKey.equalsIgnoreCase("year")) {
            System.out.println("Please enter the new year:");
            String yearChange = Main.inputScanner.nextLine();
            Game g = Main.repository.getGames().get(updateEntry);
            g.year = Integer.valueOf(yearChange);
        } else if (updateKey.equalsIgnoreCase("rating")) {
            System.out.println("Please enter the new rating:");
            String ratingChange = Main.inputScanner.nextLine();
            Game g = Main.repository.getGames().get(updateEntry);
            g.rating = Integer.valueOf(ratingChange);
        } else {
            System.err.println("I'm sorry but the entry entred was not valid.");
        }
    } else {
        System.err.println("Sorry, game not found in database.");
    }
    }
    public static void listGames() {
        System.out.println("Here are the games in the database:");
        System.out.println(Main.repository.getGames().keySet() + "\n");
    }
    public static void infoGame() {
        System.out.println("Please enter the name of the game.");
        String infoInquiry = Main.inputScanner.nextLine();
        System.out.printf("Here is the info from the server: \n Name = %s \n Genre = %s \n Console = %s \n Release Date = %d \n Rating = %d \n ", Main.repository.getGames().get(infoInquiry).name, Main.repository.getGames().get(infoInquiry).genre, Main.repository.getGames().get(infoInquiry).console, Main.repository.getGames().get(infoInquiry).year, Main.repository.getGames().get(infoInquiry).rating);
    }
}
