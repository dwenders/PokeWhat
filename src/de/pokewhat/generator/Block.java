package de.pokewhat.generator;

import de.pokewhat.gop.main.Vector2F;
import de.pokewhat.main.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by dwenders on 22.03.2016.
 */
public class Block extends Rectangle {

    Vector2F pos = new Vector2F();
    private int blockSize = 48;
    private BlockType blocktype;
    private BufferedImage block;
    private ArrayList<BufferedImage> blocks;
    private boolean isSolid;
    private boolean isAlive;
    public static int pokeCenterIndex = 0;

    public Block(Vector2F pos) {
        setBounds((int) pos.xPos, (int) pos.yPos, blockSize, blockSize);
        this.pos = pos;
        isAlive = true;
    }

    public Block(Vector2F pos, BlockType blocktype) {
        setBounds((int) pos.xPos, (int) pos.yPos, blockSize, blockSize);
        this.pos = pos;
        isAlive = true;
        this.blocktype = blocktype;
        init();
    }

    public Block isSolid(boolean isSolid) {
        this.isSolid = isSolid;
        return this;
    }

    public void init() {
        switch (blocktype) {
            case POKEMON_GRAS_1:
                block = Assets.getPokemon_gras_1();
                break;
            case NORMAL_GRAS_1:
                block = Assets.getNormal_gras_1();
                break;
            case POKE_CENTER_ROOF_TOP_LEFT:
                block = Assets.getPoke_center_roof_top_left();
                break;
            case POKE_CENTER_ROOF_TOP_MID:
                block = Assets.getPoke_center_roof_top_mid();
                break;
            case POKE_CENTER_ROOF_TOP_RIGHT:
                block = Assets.getPoke_center_roof_top_right();
                break;
            case POKE_CENTER_ROOF_LEFT_LEFT:
                block = Assets.getPoke_center_roof_left_left();
                break;
            case POKE_CENTER_ROOF_RIGHT_RIGHT:
                block = Assets.getPoke_center_roof_right_right();
                break;
            case POKE_CENTER_ROOF_MID_MID:
                block = Assets.getPoke_center_roof_mid_mid();
                break;
            case POKE_CENTER_ROOF_BOT_LEFT_1:
                block = Assets.getPoke_center_roof_bot_left_1();
                break;
            case POKE_CENTER_ROOF_BOT_LEFT_2:
                block = Assets.getPoke_center_roof_bot_left_2();
                break;
            case POKE_CENTER_ROOF_BOT_RIGHT_1:
                block = Assets.getPoke_center_roof_bot_right_1();
                break;
            case POKE_CENTER_ROOF_BOT_RIGHT_2:
                block = Assets.getPoke_center_roof_bot_right_2();
                break;
            case POKE_CENTER_ROOF_BOT_BOT_MID:
                block = Assets.getPoke_center_roof_bot_bot_mid();
                break;
            case POKE_CENTER_ROOF_BOT_BOT_RIGHT:
                block = Assets.getPoke_center_roof_bot_bot_right();
                break;
            case POKE_CENTER_ROOF_BOT_BOT_LEFT:
                block = Assets.getPoke_center_roof_bot_bot_left();
                break;
            case POKE_CENTER_ROOF_BOT_MID_1:
                block = Assets.getPoke_center_roof_bot_mid_1();
                break;
            case POKE_CENTER_ROOF_BOT_MID_2:
                block = Assets.getPoke_center_roof_bot_mid_2();
                break;
            case POKE_CENTER_FRONT_LEFT:
                block = Assets.getPoke_center_front_left();
                break;
            case POKE_CENTER_FRONT_RIGHT:
                block = Assets.getPoke_center_front_right();
                break;
            case POKE_CENTER_FRONT_MID_LEFT:
                block = Assets.getPoke_center_front_mid_left();
                break;
            case POKE_CENTER_FRONT_MID_RIGHT:
                block = Assets.getPoke_center_front_mid_right();
                break;
            case POKE_CENTER_FRONT_DOOR:
                block = Assets.getPoke_center_front_door();
                break;
            case ROAD_GRAS_BRIGHT_HZ_TOP:
                block = Assets.getRoad_gras_bright_hz_top();
                break;
            case POKE_CENTER:
                block = Assets.getPoke_center().get(pokeCenterIndex);
                pokeCenterIndex++;
                break;
            case POKE_CENTER_1:
                block = Assets.getPoke_center_1();
                break;
            case POKE_CENTER_2:
                block = Assets.getPoke_center_2();
                break;
            case POKE_CENTER_3:
                block = Assets.getPoke_center_3();
                break;
            case POKE_CENTER_4:
                block = Assets.getPoke_center_4();
                break;
            case POKE_CENTER_5:
                block = Assets.getPoke_center_5();
                break;
            case POKE_CENTER_6:
                block = Assets.getPoke_center_6();
                break;
            case POKE_CENTER_7:
                block = Assets.getPoke_center_7();
                break;
            case POKE_CENTER_8:
                block = Assets.getPoke_center_8();
                break;
            case POKE_CENTER_9:
                block = Assets.getPoke_center_9();
                break;
            case POKE_CENTER_10:
                block = Assets.getPoke_center_10();
                break;
            case POKE_CENTER_11:
                block = Assets.getPoke_center_11();
                break;
            case POKE_CENTER_12:
                block = Assets.getPoke_center_12();
                break;
            case POKE_CENTER_13:
                block = Assets.getPoke_center_13();
                break;
            case POKE_CENTER_14:
                block = Assets.getPoke_center_14();
                break;
            case POKE_CENTER_15:
                block = Assets.getPoke_center_15();
                break;
            case POKE_CENTER_16:
                block = Assets.getPoke_center_16();
                break;
            case POKE_CENTER_17:
                block = Assets.getPoke_center_17();
                break;
            case POKE_CENTER_18:
                block = Assets.getPoke_center_18();
                break;
            case POKE_CENTER_19:
                block = Assets.getPoke_center_19();
                break;
            case POKE_CENTER_20:
                block = Assets.getPoke_center_20();
                break;
            case POKE_CENTER_21:
                block = Assets.getPoke_center_21();
                break;
            case POKE_CENTER_22:
                block = Assets.getPoke_center_22();
                break;
            case POKE_CENTER_23:
                block = Assets.getPoke_center_23();
                break;
            case POKE_CENTER_24:
                block = Assets.getPoke_center_24();
                break;
            case POKE_CENTER_25:
                block = Assets.getPoke_center_25();
                break;
            case POKE_CENTER_26:
                block = Assets.getPoke_center_26();
                break;
            case POKE_CENTER_27:
                block = Assets.getPoke_center_27();
                break;
            case POKE_CENTER_28:
                block = Assets.getPoke_center_28();
                break;
            case POKE_CENTER_29:
                block = Assets.getPoke_center_29();
                break;
            case POKE_CENTER_30:
                block = Assets.getPoke_center_30();
                break;
            case POKE_CENTER_31:
                block = Assets.getPoke_center_31();
                break;
            case POKE_CENTER_32:
                block = Assets.getPoke_center_32();
                break;
            case POKE_CENTER_33:
                block = Assets.getPoke_center_33();
                break;
            case POKE_CENTER_34:
                block = Assets.getPoke_center_34();
                break;
            case POKE_CENTER_35:
                block = Assets.getPoke_center_35();
                break;
            case POKE_CENTER_36:
                block = Assets.getPoke_center_36();
                break;
            case POKE_CENTER_37:
                block = Assets.getPoke_center_37();
                break;
            case POKE_CENTER_38:
                block = Assets.getPoke_center_38();
                break;
            case POKE_CENTER_39:
                block = Assets.getPoke_center_39();
                break;
            case POKE_CENTER_40:
                block = Assets.getPoke_center_40();
                break;
            case POKE_CENTER_41:
                block = Assets.getPoke_center_41();
                break;
            case POKE_CENTER_42:
                block = Assets.getPoke_center_42();
                break;
            case POKE_CENTER_43:
                block = Assets.getPoke_center_43();
                break;
            case POKE_CENTER_44:
                block = Assets.getPoke_center_44();
                break;
            case POKE_CENTER_45:
                block = Assets.getPoke_center_45();
                break;
            case POKE_CENTER_46:
                block = Assets.getPoke_center_46();
                break;
            case POKE_CENTER_47:
                block = Assets.getPoke_center_47();
                break;
            case POKE_CENTER_48:
                block = Assets.getPoke_center_48();
                break;
            case POKE_CENTER_49:
                block = Assets.getPoke_center_49();
                break;
            case POKE_CENTER_50:
                block = Assets.getPoke_center_50();
                break;
            case POKE_CENTER_51:
                block = Assets.getPoke_center_51();
                break;
            case POKE_CENTER_52:
                block = Assets.getPoke_center_52();
                break;
            case POKE_CENTER_53:
                block = Assets.getPoke_center_53();
                break;
            case POKE_CENTER_54:
                block = Assets.getPoke_center_54();
                break;
            case POKE_CENTER_55:
                block = Assets.getPoke_center_55();
                break;
            case POKE_CENTER_56:
                block = Assets.getPoke_center_56();
                break;
            case POKE_CENTER_57:
                block = Assets.getPoke_center_57();
                break;
            case POKE_CENTER_58:
                block = Assets.getPoke_center_58();
                break;
            case POKE_CENTER_59:
                block = Assets.getPoke_center_59();
                break;
        }
    }

