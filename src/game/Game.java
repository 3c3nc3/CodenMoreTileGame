package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import display.gfx.ImageLoader;

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
    
    g.drawImage(ImageLoader.LoadImage("/textures/plasma.png/"), 10, 10, null);
    
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
