package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MainNM11 {
	
	private static BufferedWriter bw;
	private static boolean[] visit;
	private static int[] arr, num;
	private static int N,M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		visit = new boolean[N];
		
		str = br.readLine().split(" ");
		
		
		
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		num = new int[N+1];
		Arrays.sort(arr);
		solution(0,0);
		
		bw.close();
	}

	private static void solution(int depth, int index) throws IOException {
		if(depth == M) {
			
			for(int i=0; i<M; i++) {
				bw.write(num[i] + " ");
			}
			
			bw.write("\n");
			return;
		}
		
		int sav = 0;
		
		for(int i=index; i<N; i++) {
			if( arr[i] == sav) continue;
			
			num[depth] = arr[i];
			sav = num[depth];
			
			solution(depth+1, i);
			
			
		}
		//sav = num[0];
		
	}

}
