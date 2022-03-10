package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10951 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		String[] str;
		while((st = br.readLine()) != null) {
			
			str = st.split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			System.out.println(a+b);
			
		}

	}

}
