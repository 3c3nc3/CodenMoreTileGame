package game;

import java.awt.image.BufferedImage;

import display.gfx.ImageLoader;
import display.gfx.Spritesheet;

public class Assets {
  public static BufferedImage player, plasma;
  public static BufferedImage grass, stone, bricks, dirt;
  
  public static void init() {
    player = ImageLoader.LoadImage("/textures/Player.png");
    plasma = ImageLoader.LoadImage("/textures/plasma.png");
    
    Spritesheet tiles = new Spritesheet(ImageLoader.LoadImage("/textures/TileSpritesheet.png"));
    tiles.autoCrop(32, 32);
    grass = tiles.getSprite(0);
    stone = tiles.getSprite(1);
    bricks = tiles.getSprite(2);
    dirt = tiles.getSprite(3);
  }
}
