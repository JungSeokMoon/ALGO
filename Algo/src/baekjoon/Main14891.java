package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main톱니바퀴 {

	static int select = 0; // 선택
	static int dist = 0; // 방향
	static int sum = 0;
	static int[] score = {1,2,4,8};
	static ArrayList<ArrayList<Integer>> nsList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		sum=0;
		nsList = new ArrayList<>();;
		String[] str;
		for(int i=0; i<4; i++) {
			nsList.add(new ArrayList<>());
			
			str = br.readLine().split("");
			for(int j=0; j<8; j++) {
				nsList.get(i).add(Integer.parseInt(str[j]));
			}
			
		}
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for(int i=0; i<testCase; i++) {
			str = br.readLine().split(" ");
			
			select = Integer.parseInt(str[0])-1;
			dist = Integer.parseInt(str[1]);
			
			rotation();
		}
		
		for(int i=0; i<4; i++) {
			if(nsList.get(i).get(0) == 1) {
				sum += score[i];
			}
		}
		
		bw.write(sum+"");
		
		//  for(int i=0; i<4; i++) { bw.write(nsList.get(i).toString()+"\n"); }
		 
		bw.flush();
		bw.close();
	}
	
	public static void rotation() {
		int pair_one = nsList.get(select).get(2); // 3시방향
		int pair_two = nsList.get(select).get(6); // 9시방향
		
		boolean rotation = dist ==1 ? true : false;  // : true : 시계방향, false : 반시계방향
		boolean temp = rotation;
		list_rotation(select,rotation);
		rotation = !rotation;
		for(int i=select-1; i>=0; i--) {
			if(nsList.get(i).get(2) != pair_two) {
				pair_two = nsList.get(i).get(6);
				list_rotation(i,rotation);
				rotation = !rotation;
			}else {
				break;
			}
		}
		
		rotation = !temp;
		for(int i=select+1; i<4; i++) {
			if(nsList.get(i).get(6) != pair_one) {
				pair_one = nsList.get(i).get(2);
				list_rotation(i,rotation);
				rotation = !rotation;
			}else {
				break;
			}
		}
		
	}
	
	public static void list_rotation(int index, boolean flag) {
		// true : 시계방향 , false : 반시계방향
		if(flag) {
			nsList.get(index).add(0,nsList.get(index).remove(7));
		}
		else {
			nsList.get(index).add(nsList.get(index).remove(0));
			
		}
		
	}

}
