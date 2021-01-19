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

 
	<!-- 회원가입에 이용 -->
	<!-- Start reservation Area -->
	<section class="reservation-area section-gap relative">
		<div class="overlay overlay-bg"></div>
		<div class="container  ">
			<div class="row justify-content-between align-items-center">
			
				<div class="col-lg-5 reservation-right">
				
				
					<form class="form-wrap text-center" action="finalsendemail" method="get">
					<p>보낼 메일주소</p>
						<input type="text" class="form-control" name="sendemail"
							placeholder="수신할 이메일" onfocus="this.placeholder = ''"
							onblur="this.placeholder = '수신할 이메일'"> 
							
						<p>제목</p>	
						<input type="text" class="form-control" name="sendtitle"
							placeholder="메일제목" onfocus="this.placeholder = ''"
							onblur="this.placeholder = '메일제목'"> 
							
						<p>내용</p>	
						<div align="center"><!-- 내용 --> 
                           <textarea  class="form-control" name="sendcontent" id="sendcontent" cols="120" rows="12" 
                           style="width:100%; resize:none" placeholder="메일의 내용" class="form-control" >
                           
                           
                           </textarea>
                        </div>
                        
					
						<input type="submit" value="메일로 보내기"  class="primary-btn text-uppercase mt-20">
					</form>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End reservation Area -->


</body>

<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script>
			$(document).ready(function(){
						
						 //텍스트에리어에 붙여넣기
						 
						 $('#sendcontent').text('${boardnoarray}');  //'[52, 51]'
						 
						 var array123 = ${boardnoarray};

								 
						 
					 var urltext123 = "";	
						// '[52, 51]' 배열 안의 값 각각에 접근함.
					for (var  i = 0; i < $(array123).length; i++) {
						
						  var urltext="";
						  
						

                        	urltext += 
								 "http://localhost:8787/spring_mybatis/rboard_detail?boardno="
									 +$(array123).get(i);
                        	
                            urltext123 +=   urltext  ;
                            urltext123 += "  <br>  ";
                           
        
                        	alert(urltext);
                  };
                  
                  $('#sendcontent').text(  urltext123   );
                 
					
			});

		    </script>


	<!-- End services Area -->



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