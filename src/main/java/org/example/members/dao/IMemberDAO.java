package org.example.members.dao;

import org.example.members.entity.Member;

import java.util.List;

public interface IMemberDAO {
    List<Member> search(String USERNUM);
    Member select(String USERID);
    List<Member> selectAll();
    int insert(Member member);
    int insertAll(List<Member> members);
    int delete(String USERID);
    int deleteAll();
}
