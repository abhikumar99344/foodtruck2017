<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<jsp:include page="../comm/header.jsp"></jsp:include>
<script src="//code.jquery.com/jquery-1.11.0.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	function itemChange() {
		var info = [ "상품수정", "정보수정/이미지 호스팅", "상품품절", "할인" ];
		var pay = [ "제한/탈퇴", "등급/상태", "정보번경" ];
		var deliver = [ "상담불만족/건의", "상담추천/칭찬" ];
		var cancel = [ "예약정보확인", "배송정보확인" ];
		var event = [ "이용료", "정산내역/일정" ];

		var selectItem = $("#select1").val();

		var changeItem;

		if (selectItem == "상품") {
			changeItem = info;
		} else if (selectItem == "내푸드트럭") {
			changeItem = pay;
		} else if (selectItem == "고객의 소리") {
			changeItem = deliver;
		} else if (selectItem == "배달") {
			changeItem = cancel;
		} else if (selectItem == "이용료/정산/부과세") {
			changeItem = event;
		}

		$('#select2').empty();

		for (var count = 0; count < changeItem.length; count++) {
			var option = $("<option>" + changeItem[count] + "</option>");
			$('#select2').append(option);
		}

	}

	$(function() {
		$("#go").click(function() {
			alert("나의설정 -> 내문의내역 리스트에서 확인가능합니다");
		})
	})
</script>
<style type="text/css">
b {
	font-size: 30px;
}
</style>
<body>
	<%@include file="../comm/nav.jsp"%>

	<div class="span9">
		<form id="frm" action="/sellerinquriy" method="post">
			<div style="margin-left: 300px; margin-right: 300px;">
				<b>문의하기</b><br>
				<table summary="G마켓에 문의하기 작성 폼"
					style="margin-left: auto; margin-right: auto;"
					class="table notice-main">
					<colgroup>
						<col width="16%;">
						<col width="38%;">
						<col width="12%;">
						<col width="*;">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">사업자번호</th>
							<td><select name="licenseNo">
									<c:forEach items="${list}" var="all">
										<option>${all.licenseNo}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th scope="row">문의종류선택</th>
							<td>
								<!-- 중분류 시작 --> <select id="select1" name="qaScCategory1"
								onchange="itemChange()" title="문의종류 선택 정보1"
								style="width: 110px;"><option value="ALL">선택</option>
									<option>상품</option>
									<option>내푸드트럭</option>
									<option>고객의 소리</option>
									<option>배달</option>
									<option>이용료/정산/부과세</option></select> <select id="select2"
								name="qaScCategory2" title="문의종류 선택 정보2" style="width: 130px;">
									<option value="ALL">선택</option>
							</select>

							</td>
						</tr>

						<tr>
							<th scope="row" style="margin-bottom: 10px;">문의 제목</th>
							<td id="thTitle" colspan="0"><input type="text"
								name="qaScTitle" id="title" class="txt" style="width: 261px;"
								maxlength="100" title="문의 제목 입력"> <!-- 2013-09-16 웹접근성 개편 --></td>
							<!-- WPR-359 -->
							<td scope="row"></td>
							<!-- //WPR-359 -->
						</tr>
						<tr>
							<th scope="row">문의 내용
								<p>
							</th>
							<td colspan="3"><textarea name="qaScContent"
									id="txtContents" cols="65" rows="14"
									style="width: 587px; height: 168px;"
									onfocus="TextAreaFocused(this);" onkeydown="getsize(this);"
									wrap="VIRTUAL" class="txtbox" title="문의 내용 입력"></textarea>
								<div class="byte">
									<br>
								</div></td>
						</tr>
						<tr>
							<th scope="row">연락 받으실 SMS</th>
							<td colspan="3"><input type="text" class="txt"
								style="width: 200px;" name="qaScTel" title="핸드폰번호 "> <input
								name="SMS_NOTI_YN" type="checkbox" class="chk" value="Y"
								checked="" title="SMS로 답변 받음 체크">답신여부를 SMS로 받음 <!--<input name="chkCUSTOM_UPDATE_YN" id="chkCUSTOM_UPDATE_YN" type="checkbox" class="chk2" value="Y" title="나의정보 동시변경 체크" checked>나의정보 동시변경-->
							</td>
						</tr>
						<tr>
							<th scope="row" style="width: 200px;">답변 받으실 E-mail</th>
							<td colspan="3">${id}<input type="hidden" value="${id}"
								name="memId">
								<p>
									&nbsp;<span style="font-size: 8pt"><font color="gray"
										face="돋움">회원정보 변경을 하려면 ? </font></span> <a href="" target="_blank"><u><font
											color="blue" face="돋움"><span style="FONT-SIZE: 8pt">&gt;&gt;
													나의설정 바로가기</span></font></u></a>
								</p></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_center_box" align="center">
				<input type="submit" class="btn btn-danger btn-large"
					value="문의하기 등록" id="go">&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" class="btn btn-danger btn-large" value="입력취소">
			</div>
		</form>
		<br> <br>
		<jsp:include page="../comm/footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript">
	function email() {
		$('#e_mail2').val($('#mail_server').val());
	}
	$('#mail_server').change(email);
</script>
</html>