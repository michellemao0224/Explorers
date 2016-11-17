package com.michelle.position;

public enum SearchPosition {
	S(new South()),
	
	N(new North()),

    W(new West()),
    
    E(new East());

    private Position pos;

    SearchPosition(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

}
