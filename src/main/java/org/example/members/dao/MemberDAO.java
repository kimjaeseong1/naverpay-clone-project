package org.example.members.dao;

import org.example.database.JDBCMgr;
import org.example.members.entity.Member;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class MemberDAO implements IMemberDAO{
    private static MemberDAO memberDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String MEMBER_SEARCH = "select * from USERINFO where USERID like ?";
    private static final String MEMBER_SELECT = "select * from USERINFO where USERID = ?";
    private static final String MEMBER_SELECT_ALL = "select * from USERINFO";
    private static final String MEMBER_INSERT = "insert into USERINFO values(?, ?, ?)";
    private static final String MEMBER_DELETE = "delete USERINFO where USERID = ?";
    private static final String MEMBER_DELETE_ALL = "delete USERINFO";

    public static MemberDAO getInstance() {
        if (memberDAO == null) {
            memberDAO = new MemberDAO();
        }
        return memberDAO;
    }

    @Override
    public List<Member> search(String USERID) {
        List<Member> memberList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SEARCH);
            stmt.setString(1,  USERID);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int USERNUM = rs.getInt("USERNUM");
                String UID = rs.getString("USERID");
                String USERPWD = rs.getString("USERPWD");

                memberList.add(new Member(USERNUM, UID, USERPWD));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }

        return memberList;
    }

    @Override
    public Member select(String USERID) {
        Member member = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, USERID);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int USERNUM = rs.getInt("USERNUM");
                String UID = rs.getString("USERID");
                String USERPWD = rs.getString("USERPWD");

                member = new Member(USERNUM, UID, USERPWD);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return member;
    }

    @Override
    public List<Member> selectAll() {
        List<Member> memberList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int USERNUM = rs.getInt("USERNUM");
                String UID = rs.getString("USERID");
                String USERPWD = rs.getString("USERPWD");

                memberList.add(new Member(USERNUM, UID, USERPWD));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return memberList;
    }

    @Override
    public int insert(Member member) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setInt(1, member.getUSERNUM());
            stmt.setString(2, member.getUSERID());
            stmt.setString(3, member.getUSERPWD());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int insertAll(List<Member> members) {
        return members.stream().map(m -> memberDAO.insert(m)).collect(Collectors.toList()).stream().reduce((x, y) -> x + y).orElse(0);
    }

    @Override
    public int delete(String USERID) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setString(1, USERID);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int deleteAll() {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE_ALL);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }
}
