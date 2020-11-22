package entities;

public class ChiTietThanhToan {
	private ThanhToan thanhToan;
	private PhiTreHan phiTreHan;
	private int soTien;
	public ChiTietThanhToan(ThanhToan thanhToan, PhiTreHan phiTreHan, int soTien) {
		super();
		this.thanhToan = thanhToan;
		this.phiTreHan = phiTreHan;
		this.soTien = soTien;
	}
	public ThanhToan getThanhToan() {
		return thanhToan;
	}
	public void setThanhToan(ThanhToan thanhToan) {
		this.thanhToan = thanhToan;
	}
	public PhiTreHan getPhiTreHan() {
		return phiTreHan;
	}
	public void setPhiTreHan(PhiTreHan phiTreHan) {
		this.phiTreHan = phiTreHan;
	}
	public int getSoTien() {
		return soTien;
	}
	public void setSoTien(int soTien) {
		this.soTien = soTien;
	}

	
}
