package BackTracking;

class Programmers_피로도 {
    static int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        explore(k, dungeons, visited, 0);
        
        return result;
    }
    
    // [최소 피로도, 소모 피로도] >=
    static void explore(int k, int[][] dungeons, boolean[] visited, int cur){
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue; // 방문했으면 패스
            
            if(k >= dungeons[i][0]){
                visited[i] = true;
                result = Math.max(result, cur + 1); // 방문 횟수 갱신
                explore(k - dungeons[i][1], dungeons, visited, cur + 1); // 방문
                visited[i] = false;
            }
            
        }
    }
}
