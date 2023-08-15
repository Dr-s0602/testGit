package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.model.vo.Member;
import static common.JDBCTemplate.close;

public class MemberDao {

	public Member selectLogin(Connection conn, String userid, String userpwd) {
		Member member = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM MEMBER WHERE USERID = ? AND USERPWD = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userid);
            pstmt.setString(2, userpwd);
            rset = pstmt.executeQuery();

            if(rset.next()){
            	member = new Member();
            	member.setUserId(userid);
            	member.setUserPwd(userpwd);
            	member.setUserName(rset.getString("USERNAME"));
                member.setGender(rset.getString("GENDER"));
            	member.setAge(rset.getInt("AGE"));
            	member.setPhone(rset.getString("PHONE"));
            	member.setEmail(rset.getString("EMAIL"));
            	member.setEnrollDate(rset.getDate("ENROLL_DATE"));
            	member.setLastModified(rset.getDate("LASTMODIFIED"));
                member.setSignType(rset.getString("SIGNTYPE"));
            	member.setAdmin(rset.getString("ADMIN"));
                member.setLoginOk(rset.getString("LOGIN_OK"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return member;
	}

}
