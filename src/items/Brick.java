package items;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Brick extends Rectangle{

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected int width;
    protected int height;
    public RectangleCollider col;
    public int hp;

    public Brick(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        this.height = height;
        this.width = width;
        this.hp = 10;
        this.col = new RectangleCollider(x, y, x + this.width, y + this.height);
    }


    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.width = width;
        this.height = height;
        this.hp = 10;
        this.col = new RectangleCollider(x, y, x + this.width, y + this.height);
    }

    public void doDamage(){
        if(this.col.collision){
            this.hp -= 1;
            this.col.collision = false;
        }
    }
}
