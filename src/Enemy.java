import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Enemy {
    private final int MOVE_AMT = 3;
    private BufferedImage image;
    private int xCoord;
    private int yCoord;

    public Enemy(){
        xCoord = 50;
        yCoord = 100;
        try {
            image = ImageIO.read(new File("src\\goomba.png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }
    public void moveRight() {
        if (xCoord + MOVE_AMT <= 920) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }


    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 435) {
            yCoord += MOVE_AMT;
        }
    }
    public void move(int x, int y) {
        if (yCoord + y <= 435 && yCoord + y > 0) {
            yCoord += y;
        }
        if (xCoord + x >= 0 && xCoord + x <= 959) {
            xCoord += x;
        }
    }
    public Rectangle playerRect() {
        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }

    public BufferedImage getImage() {
        return image;
    }
}
