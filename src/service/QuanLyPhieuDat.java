package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import database.Database;
import entities.KhachHang;
import entities.PhieuDat;
import entities.PhieuThue;
import entities.TaiKhoan;
import entities.TieuDe;

public class QuanLyPhieuDat {
	private ArrayList<PhieuDat> dsDatHang;

	public QuanLyPhieuDat() {
		dsDatHang = new ArrayList<>();
	}

	public ArrayList<PhieuDat> getDS() {
		return dsDatHang;
	}

	public int getMaPhieuDat() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 ID from PhieuDat order by ID desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int ID = rs.getInt(1);
				return ID + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<PhieuDat> dsDatHang() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from PhieuDat where trangThai in (0,1) order by trangThai desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maDH = rs.getString(2);
				String maKH = rs.getString(3);
				String tieuDe = rs.getString(4);
				String ngay = rs.getString(5);
				String gio = rs.getString(6);
				String taikhoan = rs.getString(7);
				int tinhTrang = rs.getInt(8);
				PhieuDat dh = new PhieuDat(maDH, new KhachHang(maKH), new TieuDe(tieuDe), ngay, gio,
						new TaiKhoan(taikhoan),tinhTrang);

				dsDatHang.add(dh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDatHang;
	}

	public void themDatHang(PhieuDat dh) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into PhieuDat(maKH,maTD,ngayDat,gio,tenTK,trangThai) " + " values('"
					+ dh.getKhachHang().getMaKH() + "','" + dh.getTieuDe().getMaTD() + "','" + dh.getNgayDat() + "','"
					+ dh.getGioDat() + "','" + dh.getTaiKhoan().getTenTK() + "',0)");
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public boolean delete(String maPD) {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from PhieuDat where maPD = ?");
			stmt.setString(1, maPD);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean update_tinhTrang(int tinhTrang,String maPD) {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update PhieuDat set trangThai = ? where maPD = ?");
			stmt.setInt(1, tinhTrang);
			stmt.setString(2, maPD);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public PhieuDat chiTietPhieuDat(String maPD_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDat where maPD = ?");
			st.setString(1, maPD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDH = rs.getString(2);
				String maKH = rs.getString(3);
				String tieuDe = rs.getString(4);
				String ngay = rs.getString(5);
				String gio = rs.getString(6);
				String taikhoan = rs.getString(7);
				int tinhTrang = rs.getInt(8);
				PhieuDat dh = new PhieuDat(maDH, new KhachHang(maKH), new TieuDe(tieuDe), ngay, gio,
						new TaiKhoan(taikhoan),tinhTrang);

				return dh;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PhieuDat> timPhieuDat_Nhap(String txt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from dbo.TimPhieuDat(?)");
			st.setString(1, txt);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDH = rs.getString(2);
				String maKH = rs.getString(3);
				String tieuDe = rs.getString(4);
				String ngay = rs.getString(5);
				String gio = rs.getString(6);
				String taikhoan = rs.getString(7);
				int tinhTrang = rs.getInt(8);
				PhieuDat dh = new PhieuDat(maDH, new KhachHang(maKH), new TieuDe(tieuDe), ngay, gio,
						new TaiKhoan(taikhoan),tinhTrang);
				dsDatHang.add(dh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDatHang;
	}
	
	public ArrayList<PhieuDat> timPhieuDat_Ngay(String txt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDat where ngayDat = ?");
			st.setString(1, txt);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDH = rs.getString(2);
				String maKH = rs.getString(3);
				String tieuDe = rs.getString(4);
				String ngay = rs.getString(5);
				String gio = rs.getString(6);
				String taikhoan = rs.getString(7);
				int tinhTrang = rs.getInt(8);
				PhieuDat dh = new PhieuDat(maDH, new KhachHang(maKH), new TieuDe(tieuDe), ngay, gio,
						new TaiKhoan(taikhoan),tinhTrang);
				dsDatHang.add(dh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDatHang;
	}
	
	public PhieuDat phieuDat_TieuDe_SomNhat(String maTD_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select top 1 * from PhieuDat where maTD = ? and maPD not in (select pd.maPD from PhieuDat pd join ChiTietPhieuDat d on pd.maPD = d.maPD) order by ngayDat asc , gio asc");
			st.setString(1, maTD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDH = rs.getString(2);
				String maKH = rs.getString(3);
				String tieuDe = rs.getString(4);
				String ngay = rs.getString(5);
				String gio = rs.getString(6);
				String taikhoan = rs.getString(7);
				int tinhTrang = rs.getInt(8);
				PhieuDat dh = new PhieuDat(maDH, new KhachHang(maKH), new TieuDe(tieuDe), ngay, gio,
						new TaiKhoan(taikhoan),tinhTrang);
				return dh;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public PhieuDat phieuDat_TieuDe_ThuHai(String maTD_tim,String maPD) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select top 1 * from PhieuDat where maTD = ? and maPD not in (select pd.maPD from PhieuDat pd join ChiTietPhieuDat d on pd.maPD = d.maPD) and maPD <> ? order by ngayDat asc , gio asc");
			st.setString(1, maTD_tim);
			st.setString(2, maTD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDH = rs.getString(2);
				String maKH = rs.getString(3);
				String tieuDe = rs.getString(4);
				String ngay = rs.getString(5);
				String gio = rs.getString(6);
				String taikhoan = rs.getString(7);
				int tinhTrang = rs.getInt(8);
				PhieuDat dh = new PhieuDat(maDH, new KhachHang(maKH), new TieuDe(tieuDe), ngay, gio,
						new TaiKhoan(taikhoan),tinhTrang);
				return dh;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public ArrayList<PhieuDat> tim_PhieuDat(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDat where maPD like ?");
			st.setString(1, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDH = rs.getString(2);
				String maKH = rs.getString(3);
				String tieuDe = rs.getString(4);
				String ngay = rs.getString(5);
				String gio = rs.getString(6);
				String taikhoan = rs.getString(7);
				int tinhTrang = rs.getInt(8);
				PhieuDat dh = new PhieuDat(maDH, new KhachHang(maKH), new TieuDe(tieuDe), ngay, gio,
						new TaiKhoan(taikhoan),tinhTrang);

				dsDatHang.add(dh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDatHang;
	}


}
