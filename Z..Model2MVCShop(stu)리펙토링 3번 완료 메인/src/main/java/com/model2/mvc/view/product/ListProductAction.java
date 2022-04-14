package com.model2.mvc.view.product;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;


public class ListProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		String menu = request.getParameter("menu");
		System.out.println("중가점검" + menu);
		
		Search search=new Search();
		int currentPage=1;
		if( request.getParameter("currentPage")  != null ){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		System.out.println("체에ㅔ에에에에에엥크" + currentPage);
		search.setCurrentPage(currentPage);
		
		int pageSize = Integer.parseInt(getServletContext().getInitParameter("pageSize"));
		int pageUnit  =  Integer.parseInt(getServletContext().getInitParameter("pageUnit"));
		search.setPageSize(pageSize);
		
		ProductService service=new ProductServiceImpl();
		Map<String , Object> map = service.getProductList(search);
		
		Page resultPage	= 
		new Page( currentPage, ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		request.setAttribute("list", map.get("list"));
		request.setAttribute("resultPage", resultPage);
		request.setAttribute("search", search);
		request.setAttribute("map", map);
		request.setAttribute("menu", menu);
		System.out.println(map);
		return "forward:/product/listProduct.jsp";
	}
}