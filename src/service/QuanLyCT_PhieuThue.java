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
import entities.TaiKhoan;

public class QuanLyCT_PhieuThue {
	private ArrayList<ChiTietPhieuThue> dsCTPhieuThue;

	public QuanLyCT_PhieuThue() {
		dsCTPhieuThue = new ArrayList<>();
	}

	public ArrayList<ChiTietPhieuThue> getDS() {
		return dsCTPhieuThue;
	}

	public void them_CTPT(ChiTietPhieuThue ctpt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into ChiTietPhieuThue" + " values('"+ctpt.getPhieuThue().getMaPT()+"','" + ctpt.getDia().getMaDia() + "','"
					+ ctpt.getHanTra() + "'," + ctpt.getThanhTien()+")");

		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public ArrayList<ChiTietPhieuThue> getCTPT_TheoPT(String maPT_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietPhieuThue where maPT = ?");
			st.setString(1, maPT_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(1);
				String maDia = rs.getString(2);
				String hanTra = rs.getString(3);
				int thanhTien = rs.getInt(4);
				ChiTietPhieuThue ctpt = new ChiTietPhieuThue(new PhieuThue(maPT), new Dia(maDia), hanTra, thanhTien);
				dsCTPhieuThue.add(ctpt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCTPhieuThue;
	}
	
	public String getPT_TheoDia(String maDia) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select maPT from ChiTietPhieuThue where maDia = ?");
			st.setString(1, maDia);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(1);
				return maPT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ChiTietPhieuThue getCTPT_TheoPT_Dia(String maPT_tim, String maDia_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietPhieuThue where maPT = ? and maDia = ?");
			st.setString(1, maPT_tim);
			st.setString(2, maDia_tim);			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(1);
				String maDia = rs.getString(2);
				String hanTra = rs.getString(3);
				int thanhTien = rs.getInt(4);
				ChiTietPhieuThue ctpt = new ChiTietPhieuThue(new PhieuThue(maPT), new Dia(maDia), hanTra, thanhTien);
				return ctpt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(String maPT,String maDia) {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietPhieuThue where maPT = ? and maDia = ?");
			stmt.setString(1, maPT);
			stmt.setString(2, maDia);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	
	public ArrayList<ChiTietPhieuThue> tim_CTPT(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietPhieuThue where maPT like =");
			st.setString(1, "'" + text + "'");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(1);
				String maDia = rs.getString(2);
				String hanTra = rs.getString(3);
				int thanhTien = rs.getInt(4);
				ChiTietPhieuThue ctpt = new ChiTietPhieuThue(new PhieuThue(maPT), new Dia(maDia), hanTra, thanhTien);
				dsCTPhieuThue.add(ctpt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCTPhieuThue;
	}
	
	public ChiTietPhieuThue ChiTietPhieuThue_PT_Dia(String maPT_,String maDia_) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietPhieuThue where maPT = ? and maDia = ?");
			st.setString(1, maPT_);
			st.setString(2, maDia_);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(1);
				String maDia = rs.getString(2);
				String hanTra = rs.getString(3);
				int thanhTien = rs.getInt(4);
				ChiTietPhieuThue ctpt = new ChiTietPhieuThue(new PhieuThue(maPT), new Dia(maDia), hanTra, thanhTien);
				return ctpt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ChiTietPhieuThue getPhieuThueGanNhat_TheoDia(String maDia_) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select top 1 * from ChiTietPhieuThue where maDia = ? order by maPT desc");
			st.setString(1, maDia_);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(1);
				String maDia = rs.getString(2);
				String hanTra = rs.getString(3);
				int thanhTien = rs.getInt(4);
				ChiTietPhieuThue ctpt = new ChiTietPhieuThue(new PhieuThue(maPT), new Dia(maDia), hanTra, thanhTien);
				return ctpt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
