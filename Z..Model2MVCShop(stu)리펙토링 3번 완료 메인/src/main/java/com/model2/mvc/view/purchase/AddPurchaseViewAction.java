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
import com.model2.mvc.service.user.vo.UserVO;

public class AddPurchaseViewAction extends  Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {

		String prodNum = request.getParameter("prodNo");
		System.out.println("AddPurchaseViewAction TO addPurchaseView " + prodNum);
		
		ProductService service=new ProductServiceImpl();
		ProductVO vo = service.findProduct(prodNum);
		request.setAttribute("prodInfo", vo);
		return "forward:/purchase/addPurchaseView.jsp";
	}
}