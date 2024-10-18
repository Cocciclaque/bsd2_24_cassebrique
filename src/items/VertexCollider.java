package items;

import java.awt.*;
import java.util.function.Function;

public class VertexCollider {

    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;

    public VertexCollider(int sX, int sY, int eX, int eY){
        this.startX = sX;
        this.startY = sY;
        this.endX = eX;
        this.endY = eY;
    }

    public int IsCollidingWithVertex(int sX, int sY, int eX, int eY){
        if((sX <= endX && sX >= startX && sY >= startY && sY <= endY) || (eX <= endX && eX >= startX && eY >= startY && eY <= endY)){
            return 1;
        }
        return 0;
    }

    public void draw(Graphics2D canvas){
        canvas.setColor(new Color(1, 0, 0, (float)0.3));
        canvas.fillRect(this.startX, this.startY, this.endX-this.startX, this.endY-this.startY);
    }

}
