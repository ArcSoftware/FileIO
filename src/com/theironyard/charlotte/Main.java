package com.theironyard.charlotte;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Scanner inputScanner = new Scanner(System.in);
    public static GameRepository repository = new GameRepository();

    public static void main(String[] args) throws Exception{
        System.out.println("Welcome to the Game Database. \n Here you can store information about video games.");
        repository = ReadWriteClass.load();
        Menu.mainMenu();
    }
}
