import java.util.ArrayList;

/**
 *  Stream foreach vs for loop 시간 비교
 *
 *                  ArrayList<Integer>
 *
 *                       100000개  1000000개  20000000개
 *
 *  for                   0.0       0.0       0.004
 *  stream - foreach      0.039     0.071     0.069
 *  list - foreach        0.015     0.015     0.039
 *
 *                  ArraysList<String>
 *
 *                       100000개  1000000개  20000000개
 *
 *  for                   0.001     0.003     0.016
 *  stream - foreach      0.045     0.053     5.709
 *  list - foreach        0.006     0.462     0.285   ? ? ?
 */
public class StreamVsForloop {


    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20000000; i++) {
            list.add(String.valueOf(i));
        }


        Long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        Long end = System.currentTimeMillis();

        System.out.println("리스트 포문 -->"+(end-start)/1000.0+"초");

        start = System.currentTimeMillis();

        list.stream().forEach(n-> n += 1);

        end = System.currentTimeMillis();

        System.out.println("리스트 스트림 포이치 -->"+(end-start)/1000.0+"초");

        start = System.currentTimeMillis();

        list.forEach(n -> n += 1);

        end = System.currentTimeMillis();

        System.out.println("리스트 포이치 -->"+(end-start)/1000.0+"초");
    }


}
