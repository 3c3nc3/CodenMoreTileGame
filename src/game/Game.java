package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;

public class Game implements Runnable {
  private static boolean instanceOf = false;
  private Display display;
  private Thread thread;
  
  private boolean running = false;
  
  private BufferStrategy bs;
  private Graphics g;
  
  public Game() throws IllegalAccessException {
    if (instanceOf) 
      throw new IllegalAccessException("An instance of this class already exists!");
    else 
      instanceOf = true;
  }
  
  private void init() {
    display = new Display();
    display.getCanvas().setBackground(Color.DARK_GRAY);
    Assets.init();
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

    g.drawImage(Assets.player, 0, 0, null);
    g.drawImage(Assets.plasma, 64, 0, null);
    g.drawImage(Assets.grass, 128, 0, null);
    g.drawImage(Assets.dirt, 192, 0, null);
    g.drawImage(Assets.stone, 256, 0, null);
    
    g.drawImage(Assets.bricks, 320, 0, null);
    g.drawImage(Assets.bricks, 352, 0, null);
    g.drawImage(Assets.bricks, 384, 0, null);
    g.drawImage(Assets.bricks, 416, 0, null);
    
    g.drawImage(Assets.bricks, 320, 32, null);
    g.drawImage(Assets.bricks, 352, 32, null);
    g.drawImage(Assets.bricks, 384, 32, null);
    g.drawImage(Assets.bricks, 416, 32, null);
    
    g.drawImage(Assets.bricks, 320, 64, null);
    g.drawImage(Assets.bricks, 352, 64, null);
    g.drawImage(Assets.bricks, 384, 64, null);
    g.drawImage(Assets.bricks, 416, 64, null);
    
    g.drawImage(Assets.bricks, 320, 96, null);
    g.drawImage(Assets.bricks, 352, 96, null);
    g.drawImage(Assets.bricks, 384, 96, null);
    g.drawImage(Assets.bricks, 416, 96, null);

    g.drawImage(Assets.dirt, 320, 128, null);
    g.drawImage(Assets.dirt, 352, 128, null);
    g.drawImage(Assets.dirt, 384, 128, null);
    g.drawImage(Assets.dirt, 416, 128, null);
    
    g.drawImage(Assets.dirt, 320, 160, null);
    g.drawImage(Assets.dirt, 352, 160, null);
    g.drawImage(Assets.dirt, 384, 160, null);
    g.drawImage(Assets.dirt, 416, 160, null);
    
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
