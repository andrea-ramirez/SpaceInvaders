package spaceinvaders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antoniomejorado
 */
import java.awt.Graphics;


public class Alien extends Item {

    private Bomb bomb;

    public Alien(int x, int y, int width, int height, Board board) {
        super(x,y,width,height);
        this.board = board;
        initAlien(x, y);
    }

    private void initAlien(int x, int y) {

        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);

        

        setImage(loadImage("/resources/alien.png"));
    }



    public void act(int direction) {

        this.x += direction;
    }

    public Bomb getBomb() {

        return bomb;
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
    
    public class Bomb extends Sprite {

        private boolean destroyed;

        public Bomb(int x, int y) {

            initBomb(x, y);
        }

        private void initBomb(int x, int y) {

            setDestroyed(true);

            this.x = x;
            this.y = y;

            setImage(loadImage("/resources/bomb.png"));
        }

        public void setDestroyed(boolean destroyed) {

            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {

            return destroyed;
        }
    }
}
