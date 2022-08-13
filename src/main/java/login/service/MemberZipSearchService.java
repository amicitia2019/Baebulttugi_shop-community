package login.service;

import java.sql.Connection; 
import java.util.ArrayList;

import login.dao.MemberDAO;

import static db.JdbcUtil.*;
import login.vo.ZipCodeVO;

public class MemberZipSearchService {

	public ArrayList<ZipCodeVO> searchZipcodeList(String ro) {
		// TODO Auto-generated method stub
		Connection con =getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		ArrayList<ZipCodeVO> zipCodeList = memberDAO.selectZipCodeList(ro);
		close(con);
		
		return zipCodeList;
	}

}
