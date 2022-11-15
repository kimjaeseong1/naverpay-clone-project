package org.example.members.service;

import org.example.members.dto.MemberDTO;

import java.util.List;

public interface IMemberService {
    MemberDTO login(String USERID);
    MemberDTO login(String USERID, String USERPWD);
    boolean autoLogin(String autoLogin, String cookieId);
    List<MemberDTO> findByUserId(String USERID);
    MemberDTO getByUserId(String USERID);
    List<MemberDTO> getAllUsers();
}
