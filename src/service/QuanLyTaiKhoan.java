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

import javax.swing.JOptionPane;

import database.Database;
import entities.KhachHang;
import entities.TaiKhoan;

public class QuanLyTaiKhoan {
	private ArrayList<TaiKhoan> dsTaiKhoan;

	public QuanLyTaiKhoan() {
		dsTaiKhoan = new ArrayList<>();
	}

	public ArrayList<TaiKhoan> getDS() {
		return dsTaiKhoan;
	}

	public ArrayList<TaiKhoan> dsTaiKhoan() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from TaiKhoan";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String tenTK = rs.getString(1);
				String matKhau = rs.getString(2);
				String hoTen = rs.getNString(3);
				String email = rs.getNString(4);
				String sdt = rs.getString(5);
				int quyen = rs.getInt(6);
				int truyCap = rs.getInt(7);
				TaiKhoan tk = new TaiKhoan(tenTK, matKhau, hoTen, email, sdt, quyen,truyCap);
				dsTaiKhoan.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}

	public void themTaiKhoan(TaiKhoan tk) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("insert into TaiKhoan" + " values('" + tk.getTenTK() + "','" + tk.getMatKhau() + "',N'"
				+ tk.getHoTen() + "',N'"
				+ tk.getEmail() + "','"
				+ tk.getSdt() + "'," + tk.getQuyen() + "," + tk.getTruyCap() + ")");
	}

	public TaiKhoan chiTietTaiKhoan(String tenTK_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from TaiKhoan where tenTK = ?");
			st.setString(1, tenTK_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String tenTK = rs.getString(1);
				String matKhau = rs.getString(2);
				String hoTen = rs.getNString(3);
				String email = rs.getNString(4);
				String sdt = rs.getString(5);
				int quyen = rs.getInt(6);
				int truyCap = rs.getInt(7);
				TaiKhoan tk = new TaiKhoan(tenTK, matKhau, hoTen, email, sdt, quyen,truyCap);
				return tk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatTaiKhoan(TaiKhoan tk) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set hoTen = ?, matKhau = ?, email = ?, sdt = ?, quyen = ?, truyCap = ? where tenTK = ? ");
			stmt.setNString(1, tk.getHoTen());
			stmt.setString(2, tk.getMatKhau());
			stmt.setString(3, tk.getEmail());
			stmt.setString(4, tk.getSdt());
			stmt.setInt(5, tk.getQuyen());
			stmt.setInt(6, tk.getTruyCap());
			stmt.setString(7, tk.getTenTK());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String tenTK) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from TaiKhoan where tenTK = ?");
		stmt.setString(1, tenTK);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public ArrayList<TaiKhoan> tim_TaiKhoan(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from TaiKhoan where tenTK like ? or hoTen like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String tenTK = rs.getString(1);
				String matKhau = rs.getString(2);
				String hoTen = rs.getNString(3);
				String email = rs.getNString(4);
				String sdt = rs.getString(5);
				int quyen = rs.getInt(6);
				int truyCap = rs.getInt(7);
				TaiKhoan tk = new TaiKhoan(tenTK, matKhau, hoTen, email, sdt, quyen,truyCap);
				dsTaiKhoan.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}
}
