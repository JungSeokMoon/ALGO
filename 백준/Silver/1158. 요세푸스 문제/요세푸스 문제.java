import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 
이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

출력
예제와 같이 요세푸스 순열을 출력한다.

7 3

<3, 6, 2, 7, 5, 1, 4>
 */
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		int[] num = new int[N];
		boolean[] visit = new boolean[N];
		int[] result = new int[N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			num[i] = i+1;
		}
		visit[K-1] = true;
		result[cnt] = num[K-1];
		cnt++;
		
		int temp_K = K;
		int temp_cnt = 0;
		while(cnt<N) {
			
			while(temp_cnt<K) {
				temp_K++;
				if(visit[((temp_K-1)%N)]) {
					continue;
				}
				temp_cnt++;
				
			}
			visit[(temp_K-1)%N] = true;
			result[cnt] = num[(temp_K-1)%N];
			cnt++;
			temp_cnt=0;
			
		}
		
		System.out.print("<");
		for(int i=0; i<N; i++) {
			if(i == N-1) {
				System.out.print(result[i]+">");
			}else {
			System.out.print(result[i]+", ");
		
			}
		}
		
		
		
	}

}
/*
 * 1 2 x 4 5 6 7
 */