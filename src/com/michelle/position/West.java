package com.michelle.position;

import com.michelle.explorer.Explorer;

public class West implements Position{

	@Override
	public void moveForward(Explorer e) {
		// TODO Auto-generated method stub
		e.setRow(e.getRow() - 1);
		
	}

	@Override
	public Position turnRight() {
		// TODO Auto-generated method stub
		return new North();
	}

	@Override
	public Position turnLeft() {
		// TODO Auto-generated method stub
		return new South();
	}

}
