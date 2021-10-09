import java.util.*;
public class wow {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        List<Integer> randomList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        
        int addChar = 16 - 10;
            for (int i = 0; i < addChar; i++) {
                randomList.add(i + 97);
            }
            Collections.shuffle(randomList);

            
            while (randomList.get(0) == 0) {
                Collections.shuffle(randomList);
            }
            for (int i = 0; i < 4; i++) {
                if (randomList.get(i) > 96) {
                    sb.append(Character.toString(randomList.get(i)));
                } else {
                    sb.append(randomList.get(i));
                }
            }
        System.out.print(sb);
    }
}
