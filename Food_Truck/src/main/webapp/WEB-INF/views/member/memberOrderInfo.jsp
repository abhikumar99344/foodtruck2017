<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../comm/header.jsp"></jsp:include>
<style>
	.table-responsive, .unit, .table-info{
		border: hidden;
	}
	
	
</style>
<body>

	<%@include file="../comm/nav.jsp"%>

	<!-- test -->
	<div></div>
	<section class="cart-page page fix">
		<!--Start Cart Area-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-md-3">
					<div class="single-sidebar">
						<h2>내 정보</h2>
						<ul align="center">
							<li><a href="/memberInfo">회원 정보</a></li>
							<li><a href="/memberOrderInfo">주문 내역</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-8 col-md-9">
					<div class="table-responsive">
						<table class="table cart-table">		
							<thead class="table-title">				
								<tr>
									<th class="ftruckNo">푸드 트럭</th>
									<th class="ordDate">주문일</th>
									<th class="prodName">상품명</th>
									<th class="ordQty">수량</th>
									<th class="ordPrice">가격</th>
								</tr>
							</thead>
							<tbody>
							<c:set var = "sum" value="0" />
								<c:forEach items='${list}' var="MemberInfo">
									<tr class="table-info">
										<!-- 푸드트럭 이름 -->
										<td class="unit">${MemberInfo.ftruckName}
										<!-- 주문일 -->
										<td class="unit">${MemberInfo.ordDate}</td>		
										<!-- 상품명 -->
										<td class="unit">${MemberInfo.prodName}</td>
										<!-- 상품 갯수  -->
										<td class="unit">${MemberInfo.ordQty}개</td>
										<!-- 제품 가격 -->
										<td class="unit">${MemberInfo.ordPrice}원</td>
									</tr>
										<c:set var="sum" value="${sum+MemberInfo.ordPrice}" />
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-sm-6 col-md-7">
					</div>					
					<div class="col-sm-6 col-md-5">
						<div class="proceed fix">
							<div class="total">
								<h6>
									총 금액 <span class="totalPriceTest"><c:out value="${sum}" />원</span>
								</h6>
							</div>
						</div>
					</div>	
				</div>			
			</div>
		</div>
	</section>
	
	<!--End Cart Area-->

	<br>
	<br>
	<br>
	
	<jsp:include page="../comm/footer.jsp"></jsp:include>

</body>
</html>