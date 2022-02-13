package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainNM3 {
	
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		int[] num = new int[N+1];
		
		solution(N,M,0,num);
		
		bw.close();
	}

	private static void solution(int n, int m, int depth, int[] num) throws IOException {
		if(depth == m) {
			
			for(int i=0; i<m; i++) {
				bw.write(num[i] + " ");
			}
			
			bw.write("\n");
			
			return;
		}
		
		
		for(int i=1; i<=n; i++) {
			
			num[depth] = i;
			solution(n,m,depth+1, num);
			
		}
		
		
	}

}
