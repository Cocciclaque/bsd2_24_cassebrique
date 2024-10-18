import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import items.*;

public class Main extends Canvas implements KeyListener {

    public JFrame window = new JFrame();
    public int width = 600;
    public int height = 900;
    List<Ball> ballList = new ArrayList<Ball>();
    List<Brick> brickList = new ArrayList<Brick>();
    List<Bonus> bonusList = new ArrayList<Bonus>();
    List<Ball> newBallList = new ArrayList<Ball>();
    List<Brick> newBrickList = new ArrayList<Brick>();
    Bar player = new Bar(Math.round((float) width /2), height-100, 100, 30, 20, Color.WHITE);
    public Main() {
        this.window.setSize(width,height);
        this.setSize(width, height);
        this.setBounds(0, 0, width, height);

        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton button = new JButton("Add a ball.");
        JButton buttonTen = new JButton("Add 10 balls.");
        JButton buttonBrick = new JButton("Add a normal brick.");
        JButton buttonBrickBig = new JButton("Add a bigger than normal brick.");
        ActionListener click = (event) -> {
            try {
                newBallList.add(new Ball((int) this.width, (int) this.height, 20));
            }catch(Exception ignored) {

            }

            };


        ActionListener clickTen = (event) -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    newBallList.add(new Ball((int) this.width, (int) this.height, 20));

                }
            }catch (Exception ignored){

            }
        };
        ActionListener clickBrick = (event) -> {
            try {
                newBrickList.add(new Brick((int) Math.round((Math.random() * width)), (int) Math.round((Math.random() * height)),
                        (int) Math.round((Math.random() * 200)), (int) Math.round((Math.random() * 200))));
            }catch (Exception ignored){

        }

        };
        ActionListener clickBrickBig = (event) -> {
            try{
                newBrickList.add(new Brick((int) Math.round((Math.random()*width)-200),(int) Math.round((Math.random()*height)-200),
                        (int) Math.round((Math.random()*400))+200,(int) Math.round((Math.random()*400))+200));
            }catch (Exception ignored){

            }

        };
        button.addActionListener(click);
        buttonTen.addActionListener(clickTen);
        buttonBrick.addActionListener(clickBrick);
        buttonBrickBig.addActionListener(clickBrickBig);
        panel.add(button);
        panel.add(buttonTen);
        panel.add(buttonBrick);
        panel.add(buttonBrickBig);


        ballList.add(new Ball((int)height, (int)width, 20));

        brickList.add(new Brick((int) 200, 200, 100, 150, Color.GREEN));
        brickList.add(new Brick((int) 420, 69, 69,69));

        panel.add(this);
        this.window.setContentPane(panel);


        this.setIgnoreRepaint(true);
        this.setFocusable(true);

        this.window.pack();
        this.window.setResizable(false);
        this.window.requestFocus();

        this.createBufferStrategy(2);

        this.window.setVisible(true);
        this.setVisible(true);

        try{
            launchGame();
        } catch (InterruptedException ignored){

        }
    }

    public static void main(String[] args) {
        new Main();
    }

    public void launchGame() throws InterruptedException {



        while(true) {


            Graphics2D canvas = (Graphics2D)this.getBufferStrategy().getDrawGraphics();

            canvas.setColor(Color.BLUE);
            canvas.fillRect(0, 0, this.width, this.height);
            try {
                for (Ball ball : ballList) {
                    ball.resetColList();
                    ball.draw(canvas);
                    ball.move(this.height, this.width);
                    for (Brick brick : brickList) {
                        ball.setColList(brick.col.IsCollidingWithRectangleCollider(ball));
                    }
                    ball.setColList(player.col.IsCollidingWithRectangleCollider(ball));

                    if (ball.getColDir(0) && ball.getDirY() == 1) {
                        ball.changeVerticalDir();
                    }
                    if (ball.getColDir(1) && ball.getDirY() == -1) {
                        ball.changeVerticalDir();
                    }
                    if (ball.getColDir(2) && ball.getDirX() == 1) {
                        ball.changeHorizontalDir();
                    }
                    if (ball.getColDir(3) && ball.getDirX() == -1) {
                        ball.changeHorizontalDir();
                    }

                }


                List<Brick> bricks = new ArrayList<Brick>();
                for (Brick brick : brickList) {
                    brick.draw(canvas);
                    brick.doDamage();
                    if (brick.hp >= 0) {
                        bricks.add(brick);
                    } else {
                        boolean isBonus = 0.5 >= Math.random();
                        boolean isSpeed = 0.5 >= Math.random();
                        bonusList.add(new Bonus(brick.getX()+brick.getWidth()/2-20, brick.getY()+brick.getHeight()/2-20, 40, isBonus, isSpeed));
                    }
                }
                List<Bonus> newBonuses = new ArrayList<Bonus>();
                for (Bonus bonus : bonusList) {
                    bonus.draw(canvas);
                    bonus.move(width);
                    if (bonus.getY() <= height) {
                        newBonuses.add(bonus);
                    }
                }
            player.draw(canvas);
            bonusList = newBonuses;
            newBrickList = bricks;
            }catch (Exception ignored){}
            canvas.dispose();
            this.getBufferStrategy().show();
            ballList = newBallList;
            brickList = newBrickList;
            Thread.sleep(1000/60);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("This is a test");
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            player.move(1);
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_Q || e.getKeyCode() == KeyEvent.VK_A) {
            player.move(-1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            player.move(1);
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_Q || e.getKeyCode() == KeyEvent.VK_A) {
            player.move(-1);
        }
    }
}