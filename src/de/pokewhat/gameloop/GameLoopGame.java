package de.pokewhat.gameloop;

import de.pokewhat.gamestate.GameStateManager;
import de.pokewhat.gop.main.GameLoop;
import de.pokewhat.gop.main.Vector2F;
import de.pokewhat.main.Assets;

/**
 * Created by dwenders on 22.03.2016.
 */
public class GameLoopGame extends GameLoop {

    GameStateManager gsm;
    public static Assets assets = new Assets();

    public GameLoopGame(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        assets.init();
        gsm = new GameStateManager();
        gsm.init();
        super.init();
    }

    @Override
    public void render() {
        super.render();
        gsm.render(graphics2D);
        clear();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void tick(double deltaTime) {
        gsm.tick(deltaTime);
    }
}
