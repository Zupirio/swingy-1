package com.nmajozi.swingy.controller;

import com.nmajozi.swingy.view.ViewMode;
import com.nmajozi.swingy.view.Console;
import com.nmajozi.swingy.view.GUI;
import com.nmajozi.swingy.utils.Tools;

public class Game {
    private final String FILENAME = "heroes.txt";
    private String gameMode = null;
    private ViewMode view = null;

    public Game(String gameMode){
        if (gameMode.equals("console")){
            this.gameMode = "CONSOLE";
            System.out.println("GAME");
            this.view = new Console();
            this.view.run();
        }
        else if (gameMode.equals("gui")){
            this.gameMode = "GUI";
            this.view = new GUI();
        }
        else{
            String report = String.format("\nERROR\nWrong mode.\nUSAGE:\n%sjava -jar swing.jar console\n %sOR\n%sjava -jar swing.jar gui", Tools.padLeft(" ", 7), Tools.padLeft(" ", 19), Tools.padLeft(" ", 7));
            System.out.println(report);
            System.exit(1);
        }
    }

    public void run(){

    }
}