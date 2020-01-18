package main;

import game.Game;

public class Main {
  public static void main(String[] args) {
    Game game;
    System.setProperty("sun.java2d.opengl", "true");
    try {
      game = new Game();
      game.start();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
