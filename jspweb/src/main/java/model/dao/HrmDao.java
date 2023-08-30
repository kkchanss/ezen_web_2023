package model.dao;

import java.util.ArrayList;

import model.dto.HrmDto;

public class HrmDao extends Dao {
	private static HrmDao hrmDao = new HrmDao();
	public static HrmDao getInstance() {return hrmDao;}
	private HrmDao() {};
	
	public boolean hrmWrite(String hname, String himg, String hphone, String hposition) {
		
		try {
			String sql = "insert into hrm(hname,himg,hphone,hposition) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, hname);
			ps.setString(2, himg);
			ps.setString(3, hphone);
			ps.setString(4, hposition);
			int row = ps.executeUpdate();
			if(row == 1) return true;
		}catch(Exception e) {
			System.out.println("hrmWrite DB 오류 발생 : " + e);
		}
		
		return false;
	}
	
	public ArrayList<HrmDto> hrmSelect() {
		
		ArrayList<HrmDto> list = new ArrayList<>();
		
		try {
			String sql = "select * from hrm";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HrmDto dto = new HrmDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				
				list.add(dto);
			}
			return list;
		}catch(Exception e) {
			System.out.println("hrmSelect DB 오류 발생 : " + e);
		}
		
		return null;
	}
}
