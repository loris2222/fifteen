package com.logivi._15Puzzle.Game;

import com.logivi._15Puzzle.Solver.Action;

public class Move implements Action
{
    int[] moveDirection;

    public Move(int x,int y)
    {
        moveDirection = new int[2];
        moveDirection[0] = x;
        moveDirection[1] = y;
    }

    @Override
    public int getCost()
    {
        return 1;
    }

    public String toString()
    {
        return ""+moveDirection[0]+"-"+moveDirection[1];
    }
}
