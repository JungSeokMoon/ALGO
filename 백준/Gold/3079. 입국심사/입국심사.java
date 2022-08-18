import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
문제
상근이와 친구들은 오스트레일리아로 여행을 떠났다. 상근이와 친구들은 총 M명이고, 지금 공항에서 한 줄로 서서 입국심사를 기다리고 있다. 입국심사대는 총 N개가 있다. 
각 입국심사관이 심사를 하는데 걸리는 시간은 사람마다 모두 다르다. k번 심사대에 앉아있는 심사관이 한 명을 심사를 하는데 드는 시간은 Tk이다.

가장 처음에 모든 심사대는 비어있고, 심사를 할 준비를 모두 끝냈다. 상근이와 친구들은 비행기 하나를 전세내고 놀러갔기 때문에, 지금 심사를 기다리고 있는 사람은 모두 상근이와 친구들이다. 
한 심사대에서는 한 번에 한 사람만 심사를 할 수 있다. 가장 앞에 서 있는 사람은 비어있는 심사대가 보이면 거기로 가서 심사를 받을 수 있다.
 하지만 항상 이동을 해야 하는 것은 아니다. 더 빠른 심사대의 심사가 끝나길 기다린 다음에 그 곳으로 가서 심사를 받아도 된다.

상근이와 친구들은 모두 컴퓨터 공학과 학생이기 때문에, 어떻게 심사를 받으면 모든 사람이 심사를 받는데 걸리는 시간이 최소가 될지 궁금해졌다.

예를 들어, 두 심사대가 있고, 심사를 하는데 걸리는 시간이 각각 7초와 10초라고 하자. 줄에 서 있는 사람이 6명이라면, 
가장 첫 두 사람은 즉시 심사를 받으러 가게 된다. 7초가 되었을 때, 첫 번째 심사대는 비어있게 되고, 세 번째 사람이 그곳으로 이동해서 심사를 받으면 된다. 
10초가 되는 순간, 네 번째 사람이 이곳으로 이동해서 심사를 받으면 되고, 14초가 되었을 때는 다섯 번째 사람이 첫 번째 심사대로 이동해서 심사를 받으면 된다. 
20초가 되었을 때, 두 번째 심사대가 비어있게 된다. 하지만, 여섯 번째 사람이 그 곳으로 이동하지 않고, 1초를 더 기다린 다음에 첫 번째 심사대로 이동해서 심사를 받으면,
 모든 사람이 심사를 받는데 걸리는 시간이 28초가 된다. 만약, 마지막 사람이 1초를 더 기다리지않고, 첫 번째 심사대로 이동하지 않았다면, 
 모든 사람이 심사를 받는데 걸리는 시간이 30초가 되게 된다.

상근이와 친구들이 심사를 받는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 1,000,000,000)

다음 N개 줄에는 각 심사대에서 심사를 하는데 걸리는 시간인 Tk가 주어진다. (1 ≤ Tk ≤ 109)

출력
첫째 줄에 상근이와 친구들이 심사를 마치는데 걸리는 시간의 최솟값을 출력한다. 

2 6
7
10

28


7 10
3
8
3
6
9
2
4

8
 */
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]); // 입국심사대
		int M = Integer.parseInt(str[1]); // 친구들
		/*
		 * 다탐색하면 무조건 시간초과난다.  최악의 시간 경우의수 N=1, M,K= 10^9 * 10^9 = 10^18 ... 무조건 시간초과 
		 * 2 6
		 * 7
		 * 10
		 * 
		 * 28
		 * 
		 * 6*10 = 60
		 * 
		 * 17 30,  xxxxxx
		 * 
		 * 30/7 = 4,  30/10 = 3  => 7
		 * 
		 * 7 < 30   +++ 30
		 * 
		 * 7 : 29
		 * 
		 * 29/2 14
		 * 
		 * 14/7 = 2, 14/10 = 1  => 3  xxxxx
		 * 
		 * 
		 * 
		 * 6*10 = mid =60/2 =30 온쪽 오른쪽
		 * left = 0, right = 60
		 * / 하는이유 시간이니깐. 해당시간만큼 빠지면 되는거니깐
		 * 30/7 + 30/10 = 7  > 6  초과   값 = mid = 30 왼쪽범위에있다. 
		 * 
		 * left = 0, right = 29 mid = 14
		 * 
		 * 14/7 + 14/10 = 3 < 6 미ㅣ만.. 부족하다 오른쪽범위다 그면 left 늘린다.
		 * 
		 * left = 15, right = 29
		 * 
		 * mid = 22
		 * 
		 * 22/7 + 22/10 = 5 < 6 미만.. 부족 오른쪽범위 그면 left 늘린다.
		 * 
		 * left = 23, right = 29 / mid = 26
		 * 
		 * 26/7 + 26/10 = 5 <6 미만  오른쪽범위 left 늘린다.
		 * 
		 * left = 27, right = 29 / mid = 28
		 * 
		 * 28/7 + 28/10 = 6 = 6 동일  임마다.  값 = mid = 28
		 * 
		 * 무조건 나눠떨어지는가 그면? 이분탐색이니 무조건 되겠네 -> 두번째케이스에서 안되네 최소값 비교하면서 while 끝나나봄
		 * 
		 * left , right 같아지는 순간까지.
		 * 고우
		 * 
		 * 
		 * 
		 */
		
		int[] time = new int[N]; // 입국심사 시간 저장하는 배열
		long left = 0;
		long mid = 0;
		long right = 0;
		long val = 0;
		long result = Long.MAX_VALUE;
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(br.readLine());
			
			right = right <= time[i] ? time[i] : right;
		}
		right = right * M; // 최대 시간값 설정.
		while(left <= right) {
			mid = (left+right)/2;
			val = 0;
			for(int i=0; i<N; i++) {
				val += mid / time[i];
			}
			
			if(val < M) { // 오른쪽에 있다
				left = mid+1;
			}else { // 왼쪽에 있다.
				right = mid-1;
				result = Math.min(result, mid);
			}
			
		}
		
		bw.write(result+"");
		
		bw.flush();
		bw.close();
	}

}
