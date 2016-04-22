package de.pokewhat.main;

import de.pokewhat.gop.main.SpriteSheet;
import de.pokewhat.gop.main.loadImageFrom;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.BatchUpdateException;
import java.util.ArrayList;

/**
 * Created by dwenders on 22.03.2016.
 */
public class Assets {

    //SpriteSheets
    public static SpriteSheet blocks = new SpriteSheet();
    public static SpriteSheet player = new SpriteSheet();
    public static SpriteSheet mouse = new SpriteSheet();
    public static SpriteSheet center = new SpriteSheet();

    //Mouse
    public static BufferedImage mouse_pressed;
    public static BufferedImage mouse_unpressed;

    //Button
    private static BufferedImage button_heldover;
    private static BufferedImage button_notover;

    //World Blocks
    public static BufferedImage pokemon_gras_1;
    public static BufferedImage normal_gras_1;

    //PokeCenter
    public static BufferedImage poke_center_roof_top_left;
    public static BufferedImage poke_center_roof_top_mid;
    public static BufferedImage poke_center_roof_top_right;
    public static BufferedImage poke_center_roof_left_left;
    public static BufferedImage poke_center_roof_right_right;
    public static BufferedImage poke_center_roof_mid_mid;
    public static BufferedImage poke_center_roof_bot_left_1;
    public static BufferedImage poke_center_roof_bot_left_2;
    public static BufferedImage poke_center_roof_bot_right_1;
    public static BufferedImage poke_center_roof_bot_right_2;
    public static BufferedImage poke_center_roof_bot_bot_mid;
    public static BufferedImage poke_center_roof_bot_bot_left;
    public static BufferedImage poke_center_roof_bot_bot_right;
    public static BufferedImage poke_center_roof_bot_mid_1;
    public static BufferedImage poke_center_roof_bot_mid_2;
    public static BufferedImage poke_center_front_left;
    public static BufferedImage poke_center_front_right;
    public static BufferedImage poke_center_front_mid_left;
    public static BufferedImage poke_center_front_mid_right;
    public static BufferedImage poke_center_front_door;
    public static BufferedImage road_gras_bright_hz_top;

    //PokeCenterInDoor
    //Row1
    public static ArrayList<BufferedImage> poke_center;
    public static BufferedImage poke_center_1;
    public static BufferedImage poke_center_2;
    public static BufferedImage poke_center_3;
    public static BufferedImage poke_center_4;
    public static BufferedImage poke_center_5;
    public static BufferedImage poke_center_6;
    public static BufferedImage poke_center_7;
    public static BufferedImage poke_center_8;
    public static BufferedImage poke_center_9;
    public static BufferedImage poke_center_10;
    public static BufferedImage poke_center_11;
    public static BufferedImage poke_center_12;
    public static BufferedImage poke_center_13;
    public static BufferedImage poke_center_14;

    //Row2
    public static BufferedImage poke_center_15;
    public static BufferedImage poke_center_16;
    public static BufferedImage poke_center_17;
    public static BufferedImage poke_center_18;
    public static BufferedImage poke_center_19;
    public static BufferedImage poke_center_20;
    public static BufferedImage poke_center_21;
    public static BufferedImage poke_center_22;
    public static BufferedImage poke_center_23;
    public static BufferedImage poke_center_24;
    public static BufferedImage poke_center_25;
    public static BufferedImage poke_center_26;
    public static BufferedImage poke_center_27;
    public static BufferedImage poke_center_28;
    public static BufferedImage poke_center_29;

    //Row3
    public static BufferedImage poke_center_30;
    public static BufferedImage poke_center_31;
    public static BufferedImage poke_center_32;
    public static BufferedImage poke_center_33;
    public static BufferedImage poke_center_34;
    public static BufferedImage poke_center_35;
    public static BufferedImage poke_center_36;
    public static BufferedImage poke_center_37;
    public static BufferedImage poke_center_38;
    public static BufferedImage poke_center_39;
    public static BufferedImage poke_center_40;
    public static BufferedImage poke_center_41;
    public static BufferedImage poke_center_42;
    public static BufferedImage poke_center_43;
    public static BufferedImage poke_center_44;

