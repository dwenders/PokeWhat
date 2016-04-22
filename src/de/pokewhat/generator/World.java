package de.pokewhat.generator;

import de.pokewhat.gamestate.GameStateManager;
import de.pokewhat.gamestate.LevelLoader;
import de.pokewhat.gop.main.Vector2F;
import de.pokewhat.gop.main.loadImageFrom;
import de.pokewhat.main.Main;
import de.pokewhat.moveableobjects.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Danny on 29.03.2016.
 */
public class World {

    public static Vector2F map_pos = new Vector2F();
    private String worldName;
    private BufferedImage map;
    private BufferedImage map2;
    private BufferedImage map3;
    private int world_width;
    private int world_height;
    private boolean hasSize = false;
    private int blockSize = 48;
    private Player player;
    private boolean hasGenerated;

    public static TileManager tiles;

    private Block spawn;

    private GameStateManager gsm;

    public World(String worldName, GameStateManager gsm) {
        this.worldName = worldName;
        this.gsm = gsm;
        Vector2F.setWorldVariables(map_pos.xPos, map_pos.yPos);
    }

    public void init() {
        tiles = new TileManager();

        map_pos.xPos = spawn.getBlockLocation().xPos - player.getPos().xPos;
        map_pos.yPos = spawn.getBlockLocation().yPos - player.getPos().yPos;

        if (player != null) {
            player.init(this);
        }
    }

    public void tick(double deltaTime) {

        Vector2F.setWorldVariables(map_pos.xPos, map_pos.yPos);


        if (player.hasSpwaned()) {
            spawn.tick(deltaTime);
        }

        tiles.tick(deltaTime);
        tiles.tick2(deltaTime);

        if (player != null) {
            player.tick(deltaTime);
        }
    }

    public void render(Graphics2D g) {

        if (player.hasSpwaned()) {
            spawn.render(g);
        }

        tiles.render(g);
        tiles.render2(g);

        if (player != null) {
            player.render(g);
        }

    }

    public void generate(String world_image_name) {

        map = null;
        map2 = null;
        map3 = null;

        if (hasSize) {
            try {
                if (!world_image_name.equalsIgnoreCase("pokecenter_map")) {
                    map = loadImageFrom.loadImageFrom(Main.class, "img/" + world_image_name + ".png");
                }
                map2 = loadImageFrom.loadImageFrom(Main.class, "img/"+world_image_name + "2.png");
                map3 = loadImageFrom.loadImageFrom(Main.class, "img/"+world_image_name + "3.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (world_image_name.equalsIgnoreCase("pokecenter_map")) {
                addMapToWorld(1, 15, 9);
                addBlocksToWorld(map2, 2);
                addBlocksToWorld(map3, 3);
            } else {
                addBlocksToWorld(map, 1);
                addBlocksToWorld(map2, 2);
                addBlocksToWorld(map3, 3);
            }
        }
        hasGenerated = true;
    }

    private void addMapToWorld(int layer, int sizeX, int sizeY) {
        int currentLayer = layer - 1;
        ArrayList<Block>[] whichLayer = new ArrayList[3];
        whichLayer[0] = tiles.blocks;
        whichLayer[1] = tiles.blocks2;
        whichLayer[2] = tiles.blocks3;
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 15; x++) {
                whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER));
            }
        }
    }


    public void addBlocksToWorld(BufferedImage map, int layer) {
        int currentLayer = layer - 1;
        ArrayList<Block>[] whichLayer = new ArrayList[3];
        whichLayer[0] = tiles.blocks;
        whichLayer[1] = tiles.blocks2;
        whichLayer[2] = tiles.blocks3;

        for (int x = 0; x < world_width; x++) {
            for (int y = 0; y < world_height; y++) {
                int col = map.getRGB(x, y);
                switch (col & 0xFFFFFF) {
                    case 0xFF0000:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKEMON_GRAS_1));
                        break;
                    case 0x808080:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.NORMAL_GRAS_1));
                        break;
                    case 0xFFCA59:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_TOP_LEFT));
                        break;
                    case 0xFF8789:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_TOP_MID));
                        break;
                    case 0xF1FF5E:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_TOP_RIGHT));
                        break;
                    case 0x429AFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_LEFT_LEFT).isSolid(true));
                        break;
                    case 0x4762FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_RIGHT_RIGHT).isSolid(true));
                        break;
                    case 0x96FFC5:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_MID_MID).isSolid(true));
                        break;
                    case 0x6DFAFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_LEFT_1).isSolid(true));
                        break;
                    case 0xFFAD49:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_LEFT_2).isSolid(true));
                        break;
                    case 0xFFCDA8:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_RIGHT_1).isSolid(true));
                        break;
                    case 0xC3FF7A:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_RIGHT_2).isSolid(true));
                        break;
                    case 0xCF11FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_BOT_MID).isSolid(true));
                        break;
                    case 0xA3D5FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_BOT_LEFT).isSolid(true));
                        break;
                    case 0xAAFFEC:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_BOT_RIGHT).isSolid(true));
                        break;
                    case 0x44FF1E:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_MID_1).isSolid(true));
                        break;
                    case 0xFFC638:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_ROOF_BOT_MID_2).isSolid(true));
                        break;
                    case 0xC1FFD7:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_FRONT_LEFT).isSolid(true));
                        break;
                    case 0xFF7970:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_FRONT_RIGHT).isSolid(true));
                        break;
                    case 0x8438FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_FRONT_MID_LEFT).isSolid(true));
                        break;
                    case 0xFF3056:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_FRONT_MID_RIGHT).isSolid(true));
                        break;
                    case 0xFF1E83:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_FRONT_DOOR));
                        break;
                    case 0xFF4FFC:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.ROAD_GRAS_BRIGHT_HZ_TOP));
                        break;
                }
            }
        }
    }


    public void setSize(int world_width, int world_height) {
        this.world_width = world_width;
        this.world_height = world_height;
        hasSize = true;
    }

    public void addPlayer(Player player) {
        this.player = player;
    }

    public Vector2F getWorldPos() {
        return map_pos;
    }

    public float getWorldXpos() {
        return map_pos.xPos;
    }

    public float getWorldYpos() {
        return map_pos.yPos;
    }

    public boolean hasGenerated() {
        return hasGenerated;
    }

    public void resetWorld() {
        tiles.getBlocks().clear();
        tiles.getBlocks2().clear();
        tiles.getBlocks3().clear();
        //spawn = null;
    }

    public void setWorldSpawn(float xpos, float ypos) {
        if (xpos < world_width) {
            if (ypos < world_height) {
                Block spawn = new Block(new Vector2F(xpos * blockSize, ypos * blockSize));
                this.spawn = spawn;
            }
        }
    }

    public Vector2F getWorldSpawn() {
        return spawn.pos;
    }

    public void changeToWorld(String wn, String mn) {
        if (wn != worldName) {
            resetWorld();
            gsm.states.push(new LevelLoader(gsm, wn, mn, 15, 9));
            gsm.states.peek().init();
            System.out.println("CHANGED TO WORLD: " + wn + "");
        } else {
            System.err.println("You are already in that world !");
        }
    }
}
