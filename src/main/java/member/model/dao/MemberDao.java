package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public int insertMember(Connection conn, Member member) {
		int result = 0;
        PreparedStatement pstmt = null;
        String query = "insert into member values(?,?,?,?,?,?,?,default,default,default,default,default)";
        
        try {
        	 pstmt = conn.prepareStatement(query);
        	 
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getUserName());
            pstmt.setString(4, member.getGender());
            pstmt.setInt(5, member.getAge());
            pstmt.setString(6, member.getPhone());
            pstmt.setString(7, member.getEmail());

            result = pstmt.executeUpdate();
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            close(pstmt);
        }


        return result;
		
	}

	public Member selectMember(Connection conn, String userid) {
	    Member member = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM MEMBER WHERE USERID = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userid);
            rset = pstmt.executeQuery();

            if(rset.next()){
            	member = new Member();

                //결과 매핑 : 컬럼값 꺼내서 필드에 옮기기
            	member.setUserId(userid);
                member.setUserPwd(rset.getString("USERPWD"));
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

	public int updateMember(Connection conn, Member member) {
		int result = 0;
        PreparedStatement pstmt = null;
        String query= "update member set age = ?, phone = ?, email =?, "
                + "lastmodified = sysdate where userid = ?";
        try {
        	pstmt = conn.prepareStatement(query);
        	 
            pstmt.setInt(1, member.getAge());
            pstmt.setString(2, member.getPhone());
            pstmt.setString(3,member.getEmail());
            pstmt.setString(4,member.getUserId());
            result = pstmt.executeUpdate();
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            close(pstmt);
        }
        return result;
	}

	public int deleteMember(Connection conn, String userid) {
		int result = 0;
        PreparedStatement pstmt = null;
        String query= "delete from member where userid = ?";
        try {
        	pstmt = conn.prepareStatement(query);
            pstmt.setString(1,userid);
            result = pstmt.executeUpdate();
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            close(pstmt);
        }
        return result;
	}

	public ArrayList<Member> selectList(Connection conn) {
        ArrayList<Member> list = new ArrayList<Member>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM MEMBER";

        try {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();

            while(rset.next()){
                Member member = new Member();

                //결과 매핑 : 컬럼값 꺼내서 필드에 옮기기
            	member.setUserId(rset.getString("USERID"));
                member.setUserPwd(rset.getString("USERPWD"));
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

                list.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;
	}

}
