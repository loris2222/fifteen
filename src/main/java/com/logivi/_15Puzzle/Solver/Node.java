package com.logivi._15Puzzle.Solver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Node implements Comparable<Node>
{
    Action action;
    int pathCost;
    GameState gameState;
    protected Node parent;
    protected List<Node> children = new ArrayList<>();
    int value;

    public Node(GameState gameState)
    {
        action=null;
        parent=null;
        pathCost=0;
        this.gameState = gameState;
        value=pathCost+gameState.getHeuristic();
    }

    public Node(GameState gameState, Action action, int oldCost, Node parent)
    {
        this.gameState = gameState;
        this.action = action;
        this.parent = parent;
        pathCost = oldCost+action.getCost();
        value=pathCost+gameState.getHeuristic();
    }

    public Node addChild(GameState gameState, Action action)
    {
        Node result = new Node(gameState, action, this.pathCost, this);
        children.add(result);
        return result;
    }

    @Override
    public int compareTo(Node other)
    {
        return this.value-other.value;
    }
}
