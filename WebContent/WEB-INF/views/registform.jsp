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
						<a href="index.html"><img src="resources/img2/logo.png" alt=""
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
	<section class="about-banner relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">회원가입</h1>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;



	<!-- 회원가입에 이용 -->
	<!-- Start reservation Area -->
	<section class="reservation-area section-gap relative">
		<div class="overlay overlay-bg"></div>
		<div class="container  ">
			<div class="row justify-content-between align-items-center" style="position:relative;
			                                       left:250px; width: 1400px">
				<div class="col-lg-5 reservation-right">
				
				
				<form class=" text-center" action="registuser"  enctype="multipart/form-data"  method="post" >
					
					
					
					
					<!-- 프로필 사진  -->
					<div class="inputArea">
						<label for="memberImg">프로필 이미지 수정</label> 
						
						<input type="file" id="memberImg" name="file" />
						<div class="select_img">
								<img style="border: 1px solid;
                                 border-radius: 70px;
                                 -moz-border-radius: 70px;
                                 -khtml-border-radius: 70px;
                                 -webkit-border-radius: 70px;">
						</div>


						<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
						<script>
                          $("#memberImg").change(function(){
                             if(this.files && this.files[0]) {
                             var reader = new FileReader;
                             reader.onload = function(data) {
                             $(".select_img img").attr("src", data.target.result).width(150);        
                             }
                            reader.readAsDataURL(this.files[0]);
                             }
                          });
                        </script>
					</div>
					<br><br>
					
					
						<input type="text" class="form-control id" name="id"
							placeholder="id" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'id'"> 
							
							
<button type ="button" class="idCheck"> 아이디중복확인 </button>
<p class="result">
   <span class="msg"> 아이디를 확인해주세요. </span>
</p>

<script> 
$(function(){
$(".idCheck").click(function(){
 

 var query = {"id" : $(".id").val()};
 alert(query);
 
 $.ajax({
  url : "idCheck",
  type : "post",
  data : query,
  success : function(data) {
  
   if(data == 1) {
    $(".msg").text("사용 불가");
    $(".msg").attr("style", "color:#f00");    
    $("#submit").attr("disabled", "disabled");
   } else {
    $(".msg").text("사용 가능");
    $(".msg").attr("style", "color:#00f");
    $("#submit").removeAttr("disabled");
   }
  }
 });  // ajax 끝
});
});

$(".id").keyup(function(){
 $(".result .msg").text("아이디를 확인해주십시오.");
 $(".result .msg").attr("style", "color:#000");
 
 $("#submit").attr("disabled", "disabled");
 
});
</script>
							
							
							
						<input type="password" class="form-control" name="pw"
							placeholder="pw" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'pw'"> 
						<input
							type="text" class="form-control" name="name"
							placeholder="name" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'name'"> 
						<input
							type="email" class="form-control" name="email"
							placeholder="email" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'email'"> 
						<input
							type="text" class="form-control" name="phone"
							placeholder="phone" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'phone'"> 
					
					
						<input type="submit" id="submit" value="회원가입"  class="primary-btn text-uppercase mt-20">
					</form>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End reservation Area -->








	<!-- End services Area -->


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