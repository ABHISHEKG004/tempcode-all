package MCexamples.inemoryQueueSystem.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Abhishek gupta on 2019-08-30
 */
public class TopDependency
{
  private int v;
  private LinkedList<Integer> adj[];

  public TopDependency(int v)
  {
    this.v = v;
    adj = new LinkedList[v];
    for (int i=0; i<v; ++i)
      adj[i] = new LinkedList();
  }

  public void addEdge(int v,int w) { adj[v].add(w); }


  private void topologicalSortUtil(int v, boolean visited[], Stack stack) {

    visited[v] = true;
    Integer i;

    Iterator<Integer> it = adj[v].iterator();
    while (it.hasNext())
    {
      i = it.next();
      if (!visited[i])
        topologicalSortUtil(i, visited, stack);
    }

    stack.push(new Integer(v));
  }


  public Stack topologicalSort()
  {
    Stack stack = new Stack();
    boolean visited[] = new boolean[v];
    for (int i = 0; i < v; i++)
      visited[i] = false;

    for (int i = 0; i < v; i++)
      if (!visited[i])
        topologicalSortUtil(i, visited, stack);
    return stack;
  }
}