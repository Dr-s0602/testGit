package member.model.service;
import member.model.vo.Member;
import member.model.dao.MemberDao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

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
	public Member selectMember(String userid) {
		 Connection conn = getConnection();
	        Member Member = memberDao.selectMember(conn, userid);
	        close(conn);
	        return Member;
	}
	public int updateMember(Member member) {
		Connection conn = getConnection();
        int result = memberDao.updateMember(conn, member);
        if(result > 0){
            commit(conn);
        }else{
            rollback(conn);
        }
        close(conn);
        return result;
	}
	public int deleteMember(String userid) {
		Connection conn = getConnection();
        int result = memberDao.deleteMember(conn, userid);
        if(result > 0){
            commit(conn);
        }else{
            rollback(conn);
        }
        close(conn);
        return result;
	}
	public ArrayList<Member> selectList() {
		 Connection conn = getConnection();
	        ArrayList<Member> memberList = memberDao.selectList(conn);
	        close(conn);
	        return memberList;
	}

}
