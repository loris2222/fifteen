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
        int[][] startscramble = {{6,11,2,4},{13,15,8,7},{0,5,9,1},{10,14,12,3}};
        int[] startzero = {2,0};
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
