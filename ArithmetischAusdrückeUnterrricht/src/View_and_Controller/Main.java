package View_and_Controller;

public class Main {
	
	public static void main(String[] args) {
		Facade facade = new Facade();
		View view = new View();
		view.setVisible(true);
		new Controller(view, facade);
		
	}
}
