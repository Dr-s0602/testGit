package member.model.service;
import member.model.vo.Member;
import member.model.dao.MemberDao;

import static common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
    private MemberDao memberDao = new MemberDao();

    public MemberService() {
    }
    public Member selectLogin(String userid, String userpwd){
        Connection conn = getConnection();
        Member loginMember = memberDao.selectLogin(conn, userid, userpwd);
        close(conn);
        return loginMember;
    }
}
