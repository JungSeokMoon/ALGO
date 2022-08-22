import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
/*
시루는 가을에 입을 바지를 미리 사기 위해 백화점에 왔다. 다리가 길고 저체중인 시루는 길이가 맞는 바지를 사면 허리가 너무 크고, 허리가 맞는 바지를 사면 길이가 짧아서 잘 맞는 바지를 찾지 못하고 있다.

길이가 맞는 바지를 산 다음 허리둘레를 수선을 하거나 허리띠를 하면 되지만, 수선하는 것은 귀찮고 허리띠를 불편해하는 시루는 멋진 아이디어를 생각해냈다.
 허리가 조금 크고 길이가 조금 짧은 바지를 산 다음, 허리가 아닌 엉덩이에 바지를 걸치는 방식으로 입는 것이다.

지면에서 x 만큼 떨어진 시루의 하체 둘레는 f(x) = max(a(x-b)^2+c, d)$로 계산할 수 있다. 예를 들어 f(x) = max(-0.1(x-50)^2+10, 6)이라고 하면,
 시루가 엎드려 있을 때 하체는 다음과 같은 형태이다.

44 ~ 50 ~ 56   56-44+1 = 13
6  ~ 10 ~ 6    6 7 8 9 10 9 8 7 6

시루는 백화점에서 n개의 바지를 골랐다. i번째 바지의 허리둘레는 u_i, 길이는 v_i이다. 바지를 위에서부터 내려가는 방식으로 허리둘레가 시루의 하체 둘레와 딱 맞도록 바지를 입었을 때, 
바지가 끌리지 않으면서 끝부분의 높이가 지면과 일치하는지 확인해 보자. 바지의 허리 부분은 시루의 하체에서 둘레가 가장 큰 위치보다 높거나 같은 곳에서만 걸린다.

입력
첫째 줄에 시루의 하체 둘레를 의미하는 네 정수 a, b, c, d가 공백으로 구분되어 주어진다. (-10 < a <-1, 1 < b <10,000 , 1 < d < c \10000)

둘째 줄에 바지의 개수 $N$이 주어진다. (1 <= N <= 100000)

셋째 줄부터 N개의 줄에 걸쳐, $번째 줄에 i번째 바지의 둘레와 길이를 의미하는 두 정수 u_i, v_i가 공백으로 구분되어 주어진다. (d < u_i < c, b < v_i < 10000)

출력
바지가 땅에 끌리지 않고, 바지의 끝부분의 높이가 지면과 일치하는 바지의 개수를 출력한다.

-1 50 10 6
4
10 50
10 52
9 51
9 50

2
-0.1 (x^2 -100x + 2500) + 10 = -0.1x^2 + 10x - 250 + 10 = -0.1x^2+10x-240, 6
-1 (x^2 -100x + 2500) + 10 = -x^2 + 100x -2500 + 10 = -x^2+100x-2490
첫 번째 바지와 두 번째 바지는 지면으로부터 50 만큼 떨어진 위치에서 하체에 걸린다. 따라서 길이가 50인 첫 번째 바지는 끝부분의 높이가 지면과 일치하고, 길이가 52인 두 번째 바지는 땅에 끌린다.

세 번째 바지와 네 번째 바지는 지면으로부터 51 만큼 떨어진 위치에서 하체에 걸린다. 따라서 길이가 51인 세 번째 바지는 끝부분의 높이가 지면과 일치하고,
 길이가 50인 네 번째 바지의 끝부분은 지면으로부터 1 만큼 떨어진 곳에 위치한다.
 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		int d = Integer.parseInt(str[3]);
		
		int N =Integer.parseInt(br.readLine());
		
		int u = 0,v = 0;
		int cnt = 0;
		int cal = 0;
		int see = 0;
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			u = Integer.parseInt(str[0]); // 허리둘레
			v = Integer.parseInt(str[1]); // 바지길이
			int x2 = v*v;
			int ab = 2*v*b;
			int b2 = b*b;
			cal = Math.max(a*(x2 -ab + b2) + c, d);
			
			if(cal == u) cnt++;
			
		}
		
		bw.write(cnt+"");

		
		bw.flush();
		bw.close();
	}

}
