package com.theironyard.charlotte;

import java.io.IOException;

/**
 * Created by Jake on 4/7/17.
 */
public class Menu {
    public static int getMainMenuSelection() throws IOException{
        System.out.println("Main Menu: \n 1. Add a game \n 2. Update a game \n 3. List all items in database. \n 4. Info on a game. \n 5. Save changes.");
        int selection = Integer.valueOf(Main.inputScanner.nextLine());

        if (selection <= 0 || selection > 5) {
            System.err.println("Invalid Selection, human.");
            return -1;
        }

        return selection;
    }

    public static void displayGameContents(GameRepository repo) {
        System.out.println("Please enter the name of the game.");
        String infoInquiry = Main.inputScanner.nextLine();

        Game game = repo.getGames().get(infoInquiry);

        System.out.printf("Here is the info from the server: \n " +
                "Name = %s \n " +
                "Genre = %s \n " +
                "Console = %s \n " +
                "Release Date = %d \n " +
                "Rating = %d \n ",
                    game.name,
                    game.genre,
                    game.console,
                    game.year,
                    game.rating);
    }

    private static Game getGameDetails(String name) {
        System.out.println("Please enter the genre:");
        String enteredGenre = Main.inputScanner.nextLine();

        System.out.println("Please enter the console the game is on:");
        String enteredConsole = Main.inputScanner.nextLine();

        System.out.println("Please enter the year the game was released:");
        String enteredYear = Main.inputScanner.nextLine();

        System.out.println("Please enter the rating of the game [1-5] star:");
        String enteredRating = Main.inputScanner.nextLine();

        return new Game(name, enteredGenre, enteredConsole, Integer.valueOf(enteredYear), Integer.valueOf(enteredRating));
    }

    public static Game addGame(GameRepository repo) {
        System.out.println("Please enter the name of the game you would like to add to the database:");
        String name = Main.inputScanner.nextLine();

        if (!repo.getGames().containsKey(name)) {
            return getGameDetails(name);
        } else {
            System.out.println("Game already exists");
            return null;
        }
    }

    public static Game updateGame(GameRepository repo) {
        System.out.println("Please enter the name of the game you would like to update:");
        String name = Main.inputScanner.nextLine();

        if (repo.getGames().containsKey(name)) {
            return getGameDetails(name);
        } else {
            System.out.println("Specified game not found.");
            return null;
        }
    }

    public static void listGames(GameRepository repo) {
        if (repo.getGames().size() > 0) {
            System.out.println("Here are the games in the database:");
            System.out.println(repo.getGames().keySet() + "\n");
        } else {
            System.out.println("No games currently present.");
        }
    }
}
