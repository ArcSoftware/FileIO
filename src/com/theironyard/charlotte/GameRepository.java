package com.theironyard.charlotte;

import java.util.HashMap;

/**
 * Created by Jake on 4/7/17.
 */
public class GameRepository {
    private HashMap<String, Game> games = new HashMap<>();

    public HashMap<String, Game> getGames() {
        return games;
    }

    public void setGames(HashMap<String, Game> games) {
        this.games = games;
    }
}
