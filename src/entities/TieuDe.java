package entities;

public class TieuDe {
	private String maTD;
	private String tenTD;
	public TieuDe(String maTD, String tenTD) {
		super();
		this.maTD = maTD;
		this.tenTD = tenTD;
	}
	public TieuDe(String maTD) {
		super();
		this.maTD = maTD;
	}
	public String getMaTD() {
		return maTD;
	}
	public void setMaTD(String maTD) {
		this.maTD = maTD;
	}
	public String getTenTD() {
		return tenTD;
	}
	public void setTenTD(String tenTD) {
		this.tenTD = tenTD;
	}
		@Override
	public String toString() {
		return maTD + "   " + tenTD;
	}
}
