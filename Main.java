package day05;
// 객체 미 사용
// 문제점 : 캐릭터가 늘어 날 수록 변수가 늘어나야 함
public class Main { // 기본타입 변수로 처리
    public static void main(String[] args) {
        int char1_no = 1;
        int char1_age = 20;
        int char1_jumin = 1234;
        int char1_attackPoint = 50;
        String char1_name =  "홍길동";
        introduce(char1_no, char1_age, char1_jumin, char1_attackPoint, char1_name);

        int char2_no = 2;
        int char2_age = 20;
        int char2_jumin = 1235;
        int char2_attackPoint = 100;
        String char2_name =  "이길순";
        introduce(char2_no, char2_age, char2_jumin, char2_attackPoint, char2_name);

    }
    static void introduce(int no, int age, int jumin, int attackPoint, String name){
        System.out.println("====캐릭터 소개====");
        System.out.printf("번호 : %d\n", no);
        System.out.printf("나이 : %d\n", age);
        System.out.printf("주민 : %d\n", jumin);
        System.out.printf("공격 : %d\n", attackPoint);
        System.out.printf("이름 : %s\n", name);
    }
}

class 캐릭터{

}