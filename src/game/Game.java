package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import display.gfx.ImageLoader;
import display.gfx.Spritesheet;

public class Game implements Runnable {
  private static boolean instanceOf = false;
  private Display display;
  private Thread thread;
  
  private boolean running = false;
  
  private BufferStrategy bs;
  private Graphics g;
  
  Spritesheet s = new Spritesheet(ImageLoader.LoadImage("/textures/IconSpritesheet.png/"));
  
  public Game() throws IllegalAccessException {
    if (instanceOf) 
      throw new IllegalAccessException("An instance of this class already exists!");
    else 
      instanceOf = true;
    s.autoCrop(32, 32);
  }
  
  private void init() {
    display = new Display();
    display.getCanvas().setBackground(Color.DARK_GRAY);
  }
  
  private void tick() {
    
  }
  
  private void render() {
    bs = display.getCanvas().getBufferStrategy();
    if (bs == null) {
      display.getCanvas().createBufferStrategy(3);
      return;
    }
    g = bs.getDrawGraphics();
    g.clearRect(0, 0, display.getLength(), display.getHeight());

    g.drawImage(s.getSprite(0), 0, 0, null);
    g.drawImage(s.getSprite(1), 32, 0, null);
    g.drawImage(s.getSprite(2), 64, 0, null);
    g.drawImage(s.getSprite(3), 96, 0, null);
    g.drawImage(s.getSprite(4), 128, 0, null);
    g.drawImage(s.getSprite(5), 256, 64, null);
    g.drawImage(s.getSprite(6), 0, 32, null);
    g.drawImage(s.getSprite(7), 0, 64, null);
    g.drawImage(s.getSprite(8), 0, 128, null);
    
    bs.show();
    g.dispose();
  }
  
  public void run() {
    init();
    while (running) {
      tick();
      render();
    }
    stop();
  }
  
  public synchronized void start() {
    if (running) 
      return;
    thread = new Thread(this);
    running = true;
    thread.start();
  }
  
  public synchronized void stop() {
    if (!running) 
      return;
    try {
      thread.join();
    } catch(Exception e) {
      e.printStackTrace();
    }
    running = false;
  }
}
