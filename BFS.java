import java.util.*;
public class BFS {
	static Scanner in=new Scanner(System.in);
	static class Edge{
		public int dest, weight;
		Edge(int dest, int weight)
		{
			this.dest=dest;
			this.weight=weight;
		}
		Edge(int dest)
		{
			this.dest=dest;
			this.weight=1;
		}
	}
	static void create_list(int n, int m,ArrayList<ArrayList<Edge>> lista)
	{
		for(int i=0; i<n; i++)
			lista.add(new ArrayList<Edge>());
		for(int i=0; i<m; i++)
		{
			int x, y;
			x=in.nextInt();
			y=in.nextInt();
			Edge temp=new Edge(y);
			lista.get(x).add(temp);
			temp=new Edge(x);
			lista.get(y).add(temp);
		}
	}	
	static void bfs(int s, ArrayList<ArrayList<Edge>> lista, int[] v)
	{
		v[s]=1;
		Queue<Integer> sira=new LinkedList<Integer>();
		sira.add(s);
		while(!sira.isEmpty())
		{
			int t=sira.remove();
			for(int i=0; i<lista.get(t).size(); i++)
			{
				if(v[lista.get(t).get(i).dest]==0)
				{
					v[lista.get(t).get(i).dest]=v[t]+1;
					sira.add(lista.get(t).get(i).dest);
				}
			}
		}
	}	
	public static void main(String[] args) {
		int n=0, m=0;
		int i;
		n=in.nextInt();
		m=in.nextInt();
		ArrayList<ArrayList<Edge>> lista=new ArrayList<ArrayList<Edge>>();
		create_list(n, m, lista);
		int[] visited=new int[n];
		for(i=0; i<n; i++)
		{
			if(visited[i]==0)
				bfs(i, lista, visited);
			System.out.print(visited[i]+" ");
		}
	}
}