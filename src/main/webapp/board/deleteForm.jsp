<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/view/color.jsp"%>

<%
int num = (int) request.getAttribute("num");
String pageNum = (String) request.getAttribute("pageNum");
%>
<html>
<head>
<title>'배불뚝이'-산모를 위한 사이트</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script language="JavaScript">
<!--
	function deleteSave() {
		if (document.delForm.passwd.value == '') {
			alert("비밀번호를 입력하십시요.");
			document.delForm.passwd.focus();
			return false;
		}
	}
// -->
</script>
</head>

<body bgcolor="<%=bodyback_c%>">
	<jsp:include page="/board/boardHeader.jsp"></jsp:include>
	<center>
		<b>글삭제</b> <br>
		<form method="POST" name="delForm"
			action="boardDeletePro.bo?pageNum=<%=pageNum%>"
			onsubmit="return deleteSave()">

			<table border="1" align="center" cellspacing="0" cellpadding="0"
				width="360">
				<tr height="30">
					<td align=center bgcolor="<%=value_c%>"><b>비밀번호를 입력해 주세요.</b></td>
				</tr>
				<tr height="30">
					<td align=center>비밀번호 : <input type="password" name="passwd"
						size="8" maxlength="12"> <input type="hidden" name="num"
						value="<%=num%>"></td>
				</tr>
				<tr height="30">
					<td align=center bgcolor="<%=value_c%>"><input type="submit"
						value="글삭제"> <input type="button" value="글목록"
						onclick="document.location.href='boardList.bo?pageNum=<%=pageNum%>'">
					</td>
				</tr>
			</table>
		</form>
</body>
<jsp:include page="/board/boardFooter.jsp"></jsp:include>
</html>
