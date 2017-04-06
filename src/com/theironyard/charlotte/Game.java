package com.theironyard.charlotte;

/**
 * Created by Jake on 4/6/17.
 */
public class Game {
    Game(String name, String genre, String console, int year, int rating){
        this.name = name;
        this.genre = genre;
        this.console = console;
        this.year = year;
        this.rating = rating;
    }
    public String name;
    String genre;
    String console;
    int year;
    int rating;
}
