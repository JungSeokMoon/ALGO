import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node{
		int x;
		int y;
		String data;
		int count;
		public Node(int x, int y, String data,int count) {
			super();
			this.x = x;
			this.y = y;
			this.data=data;
			this.count=count;
		}

	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static String[][] map;
	static boolean[][] check;
	static int cnt,result,startX,startY;
	static String sav;
	static Queue<Node> q;
	static Queue<Node> q2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new String[12][6]; //R=12 C=6 고정
		String[] str = null;
		for(int i=0; i<12; i++) {
			str = br.readLine().split("");
			for(int j=0; j<6; j++) {
				map[i][j] = str[j];
			}
		}
		cnt=0;
		//R,G,B,P,Y
		startX=0; startY=0;
		q = new LinkedList<Node>();
		ArrayList<Node> list = new ArrayList<>();
		result=0;
		while(true) {
			boolean success= true;
			downmap();
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(map[i][j].equals(".")) continue;
					q.add(new Node(i,j,map[i][j],1));
					check = new boolean[12][6];
					check[i][j] = true;
					cnt=0;
					while(!q.isEmpty()) {
						boolean flag = true;
						Node node = q.remove();
						cnt++;
						list.add(node);
						for(int m=0; m<4; m++) {
							int idx = node.x+dx[m];
							int idy = node.y+dy[m];
							if(idx>=0 && idy>=0 && idx<12 && idy<6) {
								if(!check[idx][idy] && map[idx][idy].equals(node.data)) {
									check[idx][idy] = true;
									q.add(new Node(idx, idy, node.data, node.count));
									
								}
							}
						} //for(m)
					}
					if(cnt >= 4) {
						for(Node node : list) {
							map[node.x][node.y]= "."; 
						}
						success=false;
					}
					list.clear();
				}
			}
			if(success)break;
			result++;

		}

		System.out.println(result);

	}
	private static void downmap() {
		for(int i=0; i<6; i++) {
			for(int j=10; j>=0; j--) {
				for(int k=11; k>j; k--) {
					if(!map[j][i].equals(".") && map[k][i].equals(".")) {
						map[k][i] = map[j][i];
						map[j][i]=".";
						break;
					}
				}
			}
		}

	}


}
