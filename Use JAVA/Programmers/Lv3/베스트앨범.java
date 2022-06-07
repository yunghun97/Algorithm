package Programmers.Lv3;

import java.util.*;
import java.util.Map.Entry;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, PriorityQueue<Music>> hmap = new HashMap<>();
        HashMap<String, Integer> albumHmap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            if (albumHmap.containsKey(genres[i])) { // 장르별 카운트
                albumHmap.put(genres[i], albumHmap.get(genres[i]) + plays[i]);
            } else {
                albumHmap.put(genres[i], plays[i]);
            }
            if (hmap.containsKey(genres[i])) { // 해당 장르에서 곡 재생 카운트
                hmap.get(genres[i]).add(new Music(i, plays[i]));
            } else { // 처음일 때
                hmap.put(genres[i], new PriorityQueue<>((o1, o2) -> {
                    if (o1.count == o2.count) {
                        return Integer.compare(o1.num, o2.num);
                    } else {
                        return Integer.compare(o2.count, o1.count);
                    }
                }));
                hmap.get(genres[i]).add(new Music(i, plays[i]));
            }
        } // for문 끝
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Album> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));

        for (Entry<String, Integer> entry : albumHmap.entrySet()) { // 장르별로 재생 횟수 pq에 넣기
            pq.add(new Album(entry.getKey(), entry.getValue()));
        }

        while (!pq.isEmpty()) { // 많이 나온 장르별로 2개씩 뽑기
            Album album = pq.poll();
            PriorityQueue<Music> pq2 = hmap.get(album.name); // 해당 장르에서 곡 재생 개수 가져오기
            for (int i = 0; i < 2; i++) { // 2개씩
                Music music = pq2.poll();
                list.add(music.num);
                if (pq2.isEmpty())
                    break; // 해당 곡이 1개 뿐이면 break;
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static class Music {
        int num;
        int count;

        public Music(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static class Album {
        String name;
        int count;

        public Album(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
