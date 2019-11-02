import java.util.*;

public class Tree<T> {
	Node <T> root = new Node<T>();
	ArrayList<T> alphabet = new ArrayList<T>();
	int L = 3;
	float pMin;
	int totalTokens;
	
	
	public Tree()
	{
		
	}
	public Tree(int l, float p)
	{
		this.L = l;
		this.pMin = p;
	}
	public void setL(int i)
	{
		L = i;
	}
	public void setpMin(float i )
	{
		pMin = i;
	}
	
	public void train(ArrayList<T> input)
	{
		totalTokens = input.size();
		for(int i = 1; i <= L; i++)
		{
			for(int j = 0; j<input.size()-(i-1); j++)
			{
			ArrayList<T> curSequence = new ArrayList<T> (input.subList(j, j + i));
			Node<T> nodes = new Node<T>(curSequence);
			
			root.addNode(nodes);
			}
			
		}
		root.pMin(totalTokens, pMin);	
		
	}
	
	void printTree()
	{
		root.printOne();
	}
	
	
}
