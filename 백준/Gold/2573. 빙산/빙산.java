import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Node> q = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		String[] str = br.readLine().split(" ");
		int R = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);
		int[][] map = new int[R][C];
		int[][] copymap = new int[R][C];
		boolean[][] visit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<C; j++) {
				map[i][j]=Integer.parseInt(str[j]);
				copymap[i][j]=map[i][j];
				if(map[i][j]!=0)q.add(new Node(i,j));
				
			}
		}
		int[][] resultmap = new int[R][C];
		boolean check=false;
		int result=0;
		while(!q.isEmpty()) {
			int size = q.size();
			result++;
			visit = new boolean[R][C];
			for(int i=0; i<size; i++) {
				Node node = q.remove();
				int cnt =0;
				for(int m=0; m<4; m++) {
					int idx = node.x+dx[m];
					int idy = node.y+dy[m];
					if(idx>=0 && idy>=0 && idx<R & idy<C) {
						if(map[idx][idy]==0) cnt++;						
					}
				}
				copymap[node.x][node.y]-=cnt;
				if(copymap[node.x][node.y]<0 )copymap[node.x][node.y]=0;
				if(copymap[node.x][node.y]>0) q.add(new Node(node.x,node.y));
								
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j]=copymap[i][j];
				}
			}			
			
			outloop : for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]!=0) {
						q2.add(new Node(i,j));
						visit[i][j]=true;
						break outloop;
					}
				}
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]==0)visit[i][j]=true;
				}
			}
			while(!q2.isEmpty()) {
				Node node = q2.remove();
				for(int m=0; m<4; m++) {
					int idx = node.x + dx[m];
					int idy = node.y + dy[m];
					if(idx>=0 && idy>=0 && idx<R && idy<C) {
						if(!visit[idx][idy] && map[idx][idy]!=0) {
							visit[idx][idy]=true;
							q2.add(new Node(idx,idy));
						}
					}
					
				}
			}
			outloop:for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(!visit[i][j]) {
						check = true;
						break outloop;
					}
				}
			}
			
			if(check) break;
		}
		if(check)System.out.println(result);
		else{
			System.out.println(0);
		}
	
		
	}

}
