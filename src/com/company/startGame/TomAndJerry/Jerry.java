package com.company.startGame.TomAndJerry;

import com.company.startGame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jerry implements KeyListener, ActionListener {
    private int x=20, y=380;
    private Image image = new ImageIcon("image/jerry_right_small.png").getImage();
    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isUp = false;
    private boolean isDown = false;
    private boolean isEXIT = false;
    private boolean catchMe = false;
    private boolean jerryWin = false;
    private int speedJerry = 7;

    public void moveJerry(){
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(catchMe==false && jerryWin==false) {
                    if (isRight) {
                        image = new ImageIcon("image/jerry_right_small.png").getImage();
                        if (x < 540) x += speedJerry;
                        if (x >= 540 && x <= 620 && y + 540 >= x &&x<900) x += speedJerry;
                        if (x >= 620 && x < 740 && y + y / 2 + 400 >= x &&x<900) x += speedJerry;
                        if (x >= 740 && y + y / 2 + 440 >= x && x<900) x += speedJerry;
                    }

                    if (isLeft) {
                        image = new ImageIcon("image/jerry_left_small.png").getImage();
                        //if(x>=8)x-=4
                        int z = 0;
                        if (x > 240 && x < 498) z = 94;
                        if (x + y >= 740 - y + z &&x>=-20) x -= speedJerry;

                    }

                    if (isUp) {
                        if (x < 340 && x > 200 && y < 250) y += speedJerry;
                        if (y >= 336 - (x / 4) && x < 540) y -= speedJerry;
                        if (x >= 540 && x < 660 && y + 310 > x) y -= speedJerry;
                        if (x >= 660 && y + 420 > x) y -= speedJerry;
                        if (x >= 660 && y > 280 && y + 660 > x) y -= speedJerry;
                        if (x <= 720 && y <= 280 && y >= 200 && y + 760 > x) y -= speedJerry;
                    }
                    if (isDown) {
                        if(y<570)y += speedJerry;
                    }
                }
                if(catchMe==true||jerryWin==true){
                    image = new ImageIcon("image/.png").getImage();
                    MainFrame.panel.repaint();
                }
                if (isEXIT)System.exit(0);
                MainFrame.panel.repaint();
            }
        });
        timer.start();
    }

    public void setCatchMe(boolean catchMe) {
        this.catchMe = catchMe;
    }

    public void setJerryWin(boolean jerryWin) {
        this.jerryWin = jerryWin;
    }

    public Jerry() {
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
        if (e.getKeyCode()==KeyEvent.VK_LEFT) isLeft = true;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) isRight = true;
        if (e.getKeyCode()==KeyEvent.VK_UP) isUp = true;
        if (e.getKeyCode()==KeyEvent.VK_DOWN) isDown = true;
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE) isEXIT = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT) isLeft = false;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) isRight = false;
        if (e.getKeyCode()==KeyEvent.VK_UP) isUp = false;
        if (e.getKeyCode()==KeyEvent.VK_DOWN) isDown = false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




