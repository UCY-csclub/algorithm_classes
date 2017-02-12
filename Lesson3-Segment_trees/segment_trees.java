import java.util.*;
import java.lang.*;

public class Main{

	public static final int INF = 1000000000;

	//Build the segment tree
	public static void build(int node, int start, int finish, int segtree[], int arr[]){

		if(start == finish){

			segtree[node] = arr[start];
		}
		else{

			int mid = (start + finish) /2;

			build(node*2,start, mid, segtree,arr);
			build(node*2+1,mid+1,finish,segtree, arr);

			segtree[node] = Math.min(segtree[node*2],segtree[node*2+1]);
		}

	}

	//Add value to the given range (a to b)

	public static void update(int node, int start, int finish, int a, int b, int value, int segtree[]){

		//Out of range
		if(start > finish || start > b || finish < a)
			return;

		//if the node is a leaf node
		//add value to current node

		if(start == finish){
			segtree[node] += value;
			return;
		}

		
		//Otherwise visit the children recursively

		int mid = (start + finish)/2;

		update(node*2,start,mid,a,b,value, segtree);
		update(node*2+1,mid+1,finish,a,b,value,segtree);

		segtree[node] = Math.min(segtree[node*2], segtree[node*2+1]);

		

	}

	//Get the minimum in the given range(a to b)
	public static int query(int node, int start, int finish, int a, int b, int segtree[]){

		if(start > b || finish < a){
			return INF;
		}

		if(start >= a && finish <= b){

			return segtree[node];
		}

	

				int mid = (start + finish) /2;

				int q1 = query(node*2,start,mid,a,b,segtree);
				int q2 = query(node*2+1,mid+1,finish,a,b,segtree);

				return Math.min(q1,q2);
		

	}


	public static void main(String[] args){

		int n,q,a,b;
		int arr[] = new int[100001];
		int segtree[] = new int [300003];

		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();

		for(int i=0;i<n;i++){

			arr[i] = scan.nextInt();
		}

		build(1,0,n-1,segtree,arr);

		q = scan.nextInt();

		for(int i=0;i<q;i++){
			a = scan.nextInt();
			b = scan.nextInt();

			System.out.println(query(1,0,n-1,a,b,segtree));
		}

	}
}