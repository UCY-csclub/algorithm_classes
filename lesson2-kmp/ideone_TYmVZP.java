import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
		String s, m;
		int size=in.nextInt();
		s=in.next();
		m=in.next();
		String t=s+"#"+m;
		int[] prefix=new int[t.length()];
		prefix[0]=-1;
		for(int i=1; i<t.length(); i++)
		{
			int p1, p2;
			p1=prefix[i-1];
			p2=i-1;
			while(true)
			{
				if(t.charAt(p1+1)==t.charAt(i))
				{
					prefix[i]=prefix[p2]+1;
					if(prefix[i]==size-1)
					{
						System.out.println(i-size-prefix[i]-1);
					}
					break;
				}
				if(p2==-1)
				{
					prefix[i]=-1;
					break;
				}
				p2=p1;
				p1=prefix[Math.max(0, p1)];
			}
		}
	}
	}
}
