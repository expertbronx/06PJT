package com.model2.mvc.service.purchase;

import java.util.HashMap;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public interface PurchaseService {
	
	public PurchaseVO addPurchase(PurchaseVO purchaseVO)  throws Exception;
	
	public PurchaseVO getPurchase(int i) throws Exception;
	
	public Map<String, Object> getPurchaseList(Search search, String i) throws Exception;
	
	public Map<String, Object> getSaleList(Search search) throws Exception;
	
	public PurchaseVO updatePurchase(PurchaseVO purchaseVO) throws Exception;
	
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception;
	
}
