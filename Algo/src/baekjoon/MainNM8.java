package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MainNM8 {
	
	private static BufferedWriter bw;
	private static boolean[] visit;
	private static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		visit = new boolean[N];
		str = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int[] num = new int[N+1];
		Arrays.sort(arr);
		solution(N,M,0,num,0);
		
		bw.close();
	}

	private static void solution(int n, int m, int depth, int[] num, int index) throws IOException {
		if(depth == m) {
			
			for(int i=0; i<m; i++) {
				bw.write(num[i] + " ");
			}
			
			bw.write("\n");
			
			return;
		}
		
		
		for(int i=index; i<n; i++) {
			num[depth] = arr[i];
			solution(n,m,depth+1, num, i);
			
			
			
		}
		
		
	}

}
