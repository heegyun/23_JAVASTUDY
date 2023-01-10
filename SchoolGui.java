package day_07;

import day_05.SchoolApp;
import day_05.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolGui extends JFrame {

    // 업무 처리(비즈니스로직)처리 객체 생성
    SchoolApp schoolApp = new SchoolApp();
    Person person;

    JTextArea ta;
    JButton reg, del, find, print, save;
    //등록, 삭제, 검색, 출력, 저장
    JButton btStudent, btTeacher, btStaff, btFindOk,btFindClose;
    //학생, 		교사, 	직원,  		검색, 	검색종료
    JButton btOk, btCancel, btClose;

    JDialog dial1, dial2, dial3;
    //대화상자 3개 만들기...
    JLabel lbName, lbAddr, lbId, lbPub;
    JTextField tfName, tfAddr, tfId, tfPub, tfFindName;

    public SchoolGui(){
        super(":::학사관리 프로그램 v1.1:::");
        makeGui();

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500,500);
        setVisible(true);
    }//생성자-----------

    /**GUI를 구성하는 메소드*/
    public void makeGui() {
        ta = new JTextArea();
        add(ta, "Center");

        JPanel pn = new JPanel(new GridLayout(0, 1, 10, 10)) {
            //패널 바깥 여백을 설정하는 메소드 오버라이딩
            public Insets getInsets() {
                return new Insets(10, 10, 10, 10);
            }
        };
        //열은 1열로 고정시키고
        //행은 컴포넌트 부착하는 것에 따라
        //유동적으로..
        pn.setBackground(Color.orange);
        add(pn, "East");

        pn.add(reg = new JButton("등   록"));
        pn.add(find = new JButton("검  색"));
        pn.add(del = new JButton("삭   제"));
        pn.add(print = new JButton("출  력"));
        pn.add(save = new JButton("저  장"));

        //Dialog 1만들기
        dial1 = new JDialog(this, true);
        dial2 = new JDialog(this, true);
        dial3 = new JDialog(this, "**검색**", true);

        //dial1에 컴포넌트 부착---
        btStudent = new JButton("학생");
        btTeacher = new JButton("교사");
        btStaff = new JButton("직원");
        btClose = new JButton("닫기");

        dial1.setTitle("**등록**");
        dial1.setLayout(new GridLayout(1, 0));
        dial1.add(btStudent);
        dial1.add(btTeacher);
        dial1.add(btStaff);
        dial1.add(btClose);

        //dial2에 컴포넌트 부착---
        JPanel dp1 = new JPanel();
        JPanel dp2 = new JPanel();
        JPanel dp3 = new JPanel();
        dp1.setLayout(new GridLayout(4, 1));
        dp2.setLayout(new GridLayout(4, 1));

        dial2.add(dp1, "West");//라벨을 붙일 패널
        dial2.add(dp2, "Center");//텍스트필드 붙일 패널
        dial2.add(dp3, "South");//버튼 붙일 패널

        dp1.add(lbName = new JLabel("이름"));
        dp1.add(lbAddr = new JLabel("주소"));
        dp1.add(lbId = new JLabel("ID"));
        dp1.add(lbPub = new JLabel("기타"));

        dp2.add(tfName = new JTextField());
        dp2.add(tfAddr = new JTextField());
        dp2.add(tfId = new JTextField());
        dp2.add(tfPub = new JTextField());

        dp3.add(btOk = new JButton("처리"));
        dp3.add(btCancel = new JButton("취소"));

        //dial3에 검색 또는 삭제 관련 컴포넌트 부착
        JLabel lb = new JLabel("이름을 입력하세요");
        dial3.add(lb, "North");
        JPanel dp4 = new JPanel();
        dial3.add(dp4, "Center");
        tfFindName = new JTextField(20);
        dp4.add(tfFindName);
        btFindOk = new JButton("확인");
        btFindClose = new JButton("닫기");
        dp4.add(btFindOk);
        dp4.add(btFindClose);

        //리스너 부착------
        MyHandler my=new MyHandler();//이벤트 처리 클래스
        reg.addActionListener(my);
        find.addActionListener(my);
        del.addActionListener(my);
        print.addActionListener(my);
        save.addActionListener(my);

        btStudent.addActionListener(my);
        btTeacher.addActionListener(my);
        btStaff.addActionListener(my);
        btOk.addActionListener(my);
        btCancel.addActionListener(my);
        btClose.addActionListener(my);

        btFindOk.addActionListener(my);
        btFindClose.addActionListener(my);

        //ta를 편집 불가능하게끔...
        ta.setEditable(false);



    }//-------------------------------

    /**이벤트를 처리하는 클래스-Inner Member Class*/
    class MyHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if (o == reg) {//등록
                dial1.pack();
                //각 컴포넌트의 preferred size 만큼 압축하여
                //크기를 정한다.
                dial1.setLocation(500, 0);//x,y좌표(500,0)
                dial1.setVisible(true);

            } else if (o == find) {//검색
                dial3.setTitle("**검색**");
                dial3.pack();
                dial3.setVisible(true);

            } else if (o == del) {//삭제
                dial3.setTitle("**삭제**");
                dial3.pack();
                dial3.setVisible(true);

            } else if (o == print) {//출력
                String str = schoolApp.printAll();
                ta.append(str + "\n");

            } else if (o == save) {//저장
                //1>, 2>
                FileDialog fd
                        = new FileDialog(SchoolGui.this,
                        "파일저장", FileDialog.SAVE);
                fd.setVisible(true);
                //파일 경로 얻기
                String dir = fd.getDirectory();
                String file = fd.getFile();
                String filename = dir + file;
                setTitle(filename);

                try {
                    FileWriter fw = new FileWriter(filename);
                    String content = ta.getText();
                    //ta로부터 가져온 내용을 fw를 통해 쓴다.
                    fw.write(content);
                    fw.flush();
                    fw.close();
                    setTitle("저장 완료");
                    ta.append("저장 완료!!!->" + filename + "\n");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }else if(o==btStudent){//학생
                dial2.setTitle("**학생 등록**");
                lbId.setText("학번");
                lbPub.setText("학급");
                dial2.pack();
                dial2.setLocation(500,30);
                dial2.setVisible(true);

            }else if(o==btTeacher){//교사
                dial2.setTitle("**교사 등록**");
                lbId.setText("교번");
                lbPub.setText("과목");
                dial2.pack();
                dial2.setLocation(500, 30);
                dial2.setVisible(true);

            }else if(o==btStaff){//직원
                dial2.setTitle("**직원 등록**");
                lbId.setText("사번");
                lbPub.setText("부서");
                dial2.pack();
                dial2.setLocation(500, 30);
                dial2.setVisible(true);

            }else if(o==btOk){
                //사용자 정보 등록
                String name=tfName.getText();
                String addr=tfAddr.getText();
                String id=tfId.getText();

                String pub=tfPub.getText();
                //어떤 객체이냐에 따라 호출할 메소드가 달라진다.

                String title=dial2.getTitle();
                System.out.println(title);
                String word=title.substring(2, 4);
                //문자열 인덱스 2부터 4의 직전까지 잘라내어
                //돌려준다.
                System.out.println(word);
                if(word.equals("학생")){
                    person=new Student();
                    ((Student)person).setClassName(pub);
                }else if(word.equals("교사")){
                    person=new Teacher();
                    ((Teacher)person).setSubject(pub);
                }else if(word.equals("직원")){
                    person=new Staff();
                    ((Staff)person).setDept(pub);
                }
                person.setName(name);
                person.setAddr(addr);
                person.setId(id);
                ///////비즈니스 메소드///////////////
                schoolApp.addPerson(person);
                ////////////////////////////////////
                tfName.setText("");
                tfId.setText("");
                tfAddr.setText("");
                tfPub.setText("");

                //텍스트필드에 포커스가 가게끔..
                tfName.requestFocus();

            }else if(o==btCancel){//취소
                dial2.dispose();
                tfName.setText("");
                tfId.setText("");
                tfAddr.setText("");
                tfPub.setText("");

            }else if(o==btClose){
                //dial1 닫기
                dial1.dispose();

            }
            if(o==btFindOk){//검색(삭제)확인
                String title=dial3.getTitle();
                String word=title.substring(2, 4);
                //제목으로 검색 대화창인지 삭제 대화창인지
                //구별하기 위해 ..

                if(word.equals("검색")){
                    String name=tfFindName.getText();
                    ////////////////////////////////
                    String msg=schoolApp.findPerson(name);
                    ////////////////////////////////
                    ta.append(msg+"\n");
                }else{
                    String name=tfFindName.getText();
                    /////////////////////////////////
                    String msg=schoolApp.removePerson(name);
                    ////////////////////////////////
                    ta.append(msg+"\n");
                }
                tfFindName.setText("");

            }else if(o==btFindClose){//검색(삭제)창 닫기
                dial3.dispose();
            }

        }

    }//////////////////

    public static void main(String[] args) {
        new SchoolGui();

    }
}
