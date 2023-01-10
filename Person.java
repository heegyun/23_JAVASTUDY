package day_05;
import java.util.Scanner;
public abstract class Person { // 추상 클래스 : 1개의 추상 메소드를 갖고 있어야 함..

    private String name; // 이름
    private String addr; // 주소
    private String id; //

    // 추상 메소드 정의.....
    public abstract String getId() ;
    public abstract void setId(String id) ;

    // 기본 생성자
    public Person(){}

    // 인자 생성자
    public Person(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**사람 정보를 입력받는 모듈*/
    public void inputInfo(){
        System.out.println("이름을 입력하세요=>");
        Scanner sc=new Scanner(System.in);
        String nm=sc.nextLine();
        setName(nm);//멤버 변수에 입력값을 저장

        System.out.println("주소를 입력하세요=>");
        String ad=sc.nextLine();
        setAddr(ad);//멤버 변수에 입력값을 저장
    }//-------------

    /**사람의 정보를 문자열로 반환해주는 메소드* */
    public String personInfo(){
        String info="이름: "+name+"\n주소: "+addr;
        return info;
    }

    /**사람 정보를 콘솔에 출력해주는 메소드*/
    public void printAll(){
        System.out.println(this.personInfo());
    }

    public String toString(){
        return name;
    }

}
