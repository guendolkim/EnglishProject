<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form:form class="" action="/portfolio/book/joinBook"
				modelAttribute="CodeVO" method="post" enctype="multipart/form-data">
<ul>
     <li>BOOK_KO_NAME<input type="text" value=""></li>
    <li>BOOK_EN_NAME<input type="text"></li>
    <li>BOOK_KO_AUHTHOR<input type="text"></li>
    <li>BOOK_EN_AUHTHOR<input type="text">${difficult }</li> 
    <li>
  
   <form:select class="difficult" path="difficult" items="${difficult }">
								<option value="">선택</option>
								<form:options path="difficult" items="${difficult }"
									itemValue="CODE_ID" itemLabel="NAME" />
							</form:select></li> 
							
     <li>BOOK_LEVEL<input type="text"></li>
    <li>BOOK_KO_CONTENT<input type="text"></li>
    <li>BOOK_EN_CONTENT<input type="text"></li>
    <li>BOOK_PIC<input type="text"></li>
    <li>BOOK_FTYPE<input type="text"></li>
    <li>BOOK_FSIZE<input type="text"></li>
    <li>BOOK_FNAME<input type="text"></li>
    <li><input type="submit" value="등록"></li>
    <li><input type="submit" value="취소"></li> 
  </ul>
  </form:form>
</body>
</html>