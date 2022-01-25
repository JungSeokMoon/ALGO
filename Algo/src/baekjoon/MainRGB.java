package baekjoon;

import java.io.*;
import java.util.*;

public class MainRGB{
    
    static class Node{
        int x;
        int y;
        String rgb;
        
        public Node(int x, int y, String rgb){
            this.x = x;
            this.y = y;
            this.rgb = rgb;
        }
    }
    
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static String result = "";
    private static int cnt = 0;
    private static boolean[][] isVisited;
    private static String[][] map;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        map = new String[n][n];
        
        for(int i=0; i<n; i++){
            map[i] = br.readLine().split("");
        }
        
        bfs(n);
        result += cnt + " ";
        init(n);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isVisited[i][j]) continue;
                cnt++;
                dfs(i,j,n);
            }
        }
        
        result += cnt;
        
        System.out.println(result);
    }
    
    public static void bfs(int n){
        Queue<Node> q = new LinkedList<Node>();
        isVisited = new boolean[n][n];
        
        q.add(new Node(0,0,map[0][0]));
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isVisited[i][j]) continue;
                q.add(new Node(i,j,map[i][j]));
                cnt++;
                while(!q.isEmpty()){
                    Node nd = q.remove();
                    String nd_rgb = nd.rgb;
                    
                    for(int m=0; m<4; m++){
                        int idx = dx[m] + nd.x;
                        int idy = dy[m] + nd.y;
                        
                        if(idx >=0 && idy >= 0 && idx <n && idy <n){
                            String rgb = map[idx][idy];
                            if(nd_rgb.equals(rgb) && !isVisited[idx][idy]){
                                isVisited[idx][idy] = true;
                                q.add(new Node(idx,idy, map[idx][idy]));
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void dfs(int x, int y, int n){
        String map_rgb = map[x][y];
        
        for(int m=0; m<4; m++){
            int idx = dx[m] + x;
            int idy = dy[m] + y;
            
            if(idx >= 0 && idy >= 0 && idx < n && idy < n ){
                String rgb = map[idx][idy];
                
                if(!isVisited[idx][idy] && map_rgb.equals(rgb)){
                    isVisited[idx][idy] = true;
                    dfs(idx,idy,n);
                }
            }
        }
    }
    
    public static void init(int n){
        cnt = 0;
        isVisited = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j].equals("G"))
                    map[i][j] = "R";
            }
        }
    }
    
}