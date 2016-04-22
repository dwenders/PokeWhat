package de.pokewhat.gamestate;

import java.awt.*;

/**
 * Created by dwenders on 22.03.2016.
 */
public abstract class GameState {

    public GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void tick(double deltaTime);
    public abstract void render(Graphics2D g);
    public abstract void init();

}
