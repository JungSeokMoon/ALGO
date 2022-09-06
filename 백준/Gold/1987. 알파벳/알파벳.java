import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	static int result,R,C,re;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		 R = Integer.parseInt(str[0]);
		 C = Integer.parseInt(str[1]);
		char[][] map = new char[R][C];
		boolean[] visit = new boolean[26];
		char[] sav = new char[26];
		for(int i=0; i<R; i++) {
			str = br.readLine().split("");
			for(int j=0; j<C; j++) {
				map[i][j]=str[j].charAt(0);
			}
		}
		result=0;
		re=0;
		dfs(visit,map,sav,0,0);
		System.out.println(result+1);
		
	}
	static void dfs(boolean[] visit, char[][] map, char[] sav, int x,int y) {

		visit[map[x][y]-'A']=true;
		
		for(int m=0; m<4; m++) {
			int idx = x+dx[m];
			int idy = y+dy[m];
		
			if(idx>=0 && idy>=0 && idx<R && idy<C) {
				int next= map[idx][idy]-'A';
				if(!visit[next]) {
					result=Math.max(++re, result);
					dfs(visit,map,sav,idx,idy);
				}
			}
		}
		--re;
		visit[map[x][y]-'A']=false;
	}
}
