package com.logivi._15Puzzle.Solver;

import java.util.ArrayList;
import java.util.List;

public class NodeTree
{
    Node root;

    public NodeTree(GameState start)
    {
        root = new Node(start);
    }

    public List<Node> expandNode(Node node, List<Action> actionList)
    {
        ArrayList<Node> result = new ArrayList<>();
        for (Action action:actionList)
        {
            //System.out.println("Expanding: "+action);
            GameState after = node.gameState.perform(action);
            //System.out.println(after);
            result.add(node.addChild(after,action));
        }
        return result;
    }
}
