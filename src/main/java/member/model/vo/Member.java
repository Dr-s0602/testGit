package member.model.vo;


import java.sql.Date;

//vo (dto, do,entity,bean) 작성규칙
// 1. 반드시 직렬화 할것
// 2. 모든 필드는 private : 반드시 캡슐화 할것
// 3. 기본생성자, 매개변수 있는 생성자 작성할 것
// 4. 모든 필드에 대한 getters & setters
// 5. toString() overriding
// ect. equals(), clone() 등 오버라이딩, 그 외의 메소드
public class Member  implements java.io.Serializable{
	private static final long serialVersionUID = 1636171309167421393L;
//	USERID	VARCHAR2(50 BYTE)
	private String userId;
//	USERPWD	VARCHAR2(100 BYTE)
	private String userPwd;
//	USERNAME	VARCHAR2(20 BYTE)
	private String userName;
//	GENDER	CHAR(1 BYTE)
	private String gender;
//	AGE	NUMBER(3,0)
	private int age;
//	PHONE	VARCHAR2(13 BYTE)
	private String phone;
//	EMAIL	VARCHAR2(30 BYTE)
	private String email;
//	ENROLL_DATE	DATE
	private java.sql.Date enrollDate;
//	LASTMODIFIED	DATE
	private java.sql.Date lastModified;
//	SIGNTYPE	VARCHAR2(10 BYTE)
	private String signType;
//	ADMIN	CHAR(1 BYTE)
	private String admin;
//	LOGIN_OK	CHAR(1 BYTE)
	private String loginOk;

	public Member() {
	}

	public Member(String userId, String userPwd, String userName, String gender, int age, String phone, String email, Date enrollDate, Date lastModified, String signType, String admin, String loginOk) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.enrollDate = enrollDate;
		this.lastModified = lastModified;
		this.signType = signType;
		this.admin = admin;
		this.loginOk = loginOk;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getLoginOk() {
		return loginOk;
	}

	public void setLoginOk(String loginOk) {
		this.loginOk = loginOk;
	}

	@Override
	public String toString() {
		return "member{" +
				"userId='" + userId + '\'' +
				", userPwd='" + userPwd + '\'' +
				", userName='" + userName + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", enrollDate=" + enrollDate +
				", lastModified=" + lastModified +
				", signType='" + signType + '\'' +
				", admin='" + admin + '\'' +
				", loginOk='" + loginOk + '\'' +
				'}';
	}
}
