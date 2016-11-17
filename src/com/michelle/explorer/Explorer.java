package com.michelle.explorer;

import java.util.ArrayList;

import com.michelle.controller.Controller;
import com.michelle.land.LandingArea;
import com.michelle.position.Position;

public class Explorer {
	private int row;
	private int col;
	private Position pos;
	private LandingArea area;
	
	public Explorer(LandingArea area,int row, int col, Position pos){
		if(pos == null){
			throw new NullPointerException("The Explorer's position cannot be null");
		}else if (area == null){
			throw new NullPointerException("The LandingArea cannot be null");
		}
		this.area = area;
		this.row = row;
		this.col = col;
		this.pos = pos;
		
		inputValudation();
	}
	public LandingArea getLandingArea() {
        return area;
    }
	
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	@Override
	public String toString() {
		 return row + " "+ col + " "
	                + Character.toString(getPos().getClass().getSimpleName().charAt(0));
	}
	
	public void turnRight() {
        pos = getPos().turnRight();
    }

    public void turnLeft() {
        pos = getPos().turnLeft();
    }

    public void moveForward() {
        getPos().moveForward(this);
        inputValudation();
    }
	//Check whether input data or executed data is out of bounds
    public void inputValudation(){
		if(this.getRow() > area.getCoordinateX() || this.getCol() > area.getCoordinateY() 
				|| this.getRow() < area.getInitCoordinateX() || this.getCol() < area.getInitCoordinateY()){
			throw new ExplorerOutOfBoundsException();
		}
	}
    //Call execute function from Controller
    public void executeInput(ArrayList<Controller> inputs) {
        for (Controller input : inputs)
            input.execute(this);
    }
	
}
