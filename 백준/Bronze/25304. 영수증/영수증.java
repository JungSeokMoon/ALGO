import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
/*


출력
구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes를 출력한다. 일치하지 않는다면 No를 출력한다.

260000
4
20000 5
30000 2
10000 6
5000 8

Yes

250000
4
20000 5
30000 2
10000 6
5000 8

No
 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int total = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		
		long sum = 0L;
		String[] str;
		for(int i=0; i<cnt; i++) {
			str = br.readLine().split(" ");
			
			sum += (Integer.parseInt(str[0]) * Integer.parseInt(str[1]));
		}
		
		if(total == sum) {
			bw.write("Yes");
		}else {
			bw.write("No");
		}

		bw.flush();
		bw.close();
	}

}
