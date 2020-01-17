package View_and_Controller;

public class Main {
	
	public static void main(String[] args) {
		Facade facade = new Facade();
		View view1 = new View(), view2 = new View();
		view1.setVisible(true);
		view2.setVisible(true);
		Controller c1 = new Controller(view1, facade);
		facade.register(c1);
		Controller c2 = new Controller(view2, facade);
		facade.register(c2);
			
	}
}
