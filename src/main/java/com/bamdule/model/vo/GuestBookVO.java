package com.bamdule.model.vo;

/**
 *
 * @author MW
 */
public class GuestBookVO {

    private Integer no;      // PK
    private String name;    // 이름
    private String pwd;      // 비밀번호
    private String content; // 내용
    private String regDate; // 등록일

    public GuestBookVO() {
    }

    public GuestBookVO(String name, String pwd, String content, String regDate) {
        this.name = name;
        this.pwd = pwd;
        this.content = content;
        this.regDate = regDate;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "GuestBookVO{" + "no=" + no + ", name=" + name + ", pwd=" + pwd + ", content=" + content + ", regDate=" + regDate + '}';
    }

}
