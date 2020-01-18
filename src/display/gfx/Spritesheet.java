package display.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Spritesheet {
  
  private BufferedImage image;
  private int imgWidth, imgHeight;
  
  private ArrayList<BufferedImage> subimages = new ArrayList<BufferedImage>();
  
  public Spritesheet (BufferedImage image) {
    this.image = image;
    imgWidth = image.getWidth();
    imgHeight = image.getHeight();
  }
  
  public BufferedImage singleCrop(int x, int y, int w, int h) {
    return image.getSubimage(x, y, w, h);
  }
  
  public void autoCrop(int spriteWidth, int spriteHeight) {
    int rowTotal = imgWidth / spriteWidth;
    int columnTotal =  imgHeight / spriteHeight;
    int total = rowTotal * columnTotal;
    
    for(int i = 0; i < total; i++) {
      int spriteY = i / rowTotal;
      int spriteX = i % rowTotal;
      
      subimages.add(image.getSubimage(spriteX * spriteWidth, spriteY * spriteHeight, spriteWidth, spriteHeight));
    }
  }
  
  public BufferedImage getSprite(int id) {
    return subimages.get(id);
  }
}
