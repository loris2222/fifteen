package com.logivi._15Puzzle.Solver;

import java.util.List;

public interface GameState
{
    public List<Action> getActions();
    public int getHeuristic(GameState goal);
    public GameState perform(Action action);
}
