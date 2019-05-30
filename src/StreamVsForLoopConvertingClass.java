import java.util.ArrayList;
import java.util.List;


/**
 *  Stream foreach vs for loop 클래스 변환 비교
 *
 *                  ArrayList<Member> -> ArrayList<MemberDto>
 *
 *                       100000개  1000000개  5000000개
 *
 *  for                   0.005     0.022     0.215
 *  stream - foreach      0.045     0.454     0.542
 *
 */
public class StreamVsForLoopConvertingClass {


    public static void main(String[] args) {

        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 5000000; i++) {
            members.add(new Member("a".concat(String.valueOf(i)),i,String.valueOf(i)));
        }

        List<MemberDto> memberDtos = new ArrayList<>();

        Long start = System.currentTimeMillis();

        members.stream().map(MemberDto::new).forEach(memberDtos::add);

        Long end = System.currentTimeMillis();

        System.out.println("stream 컨버팅 시간"+(end-start)/1000.0+"초");


        start = System.currentTimeMillis();

        List<MemberDto> memberDtos1 = new ArrayList<>();

        for (int i = 0; i < members.size() ; i++) {

            memberDtos1.add(new MemberDto(members.get(i)));

        }

        end = System.currentTimeMillis();

        System.out.println("for loop 컨버팅 시간"+(end-start)/1000.0+"초");
    }
    static class Member{

        private String name;
        private int age;
        private String add;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAdd() {
            return add;
        }
        public Member(String name,int age,String add){
            this.name = name;
            this.age = age;
            this.add = add;
        }
    }
    static class MemberDto{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
        public MemberDto(Member member){
            this.name = member.getName();
            this.age = member.getAge();

        }


    }


}
