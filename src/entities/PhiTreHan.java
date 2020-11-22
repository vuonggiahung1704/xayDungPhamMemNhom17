package entities;

public class PhiTreHan {
	private PhieuTra phieuTra;
	private int phatQuaHan;
	private int phatHuHong;
	private int tongTien;
	private int thanhToan;
	private int traTruoc;
	private int tienThu;
	public PhiTreHan(PhieuTra phieuTra, int phatQuaHan, int phatHuHong, int tongTien, int thanhToan, int traTruoc) {
		super();
		this.phieuTra = phieuTra;
		this.phatQuaHan = phatQuaHan;
		this.phatHuHong = phatHuHong;
		this.tongTien = tongTien;
		this.thanhToan = thanhToan;
		this.traTruoc = traTruoc;
	}
	public PhiTreHan(PhieuTra phieuTra, int phatQuaHan, int phatHuHong, int tongTien, int thanhToan, int traTruoc,
			int tienThu) {
		super();
		this.phieuTra = phieuTra;
		this.phatQuaHan = phatQuaHan;
		this.phatHuHong = phatHuHong;
		this.tongTien = tongTien;
		this.thanhToan = thanhToan;
		this.traTruoc = traTruoc;
		this.tienThu = tienThu;
	}
	public PhiTreHan(PhieuTra phieuTra) {
		super();
		this.phieuTra = phieuTra;
	}
	public PhieuTra getPhieuTra() {
		return phieuTra;
	}
	public void setPhieuTra(PhieuTra phieuTra) {
		this.phieuTra = phieuTra;
	}
	public int getPhatQuaHan() {
		return phatQuaHan;
	}
	public void setPhatQuaHan(int phatQuaHan) {
		this.phatQuaHan = phatQuaHan;
	}
	public int getPhatHuHong() {
		return phatHuHong;
	}
	public void setPhatHuHong(int phatHuHong) {
		this.phatHuHong = phatHuHong;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public int getThanhToan() {
		return thanhToan;
	}
	public void setThanhToan(int thanhToan) {
		this.thanhToan = thanhToan;
	}
	public int getTraTruoc() {
		return traTruoc;
	}
	public void setTraTruoc(int traTruoc) {
		this.traTruoc = traTruoc;
	}
	public int getTienThu() {
		return tienThu;
	}
	public void setTienThu(int tienThu) {
		this.tienThu = tienThu;
	}
	
	
}
