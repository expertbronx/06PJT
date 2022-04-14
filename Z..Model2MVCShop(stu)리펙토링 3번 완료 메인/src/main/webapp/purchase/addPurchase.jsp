<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>

<html>
<head>
<title>구매 결과창</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=0" method="post">

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td>${purcInfo.purchaseProd.prodNo}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<td>${user.userId}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
		<c:choose>
			<c:when test = "${purcInfo.paymentOption == '001'}">
			현금구매
			</c:when>
			<c:when test = "${purcInfo.paymentOption == '002'}">
			신용구매
			</c:when>
		</c:choose>
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td>${purcInfo.receiverName}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td>${purcInfo.receiverPhone}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<td>${purcInfo.divyAddr}</td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td>${purcInfo.divyRequest}</td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td>${purcInfo.divyDate}</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>