package com.logivi._15Puzzle.Solver;

import javafx.collections.transformation.SortedList;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solver
{
    public GameState goalState;
    public NodeTree tree;
    public List<Node> frontier = new ArrayList<>(); //TODO implement this better and more efficiently
    public List<GameState> closedList = new ArrayList<>();

    public Solver(GameState startState, GameState goalState)
    {
        tree = new NodeTree(startState);
        this.goalState = goalState;
    }

    public void solve()
    {
        Node currentNode = tree.root;
        closedList.add(currentNode.gameState);
        while (!currentNode.gameState.equals(goalState))
        {
            //System.out.println("Heuristic: "+currentNode.gameState.getHeuristic(null));
            //System.out.println(currentNode.gameState);
            ArrayList<Node> expansion = (ArrayList)tree.expandNode(currentNode, (ArrayList<Action>) currentNode.gameState.getActions());
            for (Node n:expansion)
            {
                if(!closedList.contains(n.gameState))
                {
                    frontier.add(n);
                }
            }
            Collections.sort(frontier);
            currentNode = frontier.remove(0);
            closedList.add(currentNode.gameState);
        }
        System.out.println("Solution found");
        //System.out.println(currentNode.gameState);
        ArrayList<Action> result = new ArrayList<>();
        while (currentNode.parent!=null)
        {
            //System.out.println(currentNode.gameState);
            result.add(currentNode.action);
            currentNode = currentNode.parent;
        }
        Collections.reverse(result);
        for (Action action : result)
        {
            System.out.println( action );
        }
    }
}
