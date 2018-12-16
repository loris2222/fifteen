package com.logivi._15Puzzle.Game;

import com.logivi._15Puzzle.Solver.Action;
import com.logivi._15Puzzle.Solver.GameState;

import java.util.ArrayList;
import java.util.List;

public class Board implements GameState
{
    int[][] tiles;
    int[] empty;

    /* List<Move> possibleMoves; */

    public Board()
    {
        //Set tiles in order
        int a=0;
        tiles = new int[4][4];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                tiles[i][j]=a;
                a++;
            }
        }
        //Set empty tile
        tiles[3][3]=0;
        empty = new int[2];
        empty[0]=3;
        empty[1]=3;
        //Create standard moves
        /*
        possibleMoves = new ArrayList<>();
        possibleMoves.add(new Move(1,0));
        possibleMoves.add(new Move(0,1));
        possibleMoves.add(new Move(-1,0));
        possibleMoves.add(new Move(0,-1));
        */
    }

    private Board(Board b)
    {
        this();
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++)
                tiles[i][j]=b.tiles[i][j];
        empty[0]=b.empty[0];
        empty[1]=b.empty[1];
    }

    public Board(int[][] tiles, int[] empty)
    {
        this();
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++)
                this.tiles[i][j]=tiles[i][j];
        this.empty[0]=empty[0];
        this.empty[1]=empty[1];
    }

    @Override
    public List<Action> getActions()
    {
        ArrayList<Action> result = new ArrayList<>();
        if(empty[0]>0)
        {
            result.add(new Move(-1,0));
        }
        if(empty[0]<3)
        {
            result.add(new Move(1,0));
        }
        if(empty[1]>0)
        {
            result.add(new Move(0,-1));
        }
        if(empty[1]<3)
        {
            result.add(new Move(0,1));
        }
        return result;
    }

    @Override
    public int getHeuristic()
    {
        int result=0;
        int a=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(tiles[i][j]!=a)
                {
                    result++;
                }
                a++;
            }
        }
        return result;
    }

    @Override
    public GameState perform(Action action)
    {
        //Action has been given to solver by this class hence it will be castable to move
        Move m = (Move)action;
        //Clone the current game state to use it for modification
        Board result = new Board(this);
        //Move the tile and set the corresponding to 0
        result.tiles[empty[0]][empty[1]] = result.tiles[empty[0]+m.moveDirection[0]][empty[1]+m.moveDirection[1]];
        result.tiles[empty[0]+m.moveDirection[0]][empty[1]+m.moveDirection[1]] = 0;
        //Set empty
        result.empty[0]+=m.moveDirection[0];
        result.empty[1]+=m.moveDirection[1];
        return result;
    }

    @Override
    public boolean equals(GameState other)
    {
        int result=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(tiles[i][j]!=((Board)other).tiles[i][j])
                {
                    result++;
                }
            }
        }
        return result==0;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                str.append(tiles[i][j]);
                str.append("\t");
            }
            str.append("\n");
        }
        return str.toString();
    }
}




























