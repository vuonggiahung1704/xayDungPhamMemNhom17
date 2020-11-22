package entities;

public class TheLoai {
	private int maTL;
	private String tenTL;
	private int giaThue;
	private int giaPhat;
	private int giaDenBu;

	
	public TheLoai(int maTL) {
		super();
		this.maTL = maTL;
	}
	public TheLoai(int maTL, String tenTL, int giaThue, int giaPhat, int giaDenBu) {
	super();
	this.maTL = maTL;
	this.tenTL = tenTL;
	this.giaThue = giaThue;
	this.giaPhat = giaPhat;
	this.giaDenBu = giaDenBu;
}
	public int getMaTL() {
		return maTL;
	}
	public void setMaTL(int maTL) {
		this.maTL = maTL;
	}
	public String getTenTL() {
		return tenTL;
	}
	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}
	public int getGiaThue() {
		return giaThue;
	}
	public void setGiaThue(int giaThue) {
		this.giaThue = giaThue;
	}

	public int getGiaPhat() {
		return giaPhat;
	}
	public void setGiaPhat(int giaPhat) {
		this.giaPhat = giaPhat;
	}

	public int getGiaDenBu() {
		return giaDenBu;
	}
	public void setGiaDenBu(int giaDenBu) {
		this.giaDenBu = giaDenBu;
	}
	@Override
	public String toString() {
		return tenTL;
	}
		
}
