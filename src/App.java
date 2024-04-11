import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
      // Creates SeatReservationFrame and its components
      ProductListFrame myFrame = new ProductListFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
