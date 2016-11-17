package com.michelle.position;

import com.michelle.explorer.Explorer;

public class North implements Position{

	@Override
	public void moveForward(Explorer e) {
		// TODO Auto-generated method stub
		e.setCol(e.getCol() + 1);
		
	}

	@Override
	public Position turnRight() {
		// TODO Auto-generated method stub
		return new East();
	}

	@Override
	public Position turnLeft() {
		// TODO Auto-generated method stub
		return new West();
	}

}
