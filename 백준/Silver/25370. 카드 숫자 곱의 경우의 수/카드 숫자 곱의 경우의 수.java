import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
문제
1부터 9사이의 정수가 하나씩 적힌 카드가 무수히 많이 주어진다. 이 카드 중에서 n장의 카드를 선택하자. 
같은 카드를 중복해서 선택할 수 있다. 선택한 n장의 카드의 정수를 곱한 값을 a라고 하자. a가 될 수 있는 수의 개수를 출력하자.

입력
첫 번째 줄에 선택할 카드 개수 n이 주어진다.

출력
첫 번째 줄에 a가 될 수 있는 수의 개수를 출력한다.

제한
1 ≤ n ≤ 7

1
a가 될 수 있는 수는 1, 2, 3, 4, 5, 6, 7, 8, 9 이다.
9

2
a가 될 수 있는 수는 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 12 ,
 14 , 15 , 16 , 18 , 20 , 21 , 24 , 25 , 27 , 28 , 30 , 32 , 35 , 36 , 40 , 42 , 45 , 48 , 49 , 54 , 56 , 63 , 64 , 72 , 81로 
 
 36개 이다.

 

36
 */
public class Main {

	static int[] arr;// 
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		 N = Integer.parseInt(br.readLine());
		// 9^6 = 531441
		int length = (int)Math.pow(9, N) + 1;
		
		arr = new int[length];
		
		int cnt = 0;
		
		
		solve(0, 1);
	
		for(int i=1; i<length; i++) {
			if(arr[i] == 1)cnt++;
		}
		
		
		bw.write(cnt+"");
		
		bw.flush();
		bw.close();

	}
	private static void solve(int cnt, int num) {
		if(cnt==N) { // 횟수.
			arr[num] = 1;
			return;
		}
		for(int i=1; i<=9; i++) {
			solve(cnt+1, num*i);
		}
		
		
	}

}
