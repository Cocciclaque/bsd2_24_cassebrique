package items;

import java.awt.*;
import java.util.ArrayList;

public class RectangleCollider{

    protected VertexCollider up;
    protected VertexCollider down;
    protected VertexCollider left;
    protected VertexCollider right;
    protected int colGirth = 10;
    protected boolean collision = false;

    public RectangleCollider(int x, int y, int width, int height){
        this.up = new VertexCollider(x, y, width, y+colGirth);
        this.down = new VertexCollider(x, height-colGirth, width, height);
        this.left = new VertexCollider(x, y, x+colGirth, height);
        this.right = new VertexCollider(width-colGirth, y, width, height);
    }

    public ArrayList<Integer> IsCollidingWithRectangleCollider(Ball ball){
        ArrayList<Integer> collisionArray = new ArrayList<>(4);
        collisionArray.add(0);
        collisionArray.add(0);
        collisionArray.add(0);
        collisionArray.add(0);
        collisionArray.set(0, ball.collisionList.get(0)+this.up.IsCollidingWithVertex(ball.x, ball.y + ball.diameter, ball.x + ball.diameter, ball.y + ball.diameter));
        collisionArray.set(1, ball.collisionList.get(1)+this.down.IsCollidingWithVertex(ball.x, ball.y, ball.x + ball.diameter, ball.y));
        collisionArray.set(2, ball.collisionList.get(2)+this.left.IsCollidingWithVertex(ball.x + ball.diameter, ball.y, ball.x + ball.diameter, ball.y + ball.diameter));
        collisionArray.set(3, ball.collisionList.get(3)+this.right.IsCollidingWithVertex(ball.x, ball.y, ball.x, ball.y+ball.diameter));
        if(collisionArray.get(0) != 0 || collisionArray.get(1) != 0 || collisionArray.get(2) != 0 || collisionArray.get(3) != 0){
            this.collision = true;
        }
        return collisionArray;
    }

    public void drawCollider(Graphics2D canvas){
        this.up.draw(canvas);
        this.down.draw(canvas);
        this.left.draw(canvas);
        this.right.draw(canvas);
    }

}
