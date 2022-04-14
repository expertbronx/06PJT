package com.model2.mvc.view.purchase;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class UpdateTranCodeAction extends Action {
       
	public String execute(	HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProductService pservice = new ProductServiceImpl();
		PurchaseService service = new PurchaseServiceImpl();
		PurchaseDAO purchaseDAO = new PurchaseDAO();

		System.out.println("¿€µø¡ﬂ1");
		
		// §–§–...
		
		PurchaseVO vo =  purchaseDAO.findTranInfo(
				Integer.parseInt(request.getParameter("prodNo")) );
		ProductVO pvo = pservice.findProduct(request.getParameter("prodNo"));
		vo.setPurchaseProd(pvo);
		System.out.println(request.getParameter("proTranCode"));
		
		service.updateTranCode(vo);
		System.out.println("dddd"+ vo);
		return "forward:/index.jsp";
	}
}
