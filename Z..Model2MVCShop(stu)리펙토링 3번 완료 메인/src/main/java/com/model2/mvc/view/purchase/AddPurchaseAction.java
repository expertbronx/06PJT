package com.model2.mvc.view.purchase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;


public class AddPurchaseAction extends  Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
     //  request.getParameter()
		HttpSession session = request.getSession();
		String prodNum = request.getParameter("prodNo");
		
		PurchaseService pservice = new PurchaseServiceImpl();
		ProductService service=new ProductServiceImpl();
		ProductVO vo = service.findProduct(prodNum);
		UserVO uvo =  (UserVO) session.getAttribute("user");
		PurchaseVO pvo = new PurchaseVO();
		
			pvo.setBuyer(uvo);
			pvo.setPurchaseProd(vo);
			pvo.setPaymentOption(request.getParameter("paymentOption"));
			pvo.setReceiverName(request.getParameter("receiverName"));
			pvo.setReceiverPhone(request.getParameter("receiverPhone"));
			pvo.setDivyAddr(request.getParameter("receiverAddr"));
			pvo.setDivyRequest(request.getParameter("receiverRequest"));
			pvo.setDivyDate(request.getParameter("receiverDate"));
			System.out.println("내용점검" + pvo);

		request.setAttribute("prodInfo", vo);
		request.setAttribute("purcInfo", pvo);
		
		pservice.addPurchase(pvo);
				
		return "forward:/purchase/addPurchase.jsp";
	}
}
