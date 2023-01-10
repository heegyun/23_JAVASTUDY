package day_05;

import java.util.Scanner;

public class Student extends Person {

    private String sID; //학번
    private String className;// 과목


    // personInfo() 메소드 오버라이딩
    public String personInfo(){
       String info= super.personInfo();// 이름, 주소가 리턴된다.
        info += "\n학번: " + sID + "\n수강과목: " + className;
        return  info;
    }

    @Override
    public String getId() {
        return sID ;
    }

    @Override
    public void setId(String id) {
        sID = id;
    }

    // inputInfo() 메소드 오버라이딩
    public void inputInfo(){
        ////////////////////////
        super.inputInfo();
        ///////////////////////
        System.out.println("학번을 입력하세요=>");
        Scanner sc=new Scanner(System.in);
        String sid=sc.nextLine();
        setId(sid);//멤버 변수에 입력값을 저장

        System.out.println("수강과목을 입력하세요=>");
        String cn=sc.nextLine();
        setClassName(cn);//멤버 변수에 입력값을 저장
    }//-------------

//    public String getsID() {
//        return sID;
//    }
//
//    public void setsID(String sID) {
//        this.sID = sID;
//    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
