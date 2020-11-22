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
import entities.ChiTietPhieuThue;
import entities.Dia;
import entities.KhachHang;
import entities.PhieuThue;
import entities.PhieuTra;
import entities.PhiTreHan;
import entities.TaiKhoan;

public class QuanLyPhiTreHan {
	private ArrayList<PhiTreHan> dsPhiTreHan;

	public QuanLyPhiTreHan() {
		dsPhiTreHan = new ArrayList<>();
	}

	public ArrayList<PhiTreHan> getDS() {
		return dsPhiTreHan;
	}

//	public ArrayList<PhiTreHan> dsPhiTreHan() {
//		try {
//			Database.getInstance();
//			Connection con = Database.getConnection();
//			String sql = "select * from PhiTreHan";
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while (rs.next()) {
//				String maPTr = rs.getString(1);
//				int quaHan = rs.getInt(2);
//				int huHong = rs.getInt(3);
//				int tongTien = rs.getInt(4);
//				int traTruoc = rs.getInt(5);
//				int thanhToan = rs.getInt(6);
//				PhiTreHan ptr = new PhiTreHan(new PhieuTra(maPTr), quaHan, huHong, tongTien, traTruoc, thanhToan);
//				dsPhiTreHan.add(ptr);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dsPhiTreHan;
//	}

	public ArrayList<PhiTreHan> tim_PhiTreHan_KhachHang_No(String maKH) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select * from dbo.CongNo_KhachHang(?)");
			st.setString(1, maKH);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPTr = rs.getString(1);
				int quaHan = rs.getInt(2);
				int huHong = rs.getInt(3);
				int tongTien = rs.getInt(4);
				int traTruoc = rs.getInt(5);
				int thanhToan = rs.getInt(6);
				PhiTreHan ptr = new PhiTreHan(new PhieuTra(maPTr), quaHan, huHong, tongTien, thanhToan, traTruoc);
				dsPhiTreHan.add(ptr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhiTreHan;
	}

	public void themPhiTreHan(PhiTreHan ptr) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into PhiTreHan(maPTr,phatQuaHan,PhatHuHong,tongTien,traTruoc,thanhToan) " + "values('"
					+ ptr.getPhieuTra().getMaPTr() + "'," + ptr.getPhatQuaHan() + "," + ptr.getPhatHuHong() + ","
					+ ptr.getTongTien() + "," + ptr.getTraTruoc() + ",0)");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public boolean capNhatPhiTreHan_ThanhToan(String maPtr, int thanhToan) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update PhiTreHan set thanhToan = ? where maPTr = ? ");
			stmt.setInt(1, thanhToan);
			stmt.setString(2, maPtr);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean capNhatPhiTreHan_TraTruoc(String maPtr, int traTruoc) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update PhiTreHan set traTruoc = ? where maPTr = ? ");
			stmt.setInt(1, traTruoc);
			stmt.setString(2, maPtr);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean huyPhiTreHan(String maPTH) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from PhiTreHan where maPTr = ?");
		stmt.setString(1, maPTH);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public static PhiTreHan chiTietPhiTreHan(String maPTr_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhiTreHan where maPTr = ?");
			st.setString(1, maPTr_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPTr = rs.getString(1);
				int quaHan = rs.getInt(2);
				int huHong = rs.getInt(3);
				int tongTien = rs.getInt(4);
				int traTruoc = rs.getInt(5);
				int thanhToan = rs.getInt(6);
				PhiTreHan ptr = new PhiTreHan(new PhieuTra(maPTr), quaHan, huHong, tongTien, thanhToan, traTruoc);
				return ptr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
