
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class BumperPanel extends JPanel {

   public static int lives = 3;
   private static int xFRAME;
   private static int yFRAME;
   private static final Color BACKGROUND = Color.BLACK;
   private static final Color FOOD_COLOR = Color.YELLOW;
   private static final Color BUMPER_COLOR = Color.BLUE;
   private int slowCount = 0;
   private Polkadot[] pd;

   private BufferedImage myImage;
   private Graphics myBuffer;
   public static int score = 0;
   private Timer refresher;
   private Pacman pacman;
   private Ghost[] ghosts;
   private Color[][] bluePixels;
   private Map map;
   private DotProcess dotprocessor;

   public BumperPanel(int x, int y) {
      xFRAME = x;
      yFRAME = y;
      myImage = new BufferedImage(xFRAME, yFRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      map = new Map();
      bluePixels = map.getArray();
      pacman = new Pacman(200, 200);
      dotprocessor = new DotProcess(xFRAME, yFRAME);
      
      pd = new Polkadot[20000];
      for (int i = 0; i < pd.length; i++) {
         pd[i] = new Polkadot();
      }
      dotprocessor.placeDots(pd, bluePixels);
   
      ghosts = new Ghost[5];
      for (int i = 0; i < ghosts.length; i++) {
         ghosts[i] = new Ghost();
      }
   // ghosts[1] = new Ghost(260, 140);
      //   	ghosts[2] = new Ghost(240, 160);
      //   	ghosts[3] = new Ghost(250, 150);
      //   	ghosts[0] = new Ghost(240, 140);
   
      refresher = new Timer(1, new Refresh());
   
      refresher.start();
      setFocusable(true);
      addKeyListener(new Key());
   
   }

   public static void setLives(int x) {
      //x = Integer.parseInt(JOptionPane.showInputDialog("Set Lives: "));
      lives = x;
   }

   public static int getLives() {
      return lives;
   }

   public void paintComponent(Graphics g) {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }

   public class Key extends KeyAdapter {
   
      public void keyPressed(KeyEvent e) {
         //System.out.println(e.getKeyCode());
         if ((e.getKeyCode() == KeyEvent.VK_UP) && (pacman.getY() > 15)) {
            pacman.moveVertical(-5);
         }
         if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (pacman.getY() < 285)) {
            pacman.moveVertical(5);
         }
         if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (pacman.getX() < 485)) {
            pacman.moveHorizontal(5);
         }
         if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (pacman.getX() > 15)) {
            pacman.moveHorizontal(-5);
         }
      }
   }

   private class Refresh implements ActionListener {
   
      public void actionPerformed(ActionEvent e) {
         myBuffer.setColor(Color.black);
         myBuffer.fillRect(0, 0, xFRAME, yFRAME);
      
         myBuffer.drawImage(map.getImage(), 0, 0, xFRAME, yFRAME, null);
      
         pacman.draw(myBuffer);
         WallCollision.checkNorth(pacman, bluePixels);
         WallCollision.checkEast(pacman, bluePixels);
         WallCollision.checkSouth(pacman, bluePixels);
         WallCollision.checkWest(pacman, bluePixels);
      
         if (slowCount == 7) {
            for (int i = 0; i < ghosts.length; i++) {
<<<<<<< HEAD
<<<<<<< HEAD
               //ghosts[i].draw(myBuffer);
=======
               ghosts[i].draw(myBuffer);
>>>>>>> origin/master
=======
               ghosts[i].draw(myBuffer);
>>>>>>> parent of baafaa8... changes
               WallCollision.checkNorth(ghosts[i], bluePixels);
               WallCollision.checkEast(ghosts[i], bluePixels);
               WallCollision.checkSouth(ghosts[i], bluePixels);
               WallCollision.checkWest(ghosts[i], bluePixels);
               ghosts[i].move(5);
               if (DeathByGhost.collide(pacman, ghosts[i])) {
                  refresher.stop();
                  GameOver.endGame();
               }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of baafaa8... changes
                ghosts[i].draw(myBuffer);
            }

            myBuffer.setColor(Color.black);
            myBuffer.fillRect(0, 0, xFRAME, yFRAME);

            myBuffer.drawImage(map.getImage(), 0, 0, xFRAME, yFRAME, null);

            pacman.draw(myBuffer);
            WallCollision.checkNorth(pacman, bluePixels);
            WallCollision.checkEast(pacman, bluePixels);
            WallCollision.checkSouth(pacman, bluePixels);
            WallCollision.checkWest(pacman, bluePixels);

            if (slowCount == 7) {
                for (int i = 0; i < ghosts.length; i++) {
                    ghosts[i].draw(myBuffer);
                    WallCollision.checkNorth(ghosts[i], bluePixels);
                    WallCollision.checkEast(ghosts[i], bluePixels);
                    WallCollision.checkSouth(ghosts[i], bluePixels);
                    WallCollision.checkWest(ghosts[i], bluePixels);
                    ghosts[i].move(1);
                    if (DeathByGhost.collide(pacman, ghosts[i])) {
                        refresher.stop();
                        lives--;
                        pacman.setX(200);
                        pacman.setY(200);

                        for (int q = 0; q < ghosts.length; q++) {
                            ghosts[q].setX(240);
                            ghosts[q].setY(140);
                        }

                        if (lives == 0) {
                            GameOver.endGame();
                        }
                        refresher.start();
                    }
                }
                slowCount = 0;
>>>>>>> origin/master
            }
            slowCount++;

=======
            }
            slowCount = 0;
         }
         slowCount++;
      
         for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].draw(myBuffer);
         }
      
         myBuffer.setColor(Color.black);
         myBuffer.fillRect(0, 0, xFRAME, yFRAME);
      
         myBuffer.drawImage(map.getImage(), 0, 0, xFRAME, yFRAME, null);
      
         pacman.draw(myBuffer);
         WallCollision.checkNorth(pacman, bluePixels);
         WallCollision.checkEast(pacman, bluePixels);
         WallCollision.checkSouth(pacman, bluePixels);
         WallCollision.checkWest(pacman, bluePixels);
      
         if (slowCount == 7) {
>>>>>>> origin/master
            for (int i = 0; i < ghosts.length; i++) {
               ghosts[i].draw(myBuffer);
               WallCollision.checkNorth(ghosts[i], bluePixels);
               WallCollision.checkEast(ghosts[i], bluePixels);
               WallCollision.checkSouth(ghosts[i], bluePixels);
               WallCollision.checkWest(ghosts[i], bluePixels);
               ghosts[i].move(1);
               if (DeathByGhost.collide(pacman, ghosts[i])) {
                  refresher.stop();
                  GameOver.endGame();
               }
            }
            slowCount = 0;
         }
         slowCount++;
      
         for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].draw(myBuffer);
         }
         
         for (int i=0; i<pd.length; i++)
            if (PolkadotCollision.collide(pacman, pd[i]))
            {
               score++;
               pd[i].setY(pd[i].getY()+300);
            }
         
         dotprocessor.drawDots(pd, myBuffer);
      
         myBuffer.setColor(Color.white);
         myBuffer.setFont(new Font("Monospaced", Font.BOLD, 8));
         myBuffer.drawString("Lives:" + lives, 430, 60);
            
         myBuffer.setColor(Color.white);
         myBuffer.setFont(new Font("Monospaced", Font.BOLD, 8));
         myBuffer.drawString("Score:" + score, 40, 60);
                     
         repaint();
      }
   }

}
