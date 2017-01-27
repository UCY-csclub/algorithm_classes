import java.util.*;
public class DFS {
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
	static void dfs(int s, ArrayList<ArrayList<Edge>> lista, boolean[] v)
	{
		v[s]=true;
		for(int i=0; i<lista.get(s).size(); i++)
			if(!v[lista.get(s).get(i).dest])
				dfs(lista.get(s).get(i).dest,lista, v);	
	}
	static void create_list(int n, int m,ArrayList<ArrayList<Edge>> lista)
	{
		for(int i=0; i<n; i++)
			lista.add(new ArrayList<Edge>());
		for(int i=0; i<m; i++)
		{
			int x, y, z;
			x=in.nextInt();
			y=in.nextInt();
			z=in.nextInt();
			Edge temp=new Edge(y, z);
			lista.get(x).add(temp);
			temp=new Edge(x, z);
			lista.get(y).add(temp);
		}
	}
	public static void main(String[] args) {
		int n=0, m=0;
		int i;
		n=in.nextInt();
		m=in.nextInt();
		ArrayList<ArrayList<Edge>> lista=new ArrayList<ArrayList<Edge>>();
		create_list(n, m, lista);
		boolean[] visited=new boolean[n];
		for(i=0; i<n; i++)
			if(!visited[i])
				dfs(i, lista, visited);
	}
}