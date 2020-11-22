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
import entities.PhiTreHan;
import entities.PhieuThue;
import entities.PhieuTra;
import entities.ThanhToan;
import entities.TaiKhoan;

public class QuanLyThanhToan {
	private ArrayList<ThanhToan> dsThanhToan;

	public QuanLyThanhToan() {
		dsThanhToan = new ArrayList<>();
	}

	public ArrayList<ThanhToan> getDS() {
		return dsThanhToan;
	}

	public String getMaThanhToan() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maTT from ThanhToan order by maTT desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maTT = rs.getString(1);
				return maTT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public ArrayList<ThanhToan> dsThanhToan() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from ThanhToan";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maTT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngay = rs.getString(4);
				int tongTien = rs.getInt(5);
				String nv = rs.getString(6);
				ThanhToan tt = new ThanhToan(maTT, new KhachHang(maKH),tongTien, ngay,new TaiKhoan(nv));
				dsThanhToan.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThanhToan;
	}

	public ArrayList<ThanhToan> tim_ThanhToan_KhachHang(String maKH_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select * from ThanhToan where maKH = ?");
			st.setString(1, maKH_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maTT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngay = rs.getString(4);
				int tongTien = rs.getInt(5);
				String nv = rs.getString(6);
				ThanhToan tt = new ThanhToan(maTT, new KhachHang(maKH),tongTien, ngay,new TaiKhoan(nv));
				dsThanhToan.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThanhToan;
	}

	public void themThanhToan(ThanhToan tt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into ThanhToan(maKH,ngayThanhToan,tongTien,tenTK) " + "values('"+tt.getKhachHang().getMaKH()+"','" + tt.getNgayThanhToan() + "',"
					+ tt.getTongTien() + ",'" + tt.getTaiKhoan().getTenTK() + "')");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public static ThanhToan chiTietThanhToan(String maTT_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ThanhToan where maTT = ?");
			st.setString(1, maTT_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maTT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngay = rs.getString(4);
				int tongTien = rs.getInt(5);
				String nv = rs.getString(6);
				ThanhToan tt = new ThanhToan(maTT, new KhachHang(maKH),tongTien, ngay,new TaiKhoan(nv));
				return tt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
