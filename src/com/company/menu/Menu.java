package com.company.menu;

import com.company.startGame.MainFrame;
import com.company.startGame.Sound;

import javax.swing.*;
import java.awt.*;

public class Menu{
    public static JFrame frameMenu = new JFrame();
    public static JPanel panel2;
    Arrow point = new Arrow();

    Image imageMenu = new ImageIcon("image/tomandjerry2.jpg").getImage();
    Image imageStart = new ImageIcon("image/start.png").getImage();
    Image imageRulesGame = new ImageIcon("image/rules.png").getImage();
    Image imageRules = new ImageIcon("image/rulesgame2.png").getImage();
    Image imageExit = new ImageIcon("image/exit.png").getImage();
    Sound music = Sound.playSound("sound/TomJerrySound.wav");

    public Menu(){
        frameMenu.setLocation(200, 0);
        frameMenu.setSize(1200,800);
        frameMenu.setTitle("MENU");
        frameMenu.setVisible(true);



        panel2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                //super.paintComponent(g);
                g.drawImage(imageMenu,0,0,null);
                g.drawImage(imageStart, 10,320,null);
                g.drawImage(imageRulesGame, 10, 370, null);
                g.drawImage(imageExit, 10,420,null);
                if(point.getRules()==1)g.drawImage(imageRules, 10,520,null);
                g.drawImage(point.getImage(), 120, point.getyPointer(), null);
                if(point.getStopSound()==1){
                    music.stop();
                    frameMenu.setVisible(false);
                    new MainFrame();
                }

            }
        };
        frameMenu.add(panel2);
        frameMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMenu.setVisible(true);

    }

}

