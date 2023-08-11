package 과제.과제11.model.dto;

public class MessageDto {
	private int msno;
	private int sender;
	private int taker;
	private String mscontent;
	private String senderid;
	private String msdatetime;
	
	public MessageDto() {
		// TODO Auto-generated constructor stub
	}

	public MessageDto(int msno, int sender, int taker, String mscontent, String senderid, String msdatetime) {
		super();
		this.msno = msno;
		this.sender = sender;
		this.taker = taker;
		this.mscontent = mscontent;
		this.senderid = senderid;
		this.msdatetime = msdatetime;
	}

	public int getMsno() {
		return msno;
	}

	public void setMsno(int msno) {
		this.msno = msno;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getTaker() {
		return taker;
	}

	public void setTaker(int taker) {
		this.taker = taker;
	}

	public String getMscontent() {
		return mscontent;
	}

	public void setMscontent(String mscontent) {
		this.mscontent = mscontent;
	}
	
	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	
	public String getMsdatetime() {
		return msdatetime;
	}

	public void setMsdatetime(String msdatetime) {
		this.msdatetime = msdatetime;
	}

	@Override
	public String toString() {
		return "MessageDto [msno=" + msno + ", sender=" + sender + ", taker=" + taker + ", mscontent=" + mscontent
				+ ", senderid=" + senderid + ", msdatetime=" + msdatetime + "]";
	}
	
	
}
