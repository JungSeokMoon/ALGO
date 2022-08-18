import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
/*
문제
2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.

이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.

커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

입력
첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.

둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.

출력
상을 받는 커트라인을 출력하라.

5 2
100 76 85 93 98

98
 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		int[] student = new int[N];
		str = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			student[i] = Integer.parseInt(str[i]);
		}

		Arrays.sort(student);
		
		bw.write(student[N-k]+"");
		
		bw.flush();
		bw.close();
	}

}
