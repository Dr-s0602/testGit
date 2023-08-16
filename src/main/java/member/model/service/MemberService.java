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
    public int insertMember(Member member){
        
        Connection conn = getConnection();
        int result = memberDao.insertMember(conn, member);
        if(result > 0){
            commit(conn);
        }else{
            rollback(conn);
        }

        close(conn);

        return result;
    }
}
