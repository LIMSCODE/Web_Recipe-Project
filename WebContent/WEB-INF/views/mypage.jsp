<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- 추천순, 날짜순 / 내게시글 후기보기, 내가 남긴 댓글/  -->
<!-- 포인트 조회기간 선택 / 표 나옴/ 표 목록 : 날짜, 내역, 지급포인트, 사용포인트 -->
<!DOCTYPE html>
<html lang="zxx" class="no-js">
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
<!-- Site Title -->
<title>Marco</title>

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



	<header id="header">
		<div class="header-top">
			<div class="container">
				<div class="row justify-content-center">
					<div id="logo">
						<a href="index"><img src="resources/img2/logo.png" alt=""
							title="" /></a>
					</div>
				</div>
			</div>
		</div>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-center d-flex">
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="listSearchsendmail">레시피 게시판</a></li>
						<li><a href="reviewboard_a">후기 게시판</a></li>

						<li><a href="restau2"> 맛집 지도</a></li>
						
						<c:choose>

							<c:when test="${login!=null}">
								<li><a href="mypage">마이페이지 ()</a></li>
								
								<li><a href="originallogout">로그아웃</a></li>
							</c:when>

							<c:when test="${sessionId != null}">

								<li><a href="mypage">마이페이지</a></li>
								<li><a href="mypage">'${sessionId}'님, 네이버 아이디로 로그인됨.</a></li>
								<li><a href="logout">로그아웃</a></li>
								
								
								
								</h3>
							</c:when>


							<c:otherwise>
							
								<li><a href="loginform">로그인</a></li>
								<li><a href="registform">회원가입</a></li>
							</c:otherwise>
						</c:choose>

					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	<!-- #header -->


	<!-- start banner Area -->
	<section class="relative about-banner">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">My Page</h1>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->




	<section class="menu-area" style="margin:50px">
		<div class=""   >
			<div class="row justify-content-center">
				<div class="menu-content">
				
					<div class="title text-center">
					    <br>
						<h1 class="mb-10">회원 정보 </h1>
						<br>

					</div>
				</div>
			</div>
			<div class="row" style="vertical-align:middle">
				
					<!-- 마이페이지에 이용 -->
					<div class="form-group "  style="width: 1200px; vertical-align:middle; ">
					
					    <div style="float:left;  width: 30%; margin:10px" >
							<img src="${pageContext.request.contextPath}/${dtos.memberImg }" 
							     style="border: 1px solid;
                                 border-radius: 200px;
                                 -moz-border-radius: 200px;
                                 -khtml-border-radius: 200px;
                                 -webkit-border-radius: 200px; width: 200px; "/>
                        </div>
                        
                        <div style="float:left; width: 30%; margin:10px">
                            <p>ID : ${dtos.id }</p>
							<p>NAME : ${dtos.name}</p>
							<p style="color: red">${dtos.point } POINT 소유하고 있음.</p>
							
						</div>
						<div style="float:left; margin:10px">
						<br><br><br><br><br>
						</div>
						
						<div style="float:left; width: 20%; margin:10px">
						
							<p>EMAIL : ${dtos.email }</p>
							<p>PHONE : ${dtos.phone }</p>
							<a href="mypage_modify" class="primary-btn text-uppercase">수정</a>
							<a href="mypage_deletemember" class="primary-btn text-uppercase">탈퇴</a>
						</div>
						
					
						</div>
					</div>
				</div>
		
	</section>
	


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

<!-- Start menu-area Area -->
	<section class="menu-area" style="margin:10px" id="menu">
		<div class="container">

			<div class="row justify-content-center">
				<div class="menu-content">
				
					<div class="title text-center">
					    <br>
						<h1 class="mb-10"> 나의 글 정보 </h1>
						<br>

					</div>
				</div>
			</div>

			<!-- 밥,빵,면,육류,채소선택 -->
			<ul class="filter-wrap filters col-lg-12 " style="height:10px">
			
				<li class="active" id="tableclick1" >내가 쓴 글</li>
				<li id="tableclick2">좋아요한 글</li>
				
			</ul>


			<div class="filters-content">
				<div class="row grid">





<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>


