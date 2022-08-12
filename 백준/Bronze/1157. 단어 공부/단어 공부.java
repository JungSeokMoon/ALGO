import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

Mississipi

?

zZa
Z

z
Z

baaa
A
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = (br.readLine()).toLowerCase();
		
		int size = str.length();
		
		int[] alphbat = new int[26];
		for(int i=0; i<size; i++) {
			alphbat[str.charAt(i)-'a']++;
		}
		
		int max = Integer.MIN_VALUE;
		int flag = 0;
		char idx = 0;
		for(int i=0; i<26; i++) {
			if(alphbat[i] > max) {
				max = alphbat[i];
				idx = (char) (i+'a');
				flag = 0;
			}else if(alphbat[i] == max && alphbat[i] != 0){
				flag = 1;
			}
			
			
			
		}
		
		if(flag == 1) {
			System.out.println("?");
		}else {
			System.out.println(String.valueOf(idx).toUpperCase());
		}
		
		
	}
}
