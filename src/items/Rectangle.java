package items;

import java.awt.*;

public class Rectangle extends Sprite{

    protected int width;
    protected int height;

    public Rectangle(int x, int y, int w, int h){
        super(x, y);
        this.width = w;
        this.height = h;
    }

    public Rectangle(int x, int y, int w, int h, Color c){
        super(x, y, c);
        this.width = w;
        this.height = h;
    }

    public void draw(Graphics2D canvas){
        canvas.setColor(this.color);
        canvas.fillRect(this.x, this.y, this.width, this.height);
    }
}
