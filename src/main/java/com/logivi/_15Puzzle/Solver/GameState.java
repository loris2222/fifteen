package com.logivi._15Puzzle.Solver;

import java.util.List;

public interface GameState
{
    public List<Action> getActions();
    public int getHeuristic();
    public GameState perform(Action action);
    public boolean equals(GameState other);
}
