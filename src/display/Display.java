package display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame {
  
  private Canvas canvas;
  
  private int height = 480;
  private int length = 640;
  
  public Display() {
    super("Code 'n More Tuts");
    this.setSize(length, height);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    
    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(length, height));
    canvas.setMaximumSize(canvas.getPreferredSize());
    canvas.setMinimumSize(canvas.getPreferredSize());
    
    this.add(canvas);
    
    this.pack();
    this.setVisible(true);
  }
  
  public int getHeight() {
    return height;
  }
  
  public int getLength() {
    return length;
  }
  
  public Canvas getCanvas() {
    return canvas;
  }
}
