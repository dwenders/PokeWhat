package de.pokewhat.main;

import de.pokewhat.generator.Block;
import de.pokewhat.generator.TileManager;

import java.awt.*;

/**
 * Created by dwenders on 23.03.2016.
 */
public class Check {

    public static boolean CollisionPlayerBlock(Point p1, Point p2){
        for(Block block : TileManager.blocks2){
            if(block.isSolid()){
                if(block.contains(p1) || block.contains(p2)){
                    return true;
                }
            }
        }
        return false;
    }

}