    //Row4
    public static BufferedImage poke_center_45;
    public static BufferedImage poke_center_46;
    public static BufferedImage poke_center_47;
    public static BufferedImage poke_center_48;
    public static BufferedImage poke_center_49;
    public static BufferedImage poke_center_50;
    public static BufferedImage poke_center_51;
    public static BufferedImage poke_center_52;
    public static BufferedImage poke_center_53;
    public static BufferedImage poke_center_54;
    public static BufferedImage poke_center_55;
    public static BufferedImage poke_center_56;
    public static BufferedImage poke_center_57;
    public static BufferedImage poke_center_58;
    public static BufferedImage poke_center_59;


    public void init() {
        //Source
        blocks.setSpriteSheet(loadImageFrom.loadImageFrom(Main.class, "img/pokemonWorldSprite.png"));
        player.setSpriteSheet(loadImageFrom.loadImageFrom(Main.class, "img/playerSpritesheet.png"));
        mouse.setSpriteSheet(loadImageFrom.loadImageFrom(Main.class, "img/mouseSpriteSheet.png"));
        center.setSpriteSheet(loadImageFrom.loadImageFrom(Main.class, "img/pokeCenter.png"));

        poke_center = new ArrayList();

        //PokeCenterInDoor
        int a = 5;
        for(int i=5;a<=159;){
            poke_center.add(center.getTile(i,a,16,16));
            i+=16;
            if(i>=229+16){
                i=5;
                a+=16;
            }
        }

        //poke_center_0 = center.getTile(6, 6, 16, 16);
        poke_center_1 = center.getTile(22, 6, 16, 16);
        poke_center_2 = center.getTile(38, 6, 16, 16);
        poke_center_3 = center.getTile(54, 6, 16, 16);
        poke_center_4 = center.getTile(70, 6, 16, 16);
        poke_center_5 = center.getTile(86, 6, 16, 16);
        poke_center_6 = center.getTile(102, 6, 16, 16);
        poke_center_7 = center.getTile(118, 6, 16, 16);
        poke_center_8 = center.getTile(134, 6, 16, 16);
        poke_center_9 = center.getTile(150, 6, 16, 16);
        poke_center_10 = center.getTile(166, 6, 16, 16);
        poke_center_11 = center.getTile(182, 6, 16, 16);
        poke_center_12 = center.getTile(198, 6, 16, 16);
        poke_center_13 = center.getTile(214, 6, 16, 16);
        poke_center_14 = center.getTile(230, 6, 16, 16);

        //Row 2
        poke_center_15 = center.getTile(6, 22, 16, 16);
        poke_center_16 = center.getTile(22, 22, 16, 16);
        poke_center_17 = center.getTile(38, 22, 16, 16);
        poke_center_18 = center.getTile(54, 22, 16, 16);
        poke_center_19 = center.getTile(70, 22, 16, 16);
        poke_center_20 = center.getTile(86, 22, 16, 16);
        poke_center_21 = center.getTile(102,22, 16, 16);
        poke_center_22 = center.getTile(118, 22, 16, 16);
        poke_center_23 = center.getTile(134, 22, 16, 16);
        poke_center_24 = center.getTile(150, 22, 16, 16);
        poke_center_25 = center.getTile(166, 22, 16, 16);
        poke_center_26 = center.getTile(182, 22, 16, 16);
        poke_center_27 = center.getTile(198, 22, 16, 16);
        poke_center_28 = center.getTile(214, 22, 16, 16);
        poke_center_29 = center.getTile(230, 22, 16, 16);

        //Row 3
        poke_center_30 = center.getTile(6, 38, 16, 16);
        poke_center_31 = center.getTile(22, 38, 16, 16);
        poke_center_32 = center.getTile(38, 38, 16, 16);
        poke_center_33 = center.getTile(54, 38, 16, 16);
        poke_center_34 = center.getTile(70, 38, 16, 16);
        poke_center_35 = center.getTile(86, 38, 16, 16);
        poke_center_36 = center.getTile(102, 38, 16, 16);
        poke_center_37 = center.getTile(118, 38, 16, 16);
        poke_center_38 = center.getTile(134, 38, 16, 16);
        poke_center_39 = center.getTile(150, 38, 16, 16);
        poke_center_40 = center.getTile(166, 38, 16, 16);
        poke_center_41 = center.getTile(182, 38, 16, 16);
        poke_center_42 = center.getTile(198, 38, 16, 16);
        poke_center_43 = center.getTile(214, 38, 16, 16);
        poke_center_44 = center.getTile(230, 38, 16, 16);

        //Row 4
        poke_center_45 = center.getTile(6, 54, 16, 16);
        poke_center_46 = center.getTile(22, 54, 16, 16);
        poke_center_47 = center.getTile(38, 54, 16, 16);
        poke_center_48 = center.getTile(54, 54, 16, 16);
        poke_center_49 = center.getTile(70, 54, 16, 16);
        poke_center_50 = center.getTile(86, 54, 16, 16);
        poke_center_51 = center.getTile(102,54, 16, 16);
        poke_center_52 = center.getTile(118, 54, 16, 16);
        poke_center_53 = center.getTile(134, 54, 16, 16);
        poke_center_54 = center.getTile(150, 54, 16, 16);
        poke_center_55 = center.getTile(166, 54, 16, 16);
        poke_center_56 = center.getTile(182, 54, 16, 16);
        poke_center_57 = center.getTile(198, 54, 16, 16);
        poke_center_58 = center.getTile(214, 54, 16, 16);
        poke_center_59 = center.getTile(230, 54, 16, 16);

        button_heldover = mouse.getTile(131, 405, 23, 29);
        button_notover = mouse.getTile(133, 10, 22, 22);

        //Mouse
        mouse_unpressed = mouse.getTile(133, 10, 22, 22);
        mouse_pressed = mouse.getTile(131, 405, 23, 29);

        //World - outside
        road_gras_bright_hz_top = blocks.getTile(765, 85, 16, 16);

        pokemon_gras_1 = blocks.getTile(595, 34, 16, 16);
        normal_gras_1 = blocks.getTile(578, 34, 16, 16);

        //PokeCenter
        poke_center_roof_top_left = blocks.getTile(0, 68, 16, 16);
        poke_center_roof_top_mid = blocks.getTile(17, 68, 16, 16);
        poke_center_roof_top_right = blocks.getTile(68, 68, 16, 16);

        poke_center_roof_left_left = blocks.getTile(0, 85, 16, 16);
        poke_center_roof_right_right = blocks.getTile(68, 85, 16, 16);
        poke_center_roof_mid_mid = blocks.getTile(17, 85, 16, 16);

        poke_center_roof_bot_left_1 = blocks.getTile(0, 102, 16, 16);
        poke_center_roof_bot_left_2 = blocks.getTile(0, 119, 16, 16);

        poke_center_roof_bot_right_1 = blocks.getTile(68, 102, 16, 16);
        poke_center_roof_bot_right_2 = blocks.getTile(68, 119, 16, 16);

        poke_center_roof_bot_bot_mid = blocks.getTile(17, 102, 16, 16);
        poke_center_roof_bot_bot_left = blocks.getTile(17, 119, 16, 16);
        poke_center_roof_bot_bot_right = blocks.getTile(51, 119, 16, 16);

        poke_center_roof_bot_mid_1 = blocks.getTile(34, 102, 16, 16);
        poke_center_roof_bot_mid_2 = blocks.getTile(34, 119, 16, 16);

        poke_center_front_left = blocks.getTile(0, 136, 16, 16);
        poke_center_front_right = blocks.getTile(68, 136, 16, 16);
        poke_center_front_mid_left = blocks.getTile(17, 136, 16, 16);
        poke_center_front_mid_right = blocks.getTile(51, 136, 16, 16);
        poke_center_front_door = blocks.getTile(34, 136, 16, 16);
    }

