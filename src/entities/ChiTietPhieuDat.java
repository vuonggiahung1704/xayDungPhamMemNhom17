package entities;

public class ChiTietPhieuDat {	
	private PhieuDat phieuDat;
	private Dia dia;
	private int tinhTrang;
	public ChiTietPhieuDat(PhieuDat phieuDat, Dia dia,int tinhTrang) {
		super();
		this.phieuDat = phieuDat;
		this.dia = dia;
		this.tinhTrang = tinhTrang;
	}
	
	public PhieuDat getPhieuDat() {
		return phieuDat;
	}

	public void setPhieuDat(PhieuDat phieuDat) {
		this.phieuDat = phieuDat;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
}
