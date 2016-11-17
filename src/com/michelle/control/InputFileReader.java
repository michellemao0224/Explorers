package com.michelle.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.michelle.controller.Controller;
import com.michelle.controller.MoveForwardControl;
import com.michelle.controller.SearchController;
import com.michelle.controller.TurnLeftControl;
import com.michelle.controller.TurnRightControl;
import com.michelle.explorer.Explorer;
import com.michelle.land.LandingArea;
import com.michelle.position.East;
import com.michelle.position.North;
import com.michelle.position.Position;
import com.michelle.position.SearchPosition;
import com.michelle.position.South;
import com.michelle.position.West;

public class InputFileReader{
	//Read input data
	public static ArrayList<String> fileInputReader(InputStream path) throws FileNotFoundException, IOException{
		 ArrayList<String> inputData = new ArrayList<>();
	        BufferedReader br = new BufferedReader(new InputStreamReader(path));
	        String line;
	        while ((line = br.readLine()) != null){
	        	inputData.add(line);
	        }
	        br.close();
	        return inputData;
	}
	
	//Parse input data, get first line landing location (x,y)
	public static LandingArea findLandingPosition(String LandingLocation){
		String[] landLoc = LandingLocation.split(" ");
        int CoordinateX= Integer.parseInt(landLoc[0]);
        int CoordinateY = Integer.parseInt(landLoc[1]);
        return new LandingArea(CoordinateX, CoordinateY);
		
	}
	
	//Parse input data, get second line explorer location (x,y,N)
	public static Explorer findExplorerPosition(String ExplorerLocation, LandingArea area){
		Position pos = null;
		String[] explorerLoc = ExplorerLocation.split(" ");
        int rol= Integer.parseInt(explorerLoc[0]);
        int cow = Integer.parseInt(explorerLoc[1]);
        pos = SearchPosition.valueOf(explorerLoc[2]).getPos();
        return new Explorer(area, rol, cow, pos);
	}
	
	//Parse input data, get third line command L,R,M
	public static ArrayList<Controller> controlCommand(String commandLine){
		Controller control = null;
		ArrayList<Controller> commandList = new ArrayList<>();
		char[] commands = commandLine.toCharArray();
		for (char command : commands){
			control = SearchController.valueOf(Character.toString(command)).getControl();
            commandList.add(control);
		}
		return commandList;
	}
}
