package com.company.menu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.company.menu.Menu.frameMenu;

public class Arrow implements KeyListener {
    private Image image = new ImageIcon("image/pointer3.png").getImage();
    private int yPointer = 315;
    private int rules;
    private int stopSound;

    public Arrow() {
        frameMenu.addKeyListener(this);
    }

    public Image getImage() {
        return image;
    }

    public int getyPointer() {
        return yPointer;
    }

    public int getRules() {
        return rules;
    }

    public int getStopSound() {
        return stopSound;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_UP){
            if(yPointer!=315)yPointer -=50;
            else yPointer = 415;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            if(yPointer!=415)yPointer +=50;
            else yPointer = 315;
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)System.exit(0);
        if (e.getKeyCode()==KeyEvent.VK_ENTER && yPointer==315)stopSound = 1;
        if(e.getKeyCode()==KeyEvent.VK_ENTER && yPointer==415)System.exit(0);
        if(e.getKeyCode()==KeyEvent.VK_ENTER && yPointer==365)rules = 1;

        Menu.panel2.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

