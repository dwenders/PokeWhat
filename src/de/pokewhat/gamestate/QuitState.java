package de.pokewhat.gamestate;

import de.pokewhat.main.Main;
import de.pokewhat.managers.Mousemanager;

import java.awt.*;

/**
 * Created by Danny on 28.03.2016.
 */
public class QuitState extends GameState {

    GameStateButton yes;
    GameStateButton no;
    Mousemanager mm;

    public QuitState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void tick(double deltaTime) {
        mm.tick();
        yes.tick();
        no.tick();

        if(yes.isHeldOver()){
            if(yes.isPressed()){
                System.exit(1);
            }
        }

        if(no.isHeldOver()){
            if(no.isPressed()){
                gsm.states.push(new MenuState(gsm));
                gsm.states.peek().init();;
            }
        }

    }

    @Override
    public void render(Graphics2D g) {
        yes.render(g);
        no.render(g);
        mm.render(g);
        g.clipRect(0,0, Main.width,Main.height);

    }

    @Override
    public void init() {
        mm = new Mousemanager();
        yes = new GameStateButton(Main.width / 3, 100, "Yes");
        no = new GameStateButton(Main.width / 3 + 200, 100, "No");
    }

}
