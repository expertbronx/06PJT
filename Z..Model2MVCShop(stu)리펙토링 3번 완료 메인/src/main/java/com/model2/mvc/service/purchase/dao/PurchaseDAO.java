package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseDAO {

	
	public PurchaseVO findPurchase(int i) throws Exception{
		
		Connection con = DBUtil.getConnection();

		String sql = "SELECT * FROM transaction "
				+ "WHERE tran_no = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,  i);

		ResultSet rs = stmt.executeQuery();
		
		PurchaseVO vo = new PurchaseVO();
		while (rs.next()) {
			vo.setTranNo(rs.getInt("TRAN_NO"));
			vo.setPaymentOption(rs.getString("PAYMENT_OPTION"));
			vo.setReceiverName(rs.getString("RECEIVER_NAME"));
			vo.setReceiverPhone(rs.getString("RECEIVER_PHONE"));
			vo.setDivyAddr(rs.getString("DLVY_ADDR"));
			vo.setDivyRequest(rs.getString("DLVY_REQUEST"));
			vo.setTranCode(rs.getString("TRAN_STATUS_CODE"));
			vo.setOrderDate(rs.getDate("ORDER_DATA"));
			vo.setDivyDate(rs.getString("DLVY_DATE"));
		}
		
		con.close();

		return vo;
	}
	
public PurchaseVO findTranInfo(int i) throws Exception{
		
		Connection con = DBUtil.getConnection();

		String sql = "SELECT * FROM transaction "
				+ "WHERE prod_no = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,  i);

		ResultSet rs = stmt.executeQuery();
		
		PurchaseVO vo = new PurchaseVO();
		while (rs.next()) {
			vo.setTranNo(rs.getInt("TRAN_NO"));
			vo.setPaymentOption(rs.getString("PAYMENT_OPTION"));
			vo.setReceiverName(rs.getString("RECEIVER_NAME"));
			vo.setReceiverPhone(rs.getString("RECEIVER_PHONE"));
			vo.setDivyAddr(rs.getString("DLVY_ADDR"));
			vo.setDivyRequest(rs.getString("DLVY_REQUEST"));
			vo.setTranCode(rs.getString("TRAN_STATUS_CODE"));
			vo.setOrderDate(rs.getDate("ORDER_DATA"));
			vo.setDivyDate(rs.getString("DLVY_DATE"));
		}
		
		con.close();

		return vo;
	}

	public PurchaseVO insertPurchase(PurchaseVO vo) throws Exception{
		
		Connection con = DBUtil.getConnection();

		String sql = "INSERT INTO transaction "+
		"VALUES(SEQ_transaction_tran_no.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, vo.getPurchaseProd().getProdNo());
		stmt.setString(2, vo.getBuyer().getUserId());
		stmt.setString(3, vo.getPaymentOption());
		stmt.setString(4, vo.getReceiverName());
		stmt.setString(5, vo.getReceiverPhone());
		stmt.setString(6, vo.getDivyAddr());	
		stmt.setString(7, vo.getDivyRequest());	
		stmt.setString(8, "002");
		stmt.setString(9, vo.getDivyDate());
		
		ResultSet rs = stmt.executeQuery();
		
		con.close();
		
		return vo;
	}
	
	public Map<String, Object> getPurchaseList(Search search, String i) throws Exception {

		Map<String , Object>  map = new HashMap<String, Object>();
		String sql = "SELECT t.tran_no, u.user_id, t.receiver_name, t.receiver_phone, t.tran_status_code, p.prod_no "
				+"FROM users u, transaction t, product p "
				+"WHERE t.buyer_id = u.user_id "
				+"AND t.prod_no = p.prod_no "
				+"AND u.user_id = '"+i+"'";
		
		sql += " ORDER BY  tran_no";
		System.out.println("UserDAO::Original SQL :: " + sql);
		
		int totalCount = this.getTotalCount(sql);
		System.out.println("UserDAO :: totalCount  :: " + totalCount);
		
		sql = makeCurrentPageSql(sql, search);
		
		Connection con = DBUtil.getConnection();
		Statement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println(search);
			
		List<PurchaseVO> list = new ArrayList<PurchaseVO>();

			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setProdNo(rs.getInt("prod_no"));
				
				PurchaseVO vo = new PurchaseVO();
				vo.setPurchaseProd(pvo);
				vo.setTranNo(rs.getInt("tran_no"));
				vo.setReceiverName(rs.getString("receiver_name"));
				vo.setReceiverPhone(rs.getString("receiver_phone"));
				vo.setTranCode(rs.getString("tran_status_code"));
	
				list.add(vo);
				System.out.println("점검점0" + vo);
			}
			map.put("totalCount", new Integer(totalCount));
			//==> currentPage 의 게시물 정보 갖는 List 저장
			map.put("list", list);

			rs.close();
			stmt.close();
			con.close();
			return map;
	}
	public PurchaseVO updatePurchase(PurchaseVO vo) throws Exception{
		System.out.println(vo);
		System.out.println("업뎃 메서드 종료");
		Connection con = DBUtil.getConnection();

		String sql = "UPDATE transaction "
		+ "SET receiver_name = ?, "
		+ "dlvy_addr = ?, "
		+ "receiver_phone = ? "
		+ "WHERE tran_no= ? ";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		System.out.println("널인가?" + vo.getReceiverName());
		stmt.setString(1, vo.getReceiverName());
		stmt.setString(2, vo.getDivyAddr());
		stmt.setString(3, vo.getReceiverPhone());
		stmt.setInt(4, vo.getTranNo());
		ResultSet rs = stmt.executeQuery();
		con.close();
		
		return vo;
	}
	
	public void updateTranCode(PurchaseVO vo) throws Exception{
		System.out.println(vo);
		System.out.println("업뎃 메서드 종료");
		Connection con = DBUtil.getConnection();

		String sql = "UPDATE transaction "
		+ "SET tran_status_code = ? "
		+ "WHERE prod_no= ? ";
		System.out.println("최종점검" + vo);
		PreparedStatement stmt = con.prepareStatement(sql);
		if( vo.getTranCode().equals("002" ))  {
		stmt.setString(1, "003");
		stmt.setInt(2, vo.getPurchaseProd().getProdNo());
		}else if(  vo.getTranCode().equals("003" )) {
		stmt.setString(1, "004");
		stmt.setInt(2, vo.getPurchaseProd().getProdNo());
		}
		
		ResultSet rs = stmt.executeQuery();
		vo.getPurchaseProd().setProTranCode("tran_status_code");
		con.close();
		
	}
	private int getTotalCount(String sql) throws Exception {
		
		sql = "SELECT COUNT(*) "+
		          "FROM ( " +sql+ ") countTable";
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		
		int totalCount = 0;
		if( rs.next() ){
			totalCount = rs.getInt(1);
		}
		
		pStmt.close();
		con.close();
		rs.close();
		
		return totalCount;
	}
	
	private String makeCurrentPageSql(String sql , Search search){
		sql = 	"SELECT * "+ 
					"FROM (		SELECT inner_table. * ,  ROWNUM AS row_seq " +
									" 	FROM (	"+sql+" ) inner_table "+
									"	WHERE ROWNUM <="+search.getCurrentPage()*search.getPageSize()+" ) " +
					"WHERE row_seq BETWEEN "+((search.getCurrentPage()-1)*search.getPageSize()+1) +" AND "+search.getCurrentPage()*search.getPageSize();
		
		System.out.println("UserDAO :: make SQL :: "+ sql);	
		
		return sql;
	}
	
}
	
