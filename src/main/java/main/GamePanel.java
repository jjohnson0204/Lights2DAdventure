package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class GamePanel extends JPanel implements Runnable {
    public boolean fullScreenOn;
    //FPS
    int FPS = 90;

    Thread gameThread;

    // Tiling
    final int originalTileSize = 32; // 32x32 tile
    final int scale = 2;
    public int tileSize = originalTileSize * scale; // 64x64 tile
    public int maxScreenCol = 20;
    public int maxScreenRow = 12;

    // Screen
    public int screenWidth = tileSize * maxScreenCol; // 1024
    public int screenHeight = tileSize * maxScreenRow;

    // Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionsState = 5;
    public final int gameOverState = 6;
    public final int transitionState = 7;
    public final int tradeState = 8;
    public final int sleepState = 9;
    public final int mapState = 10;

    //Helpers
    public KeyHandler keyH = new KeyHandler(this);
    public Player player = new Player(this,keyH);
    public GamePanel() throws FileNotFoundException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void resetGame(boolean restart){
//        player.setDefaultPositions();
//        player.restoreStatus();
//        player.resetCounter();
//        aSetter.setNPC();
//        aSetter.setMonster();
//
//        if(restart) {
//            player.setDefaultValues();
//            aSetter.setObject(0,1);
//            aSetter.setObject(1,1);
//            aSetter.setInteractiveTile();
//            eManager.lighting.resetDay();
//        }
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1_000_000_000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
//                drawToTempScreen(); // draw everything to the buffered image
//                drawToScreen();     // draw everything to the screen
                delta--;
                drawCount++;
            }
            if(timer >= 1_000_000_000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {

        if(gameState == playState) {

        }
        if(gameState == pauseState){

        }
        if(gameState == dialogueState){

        }
        if(gameState == gameOverState){
        }
        }

}
