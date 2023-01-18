package org.example;

import java.sql.*;

public class MemberDAO {

    static Connection connection = null;
    PreparedStatement preparedStatement = null;
    String url ="jdbc:mysql://localhost:3306/javastudy";

    String userId = "root";
    String pwd ="1234";


    public  MemberDAO() throws  ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("드라이버 로딩 성공");
    }

    // 1. DB 연결(Connection) 객체 생성 메소드
    Connection DBConnection(){
        try{
            connection = DriverManager.getConnection(url, userId, pwd);
            System.out.println("연결 성공~");
            return connection;
        }catch(SQLException sqlException){
            System.out.println("연결 실패!");
        }
        return null;
    }

    // 2. 회원 데이터 입력 메소드
    boolean InsertData(MemberDTO member){
        // 데이터베이스 연결 먼저 하기
        DBConnection();

        boolean result = false;

        String sql ="INSERT INTO member VALUES (?,?,?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            // ? 즉 인파라미터 셋팅 하기
            preparedStatement.setInt(1, member.getId());
            preparedStatement.setString(2, member.getUsername());
            preparedStatement.setString(3,member.getDept());
            preparedStatement.setString(4,member.getBirth());
            preparedStatement.setString(5, member.getEmail());
            preparedStatement.setString(6, member.getTel());

            //  셋팅 완료 후 쿼리 전송 후 결과 리턴 하기(성공 0보다 큰값->true,아니면 false->)
            int n = preparedStatement.executeUpdate();

            // 결과 리턴 하기
            if (n > 0) {
                //System.out.println("입력 성공");
                result = true;
            }else{
                //System.out.println("입력 실패");
                result = false;
            }
        }catch (SQLException sqlException){
            System.out.println("입력 데이터 오류");
        }
        return result;
    }



}
