package com.company.startGame;

import javax.swing.*;
import java.awt.*;


public  class CheckGame{
    private Image image;
    private Image imageExit;

    public Image getImage() {
        return image;
    }

    public Image getImageExit() {
        return imageExit;
    }

    public int controlGame(int xTom, int yTom, int xJerry, int yJerry, int openHole){

        if(xTom-20<xJerry&&xTom+20>xJerry  &&  yTom-60<yJerry&&yTom+60>yJerry ){
            image = new ImageIcon("image/game_over.png").getImage();
            imageExit = new ImageIcon("image/esc.png").getImage();
            return 1;
        }
        if(xJerry-30<360&&xJerry+30>360 && yJerry-30<265&&yJerry+30>265 && openHole==3){
            image = new ImageIcon("image/game_over.png").getImage();
            imageExit = new ImageIcon("image/esc.png").getImage();
            return 2;
        }
        return 0;
    }
}

