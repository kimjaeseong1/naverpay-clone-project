package org.example.members.entity;

import org.example.members.dto.MemberDTO;

public class Member {
    private int USERNUM;
    private String USERID = "";
    private String USERPWD = "";

    public Member() {

    }

    public Member(String USERID, String USERPWD) {
        this.USERID = USERID;
        this.USERPWD = USERPWD;
    }

    public Member(int USERNUM, String USERID, String USERPWD) {
        this.USERNUM = USERNUM;
        this.USERID = USERID;
        this.USERPWD = USERPWD;
    }

    public MemberDTO toDTO() {
        return new MemberDTO(USERNUM,USERID,USERPWD);
    }

    public int getUSERNUM() {
        return USERNUM;
    }

    public String getUSERID() {
        return USERID;
    }

    public String getUSERPWD() {
        return USERPWD;
    }

    @Override
    public String toString() {
        return "Member{" +
                "USERNUM=" + USERNUM +
                ", USERID='" + USERID + '\'' +
                ", USERPWD='" + USERPWD + '\'' +
                '}';
    }
}
