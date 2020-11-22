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
import entities.TaiKhoan;
import entities.TieuDe;

public class QuanLyTieuDe {
	private ArrayList<TieuDe> danhSachTieuDe;

	public QuanLyTieuDe() {
		danhSachTieuDe = new ArrayList<>();
	}

	public ArrayList<TieuDe> getdanhSach() {
		return danhSachTieuDe;
	}

	public int getMaTieuDe() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 ID from TieuDe order by ID desc";
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

	public ArrayList<TieuDe> danhSachTieuDe() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from TieuDe";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maTD = rs.getString(2);
				String tenTD = rs.getNString(3);
				TieuDe td = new TieuDe(maTD, tenTD);
				danhSachTieuDe.add(td);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachTieuDe;
	}

	public void themTieuDe(String tenTD) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into TieuDe(tenTD)" + " values(N'" + tenTD + "')");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public TieuDe chiTietTieuDe(String tenTD_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from TieuDe where maTD = ?");
			st.setString(1, tenTD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maTD = rs.getString(2);
				String tenTD = rs.getNString(3);
				TieuDe td = new TieuDe(maTD, tenTD);
				return td;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(String maTD) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from TieuDe where maTD = ?");
		stmt.setString(1, maTD);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public ArrayList<TieuDe> tim_TieuDe(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from TieuDe where maTD like ? or tenTD like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maTD = rs.getString(2);
				String tenTD = rs.getNString(3);
				TieuDe td = new TieuDe(maTD, tenTD);
				danhSachTieuDe.add(td);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachTieuDe;
	}

	public ArrayList<TieuDe> danhSach_Dia_KhongCoSan() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from TieuDe td where td.maTD not in ( select td.maTD from TieuDe td join Dia d on td.maTD = d.maTD where d.tinhTrang = 0 group by td.maTD)";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maTD = rs.getString(2);
				String tenTD = rs.getNString(3);
				TieuDe td = new TieuDe(maTD, tenTD);
				danhSachTieuDe.add(td);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachTieuDe;
	}

	public ArrayList<TieuDe> tim_TieuDe_KhongCoSan(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select * from TieuDe td where ( td.maTD like ? or td.tenTD like ? ) and td.maTD not in ( select td.maTD from TieuDe td join Dia d on td.maTD = d.maTD where d.tinhTrang = 0 group by td.maTD)");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maTD = rs.getString(2);
				String tenTD = rs.getNString(3);
				TieuDe td = new TieuDe(maTD, tenTD);
				danhSachTieuDe.add(td);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachTieuDe;
	}
	
	public int soLuongDia(String maTD) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select count(d.maTD) from Dia d where d.maTD = ?");
			st.setString(1, maTD);
			st.setString(1, maTD);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int soLuong =  rs.getInt(1);
				return soLuong;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int soLuongDia_ChoThue(String maTD) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select count(d.maTD) from Dia d where tinhTrang = 1 and d.maTD = ?");
			st.setString(1, maTD);
			st.setString(1, maTD);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int soLuong =  rs.getInt(1);
				return soLuong;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int soLuongDia_CoSan(String maTD) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select count(d.maTD) from Dia d where tinhTrang = 0 and d.maTD = ?");
			st.setString(1, maTD);
			st.setString(1, maTD);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int soLuong =  rs.getInt(1);
				return soLuong;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int soLuongDia_DuocDatHang(String maTD) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select count(pd.maTD) from PhieuDat pd where trangThai = 1 and pd.maTD = ?");
			st.setString(1, maTD);
			st.setString(1, maTD);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int soLuong =  rs.getInt(1);
				return soLuong;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int soLuongDia_DatHang(String maTD) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select count(pd.maTD) from PhieuDat pd where trangThai = 0 and pd.maTD = ?");
			st.setString(1, maTD);
			st.setString(1, maTD);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int soLuong =  rs.getInt(1);
				return soLuong;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
