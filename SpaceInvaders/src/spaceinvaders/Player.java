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

public class Player extends Item {

    private int direction;
    private Board board;
  
    public Player(int x, int y, int direction, int width, int height, Board board) {
        super(x, y, width, height);
        this.direction = direction;
        this.board = board;
    }

 
    public int getDirection() {
        return direction;
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void tick() {
        // moving player depending on flags
        if (board.getKeyManager().left) {
           setX(getX() - 2);
        }
        if (board.getKeyManager().right) {
           setX(getX() + 2);
        }
        // reset x position and y position if colision
        if (getX() + 60 >= board.getWidth()) {
            setX(board.getWidth() - 60);
        }
        else if (getX() <= -30) {
            setX(-30);
        }
        if (getY() + 80 >= board.getHeight()) {
            setY(board.getHeight() - 80);
        }
        else if (getY() <= -20) {
            setY(-20);
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
}
