//Abdalla Osman      7/20/15

   import javax.swing.JFrame;
   public class Driver
   {
      public final static int XDIMENSION = 500, YDIMENSION = 300;
      public static JFrame frame;
      public static void gameFrame(int ghosts)
      {
         frame = new JFrame("PACMAN");
         frame.setSize(XDIMENSION, YDIMENSION);
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BumperPanel(XDIMENSION, YDIMENSION, ghosts));
         frame.setVisible(true);
      }
   }
