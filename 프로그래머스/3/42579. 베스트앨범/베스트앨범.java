import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> songMap = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.putIfAbsent(genres[i], new ArrayList<>());
            songMap.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((a, b) -> 
                      genreMap.get(b) - genreMap.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for (String s : genreList) {
            List<int[]> songs = songMap.get(s);
            songs.sort((a, b) -> {
                      if (a[1] == b[1]) return a[0] - b[0];
                      return b[1] - a[1];
                          });
            
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i)[0]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}