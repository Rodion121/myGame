package com.company.startGame;

import com.company.startGame.TomAndJerry.Jerry;
import com.company.startGame.TomAndJerry.Tom;
import com.company.startGame.cheese.CheeseOne;
import com.company.startGame.cheese.CheeseThree;
import com.company.startGame.cheese.CheeseTwo;

import javax.swing.*;
import java.awt.*;

public class MainFrame{
    private int position = 0;
    public static JFrame frame = new JFrame();
    public static JPanel panel;


    Image imageFon = new ImageIcon("image/fon3.jpg").getImage();
    Image imageHole = new ImageIcon("image/hole_closed.png").getImage();
    Tom tom = new Tom();
    Jerry jerry = new Jerry();
    private int xPositionCheeseCheeseOne = (int) (200+Math.random()*320);
    private int yPositionCheeseCheeseOne = (int) (280+Math.random()*310);
    private int xPositionCheeseCheeseTwo = (int) (400+Math.random()*220);
    private int yPositionCheeseCheeseTwo = (int) (200+Math.random()*200);
    private int xPositionCheeseCheeseThree = (int) (700+Math.random()*180);
    private int yPositionCheeseCheeseThree = (int) (240+Math.random()*110);
    private int openHole;

    CheeseOne cheese1 = new CheeseOne(xPositionCheeseCheeseOne, yPositionCheeseCheeseOne);
    CheeseTwo cheese2 = new CheeseTwo(xPositionCheeseCheeseTwo, yPositionCheeseCheeseTwo);
    CheeseThree cheese3 = new CheeseThree(xPositionCheeseCheeseThree, yPositionCheeseCheeseThree);
    CheckGame check = new CheckGame();
    Sound musicFon = Sound.playSound("sound/musicFon.wav");


    public MainFrame() {
        frame.setLocation(300, 50);
        frame.setSize(1000, 750);
        frame.setTitle("TOM_AND_JERRY");

        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                cheese1.controlTime();
                if(cheese1.contrloCheese(jerry.getX(), jerry.getY())==1)openHole+=1;
                cheese2.controlTime();
                if(cheese2.contrloCheese(jerry.getX(), jerry.getY())==1)openHole+=1;
                cheese3.controlTime();
                if(cheese3.contrloCheese(jerry.getX(), jerry.getY())==1)openHole+=1;

                g.drawImage(imageFon, 0, 0, null);
                g.drawImage(imageHole, 360, 265, null);
                g.drawImage(tom.getImage(), tom.getX(), tom.getY()-position, null);
                g.drawImage(jerry.getImage(), jerry.getX(), jerry.getY(), null);

                if(tom.getY()<280)g.drawImage(check.getImage(), 160,400,null);
                else g.drawImage(check.getImage(), 160,0,null);

                if(position==0)g.drawImage(cheese1.getImage(), xPositionCheeseCheeseOne, yPositionCheeseCheeseOne, null);
                if(position==0)g.drawImage(cheese2.getImage(), xPositionCheeseCheeseTwo, yPositionCheeseCheeseTwo, null);
                if(position==0)g.drawImage(cheese3.getImage(), xPositionCheeseCheeseThree, yPositionCheeseCheeseThree, null);

                if(openHole==3)imageHole = new ImageIcon("image/hole.png").getImage();

                if(musicFon.isPlaying()==false)musicFon = Sound.playSound("sound/musicFon.wav");
                if(check.controlGame(tom.getX(), tom.getY(), jerry.getX(), jerry.getY(), openHole)==1){
                    tom.setMaybeCatch(true);
                    jerry.setCatchMe(true);
                    position = 100;
                    musicFon.stop();
                    g.drawImage(check.getImageExit(), 0,0,null);
                }
                if(check.controlGame(tom.getX(), tom.getY(), jerry.getX(), jerry.getY(), openHole)==2){
                    tom.setLose(true);
                    jerry.setJerryWin(true);
                    if(tom.getY()>250)position = 100;
                    musicFon.stop();
                    g.drawImage(check.getImageExit(), 0,0,null);
                }

            }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        jerry.moveJerry();
        tom.moveTom();
        cheese1.changeColor();
        cheese2.changeColor();
        cheese3.changeColor();


    }


}
