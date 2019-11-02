import java.util.*;

public class Node<T> {
	ArrayList<T> tokenSequence = new ArrayList<T>();
	ArrayList<Node<T>> children = new ArrayList<Node<T>>();
	double nodeProb;
	int count = 1;
	
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
				count++;
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

		return this.tokenSequence.equals(newSuffix);
		
	}
	
	boolean pMin(int total, float p)
	{
		boolean remove = false;
		float sum = total - (tokenSequence.size() - 1);
		float prob = count / sum;
		
		if((tokenSequence.size()!=0) && prob < p)
		{
			remove = true;
		}
		else
		{
			for(int i = children.size()-1; i>=0; i--)
			{
				
				//System.out.println("Checking child: " + children.get(i).getToken());
				if(children.get(i).pMin(total, p))
				{
					children.remove(children.get(i));
				}
			}
		}
		return remove;
	}
}
