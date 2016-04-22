package de.pokewhat.generator;

import de.pokewhat.moveableobjects.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dwenders on 22.03.2016.
 */
public class TileManager {

    public static ArrayList<Block> blocks = new ArrayList<Block>();
    public static ArrayList<Block> blocks2 = new ArrayList<Block>();
    public static ArrayList<Block> blocks3 = new ArrayList<Block>();

    public TileManager(){

    }

    public void tick(double deltaTime){
        for(Block block : blocks){
            block.tick(deltaTime);

            if(Player.render.intersects(block)){
                block.setAlive(true);
            } else {
                block.setAlive(false);
            }
        }
    }

    public void render (Graphics2D g){
        for(Block block : blocks){
            block.render(g);
        }
    }

    public void tick2(double deltaTime){
        for(Block block : blocks2){
            block.tick(deltaTime);

            if(Player.render.intersects(block)){
                block.setAlive(true);
            } else {
                block.setAlive(false);
            }
        }
    }

    public void render2 (Graphics2D g){
        for(Block block : blocks2){
            block.render(g);
        }
    }

    public void tick3(double deltaTime){
        for(Block block : blocks3){
            block.tick(deltaTime);

            if(Player.render.intersects(block)){
                block.setAlive(true);
            } else {
                block.setAlive(false);
            }
        }
    }

    public void render3 (Graphics2D g){
        for(Block block : blocks3){
            block.render(g);
        }
    }

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static ArrayList<Block> getBlocks2() {
        return blocks2;
    }

    public static ArrayList<Block> getBlocks3() {
        return blocks3;
    }
}
