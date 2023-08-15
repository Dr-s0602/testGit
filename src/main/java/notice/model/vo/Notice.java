package notice.model.vo;

import java.sql.Date;

public class Notice  implements java.io.Serializable{
	private static final long serialVersionUID = -283453772170417596L;

//	NOTICENO	NUMBER
	private int noticeNo;
//	NOTICETITLE	VARCHAR2(50 BYTE)
	private String noticeTitle;
//	NOTICEDATE	DATE
	private java.sql.Date noticeDate;
//	NOTICEWRITER	VARCHAR2(50 BYTE)
	private String noticeWriter;
//	NOTICECONTENT	VARCHAR2(2000 BYTE)
	private String noticeContent;
//	ORIGINAL_FILEPATH	VARCHAR2(100 BYTE)
	private String originalFilePath;
//	RENAME_FILEPATH	VARCHAR2(100 BYTE)
	private String renameFilePath;

	public Notice() {
	}

	public Notice(int noticeNo, String noticeTitle, Date noticeDate, String noticeWriter, String noticeContent, String originalFilePath, String renameFilePath) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.originalFilePath = originalFilePath;
		this.renameFilePath = renameFilePath;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getOriginalFilePath() {
		return originalFilePath;
	}

	public void setOriginalFilePath(String originalFilePath) {
		this.originalFilePath = originalFilePath;
	}

	public String getRenameFilePath() {
		return renameFilePath;
	}

	public void setRenameFilePath(String renameFilePath) {
		this.renameFilePath = renameFilePath;
	}

	@Override
	public String toString() {
		return "notice{" +
				"noticeNo=" + noticeNo +
				", noticeTitle='" + noticeTitle + '\'' +
				", noticeDate=" + noticeDate +
				", noticeWriter='" + noticeWriter + '\'' +
				", noticeContent='" + noticeContent + '\'' +
				", originalFilePath='" + originalFilePath + '\'' +
				", renameFilePath='" + renameFilePath + '\'' +
				'}';
	}
}
