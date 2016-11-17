package com.michelle.position;

import com.michelle.explorer.Explorer;

public interface Position {
	
	public abstract void moveForward(Explorer e);
 
	public abstract Position turnRight();

	public abstract Position turnLeft();

}
