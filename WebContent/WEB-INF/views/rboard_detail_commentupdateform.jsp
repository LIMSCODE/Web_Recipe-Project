<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




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
						<a href="index.jsp"><img src="resources/img2/logo.png" alt=""
							title="" /></a>
					</div>
				</div>
			</div>
		</div>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-center d-flex">
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="listSearchsendmail">????????? ?????????</a></li>
						<li><a href="reviewboard_a">?????? ?????????</a></li>

						<li><a href="restau2"> ?????? ??????</a></li>
						
						<c:choose>

							<c:when test="${login!=null}">
								<li><a href="mypage">??????????????? ()</a></li>
								
								<li><a href="originallogout">????????????</a></li>
							</c:when>

							<c:when test="${sessionId != null}">

								<li><a href="mypage">???????????????</a></li>
								<li><a href="mypage">'${sessionId}'???, ????????? ???????????? ????????????.</a></li>
								<li><a href="logout">????????????</a></li>
								
								
								
								</h3>
							</c:when>


							<c:otherwise>
							
								<li><a href="loginform">?????????</a></li>
								<li><a href="registform">????????????</a></li>
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
					<h1 class="text-white">Rboard</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span><a
							href="blog-home.html">Blog </a> <span class="lnr lnr-arrow-right"></span>
						<a href="blog-single.html"> Blog Details Page</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->





	<!-- ???????????????, ???????????? ??? ?????? ?????? -->

	<section class="post-content-area single-post-area">
		<div class="container">




			<!-- ???????????????, ?????????, ??????  -->
			<div class="col-lg-9 col-md-9">
				<h3 class="mt-20 mb-20">${dto.title }</h3>
				<img src="${pageContext.request.contextPath}/${dto.memberImg }"
				                 style="border: 1px solid;
                                 border-radius: 70px;
                                 -moz-border-radius: 70px;
                                 -khtml-border-radius: 70px;
                                 -webkit-border-radius: 70px; width: 50px;" />
				<p class="excert">${dto.memberid }</p>

			</div>
			<hr>


			<!-- ??? ?????? -->
			<ul style="display: inline-block">
				<li>???????????????</li>
				<li>?????????</li>
				<li>???????????????</li>
			</ul>


			<!-- ????????? ?????? ?????? -->
			<div class="col-lg-3  col-md-3"
				style="float: right; display: inline-block">

				<ul class="tags" style="display: inline-block">

					<li>${dto.reg_date }</li>
					<li>?????????</li>
					<li style="float: left">?????????</li>
				</ul>
			</div>


			<!-- ????????? ?????? -->
			<div class="col-lg-12 mt-30" style="border: 1px solid;">
				<p>
					<??? ????????? ??????>
				</p>
				<p>
					<?????? ?????? ??????>
				</p>
			</div>


			<!-- ?????? ????????? ???????????? -->
			<div class="inputArea">

				<!-- 2?????????????????? ??? ?????? ????????? ?????? -->
				<c:forEach var="uploadFile" items="${uploadFileList}">
				
                <img src="${pageContext.request.contextPath}/resources/img2/rboard/${uploadFile.file_name}"

                style=" width: 70px; height: 50px" />
 
				</c:forEach>
			
			</div>
			
				<!-- ????????? -->
		
		    	<p>${dto.content}</p>
		


		</div>


	</section>


	<!-- ??????, ?????? ?????? -->
	<section class="post-content-area single-post-area">

		<div class="container">
			<!-- ?????? -->
			<div class="col-lg-12 mt-30">
				<p></p>

			</div>
			
			
			<!-- ????????? ?????? -->
			<c:if test="${ login == null }">
    			<span class="likeCount"></span>
			</c:if>				
								
			<c:if test="${ login != null }">
                <button class="" id="likeupdate">?????????</button>
                <span class="likeCount"></span>
            </c:if>


			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script type="text/javascript">
               //????????? ajax??????
				//???????????? ????????? ?????????????????? ???????????? ????????????, ?????????????????? ???????????? ????????? ??????
				$(function(){
					
					// ???????????? ?????????(?????? ?????? ?????? ?????? ??????)
					$("#likeupdate").click(function(){
						alert("hi");
						var boardno = "${dto.boardno}";
						var id = "${dto2.id}";
						
						alert(boardno);
						alert(id);

				            $.ajax({
						        url: "BoardLike",
				                type: "POST",
				                data: {
				                    "boardno" :  boardno,
				                    "id" : id
				                },
				                datatype: "json",
				                success:function(data){
				                	alert("????????? ?????????");
				                },
				                error:function(){
				                	alert("????????? ??????");
				                }
					        });
					});
				});
               
               
				function recCount() {
					var boardno = "${dto.boardno}";
					
					alert(boardno);
					
					$.ajax({
					            url: "likeCount",
				                type: "POST",
				                data: {
				                    "boardno": boardno
				                },
				                success: function (count) {
				                	$(".likeCount").html(count);
				                },
				                error:function(){
				                	alert("????????? ??? ??????");
				                }
				    });
				};

				recCount(); // ?????? ???????????? ??? ??????????????? ?????? ?????? ??????
				
			</script>

			<hr>
			
			
			
			<c:if test="${dto2.id == dto.memberid }">
			
			<div style="float: right">
                <button onclick="location.href='updateform?boardno=${dto.boardno}'">??????</button>
				<button onclick="location.href='rboarddelete?boardno=${dto.boardno}'">??????</button>
            </div>
            
            </c:if>
            
            <c:if test="${dto2.id != dto.memberid }">
			
			<div style="float: right">
                <button onclick="location.href='listSearch'">??????</button>
            </div>
            
            </c:if>
			
			



			<br> <br> <br>
			<h2>comment</h2>

			<!-- ?????????????????? -->
			<form class="box_write" id="comment" name="comment"
				action="commentwrite" accept-charset="UTF-8" method="post">

				<input type="hidden" name="boardno" value="${dto1.boardno }">
				
			
				
				<input type="hidden" name="commentwriter" value="${dto2.id }">
				


				<textarea placeholder="write comment" name="commentcontent"
					id="commentcontent" style="width: 100%"></textarea>
				<input type="submit" class="submit" style="float: right"
					value="write comment">

			</form>
			
			
			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script type="text/javascript">
				$(function() {

					$(".submit").click(function() {
						if (dto2.getId() == null) {
							alert('???????????????');

						}

					});

				});
				
		
			</script>



			<br> <br> <br>
			<!-- ????????? ????????? -->


	<c:forEach items="${commentlist}" var="dto">
			
			<!-- ???????????? ????????? ??? : ?????????????????? dto1??? ?????????. -->
			   <c:if test="${dto1.commentno == dto.commentno }">
			   
			
				<form action="rboard_comment_update" method="post"
					enctype="multipart/form-data">   
					
					<input type="hidden" name="commentno" value="${dto1.commentno}">
						<input type="hidden" name="boardno" value="${dto1.boardno}">

			       <ul class="">
					<li class="">

						<div style="display: inline-block">
							<strong>${dto1.commentno }</strong> 
							
							<img src="${pageContext.request.contextPath}/${dto2.memberImg }" 
				                style="border: 1px solid;
                                 border-radius: 70px;
                                 -moz-border-radius: 70px;
                                 -khtml-border-radius: 70px;
                                 -webkit-border-radius: 70px;
                                  width: 50px;"/>

						</div>
						
						<div style="display: inline-block">${dto2.id}</div>
						<div style="display: inline-block">:</div>
						<div style="display: inline-block">
							<br> <br> <br>
						</div>
					    <div style="float: right; display: inline-block">${dto1.commentdate }</div>
						
					
					
					
					
						<div id="image_container" class="" 
						contentEditable="true"
						
						style=" width: 1100px; overflow: scroll; height: 100px; background-color: white; border: 1px solid;">
					   </div>
					   
					   
					   <input type="hidden" class="form-control" id="commentcontenta"
						name="commentcontenta" placeholder="??????"  />


					    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
					    <script>
					    
					    //????????? ????????? ???????????? ?????????
					     $(document).ready(function(){
									
					         $('#image_container').text('${dto1.commentcontent}');

					 	    //???????????? ????????? input????????? ????????? ?????????.
							    $('#submit').click(function(){
									  
									  //contentEditable?????? ??????????????? ????????? ???????????????.
									  //??????
									  var xxx= $('#image_container').html();
									  alert(xxx);
									  
									  
									  $('#commentcontenta').val(xxx);
									  
								
								  });

					     });
					     
					    
					    </script>
						
					

					
						<br>
						
						<div style="float: right">
						<input type="submit" id="submit" class="primary-btn text-uppercase"
						value="????????????"> 
						
						<input type="button" value="??????"
						class="primary-btn text-uppercase"
						onclick="location.href='rboard_detail?boardno=${dto1.boardno}'">
					
                        </div>
					</li>
				</ul>
				<br>
				<br>
                 <hr>
                 </form>

			   
			   </c:if>
 
 
 
            <!-- ????????? ????????? ???????????? --> 
			   <c:if test="${dto1.commentno != dto.commentno }">
				<ul class="">
					<li class="">

						<div style="display: inline-block">
							<strong>${dto.commentno }</strong> 
							
							<img src="${pageContext.request.contextPath}/${dto.memberImg }" 
				                style="border: 1px solid;
                                 border-radius: 70px;
                                 -moz-border-radius: 70px;
                                 -khtml-border-radius: 70px;
                                 -webkit-border-radius: 70px;
                                  width: 50px;"/>

						</div>
						
						<div style="display: inline-block">${dto.commentwriter}</div>
						<div style="display: inline-block">:</div>
						<div style="display: inline-block">
							<br> <br> <br>
						</div>


						<div style="display: inline-block">${dto.commentcontent}</div>
						<div style="float: right; display: inline-block">${dto.commentdate }</div>
						<br>

					</li>
				</ul>
				<hr>
				</c:if>

			</c:forEach>










			<div class="paging">


				<a class="current" href="/recipes/1928/comments">1</a> <a rel="next"
					href="/recipes/1928/comments?page=2">2</a> <a
					href="/recipes/1928/comments?page=3">3</a> <a
					href="/recipes/1928/comments?page=4">4</a> <a rel="next"
					class="next" href="/recipes/1928/comments?page=2">??????</a> <a
					class="last" href="/recipes/1928/comments?page=4">???</a>

			</div>
		</div>
	</section>



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