$(document).ready(function(){
	
	
	$("#tableopen2").hide();

	
	
     $("#tableclick1").on('click', function() {
		
		$("#tableopen2").hide();
		$("#tableopen1").show();
		  
	 });

	
	$("#tableclick2").on('click', function() {
		
		$("#tableopen1").hide();
		$("#tableopen2").show();
		  
	 });
	
});
</script>		



				
<div id="tableopen1" >							
<table class="type09" id="tableopen1" style="width: 1100px ; margin: 0 auto">
    <thead>
    <tr>
        <th>제목</th>
        <th>분류</th>

        <th>날짜</th>
        <th style="width: 90px">조회수</th>
        <th style="width: 90px">댓글수</th>
        <th >보러가기</th>
    </tr>
    </thead>



    <tbody>
    
    					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 myrboard를 dto로 -->
					<c:choose>
						<c:when test="${empty myrboard}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${myrboard}" var="dto">
							
							
    <tr>
        <td>${dto.title }</td>
         <td>${dto.foodkind }/
         ${dto.countrykind }/
         ${dto.timekind }</td>
      
        <td>${dto.reg_date }</td>
        <td style="width: 90px">${dto.readcount }</td>
        <td style="width: 90px">${dto.commentcount }</td>
        <td onclick="location.href='rboard_detail?boardno=${dto.boardno}'">보러가기</td>
    </tr>
   	</c:forEach>
	</c:otherwise>
	</c:choose>
    </tbody>
</table>
</div>




<div id="tableopen2" >								
<table class="type09"  style="width: 1100px ; margin: 0 auto">
    <thead>
    <tr>
        <th >제목</th>
        <th >분류</th>
  
        <th >날짜</th>
        <th  style="width: 90px">조회수</th>
        <th  style="width: 90px">댓글수</th>
        <th   >보러가기</th>
    </tr>
    </thead>



    <tbody>
    
    					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 myrboard를 dto로 -->
					<c:choose>
						<c:when test="${empty mylike}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${mylike}" var="dto">
							
							
    <tr>
        <td>${dto.title }</td>
         <td>${dto.foodkind }/
         ${dto.countrykind }/
         ${dto.timekind }</td>

        <td >${dto.reg_date }</td>
        <td style="width: 90px">${dto.readcount }</td>
        <td style="width: 90px">${dto.commentcount }</td>
        <td onclick="location.href='rboard_detail?boardno=${dto.boardno}'">보러가기</td>
    </tr>
   	</c:forEach>
	</c:otherwise>
	</c:choose>
    </tbody>
</table>
</div>			




				</div>
			</div>

		</div>
	</section>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br>




	<!-- start footer Area -->
	<footer class="footer-area">
		<div class="footer-widget-wrap">
			<div class="container">
				<div class="row section-gap">
					<div class="col-lg-4  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h4>Opening Hours</h4>
							<ul class="hr-list">
								<li class="d-flex justify-content-between"><span>Monday
										- Friday</span> <span>08.00 am - 10.00 pm</span></li>
								<li class="d-flex justify-content-between"><span>Saturday</span>
									<span>08.00 am - 10.00 pm</span></li>
								<li class="d-flex justify-content-between"><span>Sunday</span>
									<span>08.00 am - 10.00 pm</span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h4>Contact Us</h4>
							<p>56/8, los angeles, rochy beach, Santa monica, United
								states of america - 1205</p>
							<p class="number">
								012-6532-568-9746 <br> 012-6532-569-9748
							</p>
						</div>
					</div>
					<div class="col-lg-4  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h4>Newsletter</h4>
							<p>You can trust us. we only send promo offers, not a single
								spam.</p>
							<div class="d-flex flex-row" id="mc_embed_signup">


								<form class="navbar-form"
									action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
									method="get">
									<div class="input-group add-on align-items-center d-flex">
										<input class="form-control" name="EMAIL"
											placeholder="Your Email address"
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Your Email address'" required=""
											type="email">
										<div style="position: absolute; left: -5000px;">
											<input name="b_36c4fd991d266f23781ded980_aefe40901a"
												tabindex="-1" value="" type="text">
										</div>
										<div class="input-group-btn">
											<button class="genric-btn">
												<span class="lnr lnr-arrow-right"></span>
											</button>
										</div>
									</div>
									<div class="info mt-20"></div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom-wrap">
			<div class="container">
				<div
					class="row footer-bottom d-flex justify-content-between align-items-center">
					<p class="col-lg-8 col-mdcol-sm-6 -6 footer-text m-0">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | Made with <i class="fa fa-heart-o"
							aria-hidden="true"></i> by <a href="https://colorlib.com"
							target="_blank">Colorlib</a> &amp; distributed by <a
							href="https://themewagon.com" target="_blank">ThemeWagon</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>
					<ul class="col-lg-4 col-mdcol-sm-6 -6 social-icons text-right">
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
						<li><a href="#"><i class="fa fa-behance"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!-- End footer Area -->

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
</body>
</html>