package com.company.startGame.cheese;

import com.company.startGame.MainFrame;
import com.company.startGame.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public abstract class Cheese {
    private int nSecond;
    private boolean catchCheese=false;
    private int xCheese;
    private int yCheese;

    public Cheese(int xCheese, int yCheese) {
        this.xCheese = xCheese;
        this.yCheese = yCheese;
    }

    private Image image = new ImageIcon("image/cheese.png").getImage();

    public Image getImage() {
        MainFrame.panel.repaint();
        return image;
    }

    public void controlTime(){
        java.util.Calendar calendarTime = java.util.Calendar.getInstance();
        nSecond = calendarTime.get(Calendar.SECOND);
    }
    public void changeColor(){

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nSecond%2==0 && catchCheese==false) image = new ImageIcon("image/cheese_light.png").getImage();
                if(nSecond%2!=0 &&catchCheese==false) image = new ImageIcon("image/cheese.png").getImage();
                if(catchCheese==true){
                    image = new ImageIcon("image/.png").getImage();
                }
            }
        });
        timer.start();
    }

    public int contrloCheese(int xJerry, int yJerry){
        if(xJerry-30<xCheese&&xJerry+30>xCheese && yJerry-25<yCheese&&yJerry+25>yCheese && catchCheese==false) {
            Sound musicFonCheese = Sound.playSound("sound/soundJerry.wav");
            catchCheese = true;
            return 1;
        }

        return 0;
    }
}

