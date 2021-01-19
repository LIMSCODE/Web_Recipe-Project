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
						<li><a href="index.html">Home</a></li>
						<li><a href="about.html">About</a></li>
						<li><a href="menu.html">Menu</a></li>
						<li><a href="gallery.html">Gallery</a></li>
						<li class="menu-has-children"><a href="">Blog</a>
							<ul>
								<li><a href="blog-home.html">Blog Home</a></li>
								<li><a href="blog-single.html">Blog Single</a></li>
							</ul></li>
						<li class="menu-has-children"><a href="">Pages</a>
							<ul>
								<li><a href="elements.html">Elements</a></li>
								<li class="menu-has-children"><a href="">Level 2 </a>
									<ul>
										<li><a href="#">Item One</a></li>
										<li><a href="#">Item Two</a></li>
									</ul></li>
							</ul></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	<!-- #header -->

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- 2.나라별 -->
	<div class="form-select" id="service-select"
		style="width: 33%; float: left; display: inline-block">
		<select>
			<option data-display="">동별</option>
			<option value="1">역삼동</option>
			<option value="2">개포동</option>
			<option value="3">청담동</option>
			<option value="4">삼성동</option>
			<option value="5">대치동</option>
			<option value="6">신사동</option>
			<option value="7">논현동</option>
			<option value="8">압구정동</option>
			<option value="9">세곡동</option>
			<option value="10">자곡동</option>
			<option value="11">율현동</option>
			<option value="12">일원동</option>
			<option value="13">수서동</option>
			<option value="14">도곡동</option>
			<option value="15">논현1동</option>
			<option value="16">논현2동</option>
			<option value="17">삼성1동</option>
			<option value="18">삼성2동</option>
			<option value="19">대치1동</option>
			<option value="20">대치2동</option>
			<option value="21">대치4동</option>
			<option value="22">역삼1동</option>
			<option value="23">역삼2동</option>
			<option value="24">도곡1동</option>
			<option value="25">도곡2동</option>
			<option value="26">개포1동</option>
			<option value="27">개포2동</option>
			<option value="28">개포4동</option>
			<option value="29">일원본동</option>
			<option value="30">일원1동</option>
			<option value="31">일원2동</option>

		</select>
	</div>





	<br>
	<br>


	

	<div id="map" style="width: 100%; height: 350px;"></div>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5547f6be229990d33003b21ff84d57d4&libraries=services"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>







	<br>
	<hr>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/restau.js"></script>


	<form action="restaudb" method="post">
		<input type="submit" value="db에 저장하기"> 
		<input type="hidden"
			value="restaudb" name="restaudb">

		<table>
			<thead>
			</thead>
			<tbody>
			</tbody>
		</table>

		<p>122233</p>
	</form>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



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

</body>
</html>