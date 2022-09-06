
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static int min_cnt = Integer.MAX_VALUE;
	static int N;
	static int[] related_switch;
//	static int bit = 0;
	static int max_bit = 0;
	static boolean flag =false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;

		int bit = 0;
		
		N = Integer.parseInt(br.readLine());

		visited = new boolean[(int) Math.pow(2, N)];

		related_switch = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		max_bit = (max_bit | (1 << N)) - 1;

		for (int i = 1; i <= N; i++) {
			if (st.nextToken().equals("1")) {
				bit |= (1 << (N - i));
			}
			
			st2 = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st2.nextToken());

			int temp_bit = 0;

			for (int j = 1; j <= m; j++) {
				int idx = Integer.parseInt(st2.nextToken());
				temp_bit |= (1 << (N - idx));
			}

			related_switch[i] = temp_bit;
		}

		if (bit == max_bit) {
			System.out.println(0);
			return;
		}

//		solution(0, bit);
		bfs(bit);

		if (min_cnt == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min_cnt);
	}
	
	public static void bfs(int bit) {
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(bit,0));
//		visited[bit] = true;

		while (!q.isEmpty()) {
			Node nd = q.poll();
			
			int temp = nd.num;
			int cnt = nd.count;

			if(temp == max_bit) {
				min_cnt = cnt;
				break;
			}
			int temp_2 = 0;
			for (int i = 1; i <= N; i++) {
				if((temp & (1 << (N - i))) != 0) continue;
				
					
					temp_2 = switchOn(i, temp);
					if(visited[temp_2])continue;
					visited[temp_2] = true;
					
					q.offer(new Node(temp_2, cnt+1));
			}
		}
	}

	public static void solution(int count, int bit) {
		if(flag) return;
		if (count > min_cnt) {
			return;
		}

		if (bit == max_bit) {
			if (min_cnt > count) {
				min_cnt = count;
				flag = true;
			}

			return;
		}
		for (int i = 1; i <= N; i++) { // 완전 탐색

			if((bit & (1 << (N - i))) != 0) continue;

				bit = switchOn(i, bit);
				
				if(visited[bit]) continue;
				visited[bit] = true; // 방문 처리

				
				count++;

				solution(count, bit);
		}
	}

	public static int switchOn(int k, int bit) {
		bit |= (1 << (N - k));
		bit ^= related_switch[k];
		
		return bit;
	}
	
	static class Node{
		int num;
		int count;
		
		public Node(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
}