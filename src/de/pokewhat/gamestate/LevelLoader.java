package de.pokewhat.gamestate;

import de.pokewhat.generator.World;
import de.pokewhat.main.Main;
import de.pokewhat.moveableobjects.Player;

import java.awt.*;

/**
 * Created by dwenders on 22.03.2016.
 */
public class LevelLoader extends GameState {

    public static World world;
    private String worldName;
    private String map_name;
    private int sizeX;
    private int sizeY;

    public LevelLoader(GameStateManager gsm) {
        super(gsm);
    }

    public LevelLoader(GameStateManager gsm, String worldName, String map_name, int sizeX, int sizeY) {
        super(gsm);
        this.worldName = worldName;
        this.map_name = map_name;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    @Override
    public void init() {

        if (worldName == null) {
            worldName = "NULL";
            map_name = "map";
        }
        if(sizeX == 0 && sizeY == 0){
            sizeX = 50;
            sizeY = 50;
        }

        world = new World(worldName, gsm);
        world.setSize(sizeX, sizeY);
        world.setWorldSpawn(0,0);
        world.addPlayer(new Player());
        world.init();
        world.generate(map_name);
    }

    @Override
    public void tick(double deltaTime) {
        if (world.hasGenerated()) {
            world.tick(deltaTime);
        }
    }

    @Override
    public void render(Graphics2D g) {
        if (world.hasGenerated()) {
            world.render(g);
        }
        g.clipRect(0, 0, Main.width, Main.height);
    }

}
