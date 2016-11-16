# Explorers
A squad of robotic explorers are to be landed on the planet Venus.

The landing area is rectangular and must be navigated by the explorers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

An explorer’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The landing area is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the explorer is in the bottom left corner and facing North.

In order to control an explorer, we send a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the explorer spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:

The first line of input is the upper-right coordinates of the landing area, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the explorers that have been deployed. Each explorer has two lines of input. The first line gives the explorer’s position, and the second line is a series of instructions telling the explorer how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the explorer’s orientation.

Each explorer will be finished sequentially, which means that the second explorer won’t start to move until the first one has finished moving.

OUTPUT:

The output for each explorer should be its final co-ordinates and heading.


COMMAND LINE INPUT AND OUTPUT:

Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Expected Output:
1 3 N
5 1 E

# Solution

My solution is using an Object-oriented programming(OOP) model. First, I identified the potential objects, such as Position, Controller, Explorer, Land.

Next, for each explorer, when building a constructor, we should initially check the validation of input data if it’s out of bounds or be NULL. Hence, we require the explorer’s coordinate X (row), coordinate Y (col) and Position (N,S,W,E), and LandingArea (x,y).

For each position, I constructed an interface to generate the basic functions: moveForward, turnRight, turnLeft. I combined these different operations with four directions (East, North, South, West). For example, if the explorer initially faces the North, then executing the command “turnLeft”, he will face West (new West() inside turnLeft() function). And if next order is to move forward, then new coordinate will be: coordinate X (x-1) and coordinate Y (unchanged). All positions will be called by using SearchPosition() function.

For each control, I also generated an interface Controller to execute command: MoveForwardControl, TurnLeftControl, TurnRightControl. These controls will call corresponding functions in the Explorer class.

For the landing area, I set up the origin points is (0,0).

To read the input data from file, I used a InputFileReader by opening BufferedReader and InputStreamReader, which are more functional than Scanner. Then to parse the three lines (Landing location, Explorer position, Command) in the file, I wrote three different functions to parse each line. I split the String, and made Integer corresponding to coordinate(x,y) and Char corresponding to direction and command .

In the main function, I filtered out the landing area location from the list, and I focused on how to iterate over the rest of lines (2-4 line from Test Input). I iterated over every two lines by using for loop, since every explorer needs two lines data (one for his location, another one for command on him). However, landing area location is essential to put into the findExplorerPosition() function to check the boundary.
