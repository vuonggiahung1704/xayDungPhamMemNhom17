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

public class QuanLyKhachHang {
	private ArrayList<KhachHang> dsKhachHang;

	public QuanLyKhachHang() {
		dsKhachHang = new ArrayList<>();
	}

	public ArrayList<KhachHang> getDS() {
		return dsKhachHang;
	}

	public int getMaKH() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 ID from KhachHang order by ID desc";
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
	
	public ArrayList<KhachHang> dsKhachHang() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from KhachHang";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(2);
				String tenKH = rs.getNString(3);
				String SDT = rs.getString(4);
				String diaChi = rs.getNString(5);
				KhachHang kh = new KhachHang(maKH, tenKH, SDT, diaChi);
				dsKhachHang.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public void themKhachHang(KhachHang kh) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into KhachHang(tenKH,sdt,diaChi) " + " values(N'" + kh.getTenKH() + "','"
					+ kh.getSdt() + "',N'" + kh.getDiaChi() + "')");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public KhachHang chiTietKhachHang(String maKH_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from KhachHang where maKH = ?");
			st.setString(1, maKH_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maKH = rs.getString(2);
				String hoTen = rs.getNString(3);
				String SDT = rs.getString(4);
				String diaChi = rs.getNString(5);
				KhachHang kh = new KhachHang(maKH, hoTen, SDT, diaChi);
				return kh;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatKhachHang(KhachHang kh)
	{
		Database.getInstance();
		Connection con= Database.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update KhachHang set tenKH = ?, sdt = ?, diaChi = ? where maKH = ? ");
			stmt.setNString(1, kh.getTenKH());
			stmt.setString(2, kh.getSdt());
			stmt.setNString(3, kh.getDiaChi());
			stmt.setString(4, kh.getMaKH());
			n= stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean delete(String maKH) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from KhachHang where maKH = ?");
		stmt.setString(1, maKH);
		n = stmt.executeUpdate();
		return n > 0;
	}

	
	public ArrayList<KhachHang> tim_KhachHang(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from KhachHang where maKH like ? or tenKH like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maKH = rs.getString(2);
				String hoTen = rs.getNString(3);
				String SDT = rs.getString(4);
				String diaChi = rs.getNString(5);
				KhachHang kh = new KhachHang(maKH, hoTen, SDT, diaChi);
				dsKhachHang.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	public int congNo(String maKH) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select dbo.TongNo_KhachHang(?)");
			st.setString(1, maKH);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int congNo = rs.getInt(1);
				return congNo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
