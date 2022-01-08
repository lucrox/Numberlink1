package gloo.numberlink1;

public class Controller {
	private Grid grid;
	private Path currentPath;
	
	
	public Controller(Grid grid) {
		this.grid = grid;
	}
	
	public void setCurrentPath(Path currentPath) {
		this.currentPath = currentPath;
	}

}
