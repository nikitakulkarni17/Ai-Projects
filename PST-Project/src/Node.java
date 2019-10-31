import java.util.*;

public class Node<T> {
	ArrayList<T> tokenSequence = new ArrayList<T>();
	ArrayList<Node<T>> children = new ArrayList<Node<T>>();
	double nodeProb;
	
	Node() {}
	
	Node(ArrayList<T> input)
	{
		tokenSequence = input;
	}
	public ArrayList<T> getToken()
	{
		return tokenSequence;
	}
	public ArrayList<Node<T>> getChildren()
	{
		return children;
	}
	
	void setNodeProb(double input)
	{
		
		this.nodeProb = input;
	}
	
	boolean addNode(Node<T> node)
	{
		boolean found = false;
		ArrayList<T> nodeToken = node.getToken();
			if(tokenSequence.equals(nodeToken))
			{
				found = true;
			}
		
		else if(amIaSuffix(nodeToken) || tokenSequence.size() == 0)
		{
			int index = 0;
			while(index < children.size() && !found)
			{
				found = children.get(index).addNode(node);

				index++;
			}
			
			if(found==false)
			{
				children.add(node);
	
				found = true;
			}
			
		}
		return found;
	}
	
	void printOne()
	{
		
		System.out.println(tokenSequence);
		for(int i = 0; i < children.size(); i++)
		{
			children.get(i).printTwo(1);
		}
	}
	
	void printTwo(int numSpace)
	{
		for(int i = 0; i < numSpace; i++)
		{
			System.out.print("   ");
			
		}
		System.out.print("->");
		System.out.println(tokenSequence);
		for(int i = 0; i < children.size(); i++)
		{
			
			children.get(i).printTwo(numSpace + 1);
		}
	}
	
	boolean amIaSuffix(ArrayList<T> inputSeq)
	{
		ArrayList<T> newSuffix = new ArrayList<T>(inputSeq.subList((inputSeq.size() - tokenSequence.size()), inputSeq.size()));
		boolean ans = false;
//		if(inputSeq.size() == 0)
//		{
//			ans = false;
//		}
//		else
//		{
//		
////		ArrayList<T> newSuffix = new ArrayList<T>(inputSeq.subList((tokenSequence.size() - inputSeq.size()), inputSeq.size()));
////		for(int i = 0; i <children.size(); i++)
////		{
////			if(children.get(i).equals(newSuffix));
////			ans = true;
////		}
//		}
		return this.tokenSequence.equals(newSuffix);
		
	}
}
