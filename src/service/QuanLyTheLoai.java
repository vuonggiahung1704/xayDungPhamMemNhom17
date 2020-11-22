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

public class QuanLyTheLoai {
	private ArrayList<TheLoai> dsTheLoai;

	public QuanLyTheLoai() {
		dsTheLoai = new ArrayList<>();
	}

	public ArrayList<TheLoai> getDS() {
		return dsTheLoai;
	}

	public ArrayList<TheLoai> dsTheLoai() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from TheLoai";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maTL = rs.getInt(1);
				String tenTL = rs.getString(2);
				int giaThue = rs.getInt(3);
				int giaPhat = rs.getInt(4);
				int giaDenBu = rs.getInt(5);
				TheLoai tl = new TheLoai(maTL, tenTL, giaThue, giaPhat, giaDenBu);
				dsTheLoai.add(tl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTheLoai;
	}
	
	public TheLoai chiTietTheLoai(int maTL_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from TheLoai where maTL = ?");
			st.setInt(1, maTL_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maTL = rs.getInt(1);
				String tenTL = rs.getString(2);
				int giaThue = rs.getInt(3);
				int giaPhat = rs.getInt(4);
				int giaDenBu = rs.getInt(5);
				TheLoai tl = new TheLoai(maTL, tenTL, giaThue, giaPhat, giaDenBu);
				return tl;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean capNhatTheLoai(TheLoai tl)
	{
		Database.getInstance();
		Connection con= Database.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update TheLoai set giaThue = ?, giaPhat = ? , giaDenBu = ? where maTL = ? ");
			stmt.setInt(1, tl.getGiaThue());
			stmt.setInt(2, tl.getGiaPhat());
			stmt.setInt(3, tl.getGiaDenBu());
			stmt.setInt(4, tl.getMaTL());
			n= stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return n>0;
	}
}
