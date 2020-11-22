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
import entities.ChiTietThanhToan;
import entities.PhiTreHan;
import entities.PhieuTra;
import entities.ThanhToan;

public class QuanLyCT_ThanhToan {
	private ArrayList<ChiTietThanhToan> dsCTThanhToan;

	public QuanLyCT_ThanhToan() {
		dsCTThanhToan = new ArrayList<>();
	}

	public ArrayList<ChiTietThanhToan> getDS() {
		return dsCTThanhToan;
	}

	public ArrayList<ChiTietThanhToan> dscttt() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from ChiTietThanhToan";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maTT = rs.getString(1);
				String maPtr = rs.getString(2);
				int soTien = rs.getInt(3);
				ChiTietThanhToan cttt = new ChiTietThanhToan(new ThanhToan(maTT),new PhiTreHan(new PhieuTra(maPtr)),soTien);
				dsCTThanhToan.add(cttt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCTThanhToan;
	}

	public void them_cttt(ChiTietThanhToan cttt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into ChiTietThanhToan" + " values('"+cttt.getThanhToan().getMaTT()+"','" + cttt.getPhiTreHan().getPhieuTra().getMaPTr() + "',"
					+ cttt.getSoTien()+")");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public ArrayList<ChiTietThanhToan> getcttt_TheoKhachHang(String maKH) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietThanhToan where maPT = ?");
			st.setString(1, maKH);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maTT = rs.getString(1);
				String maPtr = rs.getString(2);
				int soTien = rs.getInt(3);
				ChiTietThanhToan cttt = new ChiTietThanhToan(new ThanhToan(maTT),new PhiTreHan(new PhieuTra(maPtr)),soTien);
				dsCTThanhToan.add(cttt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCTThanhToan;
	}
	
	public ArrayList<ChiTietThanhToan> getcttt_TheoMATT(String maTT_) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietThanhToan where maTT = ?");
			st.setString(1, maTT_);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maTT = rs.getString(1);
				String maPtr = rs.getString(2);
				int soTien = rs.getInt(3);
				ChiTietThanhToan cttt = new ChiTietThanhToan(new ThanhToan(maTT),new PhiTreHan(new PhieuTra(maPtr)),soTien);
				dsCTThanhToan.add(cttt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCTThanhToan;
	}
	
	
}
