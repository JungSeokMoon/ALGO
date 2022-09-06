import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node {
		int x;
		int y;
		int bomb;
		int result;
		public Node(int x, int y, int bomb, int result) {
			super();
			this.x = x;
			this.y = y;
			this.bomb = bomb;
			this.result = result;
		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]); // 세로
		int M = Integer.parseInt(str[1]); // 가로

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		boolean[][][] visit = new boolean[N][M][2];
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(0, 0, 0, 0));
		int cnt = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.x == N - 1 && node.y == M - 1) {
				cnt = node.result + 1;
				break;
			}

			for (int m = 0; m < 4; m++) {
				int idx = node.x + dx[m];
				int idy = node.y + dy[m];

				if (idx >= 0 && idy >= 0 && idx < N && idy < M) {

					if (map[idx][idy] == 1 && node.bomb == 0 && !visit[idx][idy][1]) {
						visit[idx][idy][1] = true;
						q.offer(new Node(idx, idy, 1, node.result + 1));
					}

					else if (map[idx][idy] == 0 && !visit[idx][idy][node.bomb]) {
						visit[idx][idy][node.bomb] = true;
						q.offer(new Node(idx, idy, node.bomb, node.result + 1));
					}

				}
			}
			
		}

		if (cnt == 0)
			cnt = -1;
		if (N == 1 && M == 1) {
			cnt = 1;
		}
		System.out.println(cnt);
	}

}
