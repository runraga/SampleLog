package view;
import java.awt.EventQueue;



public class Startup {

	
	
	public static void main(String[] args) {	
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ConsoleWindow.initialize();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}
