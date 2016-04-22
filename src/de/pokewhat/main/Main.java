package de.pokewhat.main;


import de.pokewhat.gameloop.GameLoopGame;
import de.pokewhat.gop.main.GameWindow;
import de.pokewhat.managers.Mousemanager;
import de.pokewhat.moveableobjects.Player;

import java.awt.*;

/**
 * Created by dwenders on 21.03.2016.
 */
public class Main {

    public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static int width = 1024;//gd.getDisplayMode().getWidth();
    public static int height = 720;//gd.getDisplayMode().getHeight();

    public static void main (String[] args){
        GameWindow frame = new GameWindow("PokeWhat", width, height);
        frame.setFullscreen(0);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(""), new Point(8,0) , "Cursor");
        frame.setCursor(cursor);

        frame.addMouseListener(new Mousemanager());
        frame.addMouseMotionListener(new Mousemanager());
        frame.addMouseWheelListener(new Mousemanager());

        frame.addKeyListener(new Player());
        frame.setVisible(true);
        frame.add(new GameLoopGame(width,height));
    }

}
