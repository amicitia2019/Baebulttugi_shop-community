<%@page import="java.sql.Timestamp"%>
<%@page import="vo.PageVO"%>
<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "vo.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ include file="/view/color.jsp"%>
<%@ taglib  prefix = "c" 
uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%!
    SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //2021-01-12 09:17%>


<html>
<head>
<title>'배불뚝이'-산모를 위한 사이트</title>
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body bgcolor="<%=bodyback_c%>">
<jsp:include page="/board/boardHeader.jsp"></jsp:include>

<center><b>글목록(전체 글: ${pageVO.count})</b>
			<!-- 헤더 -->

<table width="700">
<tr>
    <td align="right" bgcolor="<%=value_c%>">
    <a href="boardWriteForm.bo">글쓰기</a>
    </td>
</table>

			
<c:if test="${pageVO.count == 0 }">
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
    <td align="center">
    게시판에 저장된 글이 없습니다.
    </td>
</table>
</c:if>

<!-- 테이블 -->
<c:if test="${pageVO.count != 0 }">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="<%=value_c%>"> 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td>    
    </tr>

   <c:set var = "number" value = "${pageVO.number }"></c:set>
   <c:forEach var = "article" items = "${articleList }">
   <tr height="30">
    <td align="center"  width="50" > ${number }
    <c:set var = "number" value = "${number - 1 }"></c:set>
    </td>
    
    <td  width="250" >

   <c:set var = "wid" value = "${0}"></c:set>
   <c:if test="${article.re_level > 0 }">
   <c:set var = "wid" value = "${article.re_level * 5}"></c:set>
     <img src="board/images/level.gif" width="${wid }" height="16">
     <img src="board/images/re.gif">
   </c:if>
   <c:if test="${article.re_level == 0 }">
     <img src="board/images/level.gif" width="${wid }" height="16">
   </c:if>
           
    <a href="boardContent.bo?num=${article.num }&pageNum=${pageVO.currentPage}">
           ${article.subject }</a> 
         <c:if test="${article.readcount >= 20 }">
         <img src="images/hot.gif" border="0"  height="16">
         </c:if>
         </td>
    <td align="center"  width="100"> 
       <a href="mailto:${article.email1 }">
       ${article.writer }</a></td>
    <td align="center"  width="150">
    
    <fmt:formatDate var="formDate" value = "${article.reg_date}" pattern="yyyy.MM.dd" />
    <c:out value="${formDate}"></c:out>
    </td>
    <td align="center"  width="50">${article.readcount }
    </td>
  </tr>
  </c:forEach>
</table>
</c:if>

						<!-- 페이지 이동 -->
        <c:if test="${pageVO.count > 0 }">
        <c:if test = "${pageVO.startPage > 10 }">
        <a href="boardList.bo?pageNum=${pageVO.startPage - 10 }">[이전]</a>
		</c:if>
		
		<c:forEach begin="${pageVO.startPage }" end="${pageVO.endPage }" var = "i">
        <a href="boardList.bo?pageNum=${i }">[${i }]</a>
        </c:forEach>
        <c:if test="${pageVO.endPage < pageVO.pageCount }">
        <a href="boardList.bo?pageNum=${startPage + 10 }">[다음]</a>
		</c:if>

</c:if>
</center>
<jsp:include page="/board/boardFooter.jsp"></jsp:include>
</body>
</html>