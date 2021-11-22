package com.company.startGame.TomAndJerry;

import com.company.startGame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tom implements KeyListener {
    private int x=600, y=450;
    private Image image = new ImageIcon("image/tom_sleeping.png").getImage();
    private boolean isA = false;
    private boolean isD = false;
    private boolean isW = false;
    private boolean isS = false;
    private boolean isEXIT = false;
    private boolean maybeCatch = false;
    private boolean lose = false;
    private int speedTom = 5;

    public void moveTom(){
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(maybeCatch==false&&lose==false) {
                    if (isD) {
                        image = new ImageIcon("image/tom_r_small.png").getImage();
                        if (x < 540) x += 4;
                        if (x >= 540 && x <= 720 && y + 540 >= x && x<840) x += speedTom;
                        if (x > 720 && y + 640 >= x &&x<840) x += speedTom;
                    }
                    if (isA) {
                        image = new ImageIcon("image/tom_l_small.png").getImage();
                        //if(x>=8)x-=4;
                        int z = 0;
                        if (x > 240 && x < 498) z = 84;
                        if (x + y >= 540 - y + z && x>4) x -= speedTom;
                    }
                    if (isW) {
                        if(x==600&&y==450)image = new ImageIcon("image/tom_l_small.png").getImage();
                        if (y >= 256 - (x / 4) && x < 540) y -= speedTom;
                        if (x >= 540 && x < 680 && y + 460 > x) y -= speedTom;
                        if (x >= 680 && x <= 800 && y + 560 > x) y -= speedTom;
                        if (x >= 800 && y + 620 > x) y -= speedTom;
                    }
                    if (isS) {
                        if(x==600&&y==450)image = new ImageIcon("image/tom_l_small.png").getImage();
                        if(y<500)y += speedTom;
                    }
                }
                if(maybeCatch==true){
                    image = new ImageIcon("image/Tom_catch.png").getImage();
                }
                if(lose==true){
                    //System.out.println("LOSEEEEE!");
                    image = new ImageIcon("image/tom_cry.png").getImage();
                }
                if (isEXIT)System.exit(0);
            }
        });
        MainFrame.panel.repaint();
        timer.start();
    }

    public void setMaybeCatch(boolean maybeCatch) {
        this.maybeCatch = maybeCatch;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public Tom() {
        MainFrame.frame.addKeyListener(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_A) isA = true;
        if (e.getKeyCode()==KeyEvent.VK_D) isD = true;
        if (e.getKeyCode()==KeyEvent.VK_W) isW = true;
        if (e.getKeyCode()==KeyEvent.VK_S) isS = true;
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE) isEXIT = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_A) isA = false;
        if (e.getKeyCode()==KeyEvent.VK_D) isD = false;
        if (e.getKeyCode()==KeyEvent.VK_W) isW = false;
        if (e.getKeyCode()==KeyEvent.VK_S) isS = false;
    }

}

