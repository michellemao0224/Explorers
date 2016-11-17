package com.michelle.controller;

public enum SearchController {
	L(new TurnLeftControl()),
	
	R(new TurnRightControl()),

    M(new MoveForwardControl());

    private final Controller control;

    SearchController(Controller control) {
        this.control = control;
    }

    public Controller getControl() {
        return control;
    }

}
