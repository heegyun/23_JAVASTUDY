package org.example;

public class MemberDTO {
    private int id;
    private String username;
    private String dept;
    private String birth;
    private String email;
    private String tel;

    public MemberDTO(){

    }
    public MemberDTO(int id, String username, String dept, String birth, String email, String tel) {
        this.id = id;
        this.username = username;
        this.dept = dept;
        this.birth = birth;
        this.email = email;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
