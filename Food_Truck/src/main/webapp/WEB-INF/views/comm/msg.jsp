<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String msg = (String)request.getAttribute("msg"); %>

<script type="text/javascript">
alert('<%=msg%>');
<!-- 
location.href="/loginform"  // ������ �̵�...   
--> 
</script>