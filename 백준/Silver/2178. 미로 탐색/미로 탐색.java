
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int[][] mirrow;
	static boolean[][] checked;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static class Node{
		int x;
		int y;
		int distance;
		public Node(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		mirrow = new int[N][M];
		checked = new boolean[N][M];
		int cnt=0;
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			for(int j=0; j<M; j++) {
				mirrow[i][j] = Integer.parseInt(input[j]);
			}
		}
		Queue<Node> pq = new LinkedList<>();
		//PriorityQueue<Node> pq = new PriorityQueue<>();
		Node node = null;
		pq.offer(new Node(0, 0, 1));
		while(!pq.isEmpty()) {
			node = pq.poll();
			
			if(node.x == N-1 && node.y == M-1) {
				cnt = node.distance;
				break;
			}
			
			for(int m=0; m<4; m++) {
				int idx = node.x+dx[m];
				int idy = node.y+dy[m];
				
				if(idx >=0 && idx<N && idy>=0 && idy< M && mirrow[idx][idy] ==1) {
					if(!checked[idx][idy]) {	
						checked[idx][idy]= true;
						pq.offer(new Node(idx, idy, (node.distance+mirrow[idx][idy])));					
						
					}
				}
				
			}
			
		}
		System.out.println(cnt);
	}

}
