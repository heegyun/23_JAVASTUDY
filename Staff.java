package day_05;
import static java.lang.System.out;
import java.util.Scanner;

public class Staff extends Person {

    private String dept; // 부서
    private String id;// 사번

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String personInfo() {
        String info=super.personInfo() +"\n사번: "+id +"\n부서: "+dept;
        return info;
    }
    @Override
    public void inputInfo() {
            super.inputInfo();
                //이름, 주소
        Scanner sc=new Scanner(System.in);
        out.println("사번을 입력하세요=>");
        String i=sc.nextLine();
        setId(i);
        out.println("부서를 입력하세요=>");
        String d=sc.nextLine();
        setDept(d);
    }
    @Override
    public void printAll() {
        out.println(this.personInfo());
    }

}
