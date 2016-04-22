package de.pokewhat.managers;

import de.pokewhat.main.Assets;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by Danny on 28.03.2016.
 */
public class Mousemanager implements MouseListener, MouseMotionListener, MouseWheelListener {

    private static int mouseMovedX,mouseMovedY;
    public static Point mouse;

    public static boolean pressed;

    public Mousemanager(){

    }

    public void tick(){
        mouse = new Point(mouseMovedX,mouseMovedY);
    }

    public void render(Graphics2D g){
        g.fillRect(mouseMovedX,mouseMovedY,4,4);

        if(pressed){
            g.drawImage(Assets.getMouse_pressed(),mouseMovedX,mouseMovedY,32,32,null);
        } else {
            g.drawImage(Assets.getMouse_unpressed(),mouseMovedX,mouseMovedY,32,32,null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            pressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            pressed = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseMovedX = e.getX();
        mouseMovedY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMovedX = e.getX();
        mouseMovedY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMovedX = e.getX();
        mouseMovedY = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
