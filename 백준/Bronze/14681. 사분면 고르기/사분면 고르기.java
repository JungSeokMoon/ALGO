import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
/*

12
5

1
 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		if(x>0 && y>0) {
			bw.write("1");
		}else if(x<0 && y>0) {
			bw.write("2");
		}else if(x<0 && y<0) {
			bw.write("3");
		}else if(x>0 && y<0) {
			bw.write("4");
		}
		
		bw.flush();
		bw.close();

	}

}