    public static BufferedImage getPokemon_gras_1() {
        return pokemon_gras_1;
    }

    public static BufferedImage getNormal_gras_1() {
        return normal_gras_1;
    }

    public static BufferedImage getPoke_center_front_door() {
        return poke_center_front_door;
    }

    public static BufferedImage getPoke_center_roof_bot_left_1() {
        return poke_center_roof_bot_left_1;
    }

    public static BufferedImage getPoke_center_roof_bot_left_2() {
        return poke_center_roof_bot_left_2;
    }

    public static BufferedImage getPoke_center_roof_bot_mid_1() {
        return poke_center_roof_bot_mid_1;
    }

    public static BufferedImage getPoke_center_roof_bot_mid_2() {
        return poke_center_roof_bot_mid_2;
    }

    public static BufferedImage getPoke_center_roof_bot_right_1() {
        return poke_center_roof_bot_right_1;
    }

    public static BufferedImage getPoke_center_roof_bot_right_2() {
        return poke_center_roof_bot_right_2;
    }

    public static BufferedImage getPoke_center_front_left() {
        return poke_center_front_left;
    }

    public static BufferedImage getPoke_center_front_right() {
        return poke_center_front_right;
    }

    public static BufferedImage getPoke_center_roof_left_left() {
        return poke_center_roof_left_left;
    }

