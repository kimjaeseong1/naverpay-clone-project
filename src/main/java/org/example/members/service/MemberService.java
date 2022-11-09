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
    public MemberDTO login(String USERID) {
        MemberDTO memberDTO = new MemberDTO(USERID);
        if (memberDTO == null) return null;

        Member member = memberDAO.select(memberDTO.getUSERID());
        return member.toDTO();
    }

    @Override
    public MemberDTO login(String USERID, String USERPWD) {
        MemberDTO memberDTO = new MemberDTO(USERID,USERPWD);
        if (memberDTO == null) return null;

        Member member = memberDAO.select(memberDTO.getUSERID());
        if (member == null || member.getUSERPWD() == null) return null;
        if (member.getUSERPWD().equals(memberDTO.getUSERPWD())) {
            return memberDTO;
        }
        return null;
    }

    @Override
    public boolean autoLogin(String autoLogin, String cookieId) {
        if (autoLogin == null || cookieId == null) return false;

        if (autoLogin.equals("true")) {
            if (getByUserId(cookieId) != null) {
                MemberDTO memberDTO = login(cookieId);
                return memberDTO != null;
            }
        }

        return false;
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
