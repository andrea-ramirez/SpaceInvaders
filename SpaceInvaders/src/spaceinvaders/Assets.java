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
    public static BufferedImage playerLeft[];       //pictures to go left
    public static BufferedImage playerRight[];      //pictures to go right
    public static BufferedImage playerStanding[];   //pictures to stay standing
    
    //animation de enemy
    public static BufferedImage spritesEnemy;       //to store the sprites of enemy
    public static BufferedImage enemyLights[];        //pictures for enemy to go left

    /**
     * initializing the images and sounds of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/resources/hospital.png");
        player = ImageLoader.loadImage("/resources/trump.png");
        enemy = ImageLoader.loadImage("/resources/corona.png");
        gameOver = ImageLoader.loadImage("/resources/seacabo.jpg");
        backSound = new SoundClip("/resources/back.wav");
        sneeze = new SoundClip("/resources/Gunshot.wav");
        ow = new SoundClip("/resources/preview.wav");
        defense = new SoundClip("/resources/bueno.wav");
        
        //getting the player sprites from the picture
        sprites = ImageLoader.loadImage("/resources/trump.png");
        //creating array of images before animations of player
        SpreadSheet spreadsheet = new SpreadSheet(sprites);
        playerStanding = new BufferedImage[6];
        playerRight = new BufferedImage[6];
        playerLeft = new BufferedImage[6];
        // croping the pictures from the sheet into the array
        for(int i = 0; i < 6; i++){
            playerStanding[i] = spreadsheet.crop(i*100,0,100,100);
            playerRight[i] = spreadsheet.crop(i*100,100,100,100);
            playerLeft[i] = spreadsheet.crop(i*100,200,100,100);
        }
        
        
        //getting the coronavirus sprites from the picture
        spritesEnemy = ImageLoader.loadImage("/resources/corona.png");
        //creating array of images before animations of enemy
        SpreadSheet sEnemy = new SpreadSheet(spritesEnemy);
        enemyLights = new BufferedImage[2];
        // croping the pictures from the sheet into the array
        enemyLights[0] = sEnemy.crop(0,0,256,256);
        enemyLights[1] = sEnemy.crop(256,256,256,256);
    }

}