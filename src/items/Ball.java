package items;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class Ball extends Rond{
    protected int speedX = 10;
    protected int speedY = 10;
    protected int dirX;
    protected int dirY;
    public int getDirX() {
        return dirX;
    }

    public int getDirY() {
        return dirY;
    }

    public ArrayList<Integer> collisionList;

    public void move(int height, int width){
        x += speedX * dirX;
        y += speedY * dirY;


        if(x >= width-this.diameter || x <= 0){
            changeHorizontalDir();
        }
        if(y >= height-this.diameter || y <= 0){
            changeVerticalDir();
        }
    }

    public Ball(int x, int y, int diameter){
        super((int)Math.round(Math.random() * (double) x), (int)Math.round(Math.random() * (double) y), diameter);
        this.dirY = randomDirection();
        this.dirX = randomDirection();
        this.speedY = (int) Math.round( Math.random() * ((double) y / 100));
        this.speedX = (int) Math.round( Math.random() * ((double) x / 100));
        this.collisionList = new ArrayList<>(4);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
    }
    public Ball(int x, int y, int diameter, int speedX, int speedY){
        super(x, y, diameter);
        this.dirY = randomDirection();
        this.dirX = randomDirection();
        this.speedX = speedX;
        this.speedY = speedY;
        this.collisionList = new ArrayList<>(4);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
    }

    public Ball(int x, int y, int diameter, int speedX, int speedY, Color color){
        super(x, y, diameter);
        this.dirY = randomDirection();
        this.dirX = randomDirection();
        this.speedX = speedX;
        this.speedY = speedY;
        this.collisionList = new ArrayList<>(4);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
    }

    protected int randomDirection(){
        Random random = new Random();
        boolean bool;
        bool = random.nextBoolean();
        if (bool){
            return 1;
        }
        return -1;
    }


    public void resetColList(){
        this.collisionList = new ArrayList<>(4);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
        this.collisionList.add(0);
    }
    public void setColList(ArrayList<Integer> colList){
    this.collisionList = colList;
    }

    public boolean getColDir(int direction){
        return !(this.collisionList.get(direction) % 2 == 0);
    }

    public void changeVerticalDir(){
        this.dirY = this.dirY * -1;
    }

    public void changeHorizontalDir(){
        this.dirX = this.dirX * -1;
    }
}
