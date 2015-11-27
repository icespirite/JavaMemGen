package examples;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class LoadImageApp extends Component {
          
    private BufferedImage img;
    private Image nimg;
    private Boolean opened;
    Integer width, height, size, k;

    public void DrawImg(Graphics g) {
        if (opened){
            nimg = img.getScaledInstance(width, height, 1);
            g.drawImage(nimg, 0, 0, null);
        }
    }
    
    public Boolean isNorm() {
        return opened;
    }
    
    public void DrawText(Graphics g, String str1, String str2, Rectangle bound) {
        if (opened) {
            img.getGraphics().drawString(str1, img.getWidth()/2-(str1.length()/2*(size/2)), size);
            img.getGraphics().drawString(str2, img.getWidth()/2-(str2.length()/2*(size/2)), img.getHeight()-size);
            
            nimg = img.getScaledInstance(width, height, 1);
            
            g.drawImage(nimg, 0, 0, null);
        }
    }
    
    public Graphics GetMyGraphics() {
        return img.getGraphics();      
    }
    
    public Integer GetImgWidth(){
        if (opened) {
            return img.getWidth()/k;}
        else {return -1;}
    }
    public Integer GetImgHeight(){
        if (opened) {
            return img.getHeight()/k;} 
        else {return -1;}
    }

    public LoadImageApp(String path, Rectangle view) {
       try {
           img = ImageIO.read(new File(path));
           size = 30; k = 1;
           
           img.getGraphics().setColor(Color.white);
           img.getGraphics().setFont(new Font("Arial", Font.PLAIN, size)/*img.getGraphics().getFont().deriveFont(1, size)*/);
            img.getGraphics().setFont(img.getGraphics().getFont().deriveFont(50));
           width = img.getWidth()/k;
           height = img.getHeight()/k;
        } catch (IOException e) {
            opened = false; 
        }
       opened = true;
    }
    

    public void SaveImage(String path) {
        String fileName = path;         
        File file = new File(fileName);
        try {
        if (!file.exists()) {
            file.createNewFile();
        }
        ImageIO.write(img, "jpg", file);
        } catch (Exception e) {
            ;
        }
        
    }
    
}
