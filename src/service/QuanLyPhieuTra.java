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
import entities.ChiTietThanhToan;
import entities.Dia;
import entities.KhachHang;
import entities.PhiTreHan;
import entities.PhieuThue;
import entities.PhieuTra;
import entities.TaiKhoan;
import entities.ThanhToan;

public class QuanLyPhieuTra {
	private ArrayList<PhieuTra> dsPhieuTra;

	public QuanLyPhieuTra() {
		dsPhieuTra = new ArrayList<>();
	}

	public ArrayList<PhieuTra> getDS() {
		return dsPhieuTra;
	}
	
	public String getMaPhieuDat() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maPTr from PhieuTra order by ID desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maPTr = rs.getString(1);
				return maPTr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public ArrayList<PhieuTra> dsPhieuTra() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from PhieuTra";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maPTr = rs.getString(2);
				String maPT = rs.getString(3);
				String maDia = rs.getString(4);
				String ngayTra = rs.getString(5);
				String tenTK = rs.getString(6);
				int quaHan = rs.getInt(7);
				int huHong = rs.getInt(8);
				PhieuTra ptr = new PhieuTra(maPTr, new PhieuThue(maPT), new Dia(maDia), ngayTra, new TaiKhoan(tenTK), quaHan, huHong);
				dsPhieuTra.add(ptr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuTra;
	}
	
	public ArrayList<PhieuTra> dsPhieuTra_Dia(String maDia_) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuTra where maDia = ?");
			st.setString(1, maDia_);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPTr = rs.getString(2);
				String maPT = rs.getString(3);
				String maDia = rs.getString(4);
				String ngayTra = rs.getString(5);
				String tenTK = rs.getString(6);
				int quaHan = rs.getInt(7);
				int huHong = rs.getInt(8);
				PhieuTra ptr = new PhieuTra(maPTr, new PhieuThue(maPT), new Dia(maDia), ngayTra, new TaiKhoan(tenTK), quaHan, huHong);
				dsPhieuTra.add(ptr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuTra;
	}
	
	public ArrayList<PhieuTra> timPhieuTra_Nhap(String txt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from dbo.TimPhieuTra(?)");
			st.setNString(1, txt);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPTr = rs.getString(2);
				String maPT = rs.getString(3);
				String maDia = rs.getString(4);
				String ngayTra = rs.getString(5);
				String tenTK = rs.getString(6);
				int quaHan = rs.getInt(7);
				int huHong = rs.getInt(8);
				PhieuTra ptr = new PhieuTra(maPTr, new PhieuThue(maPT), new Dia(maDia), ngayTra, new TaiKhoan(tenTK), quaHan, huHong);
				dsPhieuTra.add(ptr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuTra;
	}
	
	public ArrayList<PhieuTra> timPhieuTra_Ngay(String txt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuTra where ngayTra = ?");
			st.setString(1, txt);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPTr = rs.getString(2);
				String maPT = rs.getString(3);
				String maDia = rs.getString(4);
				String ngayTra = rs.getString(5);
				String tenTK = rs.getString(6);
				int quaHan = rs.getInt(7);
				int huHong = rs.getInt(8);
				PhieuTra ptr = new PhieuTra(maPTr, new PhieuThue(maPT), new Dia(maDia), ngayTra, new TaiKhoan(tenTK), quaHan, huHong);
				dsPhieuTra.add(ptr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuTra;
	}
		
	public void themPhieuTra(PhieuTra ptr) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into PhieuTra(maPT,maDia,ngayTra,tenTK,quaHan,huHong) "
					+ "values('"+ptr.getPt().getMaPT()+"','"+ptr.getDia().getMaDia()+"','"+ptr.getNgayTra()+"',"
							+ "'"+ptr.getNhanVien().getTenTK()+"',"+ptr.getQuaHan()+","+ptr.getHuHong() + ")");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}
	
	public static PhieuTra chiTietPhieuTra(String maPTr_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuTra where maPTr = ?");
			st.setString(1, maPTr_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPTr = rs.getString(2);
				String maPT = rs.getString(3);
				String maDia = rs.getString(4);
				String ngayTra = rs.getString(5);
				String tenTK = rs.getString(6);
				int quaHan = rs.getInt(7);
				int huHong = rs.getInt(8);
				PhieuTra ptr = new PhieuTra(maPTr, new PhieuThue(maPT), new Dia(maDia), ngayTra, new TaiKhoan(tenTK), quaHan, huHong);
				return ptr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
