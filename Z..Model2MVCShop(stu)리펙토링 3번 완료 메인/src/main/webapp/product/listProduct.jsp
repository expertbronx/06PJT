<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.service.product.vo.*" %>
<%@ page import="com.model2.mvc.view.product.*" %>
<%@ page import="com.model2.mvc.common.*" %>   

<%--<%
	HashMap<String,Object> map=(HashMap<String,Object>)request.getAttribute("map");
	SearchVO searchVO=(SearchVO)request.getAttribute("searchVO");
	
	
	int total=0;
	ArrayList<ProductVO> list=null;
	if(map != null){
		total=((Integer)map.get("count")).intValue();
		list=(ArrayList<ProductVO>)map.get("list");
	}
	
	int currentPage=searchVO.getPage();
	
	int totalPage=0;
	if(total > 0) {
		totalPage= total / searchVO.getPageUnit() ;
		if(total%searchVO.getPageUnit() >0)
			totalPage += 1;
	}
--%>

<!DOCTYPE html>
<html>
<head>


<title>惑前 包府</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">
<!--
function fncGetProductList(currentPage){
	document.getElementById("currentPage").value = currentPage;
	document.detailForm.submit();
}
-->
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=search" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
					
	<c:if test="${menu eq 'manage'}">
		惑前 包府
	</c:if
	>
	<c:if test="${menu eq 'search'}">
		惑前 格废炼雀
	</c:if>			
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0">惑前锅龋</option>
				<option value="1">惑前疙</option>
				<option value="2">惑前啊拜</option>
			</select>
			<input type="text" name="searchKeyword"  class="ct_input_g" style="width:200px; height:19px" />
		</td>
	
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetProductList();">八祸</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >傈眉 ${map.count} 扒荐, 泅犁 ${searchVO.page} 其捞瘤</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">惑前疙</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">啊拜</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">殿废老</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">泅犁惑怕</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>

	<c:if test="${menu eq 'manage'}">
		<c:forEach items="${map.list}" var="var" varStatus="i">	

		<tr class="ct_list_pop">
			<td align="center">${map.list[i.index].prodNo}</td>
			<td></td>
			<td align="left">
			<c:if test="${empty map.list[i.index].proTranCode}">
			<a href="/updateProductView.do?prodNo=${map.list[i.index].prodNo}&menu=manage">${map.list[i.index].prodName}</a>
			</c:if>
			<c:if test="${!empty map.list[i.index].proTranCode}">
			${map.list[i.index].prodName}
			</c:if>		
			</td>
					<td></td>
		<td align="left">${map.list[i.index].price}</td>
		<td></td>
		<td align="left">${map.list[i.index].regDate}</td>
		<td></td>
		<td align="left">
		
			<jsp:include page="/purchase/GetPurchase.jsp">
				<jsp:param name="count" value="${i.index}"/>
			</jsp:include>	
		
		</td>	
	</tr>
		</c:forEach>
		</c:if>
		<c:if test="${menu eq 'search'}">
	<c:forEach items="${map.list}" var="var" varStatus="i">			
	<tr class="ct_list_pop">
		<td align="center">${map.list[i.index].prodNo}</td>
		<td></td>

			<td align="left">
			<c:if test="${empty map.list[i.index].proTranCode}">
			<a href="/getProduct.do?prodNo=${map.list[i.index].prodNo}&menu=search">${map.list[i.index].prodName}</a>
			</c:if>
			<c:if test="${!empty map.list[i.index].proTranCode}">
			${map.list[i.index].prodName}
			</c:if>		
			</td>
					<td></td>
		<td align="left">${map.list[i.index].price}</td>
		<td></td>
		<td align="left">${map.list[i.index].regDate}</td>
		<td></td>
		<td align="left">
		
			<jsp:include page="/purchase/GetPurchase.jsp">
				<jsp:param name="count" value="${i.index}"/>
			</jsp:include>		
		</td>	
	</tr>
	</c:forEach>
</c:if>
		
		
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
		
	<input type="hidden" id="currentPage" name="currentPage" value=""/>	
	<c:if test="${ resultPage.currentPage <= resultPage.pageUnit }">
			⒏ 捞傈
	</c:if>
	<c:if test="${ resultPage.currentPage > resultPage.pageUnit }">
			<a href="javascript:fncGetProductList('${ resultPage.currentPage-1}')">⒏ 捞傈</a>
	</c:if>
	
	<c:forEach var="i"  begin="${resultPage.beginUnitPage}" end="${resultPage.endUnitPage}" step="1">
		<a href="javascript:fncGetProductList('${ i }');">${ i }</a>
	</c:forEach>
	
	<c:if test="${ resultPage.endUnitPage >= resultPage.maxPage }">
			捞饶 ⒑
	</c:if>
	<c:if test="${ resultPage.endUnitPage < resultPage.maxPage }">
			<a href="javascript:fncGetProductList('${resultPage.endUnitPage+1}')">捞饶 ⒑</a>
	</c:if>

		
    	</td>
	</tr>
</table>
<!--  其捞瘤 Navigator 场 -->

</form>

</div>
</body>
</html>
