package com.michelle.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.michelle.controller.Controller;
import com.michelle.explorer.Explorer;
import com.michelle.land.LandingArea;

public class ControlExplorer {

	public static void main(String[] args) {
		
		ArrayList<String> dataset = null;
		List<String> controlInput = null;
		try {
			dataset = InputFileReader.fileInputReader(ControlExplorer.class.getResourceAsStream("/file.txt"));
			//Filtered out the landing area location (sublist 0), iterate over rest of list
			controlInput = dataset.subList(1, dataset.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("INPUT:"+"\n");
		//Show input data
		 for (String data : dataset)
	            System.out.println(data);
		 
		System.out.println("\n");
		System.out.println("OUTPUT:"+"\n");
		
		LandingArea area = InputFileReader.findLandingPosition(dataset.get(0));
		//Iterate over every two lines in a list
		for (int i = 0; i < controlInput.size(); i += 2) {
			//Find explorer position, check whether the position is out of bounds
            Explorer explorer = InputFileReader.findExplorerPosition(controlInput.get(i), area);
            //Get the next line command
            ArrayList<Controller> inputs = InputFileReader.controlCommand(controlInput.get(i + 1));
            //Execute command
            explorer.executeInput(inputs);
            //Show the output result
            System.out.println(explorer.toString());
        }
	    }

	}

