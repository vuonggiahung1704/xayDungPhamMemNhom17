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
import entities.ChiTietPhieuDat;
import entities.ChiTietPhieuThue;
import entities.Dia;
import entities.KhachHang;
import entities.PhieuDat;
import entities.PhieuThue;
import entities.TaiKhoan;

public class QuanLyCT_PhieuDat {
	private ArrayList<ChiTietPhieuDat> dsCTPhieuDat;

	public QuanLyCT_PhieuDat() {
		dsCTPhieuDat = new ArrayList<>();
	}

	public ArrayList<ChiTietPhieuDat> getDS() {
		return dsCTPhieuDat;
	}

	public void them_CTPD(ChiTietPhieuDat ct) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into ChiTietPhieuDat" + " values('"+ct.getPhieuDat().getMaDH()+"','" + ct.getDia().getMaDia() + "', 0)");
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public boolean delete(String maPD) {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietPhieuDat where maPD = ?");
			stmt.setString(1, maPD);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(ChiTietPhieuDat ct) {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update ChiTietPhieuDat set trangThai = ? where maPD = ? and maDia = ?");
			stmt.setInt(1, ct.getTinhTrang());
			stmt.setString(2, ct.getPhieuDat().getMaDH());
			stmt.setString(3, ct.getDia().getMaDia());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ChiTietPhieuDat getCTPDat_TheoMaPD(String maPD_tim, int tinhTrang_) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietPhieuDat where maPD = ? and trangThai = ?");
			st.setString(1, maPD_tim);
			st.setInt(2, tinhTrang_);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPD = rs.getString(1);
				String maDia = rs.getString(2);
				int tinhTrang = rs.getInt(3);
				ChiTietPhieuDat ctpd = new ChiTietPhieuDat(new PhieuDat(maPD), new Dia(maDia), tinhTrang);
				return ctpd;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
			
	public ChiTietPhieuDat getPhieuDatGanNhat_TheoMaDia(String maD_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select top 1 * from ChiTietPhieuDat where maDia = ? and trangThai = 0 order by maPD desc");
			st.setString(1, maD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPD = rs.getString(1);
				String maDia = rs.getString(2);
				int tinhTrang = rs.getInt(3);
				ChiTietPhieuDat ctpd = new ChiTietPhieuDat(new PhieuDat(maPD), new Dia(maDia), tinhTrang);
				return ctpd;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
