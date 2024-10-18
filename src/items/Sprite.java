package items;

import java.awt.*;

public abstract class Sprite {

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    protected int x;
    protected int y;
    protected Color color;
    public Sprite(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        this.color = new Color(ratioAleatoire(), ratioAleatoire(), ratioAleatoire());
    }

    abstract void draw(Graphics2D canvas);

    protected float ratioAleatoire(){
        return (float)Math.random();
    }

}
