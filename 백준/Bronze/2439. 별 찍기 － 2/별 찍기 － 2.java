import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    
    public static void main(String[] args) throws Exception{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
         int num = Integer.parseInt(br.readLine());
        String result = "";
        
        for(int i=1; i<=num; i++){
            result = "";
            for(int j=0; j<num-i; j++){
                result+= " ";
            }    
            for(int j=0; j<i; j++){
                result += "*";
            }
            System.out.println(result);
        }
          
    }
}
