package items;

import java.awt.*;

public class Bonus extends Rond{

    protected boolean isBonus; //If True, means it this.is a bonus, otherwise it's considered a malus;
    protected boolean isSpeed; //If True, means its a speed mod, otherwise it's considered a size mod;
    protected int verticalSpeed = 10;
    protected int horizontalSpeed;
    public Bonus(int x, int y, int diameter){
        super(x, y, diameter);
        this.isBonus = 0.5 >= Math.random();
        this.isSpeed = 0.5 >= Math.random();
    }

    public Bonus(int x, int y, int diameter, Color c){
        super(x, y, diameter, c);
        this.isBonus = 0.5 >= Math.random();
        this.isSpeed = 0.5 >= Math.random();
    }
    
    public Bonus(int x, int y, int speedX, int speedY, int diameter){
        super(x, y, diameter);
        this.isBonus = 0.5 >= Math.random();
        this.isSpeed = 0.5 >= Math.random();
        this.horizontalSpeed = speedX;
        this.verticalSpeed = speedY;
    }

    public Bonus(int x, int y, int speedX, int speedY, int diameter, Color c){
        super(x, y, diameter, c);
        this.isBonus = 0.5 >= Math.random();
        this.isSpeed = 0.5 >= Math.random();
        this.horizontalSpeed = speedX;
        this.verticalSpeed = speedY;
    }

    public Bonus(int x, int y, int diameter, boolean isBonus, boolean isSpeed){
        super(x, y, diameter);
        this.isBonus = isBonus;
        this.isSpeed = isSpeed;
        if(isBonus && isSpeed){
            this.color = Color.GREEN;
        } else if (!isBonus && isSpeed) {
            this.color = Color.MAGENTA;
        } else if (isBonus) {
            this.color = Color.WHITE;
        } else {
            this.color = Color.BLACK;
        }
    }


    public Bonus(int x, int y, int speedX, int speedY, int diameter, boolean isBonus, boolean isSpeed){
        super(x, y, diameter);
        this.isBonus = isBonus;
        this.isSpeed = isSpeed;
        this.horizontalSpeed = speedX;
        this.verticalSpeed = speedY;
    }

    public void move(int limitX){
        if(this.x >= limitX){
            this.horizontalSpeed = this.horizontalSpeed * -1;
        }
        this.x += this.horizontalSpeed;
        this.y += this.verticalSpeed;
    }

}
