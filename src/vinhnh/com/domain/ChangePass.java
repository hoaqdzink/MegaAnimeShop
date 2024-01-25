package vinhnh.com.domain;

public class ChangePass {
	private String passNowCurrent;
	private String passNew;
	private String passConfirm;
	
	public ChangePass() {
	}
	public ChangePass(String passNowCurrent, String passNew, String passConfirm) {
		this.passNowCurrent = passNowCurrent;
		this.passNew = passNew;
		this.passConfirm = passConfirm;
	}
	public String getPassNowCurrent() {
		return passNowCurrent;
	}
	public void setPassNowCurrent(String passNowCurrent) {
		this.passNowCurrent = passNowCurrent;
	}
	public String getPassNew() {
		return passNew;
	}
	public void setPassNew(String passNew) {
		this.passNew = passNew;
	}
	public String getPassConfirm() {
		return passConfirm;
	}
	public void setPassConfirm(String passConfirm) {
		this.passConfirm = passConfirm;
	}
	
	
}
