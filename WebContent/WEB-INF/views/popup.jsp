<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="resources/img2/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<title>Insert title here</title>


<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
			CSS
			============================================= -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/linearicons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/jquery-ui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/nice-select.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/animate.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/owl.carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/main.css">



</head>



<body>
<p>작성글 보기</p>

  <table class="type09"  style="width: 800px ; margin: 0 auto">
    <thead>
    <tr>
        <th >제목</th>
        <th >분류</th>
 
        <th >날짜</th>
        <th  style="width: 110px">조회수</th>
        <th  style="width: 110px">댓글수</th>
        <th   >보러가기</th>
    </tr>
    </thead>
        

<div class="filters-content">
	<div class="row grid">

	<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 myrboard를 dto로 -->
   <c:choose>
	 <c:when test="${empty madeby}">
							<tr>
								<td colspan="4">----작성된 글이 존재하지 않습니다----</td>
							</tr>
	</c:when>

	<c:otherwise>
			<c:forEach items="${madeby}" var="dto">

								

    <tbody>
						
    <tr>
        <td onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title }</td>
         <td>${dto.foodkind }/
         ${dto.countrykind }/
         ${dto.timekind }</td>
        
        <td >${dto.reg_date }</td>
        <td style="width: 110px">${dto.readcount }</td>
        <td style="width: 110px">${dto.commentcount }</td>
        <td onclick="location.href='rboard_detail?boardno=${dto.boardno}'">보기</td>
    </tr>
   	
    </tbody>

</c:forEach>
	</c:otherwise>
	</c:choose>
</div>			
</div>
</table>
	
<style>
table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table.type09 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
table.type09 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
table.type09 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
</style>
	
				
</body>


	<!-- End services Area -->



	<script
		src="${pageContext.request.contextPath}/resources/js2/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/vendor/bootstrap.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/jquery-ui.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/hoverIntent.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/superfish.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/jquery.ajaxchimp.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/jquery.magnific-popup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/jquery.nice-select.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js2/mail-script.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js2/main.js"></script>






</html>