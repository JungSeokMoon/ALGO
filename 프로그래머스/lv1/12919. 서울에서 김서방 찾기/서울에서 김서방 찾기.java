class Solution {
    public String solution(String[] seoul) {
      int leng = seoul.length;
        String str = "Kim";
        for(int i=0; i<leng; i++) {
        	if(seoul[i].equals(str)) {
        		return "김서방은 "+i+"에 있다";
        	}
        }
        
        return "";
    }
}