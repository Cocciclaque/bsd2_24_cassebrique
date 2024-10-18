package items;

import java.awt.*;

public class Rond extends Sprite{

    protected int diameter;

    public Rond(int x, int y, int diameter){
        super(x, y);
        this.diameter = diameter;
    }

    public Rond(int x, int y, int diameter, Color c){
        super(x, y, c);
        this.diameter = diameter;
    }

    public void draw(Graphics2D canvas){
        canvas.setColor(this.color);
        canvas.fillOval(this.x, this.y, this.diameter, this.diameter);
    }
}
