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
import entities.PhieuThue;
import entities.TaiKhoan;

public class QuanLyPhieuThue {
	private ArrayList<PhieuThue> dsPhieuThue;

	public QuanLyPhieuThue() {
		dsPhieuThue = new ArrayList<>();
	}

	public ArrayList<PhieuThue> getDS() {
		return dsPhieuThue;
	}

	public int getMaPhieuThue() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 ID from PhieuThue order by ID desc";
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

	public ArrayList<PhieuThue> dsPhieuThue() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from PhieuThue";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maPT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngayThue = rs.getString(4);
				String tenTK = rs.getString(5);
				int tongTien = rs.getInt(6);
				PhieuThue pt = new PhieuThue(maPT, new KhachHang(maKH), ngayThue, new TaiKhoan(tenTK), tongTien);
				dsPhieuThue.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuThue;
	}

	public void themPhieuThue(PhieuThue pt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into PhieuThue(maKH,ngayThue,tenTK,tongTien) " + " values('"
					+ pt.getKhachHang().getMaKH() + "','" + pt.getNgayThue() + "','" + pt.getNhanVien().getTenTK()
					+ "'," + pt.getTongTien() + ")");

		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}
	
	public static PhieuThue chiTietPhieuThue(String maPT_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuThue where maPT = ?");
			st.setString(1, maPT_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngayThue = rs.getString(4);

				String tenTK = rs.getString(5);
				int tongTien = rs.getInt(6);
				PhieuThue pt = new PhieuThue(maPT, new KhachHang(maKH), ngayThue, new TaiKhoan(tenTK), tongTien);
				return pt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PhieuThue> tim_PhieuThue(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuThue where maPT like ? or maKH like ?");
			st.setString(1, "%" + text + "%");
			st.setString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngayThue = rs.getString(4);

				String tenTK = rs.getString(5);
				int tongTien = rs.getInt(6);
				PhieuThue pt = new PhieuThue(maPT, new KhachHang(maKH), ngayThue, new TaiKhoan(tenTK), tongTien);
				dsPhieuThue.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuThue;
	}
	
	public ArrayList<PhieuThue> tim_PhieuThue_Nhap(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from dbo.TimPhieuThue(?)");
			st.setString(1, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngayThue = rs.getString(4);

				String tenTK = rs.getString(5);
				int tongTien = rs.getInt(6);
				PhieuThue pt = new PhieuThue(maPT, new KhachHang(maKH), ngayThue, new TaiKhoan(tenTK), tongTien);
				dsPhieuThue.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuThue;
	}
	
	
	public ArrayList<PhieuThue> tim_PhieuThue_Ngay(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuThue where ngayThue = ?");
			st.setString(1, text);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngayThue = rs.getString(4);

				String tenTK = rs.getString(5);
				int tongTien = rs.getInt(6);
				PhieuThue pt = new PhieuThue(maPT, new KhachHang(maKH), ngayThue, new TaiKhoan(tenTK), tongTien);
				dsPhieuThue.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuThue;
	}
	
	public ArrayList<PhieuThue> tim_PhieuThue_KhachHang(String maKH_) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuThue where maKH = ?");
			st.setString(1, maKH_);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maPT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngayThue = rs.getString(4);

				String tenTK = rs.getString(5);
				int tongTien = rs.getInt(6);
				PhieuThue pt = new PhieuThue(maPT, new KhachHang(maKH), ngayThue, new TaiKhoan(tenTK), tongTien);
				dsPhieuThue.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuThue;
	}
	
	public static PhieuThue timPhieuThue_DiaThue_GanNhat(String maDia) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select top 1 * from PhieuThue "
					+ "where maPT in (select maPT from ChiTietPhieuThue ct join Dia d on ct.maDia = d.maDia where d.maDia = ?) order by ngayThue desc");
			st.setString(1, maDia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maPT = rs.getString(2);
				String maKH = rs.getString(3);
				String ngayThue = rs.getString(4);

				String tenTK = rs.getString(5);
				int tongTien = rs.getInt(6);
				PhieuThue pt = new PhieuThue(maPT, new KhachHang(maKH), ngayThue, new TaiKhoan(tenTK), tongTien);
				return pt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public boolean capNhatPhieuThue(PhieuThue pt) {
//	Database.getInstance();
//	Connection con = Database.getConnection();
//	PreparedStatement stmt = null;
//	int n = 0;
//	try {
//		stmt = con.prepareStatement("update KhachHang set tenTK = ? where maPT = ? ");
//		stmt.setString(1, pt.getNhanVien().getTenTK());
//		n = stmt.executeUpdate();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return n > 0;
//}
//
//public boolean delete(String maPT) {
//	Connection con = database.Database.getInstance().getConnection();
//	PreparedStatement stmt = null;
//	int n = 0;
//	try {
//		stmt = con.prepareStatement("delete from PhieuThue where maPT = ?");
//		stmt.setString(1, maPT);
//		n = stmt.executeUpdate();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return n > 0;
//}
}
