package org.example.members.vo;

import java.util.Objects;

public class MemberVO {
    private int USERNUM;
    private String USERID = "";
    private String USERPWD = "";

    public MemberVO() {

    }

    public MemberVO(int USERNUM, String USERID) {
        this.USERNUM = USERNUM;
        this.USERID = USERID;
    }

    public MemberVO(int USERNUM, String USERID, String USERPWD) {
        this.USERNUM = USERNUM;
        this.USERID = USERID;
        this.USERPWD = USERPWD;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberVO memberVO = (MemberVO) o;
        return USERNUM == memberVO.USERNUM && Objects.equals(USERID, memberVO.USERID) && Objects.equals(USERPWD, memberVO.USERPWD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(USERNUM, USERID, USERPWD);
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "USERNUM=" + USERNUM +
                ", USERID='" + USERID + '\'' +
                ", USERPWD='" + USERPWD + '\'' +
                '}';
    }
}
