package de.pokewhat.generator;

import de.pokewhat.gop.main.Vector2F;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Danny on 27.03.2016.
 */
public class BlockEntity extends Rectangle{

    private Vector2F pos;
    private BufferedImage block_image;
    private double rotation;
    private double rotation_speed = 0.8;
    private double blockSize = 24;
    private boolean isAlive;
    private int lifeTime = 120;
    private boolean isDying;
    float lifeFade = 1;

    public BlockEntity(Vector2F pos, BufferedImage block_image){
        this.pos = pos;
        this.block_image = block_image;
        rotation = new Random().nextInt(180);
        setBounds((int) pos.xPos, (int) pos.yPos, (int) blockSize, (int) blockSize);
        isAlive = true;
    }

    public void tick(double deltaTime){
        if(isAlive){
            setBounds((int)pos.xPos,(int)pos.yPos,(int)blockSize,(int)blockSize);
            rotation -= rotation_speed;

            if(!isDying){
                if(lifeTime!= 0){
                    lifeTime--;
                }
                if(lifeTime==0){
                    //World.removeDropedEntity(this);
                }
            }
            if(isDying){
                if(lifeFade!=0.000010000 ){
                    lifeFade-=0.01;
                }
                if(lifeFade<=0.000010000){
                    //World.removeDropedEntity(this);
                    isAlive = false;
                }
            }

        }

    }

    public void render(Graphics2D g){
        if(isAlive) {
            if(isDying){
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, lifeFade));
            }
            g.rotate(Math.toRadians(rotation), pos.getWorldLocation().xPos + blockSize / 2, pos.getWorldLocation().yPos + blockSize / 2);
            g.drawImage(block_image, (int) pos.getWorldLocation().xPos, (int) pos.getWorldLocation().yPos, (int) blockSize, (int) blockSize, null);
            g.drawRect((int) pos.getWorldLocation().xPos, (int) pos.getWorldLocation().yPos, (int) blockSize, (int) blockSize);
            g.rotate(-Math.toRadians(rotation), pos.getWorldLocation().xPos + blockSize / 2, pos.getWorldLocation().yPos + blockSize / 2);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        }
    }

    public Vector2F getPos(){
        return pos;
    }

    public void setPos(Vector2F pos) {
        this.pos = pos;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
