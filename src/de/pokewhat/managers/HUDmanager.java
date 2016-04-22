package de.pokewhat.managers;

import de.pokewhat.main.Main;
import de.pokewhat.moveableobjects.Player;

import java.awt.*;

/**
 * Created by Danny on 27.03.2016.
 */
public class HUDmanager {

    private Player player;

    public HUDmanager(Player player){
        this.player = player;
    }

    public void render(Graphics2D g){

        /*g.setColor(Color.black);
        g.fillRect(0,0, Main.width,Main.height/6);
        g.fillRect(0,750,Main.width,Main.height/6);
        g.setColor(Color.white);*/


        //g.drawString(player.getPos().xPos+"", 200, 200);

    }

}
