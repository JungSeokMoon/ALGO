import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	
	static class Node{
		int x;
		int y;
		int data;
		public Node(int x, int y, int data) {
			super();
			this.x = x;
			this.y = y;
			this.data = data;
		}
		
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static String[][] map;
	static boolean[][] visit;
	static Queue<Node> q;
	static int[] memo;
	static int row,col;
	static int max;
	static int index;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int cnt=0;
		row = Integer.parseInt(str[0]); //세로크기 (행)
		col = Integer.parseInt(str[1]); //가로크기 (열)
		map = new String[row][col];
		
		for(int i=0; i<row; i++) {
			str = br.readLine().split("");
			for(int j=0; j<col; j++) {
				map[i][j] = str[j];
				if(map[i][j].equals("L")) cnt++;
			}
		}
		index=0;
		memo = new int[cnt+1];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j].equals("L")) {
					max=0;
					
					bfs(i,j);
				}
			}
		}
		
		Arrays.sort(memo);
/*		for(int i=0; i<memo.length; i++) {
			System.out.print(memo[i]+" ");
		}*/
		System.out.println(memo[memo.length-1]);
		
		
	}
	private static void bfs(int i, int j) {
		visit = new boolean[row][col];
		q = new LinkedList<>();
		q.add(new Node(i, j, 0));
		visit[i][j]=true;
		while(!q.isEmpty()) {
			Node node = q.remove();
			for(int m=0; m<4; m++) {
				int idx = node.x+dx[m];
				int idy = node.y+dy[m];
				if(idx>=0 && idy>=0 && idx<row && idy <col) {
					if(map[idx][idy].equals("L") && !visit[idx][idy]) {
						visit[idx][idy]=true;
						q.add(new Node(idx, idy, node.data+1));
					}
				}
			}
			max= Math.max(max, node.data);
		}
		memo[index++]=max;
		
		
	}
}
