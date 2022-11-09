package org.example.members.dto;

import org.example.members.entity.Member;
import org.example.members.vo.MemberVO;

public class MemberDTO {
    private int USERNUM;
    private String USERID = "";
    private String USERPWD = "";

    public MemberDTO() {

    }

    public MemberDTO(String USERID) {
        this.USERID = USERID;
    }

    public MemberDTO(String USERID, String USERPWD) {
        this.USERID = USERID;
        this.USERPWD = USERPWD;
    }

    public MemberDTO(int USERNUM, String USERID, String USERPWD) {
        this.USERNUM = USERNUM;
        this.USERID = USERID;
        this.USERPWD = USERPWD;
    }

    public Member toEntity() {
        return new Member(USERID,USERPWD);
    }

    public MemberVO toVO() {
        return new MemberVO(USERNUM,USERID);
    }

    public int getUSERNUM() {
        return USERNUM;
    }

    public void setUSERNUM(int USERNUM) {
        this.USERNUM = USERNUM;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getUSERPWD() {
        return USERPWD;
    }

    public void setUSERPWD(String USERPWD) {
        this.USERPWD = USERPWD;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "USERNUM=" + USERNUM +
                ", USERID='" + USERID + '\'' +
                ", USERPWD='" + USERPWD + '\'' +
                '}';
    }
}
