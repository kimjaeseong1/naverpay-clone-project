package org.example.members.service;

import org.example.members.dao.MemberDAO;
import org.example.members.dto.MemberDTO;
import org.example.members.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService implements IMemberService{

    private MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public MemberDTO login(String USERID, String USERPWD) {
        Member member = memberDAO.select(USERID);
        if (member == null || member.getUSERPWD() == null) return null;
        MemberDTO memberDTO = new MemberDTO(member.getUSERNUM(), USERID, USERPWD);


        if (member.getUSERPWD().equals(memberDTO.getUSERPWD())) {
            return memberDTO;
        }
        return null;
    }

    @Override
    public List<MemberDTO> findByUserId(String USERID) {
        if (USERID == null) return null;

        List<Member> memberList = memberDAO.search(USERID);
        return memberList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public MemberDTO getByUserId(String USERID) {
        if (USERID == null) return null;

        Member member = memberDAO.select(USERID);
        if (member == null) return null;

        return member.toDTO();
    }

    @Override
    public List<MemberDTO> getAllUsers() {
        List<Member> memberList = memberDAO.selectAll();
        return memberList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }
}
