package com.logivi._15Puzzle;

import com.logivi._15Puzzle.Game.Board;
import com.logivi._15Puzzle.Solver.Solver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[][] startscramble = {{2,6,3,4},{13,9,7,12},{0,10,5,11},{15,1,8,14}};
        //int[][] startscramble = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{0,13,14,15}};
        //int[] startzero = {3,0};
        int[][] goalscramble = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};

        Board start = new Board(startscramble);
        Board goal = new Board(goalscramble);
        System.out.println(start);
        System.out.println(goal);
        Solver solver = new Solver(start,goal);
        solver.solve();
    }
}
