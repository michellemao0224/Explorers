package com.michelle.land;

public class LandingArea {
	
	private final int initCoordinateX = 0;
	private final int initCoordinateY = 0;
	private int CoordinateX;
	private int CoordinateY;
	
	public LandingArea(int coordinateX, int coordinateY) {
		super();
		CoordinateX = coordinateX;
		CoordinateY = coordinateY;
	}

	public int getCoordinateX() {
		return CoordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		CoordinateX = coordinateX;
	}

	public int getCoordinateY() {
		return CoordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		CoordinateY = coordinateY;
	}

	public int getInitCoordinateX() {
		return initCoordinateX;
	}

	public int getInitCoordinateY() {
		return initCoordinateY;
	}
	
	

}
