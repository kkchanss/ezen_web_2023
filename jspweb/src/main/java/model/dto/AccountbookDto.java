package model.dto;

public class AccountbookDto {

	private int ano;
	private int amoney;
	private String acontent;
	private String aday;
	
	public AccountbookDto() {
		// TODO Auto-generated constructor stub
	}

	public AccountbookDto(int ano, int amoney, String acontent, String aday) {
		super();
		this.ano = ano;
		this.amoney = amoney;
		this.acontent = acontent;
		this.aday = aday;
	}

	public AccountbookDto(int amoney, String acontent, String aday) {
		super();
		this.amoney = amoney;
		this.acontent = acontent;
		this.aday = aday;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAmoney() {
		return amoney;
	}

	public void setAmoney(int amoney) {
		this.amoney = amoney;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public String getAday() {
		return aday;
	}

	public void setAday(String aday) {
		this.aday = aday;
	}
	
	
}
