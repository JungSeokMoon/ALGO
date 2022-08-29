import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
	
		for(int testCase=1; testCase<=T; testCase++) {
			LinkedList<Integer> queue = new LinkedList<>();
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			str = br.readLine().split(" ");
			int cnt=0;
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(str[i]);
				queue.add(num);
			}
			
			while(!queue.isEmpty()) {
				boolean check = true;
				for(int i=1; i<queue.size(); i++) {
					if(queue.peek() < queue.get(i)) {
						check = false;
						break;
					}
				}
				if(check) {
					cnt++;
					queue.poll();
					
					if(M==0)break;
					else {
						M-=1;
					}
				}else {
					int temp = queue.poll();
					queue.add(temp);
					M = (M==0)? queue.size()-1 : --M;
				}
				
				
			}
			System.out.println(cnt);
		}
	}

}
