import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 *  다양한 Stream 생성 방식 연습
 */
public class StreamCreateExample {

    public static void main(String[] args) {


        // string 배열 스트림 생성
        System.out.println("Arrays.stream 으로 생성");
        Arrays.stream(new String[]{"a", "b", "c"})
                .forEach(System.out::print);

        next();

        // 빌더로 생성 직접적으로 원하는 값 넣을 수 있음
        System.out.println("Stream.builder 로 생성");
        Stream.Builder<String> stringBuilder = Stream.builder();
        Stream<String> stringStream =
                stringBuilder.add("a")
                        .add("b")
                        .add("c")
                        .build();

        stringStream.forEach(System.out::print);

        next();

        // int 배열 스트림 생성
        System.out.println("int 배열 스트림");
        Arrays.stream(new int[]{1, 2, 3})
                .forEach(System.out::print);

        next();

        // 빌더로 생성 직접적으로 원하는 값 넣을 수 있음
        System.out.println("Stream.builder 로 생성");
        Stream.Builder<Integer> integerBuilder = Stream.builder();
        Stream<Integer> integerStream =
                integerBuilder.add(3)
                .add(4)
                .add(2)
                .build();

        integerStream.forEach(System.out::print);

        next();

        // generate 로 생성 Supplier<T> 에 해당하는 람다식 인자 x 리턴값만 있음
        // generate 로 생성할때 스트림 크기가 무제한이어서 limit 으로 크기 제한을 해야함
        System.out.println("Stream.generate 로 생성");
        Stream<String> generatedStream = Stream.generate(()-> "generate").limit(3);
        generatedStream.forEach(System.out::print);


        next();

        // iterate 로 생성
        // iterate 로 생성할때 스트림 크기가 무제한이어서 limit 으로 크기 제한을 해야함
        System.out.println("Stream.iterate 로 생성");
        Stream<Integer> iteratedStream = Stream.iterate(30,integer -> integer + 3).limit(10);

        iteratedStream.forEach(System.out::print);

        next();

        // List  , Stream   Integer 생성시간 비교
        List<Integer> integerList = new ArrayList<>();
        Long startList = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            integerList.add(i);
        }
        Long endList = System.currentTimeMillis();

        System.out.println("List 생성 시간 -> "+(endList-startList)/1000.0+"초");

        Long startStream = System.currentTimeMillis();
        //Stream<Integer> stream = Stream.iterate(0,integer -> integer + 1).limit(10000000);

        IntStream stream = IntStream.range(0,10000000);
        Long endStream = System.currentTimeMillis();

        System.out.println("Stream 생성 시간 -> "+(endStream-startStream)/1000.0+"초");

        Long startReadStream = System.currentTimeMillis();
        System.out.println(stream.average());
        Long endReadStream = System.currentTimeMillis();
        System.out.println("스트림 읽는시간 ->"+(endReadStream-startReadStream)/1000.0+"초");

    }



    private static void next() {

        System.out.println();
        System.out.println("========================");
        System.out.println();
    }
}
