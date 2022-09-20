
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map;
	static boolean[][][] visit;
	static int kx, ky;
	static int px, py;
	static int[][] dir = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}}; // 오른쪽부터 반시계방향
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());

		for(int t=0; t<testCase; t++) {
			map = new char[10][10];
			visit = new boolean[10][10][100];
			
			for(int i=1; i<=8; i++) {
				String[] str = br.readLine().split("");
				for(int j=1; j<=8; j++) {
					map[i][j] = str[j-1].charAt(0);
				}
			}
			
			String[] str = br.readLine().split(" "); //킹위치 (x는 왼쪽에서부터세고(즉 열이다), y는 아래에서부터 센다(행이다. 근데 거꾸로네))
			
			kx = 9-Integer.parseInt(str[1]);
			ky = Integer.parseInt(str[0]);
			
			str = br.readLine().split(" "); // 폰위치
			
			px = 9-Integer.parseInt(str[1]);
			py = Integer.parseInt(str[0]);
			
			int result = bfs();
			
			if(result == 1) {
				bw.write("White\n");
			}else {
				bw.write("Black\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	private static int bfs() {
		// F금지, D 위험 . 움직여 K 킹, P 폰
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(kx,ky,0)); // 킹
		visit[kx][ky][0] = true;
		
		while(!q.isEmpty()) {
			Node nd = q.poll();
			
			int cur_x = nd.x;
			int cur_y = nd.y;
			int cur_next = nd.next;
			// 위험칸은 움직인다.
			// 종료조건
			if( map[px + cur_next][py] == 'F' ) { // 검은색다음위치가 금지구역이면 
				return 1;
			}
			
			if(px + cur_next > 8) { // 검은색이 밑에 도착
				return 0;
			}
			
			for(int m=0; m<8; m++) { // 8방향 탐색하자
				int idx = cur_x + dir[m][0];
				int idy = cur_y + dir[m][1];
				int tmp_next = cur_next+1; // 단계 한계증가 ( 검은색위치 증가시키기위한)
				
				if((idx >=1 && idx <= 8) && (idy>=1 && idy <= 8) && map[idx][idy] != 'F' && map[idx][idy] != 'D' && !visit[idx][idy][tmp_next]) {
					if(! ((idx == px+tmp_next && idy == py -1 ) || (idx == px+tmp_next && idy == py +1 ))  ) { // 검은폰위치에따라 바뀜
						visit[idx][idy][tmp_next] = true;
						
						if((idx == px+cur_next && idy==py) || (idx==px+tmp_next && idy == py)) { // 폰이 잡히거나 막혀서 갈길없다
							return 1;
						}
						
						q.add(new Node(idx,idy,tmp_next));
					}
				}
			}
			
			// 흰생 킹이 검은 폰의 좌표로 올라가 폰을 잡을 경우 (White)
			
			// 흰색 킹이 움직여야할 차례지만 갈 수 있는 연린칸이 없는경우(Black)
			
			// 검은폰이 움직여야하는데 열린 칸 혹은 움직일수 없는경우
			// => 폰이 체스 판의 맨 밑에 칸에 위치할 경우 검은 폰의 승리; 아닌 경우 흰색 킹의 승리;
			
            
		}
		
		return 0;
	}
	
	static class Node{
		int x;
		int y;
		int next;
		
		public Node(int x, int y, int next){
			this.x = x;
			this.y = y;
			this.next = next;
		}
	}

}