    public static BufferedImage getPoke_center_roof_mid_mid() {
        return poke_center_roof_mid_mid;
    }

    public static BufferedImage getPoke_center_roof_right_right() {
        return poke_center_roof_right_right;
    }

    public static BufferedImage getPoke_center_roof_top_left() {
        return poke_center_roof_top_left;
    }

    public static BufferedImage getPoke_center_roof_top_mid() {
        return poke_center_roof_top_mid;
    }

    public static BufferedImage getPoke_center_roof_top_right() {
        return poke_center_roof_top_right;
    }

    public static BufferedImage getPoke_center_front_mid_left() {
        return poke_center_front_mid_left;
    }

    public static BufferedImage getPoke_center_roof_bot_bot_mid() {
        return poke_center_roof_bot_bot_mid;
    }

    public static BufferedImage getPoke_center_roof_bot_bot_left() {
        return poke_center_roof_bot_bot_left;
    }

    public static BufferedImage getPoke_center_front_mid_right() {
        return poke_center_front_mid_right;
    }

    public static BufferedImage getPoke_center_roof_bot_bot_right() {
        return poke_center_roof_bot_bot_right;
    }

    public static BufferedImage getMouse_unpressed() {
        return mouse_unpressed;
    }

    public static BufferedImage getMouse_pressed() {
        return mouse_pressed;
    }

    public static BufferedImage getButton_heldover() {
        return button_heldover;
    }

    public static BufferedImage getButton_notover() {
        return button_notover;
    }

    public static BufferedImage getRoad_gras_bright_hz_top() {
        return road_gras_bright_hz_top;
    }

    public static ArrayList<BufferedImage> getPoke_center() {
        return poke_center;
    }

    public static BufferedImage getPoke_center_1() {
        return poke_center_1;
    }

    public static BufferedImage getPoke_center_2() {
        return poke_center_2;
    }

    public static BufferedImage getPoke_center_4() {
        return poke_center_4;
    }

    public static BufferedImage getPoke_center_3() {
        return poke_center_3;
    }

    public static BufferedImage getPoke_center_5() {
        return poke_center_5;
    }

    public static BufferedImage getPoke_center_6() {
        return poke_center_6;
    }

    public static BufferedImage getPoke_center_7() {
        return poke_center_7;
    }

    public static BufferedImage getPoke_center_8() {
        return poke_center_8;
    }

    public static BufferedImage getPoke_center_9() {
        return poke_center_9;
    }

    public static BufferedImage getPoke_center_10() {
        return poke_center_10;
    }

    public static BufferedImage getPoke_center_11() {
        return poke_center_11;
    }

