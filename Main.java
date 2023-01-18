package org.example;


import java.sql.Date;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        MemberDAO memberDAO = new MemberDAO();


        Date date  = new Date(System.currentTimeMillis());
        String birth = date.toString();
        //System.out.println(birth);


        MemberDTO member1 = new MemberDTO(201505,"이길동","정보통신과",birth ,"lee@hoho.com","010-333-3333");
//////////////////////
        boolean result = memberDAO.InsertData(member1);

        if(result){
            System.out.println("입력 성공");
        }else{
            System.out.println("입력 실패");
        }



       // try {
            //1.드라이버 로딩
            //Class.forName("com.mysql.cj.jdbc.Driver");

            //2. 데이터베이스 연결
            // jdbc url
           // String url="jdbc:mysql://localhost:3306/javastudy";
            //Connection connection = DriverManager.getConnection(url,"root","1234");

            //3 Statement 생성 (PreparedStatement 객체생성)
            //Statement statement = connection.createStatement();

            // 데이터 조회 쿼리...
           // String sql2 = "SELECT * FROM member " ;
            // 데이터 삭제 쿼리...
            // String sql3 = "DELETE FROM member WHERE id = 201504";
            // 데이서 수정 쿼리...
            //String sql4 = "UPDATE FROM member SET username='이기쁨'  WHERE id = 201501";


            // 데이터 입력 쿼리...
            // String sql = "INSERT INTO member VALUES " +
            //         "(201504,'박길동','컴퓨터공학과','2000-01-15','park@hoho.com','010-111-1111');";

            // PreparedStatement pst = connection.prepareStatement(sql);
            //PreparedStatement pst = connection.prepareStatement(sql2);

            //4.Statement 실행
            //  int result = pst.executeUpdate();

            // 조회 실행 및 결과 받기
            //ResultSet resultSet = pst.executeQuery();

            //5. 결과받기
//            if(result > 0){
//                System.out.println("입력 성공~~");
//            }else{
//                System.out.println("입력 실패~~");
//            }

            // 조회 결과 무한반복
//            while(resultSet.next()!=false){
//
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("username");
//                Date date = resultSet.getDate("birth");
//                String birth = date.toString();
//                String dept = resultSet.getString("dept");
//                String email = resultSet.getString("email");
//                String tel = resultSet.getString("tel");
//
//                System.out.printf("학번:%d, 이름:%s, 학과:%s, 생일:%s, 이메일:%s, 전화번호:%s",id,name,dept,birth,email,tel );
//                System.out.println("");
//
//
//            }
//            System.out.println("조회 완료");



            //6. 연결 해제
//            connection.close();
//            pst.close();


    //    }catch (Exception e){
     //       System.out.println("데이테베이스 드라이버 로딩 실패");
    //    }
    }
}