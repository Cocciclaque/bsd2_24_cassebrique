package items;

import java.awt.*;

public class Bar extends Rectangle{

    protected int speed;
    public RectangleCollider col;

    public Bar(int x, int y, int w, int h, int speed){
        super(x, y, w, h);
        this.speed = speed;
        this.col = new RectangleCollider(x, y, x + w, y + h);
    }

    public Bar(int x, int y, int w, int h, int speed, Color c){
        super(x, y, w, h, c);
        this.speed = speed;
        this.col = new RectangleCollider(x, y, x + w, y + h);
    }

    public void move(int x){
        this.x += x * this.speed;
    }

}
