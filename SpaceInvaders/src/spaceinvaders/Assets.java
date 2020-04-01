/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders;

import java.awt.image.BufferedImage;
/**
 *
 * @author Diego Garza y Andrea Ramírez
 */
public class Assets {

    public static BufferedImage background; // to store background image
    public static BufferedImage player;     // to store the player image
    public static BufferedImage enemy;   //to store the enemy image
    public static BufferedImage gameOver;
    public static SoundClip backSound;
    public static SoundClip sneeze;
    public static SoundClip ow;
    public static SoundClip defense;
    
    
    //animation del player
    public static BufferedImage sprites;        //to store the sprites
    public static BufferedImage playerUp[];     //pictures to go up
    public static BufferedImage playerLeft[];       //pictures to go left
    public static BufferedImage playerDown[];       //pictures to go down
    public static BufferedImage playerRight[];      //pictures to go right
    public static BufferedImage playerStanding[];   //pictures to stay standing
    
    //animation de los buenos
    public static BufferedImage spritesBuenos;      //to store sprites of Buenos
    public static BufferedImage buenosRight[];      //pictures for buenos to go right
    
    //animation de enemy
    public static BufferedImage spritesEnemy;       //to store the sprites of enemy
    public static BufferedImage enemyLeft[];        //pictures for enemy to go left

    /**
     * initializing the images and sounds of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/resources/hospital.png");
        player = ImageLoader.loadImage("/resources/skull.png");
        enemy = ImageLoader.loadImage("/resources/alien.png");
        gameOver = ImageLoader.loadImage("/resources/seacabo.jpg");
        backSound = new SoundClip("/resources/back.wav");
        sneeze = new SoundClip("/resources/Gunshot.wav");
        ow = new SoundClip("/resources/preview.wav");
        defense = new SoundClip("/resources/bueno.wav");
        
        //getting the sprites from the picture
        sprites = ImageLoader.loadImage("/resources/skull.png");
        //creating array of images before animations of player
        SpreadSheet spreadsheet = new SpreadSheet(sprites);
        playerUp = new BufferedImage[9];
        playerLeft = new BufferedImage[9];
        playerDown = new BufferedImage[9];
        playerRight = new BufferedImage[9];
        playerStanding = new BufferedImage[4];
        // croping the pictures from the sheet into the array
        for(int i = 0; i < 9; i++){
            playerUp[i] = spreadsheet.crop(i*64,0,64,64);
            playerLeft[i] = spreadsheet.crop(i*64,64,64,64);
            playerDown[i] = spreadsheet.crop(i*64,128,64,64);
            playerRight[i] = spreadsheet.crop(i*64,192,64,64);
        }
        playerStanding[0] = playerDown[2];
        playerStanding[1] = playerDown[3];
        playerStanding[2] = playerDown[6];
        playerStanding[3] = playerDown[7];
        
        
        //getting the sprites from the picture
        spritesEnemy = ImageLoader.loadImage("/resources/alien.png");
        //creating array of images before animations of enemy
        SpreadSheet sEnemy = new SpreadSheet(spritesEnemy);
        enemyLeft = new BufferedImage[11];
        // croping the pictures from the sheet into the array
        for(int i = 0; i < 11; i++){
            enemyLeft[i] = sEnemy.crop(i*2626/11,1435-(2626/11),2626/11,2626/11);
        }
    }

}