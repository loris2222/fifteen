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
        int[][] startscramble = {{1,2,4,7},{5,6,3,12},{11,15,14,10},{9,13,0,8}};
        int[] startzero = {3,2};
        //int[][] startscramble = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{0,13,14,15}};
        //int[] startzero = {3,0};
        int[][] goalscramble = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        int[] goalzero = {3,3};

        Board start = new Board(startscramble,startzero);
        Board goal = new Board(goalscramble,goalzero);
        System.out.println(start);
        System.out.println(goal);
        Solver solver = new Solver(start,goal);
        solver.solve();
    }
}
