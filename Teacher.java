package day_05;

import java.util.Scanner;

import static java.lang.System.out;

public class Teacher extends Person {

    private String tId; // 교번
    private String subject; // 과목

    @Override
    public String getId() {
        return tId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setId(String id) {
        tId = id;
    }

    public String personInfo() {
        String info=super.personInfo() +"\n사번: "+tId +"\n부서: "+subject;
        return info;
    }
    @Override
    public void inputInfo() {
        super.inputInfo();
        //이름, 주소
        Scanner sc=new Scanner(System.in);
        out.println("교번을 입력하세요=>");
        String i=sc.nextLine();
        setId(i);
        out.println("담당과목을 입력하세요=>");
        String d=sc.nextLine();
        setSubject(d);
    }
    @Override
    public void printAll() {
        out.println(this.personInfo());
    }
}
