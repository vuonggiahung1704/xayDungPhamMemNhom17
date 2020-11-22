package entities;

public class TaiKhoan {
	private String tenTK;
	private String matKhau;
	private String hoTen;
	private String email;
	private String sdt;
	private int quyen;
	private int truyCap;
	
	public TaiKhoan(String tenTK, String matKhau) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
	}

	public TaiKhoan(String tenTK, String matKhau, String hoTen, String email, String sdt, int quyen,int truyCap) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.quyen = quyen;
		this.truyCap = truyCap;
	}

	public TaiKhoan(String tenTK, String matKhau, int quyen,int truyCap) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.quyen = quyen;
		this.truyCap = truyCap;
	}
	
	public TaiKhoan(String tenTK) {
		super();
		this.tenTK = tenTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
	public int getTruyCap() {
		return truyCap;
	}

	public void setTruyCap(int truyCap) {
		this.truyCap = truyCap;
	}

	@Override
	public String toString() {
		return "TaiKhoan1 [tenTK=" + tenTK + ", matKhau=" + matKhau + ", hoTen=" + hoTen + ", email=" + email + ", sdt="
				+ sdt + ", quyen=" + quyen + ", truyCap=" + truyCap + "]";
	}

	
	
}
