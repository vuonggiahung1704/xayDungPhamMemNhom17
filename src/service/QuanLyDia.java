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
import entities.Dia;
import entities.KhachHang;
import entities.TaiKhoan;
import entities.TheLoai;
import entities.TieuDe;

public class QuanLyDia {
	private ArrayList<Dia> dsDia;

	public QuanLyDia() {
		dsDia = new ArrayList<>();
	}

	public ArrayList<Dia> getDS() {
		return dsDia;
	}

	public int getMaDia() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 ID from Dia order by ID desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int ID = rs.getInt(1);
				return ID+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Dia> dsDia() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from Dia";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maDia = rs.getString(2);
				int maTL = rs.getInt(3);
				String maTD = rs.getString(4);
				int tinhTrang = rs.getInt(5);
				int huHong = rs.getInt(6);
				Dia d = new Dia(maDia, new TheLoai(maTL),new TieuDe(maTD), tinhTrang, huHong);
				dsDia.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDia;
	}

	public ArrayList<Dia> dsDia_CoSan() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from Dia where tinhTrang = 0";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maDia = rs.getString(2);
				int maTL = rs.getInt(3);
				String maTD = rs.getString(4);
				int tinhTrang = rs.getInt(5);
				int huHong = rs.getInt(6);
				Dia d = new Dia(maDia, new TheLoai(maTL),new TieuDe(maTD), tinhTrang, huHong);
				dsDia.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDia;
	}
	
	public void themDia(Dia d) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into Dia(maTL,maTD,tinhTrang,huHong)" + " values(" + d.getTheLoai().getMaTL() + ",'"
					+ d.getTieuDe().getMaTD() + "',0,0)");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public Dia chiTietDia(String maDia_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from Dia where maDia = ?");
			st.setString(1, maDia_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDia = rs.getString(2);
				int maTL = rs.getInt(3);
				String maTD = rs.getString(4);
				int tinhTrang = rs.getInt(5);
				int huHong = rs.getInt(6);
				Dia d = new Dia(maDia, new TheLoai(maTL),new TieuDe(maTD), tinhTrang, huHong);
				return d;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean capNhatTinhTrangDia(int tinhTrang, String maDia) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Dia set tinhTrang = ? where maDia = ? ");
			stmt.setInt(1, tinhTrang);
			stmt.setString(2, maDia);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatTinhTrangHuHong(int huHong, String maDia) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Dia set huHong = ? where maDia = ? ");
			stmt.setInt(1, huHong);
			stmt.setString(2, maDia);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String maDia) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from Dia where maDia = ?");
		stmt.setString(1, maDia);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public ArrayList<Dia> tim_Dia(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select maDia,maTL,d.maTD,tinhTrang,huHong "
					+ "from Dia d join TieuDe td on d.maTD = td.maTD where d.maDia like ? or td.tenTD like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDia = rs.getString(1);
				int maTL = rs.getInt(2);
				String maTD = rs.getString(3);
				int tinhTrang = rs.getInt(4);
				int huHong = rs.getInt(5);
				Dia d = new Dia(maDia, new TheLoai(maTL),new TieuDe(maTD), tinhTrang, huHong);
				dsDia.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDia;
	}
	
	public ArrayList<Dia> tim_Dia_Co_San(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select d.maDia,d.maTl,d.maTD,d.tinhTrang,d.huHong"
					+ " from Dia d join TieuDe td on d.maTD = td.maTD where d.tinhTrang = 0 and (d.maDia like ? or td.tenTD like ?)");
			st.setNString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maDia = rs.getString(1);
				int maTL = rs.getInt(2);
				String maTD = rs.getString(3);
				int tinhTrang = rs.getInt(4);
				int huHong = rs.getInt(5);
				Dia d = new Dia(maDia, new TheLoai(maTL),new TieuDe(maTD), tinhTrang, huHong);
				dsDia.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDia;
	}
}
