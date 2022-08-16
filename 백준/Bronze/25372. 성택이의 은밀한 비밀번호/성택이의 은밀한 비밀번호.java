import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
문제
부산사이버대학교 학생 성택이는 엄마의 의뢰를 받아 주어진 문자열이 현관문 비밀번호에 사용 가능한지 알아내야 한다. 성택이는 공부해야 하므로 우리가 도와주자!

사용할 수 있는 비밀번호의 규칙은 다음과 같다.

비밀번호는 6자리 이상 9자리 이하여야 한다.
예를 들어, 123124는 올바른 비밀번호이고, 1202727161은 잘못된 비밀번호이다. 문자열이 주어졌을 때 현관문 비밀번호로 사용할 수 있는지 판단하자.

입력
첫째 줄에 문자열의 총개수 $N$이 주어진다.

둘째 줄부터 $N$개의 줄에 걸쳐 숫자, 영어 대소문자로만 구성된 문자열이 주어진다.

출력
줄마다 사용할 수 있는 비밀번호면 yes, 그렇지 않으면 no를 출력한다.



3
1245125
asdij
120318739721

yes
no
no

 */
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int testCase=0; testCase<t; testCase++) {
			String str = br.readLine();
			int strLeng = str.length();
			if(strLeng <6 || strLeng>9) {
				bw.write("no\n");
				continue;
			}
			
			bw.write("yes\n");
			
		}
		
		bw.flush();
		bw.close();
	}

}
