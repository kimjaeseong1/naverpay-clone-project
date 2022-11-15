package org.example.members.dao;

import org.example.members.entity.Member;

public class MemberDAOTest {
    private MemberDAO memberDAO = MemberDAO.getInstance();

    public void addMembers() {
        int res = memberDAO.deleteAll();
        if (res == 0) return;

        int count = 1;
        for (int i = 'a'; i <= 'z'; i++) {
            memberDAO.insert(new Member(count, Character.toString(i),Character.toString(i) + "1234"));
            count ++;
        }

        memberDAO.selectAll().stream().forEach(m -> System.out.println(m));
    }

    public static void main(String[] args) {
        new MemberDAOTest().addMembers();
    }
}
