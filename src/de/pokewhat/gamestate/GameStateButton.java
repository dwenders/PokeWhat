package de.pokewhat.gamestate;

import de.pokewhat.gop.main.Vector2F;
import de.pokewhat.main.Assets;
import de.pokewhat.managers.Mousemanager;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Created by Danny on 27.03.2016.
 */
public class GameStateButton extends Rectangle {

    private Vector2F pos = new Vector2F();
    private GameState gameState;
    private GameStateManager gsm;
    private boolean isHeldOver;
    private int width = 32 * 6;
    private int height = 64;
    private BufferedImage defaultImage;
    private  String buttonMessage;

    public GameStateButton(float xPos, float yPos, GameState gameState, GameStateManager gsm, String buttonMessage) {
        this.gameState = gameState;
        this.gsm = gsm;
        this.pos.xPos = xPos;
        this.pos.yPos = yPos;
        this.buttonMessage = buttonMessage;
        setBounds((int) pos.xPos, (int) pos.yPos, width, height);
        defaultImage = Assets.getButton_notover();
    }

    public GameStateButton(float xPos, float yPos,String buttonMessage) {
        this.pos.xPos = xPos;
        this.pos.yPos = yPos;
        this.buttonMessage = buttonMessage;
        setBounds((int) pos.xPos, (int) pos.yPos, width, height);
        defaultImage = Assets.getButton_notover();
    }

    public void tick() {
        setBounds((int) pos.xPos, (int) pos.yPos, width, height);
        if(Mousemanager.mouse!=null) {

            if (getBounds().contains(Mousemanager.mouse)) {
                isHeldOver = true;
            } else {
                isHeldOver = false;
            }
        }

        if(isHeldOver){
            if(defaultImage != Assets.getButton_heldover()){
                defaultImage = Assets.getButton_heldover();
            }
        } else{
            if(defaultImage != Assets.getButton_notover()){
                defaultImage = Assets.getButton_notover();
            }
        }

        if(gameState != null){
            if(isHeldOver){
                if(isPressed()){
                    gsm.states.push(gameState);
                    gsm.states.peek().init();
                    isHeldOver = false;
                    Mousemanager.pressed = false;
                }
            }
        }

    }

    Font font = new Font("Super Mario Bros 3",10,30);

    public void render(Graphics2D g) {
        g.drawImage(defaultImage,(int)pos.xPos,(int)pos.yPos,width,height,null);
        g.setFont(font);
        AffineTransform at = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(at, true, true);
        int tw = (int) font.getStringBounds(buttonMessage, frc).getWidth();
        g.drawString(buttonMessage, pos.xPos + width / 2 - tw / 2, pos.yPos + height / 2 + 8);

    }

    public boolean isHeldOver() {
        return isHeldOver;
    }

    public boolean isPressed(){
        return Mousemanager.pressed;
    }

}
