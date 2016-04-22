package de.pokewhat.moveableobjects;

import de.pokewhat.gameloop.GameLoopGame;
import de.pokewhat.gamestate.LevelLoader;
import de.pokewhat.generator.World;
import de.pokewhat.gop.main.Vector2F;
import de.pokewhat.main.Animator;
import de.pokewhat.main.Assets;
import de.pokewhat.main.Check;
import de.pokewhat.main.Main;
import de.pokewhat.managers.GUImanager;
import de.pokewhat.managers.HUDmanager;
import de.pokewhat.managers.Mousemanager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by dwenders on 22.03.2016.
 */
public class Player implements KeyListener {

    Vector2F pos = new Vector2F();
    private World world;
    private int width = 16;
    private int height = 20;
    private int scale = 3;
    private int virtualWidth = 47;
    private int virtualHeight = 47;
    private static boolean up, down, left, right;
    private static boolean upLast, downLast = true, leftLast, rightLast, running;
    private float maxSpeed = 3 * 32F;
    private int movementSpeed = 2;

    private float speedUp = 0;
    private float speedDown = 0;
    private float speedLeft = 0;
    private float speedRight = 0;

    private float slowdown = 4.093F;

    private float fixDt = 1f / 60F;

    private Mousemanager playerMM = new Mousemanager();
    private static long animationSpeed = 100;

    static private boolean moving;
    private static boolean spwaned = true;


    private int renderDistanceW = 48;
    private int renderDistanceH = 48;
    public static Rectangle render;

    private int animationState = 4;

    private float currWordPosY = 0;
    private float currWordPosX = 0;

    /*
    0 = up
    1=down
    2=right
    3=left
    4=idel
    */

    private ArrayList<BufferedImage> listUp;
    Animator ani_up;
    private ArrayList<BufferedImage> listDown;
    Animator ani_down;
    private ArrayList<BufferedImage> listLeft;
    Animator ani_left;
    private ArrayList<BufferedImage> listRight;
    Animator ani_right;
    private ArrayList<BufferedImage> listIdel;
    //Animator ani_idel;

    private HUDmanager hudm;
    private GUImanager guim;

    private static boolean upReleased, downReleased, leftReleased, rightReleased;


    public Player() {
        pos = new Vector2F(Main.width / 2 - width / 2, Main.height / 2 - height / 2);
    }

    public void init(World world) {

        hudm = new HUDmanager(this);
        guim = new GUImanager();

        this.world = world;


        render = new Rectangle((int) pos.xPos, (int) pos.yPos, renderDistanceW * 32, renderDistanceH * 32);

        listUp = new ArrayList<BufferedImage>();
        listDown = new ArrayList<BufferedImage>();
        listLeft = new ArrayList<BufferedImage>();
        listRight = new ArrayList<BufferedImage>();
        listIdel = new ArrayList<BufferedImage>();

        listUp.add(Assets.player.getTile(111, 5, 13, 18));
        listUp.add(Assets.player.getTile(124, 5, 13, 18));

        listDown.add(Assets.player.getTile(27, 4, 13, 18));
        listDown.add(Assets.player.getTile(40, 4, 13, 18));

        listRight.add(Assets.player.getTile(137, 5, 13, 18));
        listRight.add(Assets.player.getTile(150, 5, 13, 18));
        listRight.add(Assets.player.getTile(164, 5, 13, 18));
        //listRight.add(Assets.player.getTile(30,5,14,20));

        listLeft.add(Assets.player.getTile(54, 5, 13, 18));
        listLeft.add(Assets.player.getTile(68, 5, 13, 18));
        listLeft.add(Assets.player.getTile(81, 5, 13, 18));
        //listLeft.add(Assets.player.getTile(30,5,14,20));

        listIdel.add(Assets.player.getTile(96, 4, 13, 18)); //up
        listIdel.add(Assets.player.getTile(13, 4, 13, 18)); //down
        listIdel.add(Assets.player.getTile(54, 4, 13, 18)); //left
        listIdel.add(Assets.player.getTile(137, 4, 13, 18)); //right

        ani_up = new Animator(listUp);
        ani_up.setSpeed(animationSpeed);
        ani_up.play();

        ani_down = new Animator(listDown);
        ani_down.setSpeed(animationSpeed);
        ani_down.play();

        ani_left = new Animator(listLeft);
        ani_left.setSpeed(animationSpeed);
        ani_left.play();

        ani_right = new Animator(listRight);
        ani_right.setSpeed(animationSpeed);
        ani_right.play();


    }