    public static BufferedImage getPoke_center_12() {
        return poke_center_12;
    }

    public static BufferedImage getPoke_center_13() {
        return poke_center_13;
    }

    public static BufferedImage getPoke_center_14() {
        return poke_center_14;
    }

    public static BufferedImage getPoke_center_16() {
        return poke_center_16;
    }

    public static BufferedImage getPoke_center_17() {
        return poke_center_17;
    }

    public static BufferedImage getPoke_center_18() {
        return poke_center_18;
    }

    public static BufferedImage getPoke_center_19() {
        return poke_center_19;
    }

    public static BufferedImage getPoke_center_20() {
        return poke_center_20;
    }

    public static BufferedImage getPoke_center_21() {
        return poke_center_21;
    }

    public static BufferedImage getPoke_center_22() {
        return poke_center_22;
    }

    public static BufferedImage getPoke_center_23() {
        return poke_center_23;
    }

    public static BufferedImage getPoke_center_24() {
        return poke_center_24;
    }

    public static BufferedImage getPoke_center_25() {
        return poke_center_25;
    }

    public static BufferedImage getPoke_center_26() {
        return poke_center_26;
    }

    public static BufferedImage getPoke_center_27() {
        return poke_center_27;
    }

    public static BufferedImage getPoke_center_28() {
        return poke_center_28;
    }

    public static BufferedImage getPoke_center_29() {
        return poke_center_29;
    }

    public static BufferedImage getPoke_center_15() {

        return poke_center_15;
    }

    public static BufferedImage getPoke_center_30() {
        return poke_center_30;
    }

    public static BufferedImage getPoke_center_31() {
        return poke_center_31;
    }

    public static BufferedImage getPoke_center_32() {
        return poke_center_32;
    }

    public static BufferedImage getPoke_center_33() {
        return poke_center_33;
    }

    public static BufferedImage getPoke_center_34() {
        return poke_center_34;
    }

    public static BufferedImage getPoke_center_35() {
        return poke_center_35;
    }

    public static BufferedImage getPoke_center_36() {
        return poke_center_36;
    }

    public static BufferedImage getPoke_center_37() {
        return poke_center_37;
    }

    public static BufferedImage getPoke_center_38() {
        return poke_center_38;
    }

    public static BufferedImage getPoke_center_39() {
        return poke_center_39;
    }

    public static BufferedImage getPoke_center_40() {
        return poke_center_40;
    }

    public static BufferedImage getPoke_center_41() {
        return poke_center_41;
    }

    public static BufferedImage getPoke_center_42() {
        return poke_center_42;
    }

    public static BufferedImage getPoke_center_43() {
        return poke_center_43;
    }

    public static BufferedImage getPoke_center_44() {
        return poke_center_44;
    }

    public static BufferedImage getPoke_center_45() {
        return poke_center_45;
    }

    public static BufferedImage getPoke_center_46() {
        return poke_center_46;
    }

    public static BufferedImage getPoke_center_47() {
        return poke_center_47;
    }

    public static BufferedImage getPoke_center_48() {
        return poke_center_48;
    }

    public static BufferedImage getPoke_center_49() {
        return poke_center_49;
    }

    public static BufferedImage getPoke_center_50() {
        return poke_center_50;
    }

    public static BufferedImage getPoke_center_51() {
        return poke_center_51;
    }

    public static BufferedImage getPoke_center_52() {
        return poke_center_52;
    }

    public static BufferedImage getPoke_center_53() {
        return poke_center_53;
    }

    public static BufferedImage getPoke_center_54() {
        return poke_center_54;
    }

    public static BufferedImage getPoke_center_55() {
        return poke_center_55;
    }

    public static BufferedImage getPoke_center_56() {
        return poke_center_56;
    }

    public static BufferedImage getPoke_center_57() {
        return poke_center_57;
    }

    public static BufferedImage getPoke_center_58() {
        return poke_center_58;
    }

    public static BufferedImage getPoke_center_59() {
        return poke_center_59;
    }
}
