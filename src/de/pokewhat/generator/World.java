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
                map = loadImageFrom.loadImageFrom(Main.class, world_image_name + ".png");
                map2 = loadImageFrom.loadImageFrom(Main.class, world_image_name + "2.png");
                map3 = loadImageFrom.loadImageFrom(Main.class, world_image_name + "3.png");
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

                    case 0xE16BFF:
                        //whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_0));
                        break;
                    case 0xFBFFAF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_1));
                        break;
                    case 0xFF7259:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_2));
                        break;
                    case 0x4959FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_3));
                        break;
                    case 0x2DFF2D:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_4));
                        break;
                    case 0xFF7A66:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_5));
                        break;
                    case 0xA3A3FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_6));
                        break;
                    case 0xFF49FB:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_7));
                        break;
                    case 0x1CC2FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_8));
                        break;
                    case 0x51D9FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_9));
                        break;
                    case 0x0FFFDB:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_10));
                        break;
                    case 0xB5F0FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_11));
                        break;
                    case 0xFFC6E8:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_12));
                        break;
                    case 0xFFEFC1:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_13));
                        break;
                    case 0xFFD147:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_14));
                        break;

                    case 0xFF1E3C:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_15));
                        break;
                    case 0xFF1C6F:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_16));
                        break;
                    case 0x56B8FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_17));
                        break;
                    case 0xC6FF77:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_18));
                        break;
                    case 0xFFC354:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_19));
                        break;
                    case 0x00FF33:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_20));
                        break;
                    case 0xBE89FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_21));
                        break;
                    case 0xFFB2E8:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_22));
                        break;
                    case 0xAFFFDB:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_23));
                        break;
                    case 0x23B5FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_24));
                        break;
                    case 0x3A30FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_25));
                        break;
                    case 0xFF5602:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_26));
                        break;
                    case 0xFFA987:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_27));
                        break;
                    case 0xFFF31C:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_28));
                        break;
                    case 0x493FFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_29));
                        break;

                    case 0xFFF432:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_30));
                        break;
                    case 0xC6FF54:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_31));
                        break;
                    case 0x8CFFA5:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_32));
                        break;
                    case 0x59FFEB:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_33));
                        break;
                    case 0x56C9FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_34));
                        break;
                    case 0x5E96FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_35));
                        break;
                    case 0x4756FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_36));
                        break;
                    case 0x7A49FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_37));
                        break;
                    case 0xA53FFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_38));
                        break;
                    case 0xBF3FFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_39));
                        break;
                    case 0xF160FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_40));
                        break;
                    case 0xFF4486:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_41));
                        break;
                    case 0xFF4C4C:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_42));
                        break;
                    case 0xFFD177:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_43));
                        break;
                    case 0xF4FFDD:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_44));
                        break;

                    case 0xAFFFF7:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_45));
                        break;
                    case 0xAAD2FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_46));
                        break;
                    case 0xC3AFFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_47));
                        break;
                    case 0xEFB7FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_48));
                        break;
                    case 0xFFA8CF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_49));
                        break;
                    case 0xFFB0AD:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_50));
                        break;
                    case 0xFFF2BA:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_51));
                        break;
                    case 0xB6FF0C:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_52));
                        break;
                    case 0x6302FF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_53));
                        break;
                    case 0xFF0026:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_54));
                        break;
                    case 0xFF5B0F:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_55));
                        break;
                    case 0x7FFFD2:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_56));
                        break;
                    case 0xE0BCFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_57));
                        break;
                    case 0x666BFF:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_58));
                        break;
                    case 0x90FF30:
                        whichLayer[currentLayer].add(new Block(new Vector2F(x * blockSize, y * blockSize), Block.BlockType.POKE_CENTER_59));
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