    public void render(Graphics2D g) {
        if (isAlive) {
            if (blocks != null) {
                for (BufferedImage img : blocks) {
                    g.drawImage(img, (int) pos.getWorldLocation().xPos, (int) pos.getWorldLocation().yPos, blockSize, blockSize, null);
                }
            } else if (block != null) {
                g.drawImage(block, (int) pos.getWorldLocation().xPos, (int) pos.getWorldLocation().yPos, blockSize, blockSize, null);
            } else {
                g.fillRect((int) pos.getWorldLocation().xPos, (int) pos.getWorldLocation().yPos, blockSize, blockSize);
            }

            //g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize);

            if (isSolid) {
                //g.drawRect((int)pos.getWorldLocation().xPos, (int)pos.getWorldLocation().yPos, blockSize, blockSize);
            }
        }
    }

    public void tick(double deltaTime) {
        if (isAlive) {
            setBounds((int) pos.xPos, (int) pos.yPos, blockSize, blockSize);
        }
    }

    public boolean isSolid() {
        return this.isSolid;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Vector2F getBlockLocation() {
        return pos;
    }


    public enum BlockType {

        //gras
        POKEMON_GRAS_1,
        NORMAL_GRAS_1,

        //poke_center
        POKE_CENTER_ROOF_TOP_LEFT,
        POKE_CENTER_ROOF_TOP_MID,
        POKE_CENTER_ROOF_TOP_RIGHT,
        POKE_CENTER_ROOF_LEFT_LEFT,
        POKE_CENTER_ROOF_RIGHT_RIGHT,
        POKE_CENTER_ROOF_MID_MID,
        POKE_CENTER_ROOF_BOT_LEFT_1,
        POKE_CENTER_ROOF_BOT_LEFT_2,
        POKE_CENTER_ROOF_BOT_RIGHT_1,
        POKE_CENTER_ROOF_BOT_RIGHT_2,
        POKE_CENTER_ROOF_BOT_BOT_MID,
        POKE_CENTER_ROOF_BOT_BOT_LEFT,
        POKE_CENTER_ROOF_BOT_BOT_RIGHT,
        POKE_CENTER_ROOF_BOT_MID_1,
        POKE_CENTER_ROOF_BOT_MID_2,
        POKE_CENTER_FRONT_LEFT,
        POKE_CENTER_FRONT_RIGHT,
        POKE_CENTER_FRONT_MID_RIGHT,
        POKE_CENTER_FRONT_MID_LEFT,
        POKE_CENTER_FRONT_DOOR,

        //poke_center_in_door
        POKE_CENTER,
        POKE_CENTER_1,
        POKE_CENTER_2,
        POKE_CENTER_3,
        POKE_CENTER_4,
        POKE_CENTER_5,
        POKE_CENTER_6,
        POKE_CENTER_7,
        POKE_CENTER_8,
        POKE_CENTER_9,
        POKE_CENTER_10,
        POKE_CENTER_11,
        POKE_CENTER_12,
        POKE_CENTER_13,
        POKE_CENTER_14,

        POKE_CENTER_15,
        POKE_CENTER_16,
        POKE_CENTER_17,
        POKE_CENTER_18,
        POKE_CENTER_19,
        POKE_CENTER_20,
        POKE_CENTER_21,
        POKE_CENTER_22,
        POKE_CENTER_23,
        POKE_CENTER_24,
        POKE_CENTER_25,
        POKE_CENTER_26,
        POKE_CENTER_27,
        POKE_CENTER_28,
        POKE_CENTER_29,

        POKE_CENTER_30,
        POKE_CENTER_31,
        POKE_CENTER_32,
        POKE_CENTER_33,
        POKE_CENTER_34,
        POKE_CENTER_35,
        POKE_CENTER_36,
        POKE_CENTER_37,
        POKE_CENTER_38,
        POKE_CENTER_39,
        POKE_CENTER_40,
        POKE_CENTER_41,
        POKE_CENTER_42,
        POKE_CENTER_43,
        POKE_CENTER_44,

        POKE_CENTER_45,
        POKE_CENTER_46,
        POKE_CENTER_47,
        POKE_CENTER_48,
        POKE_CENTER_49,
        POKE_CENTER_50,
        POKE_CENTER_51,
        POKE_CENTER_52,
        POKE_CENTER_53,
        POKE_CENTER_54,
        POKE_CENTER_55,
        POKE_CENTER_56,
        POKE_CENTER_57,
        POKE_CENTER_58,
        POKE_CENTER_59,

        //roads
        ROAD_GRAS_BRIGHT_HZ_TOP
    }
}