    public void render(Graphics2D g) {
        //g.fillRect((int) pos.xPos, (int) pos.yPos, width, height);

        if (animationState == 0) {
            g.drawImage(ani_up.sprite, (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            if (up) {
                ani_up.update(System.currentTimeMillis());
            }
        }

        if (animationState == 1) {
            g.drawImage(ani_down.sprite, (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            if (down) {
                ani_down.update(System.currentTimeMillis());
            }
        }

        if (animationState == 2) {
            g.drawImage(ani_right.sprite, (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            if (right) {
                ani_right.update(System.currentTimeMillis());
            }
        }

        if (animationState == 3) {
            g.drawImage(ani_left.sprite, (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            if (left) {
                ani_left.update(System.currentTimeMillis());
            }
        }

        if (animationState == 4) {
            if (upLast) {
                g.drawImage(listIdel.get(0), (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            } else if (downLast) {
                g.drawImage(listIdel.get(1), (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            } else if (leftLast) {
                g.drawImage(listIdel.get(2), (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            } else if (rightLast) {
                g.drawImage(listIdel.get(3), (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            } else {
                g.drawImage(listIdel.get(1), (int) pos.xPos, (int) pos.yPos-14, width * scale, height * scale, null);
            }

            //ani_idel.update(System.currentTimeMillis());
        }
        //g.fillRect((int) pos.xPos, (int) pos.yPos, width, height);
        //g.drawRect((int) pos.xPos - renderDistanceW * 32 / 2 + width / 2, (int) pos.yPos - renderDistanceH * 32 / 2 + height / 2, renderDistanceW * 32, renderDistanceH * 32);
        world.tiles.render3(g);
        hudm.render(g);
        guim.render(g);
        playerMM.render(g);
    }

    public void tick(double deltaTime) {

        playerMM.tick();
        world.tiles.tick3(deltaTime);

        render = new Rectangle(
                (int) (pos.xPos - pos.getWorldLocation().xPos + pos.xPos - renderDistanceW * 32 / 2 + width / 2),
                (int) (pos.yPos - pos.getWorldLocation().yPos + pos.yPos - renderDistanceH * 32 / 2 + height / 2),
                renderDistanceW * 32,
                renderDistanceH * 32);

        float moveAmountU = (float) (speedUp * fixDt);
        float moveAmountD = (float) (speedDown * fixDt);
        float moveAmountL = (float) (speedLeft * fixDt);
        float moveAmountR = (float) (speedRight * fixDt);

        if (up) {
            if(world.map_pos.yPos+pos.yPos == currWordPosY-48) {
                currWordPosY -= 48;
                if(upReleased) {
                    up = false;
                    upReleased = false;
                }
            }
            else {
                animationState = 0;
                moveMapUp(moveAmountU);
            }
        }

        if (down) {
            if(world.map_pos.yPos+pos.yPos == currWordPosY+48) {
                currWordPosY += 48;
                if(downReleased) {
                    down = false;
                    downReleased = false;
                }
            } else {
                moveMapDown(moveAmountD);
                animationState = 1;
            }
        }

        if (left) {
            if(world.map_pos.xPos+pos.xPos == currWordPosX-48) {
                currWordPosX -= 48;
                if(leftReleased) {
                    left = false;
                    leftReleased = false;
                }
            }
            else {
                moveMapLeft(moveAmountL);
                animationState = 3;
            }
        }

        if (right) {
            if(world.map_pos.xPos+pos.xPos == currWordPosX+48) {
                currWordPosX += 48;
                if(rightReleased) {
                    right = false;
                    rightReleased = false;
                }
            }else {
                moveMapRight(moveAmountR);
                animationState = 2;
            }
        }

        if (!up && !down && !right && !left) {
            animationState = 4;
            if (moving) {
                moving = false;
            }
            moving = false;
        }
        if (running) {
            if (animationSpeed != 100) {
                animationSpeed = 100;
                ani_up.setSpeed(animationSpeed);
                ani_down.setSpeed(animationSpeed);
                ani_left.setSpeed(animationSpeed);
                ani_right.setSpeed(animationSpeed);
                maxSpeed += 16;
            }
        } else {
            if (animationSpeed != 180) {
                animationSpeed = 180;
                ani_up.setSpeed(animationSpeed);
                ani_down.setSpeed(animationSpeed);
                ani_left.setSpeed(animationSpeed);
                ani_right.setSpeed(animationSpeed);
                maxSpeed -= 16;
            }
        }


    }

    public void moveMapUp(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xPos + world.map_pos.xPos),
                        (int) (pos.yPos + world.map_pos.yPos - movementSpeed)),
                new Point((int) (pos.xPos + world.map_pos.xPos + virtualWidth),
                        (int) (pos.yPos + world.map_pos.yPos - movementSpeed)))) {

            if (speedUp < maxSpeed) {
                speedUp += slowdown;
            } else {
                speedUp = maxSpeed;
            }
            world.map_pos.yPos -= movementSpeed;
        } else {
            speedUp = 0;
            up = false;
        }
    }

    public void moveMapDown(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xPos + world.map_pos.xPos),
                        (int) (pos.yPos + world.map_pos.yPos + virtualHeight + movementSpeed)),
                new Point((int) (pos.xPos + world.map_pos.xPos + virtualWidth),
                        (int) (pos.yPos + world.map_pos.yPos + virtualHeight + movementSpeed)))) {

            if (speedDown < maxSpeed) {
                speedDown += slowdown;
            } else {
                speedDown = maxSpeed;
            }
            world.map_pos.yPos += movementSpeed;

        } else {
            speedDown = 0;
            down = false;
        }
    }

    public void moveMapLeft(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xPos + world.map_pos.xPos - movementSpeed),
                        (int) (pos.yPos + world.map_pos.yPos + height)),
                new Point((int) (pos.xPos + world.map_pos.xPos - movementSpeed),
                        (int) (pos.yPos + world.map_pos.yPos)))) {

            if (speedLeft < maxSpeed) {
                speedLeft += slowdown;
            } else {
                speedLeft = maxSpeed;
            }
            world.map_pos.xPos -= movementSpeed;

        } else {
            speedLeft = 0;
            left = false;
        }
    }

    public void moveMapRight(float speed) {
        if (!Check.CollisionPlayerBlock(
                new Point((int) (pos.xPos + world.map_pos.xPos + virtualWidth + movementSpeed),
                        (int) (pos.yPos + world.map_pos.yPos)),
                new Point((int) (pos.xPos + world.map_pos.xPos + virtualWidth + movementSpeed),
                        (int) (pos.yPos + world.map_pos.yPos + virtualHeight)))) {

            if (speedRight < maxSpeed) {
                speedRight += slowdown;
            } else {
                speedRight = maxSpeed;
            }
            world.map_pos.xPos += movementSpeed;

        } else {
            speedRight = 0;
            right = false;
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        if (key == KeyEvent.VK_W) {
            if (!moving) {
                moving = true;
            }
            if(!up) {
                currWordPosY = world.map_pos.yPos;
            }
            if(!down&&!left&&!right) {
                up = true;
            }

            upLast = true;
            downLast = false;
            leftLast = false;
            rightLast = false;
        }

        if (key == KeyEvent.VK_S) {
            if (!moving) {
                moving = true;
            }
            if(!down) {
                currWordPosY = world.map_pos.yPos;
            }
            if(!up && !left && !right) {
                down = true;
            }

            upLast = false;
            downLast = true;
            leftLast = false;
            rightLast = false;
        }
        if (key == KeyEvent.VK_A) {
            if (!moving) {
                moving = true;
            }
            if(!left) {
                currWordPosX = world.map_pos.xPos;
            }
            if(!right&&!up&&!down) {
                left = true;
            }

            upLast = false;
            downLast = false;
            leftLast = true;
            rightLast = false;
        }
        if (key == KeyEvent.VK_D) {
            if (!moving) {
                moving = true;
            }
            if(!right) {
                currWordPosX = world.map_pos.xPos;
            }
            if(!left&&!up&&!down) {
                right = true;
            }

            upLast = false;
            downLast = false;
            leftLast = false;
            rightLast = true;
        }
        if (key == KeyEvent.VK_SHIFT) {
            running = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            upReleased = true;
        }
        if (key == KeyEvent.VK_S) {
            downReleased = true;
        }
        if (key == KeyEvent.VK_A) {
            leftReleased = true;
        }
        if (key == KeyEvent.VK_D) {
            rightReleased = true;
        }
        if (key == KeyEvent.VK_P) {
            LevelLoader.world.changeToWorld("word", "pokecenter_map");
            //world.changeToWorld("world","map2");
        }
        if (key == KeyEvent.VK_SHIFT) {
            running = false;
        }
    }

    ////////////////////


    public Vector2F getPos() {
        return pos;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getSlowdown() {
        return slowdown;
    }

    public boolean isMoving() {
        return moving;
    }

    public boolean hasSpwaned() {
        return spwaned;
    }

}
