import java.util.*;

//	Input explanation
//	n number of elements
//	n-numbers the elements of the array
//	t - how many searches
//	t numbers to search

// 	Test case from presentation just copy paste
// 	13 
// 	10 27 28 34 57 289 344 404 755 2017 2020 2023 9999
// 	3
//	27 344 2020

//	result should be: 1 6 10

public class BS_basic_example {
	
	public static void BinarySearch(long x, long[] pin, int left, int right){
		//System.out.println(left + " - " + right);
		int mid = (left+right)/2;
		if((right==left)||(pin[mid]==x)){
			System.out.println(mid);
			return;
		}
		if(pin[mid]>x){
			BinarySearch(x,pin,left,mid-1);
			return;
		}
		BinarySearch(x,pin,mid+1,right);
	}
	
	public static void main(String[] args) {
			Scanner stdin = new Scanner(System.in);
			
			long n = stdin.nextLong();
			long[] pin = new long[(int)(n)];
			
			for(int i=0;i<n;i++){
				pin[i] = stdin.nextLong(); 
			}
			
			long t = stdin.nextLong();
			long ero;
			
			while(t>0){
				t--;
				ero = stdin.nextInt();
				BinarySearch(ero,pin,0,pin.length-1);
			}
			stdin.close();
	}

}
