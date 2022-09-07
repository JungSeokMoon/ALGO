import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int  N = Integer.parseInt(str[0]);
		int  K = Integer.parseInt(str[1]);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int[] visit = new int[100001];
		visit[N]=1;
		int result=0;
		while(!q.isEmpty()) {
			int temp = q.remove();
			if(temp==K) {
				result = visit[temp]-1;
				break;
			}
			
			if(temp-1 >=0 && visit[temp-1]==0) {
				visit[temp-1]=visit[temp]+1;
				q.add(temp-1);
				
			}
			if(temp+1 <=100000 && visit[temp+1]==0) {
				visit[temp+1]=visit[temp]+1;
				q.add(temp+1);
			}
			if(temp*2 <=100000 && visit[temp*2]==0) {
				visit[temp*2]=visit[temp]+1;
				q.add(temp*2);
			}
			
		}
		
		System.out.println(result);
		
	}

}
