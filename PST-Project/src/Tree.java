import java.util.*;

public class Tree<T> {
	Node <T> root = new Node<T>();
	int L = 3;
	
	
	public Tree()
	{
		
	}
	public void setL(int i)
	{
		L = i;
	}
	
	public void train(ArrayList<T> input)
	{
		for(int i = 1; i <= L; i++)
		{
			for(int j = 0; j<input.size()-i; j++)
			{
			ArrayList<T> curSequence = new ArrayList<T> (input.subList(j, j + i));
			Node nodes = new Node(curSequence);
			root.addNode(nodes);
			}
		}
		
	}
	
	void printTree()
	{
		root.printOne();
	}
}
