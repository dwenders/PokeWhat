package de.pokewhat.gamestate;

import de.pokewhat.main.Main;
import de.pokewhat.managers.Mousemanager;

import java.awt.*;

/**
 * Created by dwenders on 22.03.2016.
 */
public class MenuState extends GameState {

    GameStateButton startGame;
    GameStateButton multiplayer;
    GameStateButton options;
    GameStateButton quit;
    Mousemanager mm;

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void tick(double deltaTime) {
        mm.tick();
        startGame.tick();
        multiplayer.tick();
        options.tick();
        quit.tick();
    }

    @Override
    public void render(Graphics2D g) {
        startGame.render(g);
        multiplayer.render(g);
        options.render(g);
        quit.render(g);

        mm.render(g);
        g.clipRect(0, 0, Main.width, Main.height);
    }

    @Override
    public void init() {
        mm = new Mousemanager();
        startGame = new GameStateButton(Main.width / 10, 100, new LevelLoader(gsm), gsm, "StartGame");
        multiplayer = new GameStateButton(Main.width / 10, 200, new LevelLoader(gsm), gsm, "Multiplayer");
        options = new GameStateButton(Main.width / 10, 300, new LevelLoader(gsm), gsm, "Options");
        quit = new GameStateButton(Main.width / 10, 400, new QuitState(gsm), gsm, "Quit");
    }
}
