import java.util.*;

public class Tree<T> {
	Node <T> root = new Node<T>();
	ArrayList<T> alphabet = new ArrayList<T>();
	int L = 3;
	double pMin;
	int totalTokens;
	
	
	public Tree()
	{
		
	}
	public Tree(int i, double j)
	{
		this.L = i;
		this.pMin = j;
	}
//	public void setL(int i)
//	{
//		L = i;
//	}
	
	public void train(ArrayList<T> input)
	{
		this.alphabet = input;
		totalTokens = input.size();
		for(int i = 1; i <= L; i++)
		{
			for(int j = 0; j<input.size()-i; j++)
			{
			ArrayList<T> curSequence = new ArrayList<T> (input.subList(j, j + i));
			Node<T> nodes = new Node<T>(curSequence);
			double sum = totalTokens - nodes.tokenSequence.size() - 1;
			double prob = nodeNum(nodes, totalTokens) / sum;
			
			if(prob >= pMin)
			{
			root.addNode(nodes);
			}
			}
		}
		
	}
	
	void printTree()
	{
		root.printOne();
	}
	
	int nodeNum(Node<T> node, int total)
	{
		int count = 0;
		int token = node.tokenSequence.size();
		for(int i = 0; i < total - token; i ++)
		{
			ArrayList<T> tempArr = new ArrayList<T>(alphabet.subList(i, i + token));
			if(tempArr.equals (node.tokenSequence))
			{
				count++;
			}
		}
		return count;
	}
}
