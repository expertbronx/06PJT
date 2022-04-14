package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService {
	
	private PurchaseDAO  purchaseDAO;
	private ProductDAO prodDAO;

	public PurchaseServiceImpl() {
		purchaseDAO = new PurchaseDAO();
		prodDAO = new ProductDAO();
	}

	@Override
	public PurchaseVO addPurchase(PurchaseVO purchaseVO) throws Exception {
		PurchaseVO pvo = purchaseDAO.insertPurchase(purchaseVO);
		return pvo;
	}

	@Override
	public PurchaseVO getPurchase(int i) throws Exception {
		PurchaseVO pvo = purchaseDAO.findPurchase(i);
		return pvo;
	}

	@Override
	public Map<String, Object> getPurchaseList(Search search, String i) throws Exception{
		
		return purchaseDAO.getPurchaseList(search, i);
	}

	@Override
	public Map<String, Object> getSaleList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseVO updatePurchase(PurchaseVO purchaseVO) throws Exception {
		PurchaseVO pvo = purchaseDAO.updatePurchase(purchaseVO);
		return pvo;
	}

	@Override
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.updateTranCode(purchaseVO);
	}

}
