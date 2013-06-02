package gameClasses;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startingClass theApplet = new startingClass();
        theApplet.init();   // invoke the applet's init() method
        theApplet.start();  // starts the applet

        // Create a window (JFrame) and make applet the content pane.
         javax.swing.JFrame window = new javax.swing.JFrame("FoxHAT");
         window.setContentPane(theApplet);
         window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
         window.pack();              // Arrange the components.
         window.setVisible(true);
	}

}
