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
	
	
	<form role="form" method="post" autocomplete="off">
	   <input type="hidden" id="page" name="page" value="${scri.page} readonly="readonly"/>
	   <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum} readonly="readonly"/>
	  
	  <input type="hidden" id="foodkind" name="foodkind" value="${scri.foodkind} readonly="readonly"/>
	  <input type="hidden" id="countrykind" name="countrykind" value="${scri.countrykind} readonly="readonly"/>
	  <input type="hidden" id="timekind" name="timekind" value="${scri.timekind} readonly="readonly"/>
	  
	   <input type="hidden" id="searchType" name="searchType" value="${scri.searchType} readonly="readonly"/>
	   <input type="hidden" id="searchWord" name="searchWord" value="${scri.searchWord} readonly="readonly"/>
	
	</form>


	<!-- start banner Area -->
	<section class="relative about-banner">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Blog Details Page</h1>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->





	<!-- 재료입력란, 영양정보 등 기능 추가 -->

	<section class="post-content-area single-post-area">
		<div class="container">




			<!-- 멤버별사진, 아이디, 제목  -->
			<div class="col-lg-9 col-md-9">
				<h3 class="mt-20 mb-20">${dto.title }</h3>
				<img src="${pageContext.request.contextPath}/${dto.memberImg }"
				                 style="border: 1px solid;
                                 border-radius: 70px;
                                 -moz-border-radius: 70px;
                                 -khtml-border-radius: 70px;
                                 -webkit-border-radius: 70px; width: 50px;" />
				<p class="excert" style="font-size : 1.3em ; color : black">${dto.memberid }</p>

			</div>
			<hr>


			<!-- 글 분류 -->
			<ul style="display: inline-block ;">
				<음식종류별><li style="font-size : 1.1em ; color : black">   ${dto.foodkind }</li>
				<나라별><li style="font-size : 1.1em ; color : black">   ${dto.countrykind }</li>
				<조리시간별><li style="font-size : 1.1em ; color : black">   ${dto.timekind }</li>
			</ul>


			<!-- 조회수 등의 정보 -->
			<div class="col-lg-3  col-md-3"
				style="float: right; display: inline-block">

				<ul class="tags" style="display: inline-block">

					<li>${dto.reg_date }</li>
					<li>조회수   ${dto.readcount }</li>
					<li style="float: left">댓글수  ${dto.commentcount }</li>
				</ul>
			</div>


			<!-- 사용한 재료 -->
			<br><br>
			
		
			<사용 재료>
			<div class="" style="border: 1px solid;">
				<p style="font-size : 1.2em ; color : black">
					<주요 재료> ${dto.majormat }
				</p>
				<p style="font-size : 1.2em ; color : black">
					<추가 사용 재료>  ${dto.minormat }
				</p>
			</div>


		
				<!-- 넣은글 -->
		
		    	<p id="content123" style="font-size : 1.3em ; color : black">${dto.content}</p>
		


		</div>
		
			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script type="text/javascript">
		  $('.container>img').css({width:400, height:300 });
		  $('.container>img').css({"position" : "relative"});
		  $('.container>img').css({"left": "0px"});
		  
		</script>
			

	</section>


	<!-- 버튼, 댓글 섹션 -->
	<section class="post-content-area single-post-area">

		<div class="container">
			<!-- 내용 -->
			<div class="col-lg-12 mt-30">
				<p></p>

			</div>
			
			
			<div style="position: relative; left: 500px">
			<!-- 좋아요 버튼 -->
			<c:if test="${ login == null }">
			
			<img id="likeupdate123" style="width:120px; margin:0 auto " src = "data:image/png;base64,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">
			좋아요  <span style="font-size : 1.5em ; color : black" class="likeCount"></span>개
			
			
			</c:if>				
								
			<c:if test="${ login != null }">
                <img id="likeupdate" style="width:120px; margin:0 auto " src = "data:image/png;base64,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">
			좋아요  <span style="font-size : 1.5em ; color : black" class="likeCount"></span>개
			
			
			<!-- 리뷰 작성 -->
			<a href="reviewboard_writeform?boardno=${dto.boardno}">
			     <img id="review" style="width:120px; margin:0 auto " 
			     src = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS6LuQ8egXlDmMdeAZ3Tg4i_4DMAL4Xv-4Cbg&usqp=CAU"/>
                                리뷰작성하기
             </a>
			</c:if>	
			
			
          </div>


			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script type="text/javascript">
               //좋아요 ajax전송
				//추천버튼 클릭시 게시판번호와 아이디를 전송하고, 현재추천수를 표시하는 함수도 실행
				$(function(){
					
					// 추천버튼 클릭시(추천 추가 또는 추천 제거)
					$("#likeupdate").click(function(){
	
						var boardno = "${dto.boardno}";
						var id = "${dto2.id}";
						

				            $.ajax({
						        url: "BoardLike",
				                type: "POST",
				                data: {
				                    "boardno" :  boardno,
				                    "id" : id
				                },
				                datatype: "json",
				                success:function(count){
				                	
				                	$(".likeCount").html(count);
				                },
				                error:function(){
				                	alert("좋아요 실패");
				                }
					        });
					});
					
					
					//로그인 안했을때
					// 추천버튼 클릭시(추천 추가 또는 추천 제거)
					$("#likeupdate123").click(function(){
				            alert("로그인 해야합니다.");
				            location.href='loginform'
					});
				});
               
               
				function recCount() {
					var boardno = "${dto.boardno}";
					
			
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
				                	alert("좋아요 수 실패");
				                }
				    });
				};

				recCount(); // 처음 시작했을 때 실행되도록 해당 함수 호출
				
				
			</script>

			<hr>
			
			
			
			<c:if test="${dto2.id == dto.memberid }">
			
			<div style="float: right">
                <a class="submit primary-btn text-uppercase" 
                href="updateform?boardno=${dto.boardno}&page= ${scri.page} &perPageNum=${scri.perPageNum}
                &foodkind= ${scri.foodList[0]}&foodkind= ${scri.foodList[1]}
                 &foodkind= ${scri.foodList[2]}&foodkind= ${scri.foodList[3]}
                 &foodkind= ${scri.foodList[4]} &foodkind= ${scri.foodList[5]}
                  &countrykind= ${scri.countryList[0]}&countrykind=${scri.countryList[1]}
                   &countrykind= ${scri.countryList[2]} &countrykind= ${scri.countryList[3]}
                   &countrykind= ${scri.countryList[4]}
                    &timekind= ${scri.timeList[0]} &timekind= ${scri.timeList[1]}
                      &timekind= ${scri.timeList[2]}&timekind= ${scri.timeList[3]}
                       &timekind= ${scri.timeList[4]}
                       &SearchType= ${scri.searchType}&SearchWord= ${scri.searchWord}">수정</a>
				<a class="submit primary-btn text-uppercase" 
				href="rboarddelete?boardno=${dto.boardno} 
                &page= ${scri.page} &perPageNum=${scri.perPageNum}
                &foodkind= ${scri.foodList[0]}&foodkind= ${scri.foodList[1]}
                 &foodkind= ${scri.foodList[2]}&foodkind= ${scri.foodList[3]}
                 &foodkind= ${scri.foodList[4]} &foodkind= ${scri.foodList[5]}
                  &countrykind= ${scri.countryList[0]}&countrykind=${scri.countryList[1]}
                   &countrykind= ${scri.countryList[2]} &countrykind= ${scri.countryList[3]}
                   &countrykind= ${scri.countryList[4]}
                    &timekind= ${scri.timeList[0]} &timekind= ${scri.timeList[1]}
                      &timekind= ${scri.timeList[2]}&timekind= ${scri.timeList[3]}
                       &timekind= ${scri.timeList[4]}
                       &SearchType= ${scri.searchType}&SearchWord= ${scri.searchWord}">>삭제</a>
            </div>
            
            </c:if>
            
            <c:if test="${dto2.id != dto.memberid }">
			
			<div style="float: right">
                <a  class="primary-btn text-uppercase" 
                href="listSearchsendmail?boardno=${dto.boardno} 
                &page= ${scri.page} &perPageNum=${scri.perPageNum}
                &foodkind= ${scri.foodList[0]}&foodkind= ${scri.foodList[1]}
                 &foodkind= ${scri.foodList[2]}&foodkind= ${scri.foodList[3]}
                 &foodkind= ${scri.foodList[4]} &foodkind= ${scri.foodList[5]}
                  &countrykind= ${scri.countryList[0]}&countrykind=${scri.countryList[1]}
                   &countrykind= ${scri.countryList[2]} &countrykind= ${scri.countryList[3]}
                   &countrykind= ${scri.countryList[4]}
                    &timekind= ${scri.timeList[0]} &timekind= ${scri.timeList[1]}
                      &timekind= ${scri.timeList[2]}&timekind= ${scri.timeList[3]}
                       &timekind= ${scri.timeList[4]}
                       &SearchType= ${scri.searchType}&SearchWord= ${scri.searchWord}">
                목록</a>
            </div>
            
            </c:if>
			
			



			<br> <br> <br>
			<h2>comment</h2>

			<!-- 댓글작성하기 -->
			<form class="box_write" id="comment" name="comment"
				action="commentwrite" accept-charset="UTF-8" method="post">

				<input type="hidden" name="boardno" value="${dto.boardno }">
				<input type="hidden" name="commentwriter" value="${dto2.id }">
				


				<textarea placeholder="write comment" name="commentcontent"
					id="commentcontent" style="width: 100%"></textarea>
					<c:if test="${ login != null }">
				<input type="submit" id="submit" class="submit primary-btn text-uppercase" style="float: right"
					value="write comment"  >
		           </c:if>
		           <c:if test="${ login == null }">
		         <input type="submit" id="submit123" class="submit primary-btn text-uppercase" style="float: right"
					value="write comment"  >
		           </c:if>

			</form>
			
			
			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script type="text/javascript">
			
					$(function(){
						//로그인 안했을때
						// 추천버튼 클릭시(추천 추가 또는 추천 제거)
						$("#submit123").click(function(){
					            alert("로그인 해야합니다.");
					            location.href='loginform'
					            	return false;
						});
						
					
					});
				  
					

				
			</script>



			<br> <br> <br>
			<!-- 작성한 댓글들 -->


			<c:forEach items="${commentlist}" var="dto1">
				<ul class="">
					<li class="">

						<div style="display: inline-block">
							<strong>${dto1.commentno }</strong> 
							
							<img src="${pageContext.request.contextPath}/${dto1.memberImg }" 
				                style="border: 1px solid;
                                 border-radius: 70px;
                                 -moz-border-radius: 70px;
                                 -khtml-border-radius: 70px;
                                 -webkit-border-radius: 70px;
                                  width: 50px;"/>

						</div>
						
						<div style="display: inline-block">${dto1.commentwriter}</div>
						<div style="display: inline-block">:</div>
						<div style="display: inline-block">
							<br> <br> <br>
						</div>


						<div style="display: inline-block">${dto1.commentcontent}</div>
						<div style="float: right; display: inline-block">${dto1.commentdate }</div>
						<br>
						<p  style="float:right; ">
						
					
						<c:if test="${dto2.id == dto1.commentwriter }">
					
						  <div  style="display: inline-block; float:right; "   >
						         <a href='rboard_comment_delete?commentno=${dto1.commentno }&boardno=${dto1.boardno}'>  삭제    </a></div>
						
						  <div style="display: inline-block; float:right; "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </div>
						
						  <div style="display: inline-block; float:right;
						    "  ><a href='rboard_detail_commentupdateform?commentno=${dto1.commentno }&boardno=${dto1.boardno}'>  수정   </a></div>
						
						</c:if>
						
						
					    <c:if test="${dto2.id != dto1.commentwriter  }">
						  <div style="display: inline-block; float:right; "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </div>
						</c:if>
						
					
						
						</p>
					</li>
				</ul>
				<hr>
			</c:forEach>

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