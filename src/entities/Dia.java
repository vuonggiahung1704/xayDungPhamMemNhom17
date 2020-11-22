package entities;

import java.sql.Date;

public class Dia {
	private String maDia;
	private TheLoai theLoai;
	private TieuDe tieuDe;
	private int tinhTrang;
	private int huHong;
	public Dia(String maDia, TheLoai theLoai, TieuDe tieuDe, int tinhTrang,int huHong) {
		super();
		this.maDia = maDia;
		this.theLoai = theLoai;
		this.tieuDe = tieuDe;
		this.tinhTrang = tinhTrang;
		this.huHong = huHong;
	}
	
	public Dia(String maDia) {
		super();
		this.maDia = maDia;
	}

	public Dia(TheLoai theLoai, TieuDe tieuDe) {
		super();
		this.theLoai = theLoai;
		this.tieuDe = tieuDe;
	}
	public String getMaDia() {
		return maDia;
	}
	public void setMaDia(String maDia) {
		this.maDia = maDia;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	public TieuDe getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(TieuDe tieuDe) {
		this.tieuDe = tieuDe;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	public int getHuHong() {
		return huHong;
	}
	public void setHuHong(int huHong) {
		this.huHong = huHong;
	}
	
}
