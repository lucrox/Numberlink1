package gloo.numberlink1;

import java.util.List;

public class Grid {
	
	private int dimension;	
	private Cell[] cells;
	
	public Grid(int dimension) {
		this.dimension = dimension;
		cells = new Cell[dimension*dimension];
	}

}
