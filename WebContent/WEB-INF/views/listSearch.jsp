<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 한식, 중식, 양식 , 디저트 선택 -->
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



  <style>
			    .madeby {cursor:pointer;}
			    .hide{display:none; background: red;}
  </style>
  
  
  
  
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
						<li><a href="index" >Home</a></li>
						<li ><a href="" >About</a></li>
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
								<li class="menu-has-children" ><a href="">Level 2 </a>
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

	<!-- start banner Area -->
	<section class="about-banner relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Recipe Board</h1>
					<p class="text-white link-nav">
						<a href="index.html">Home </a> <span class="lnr lnr-arrow-right"></span>
						<a href="about.html"> About Us</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->



	<!-- Start menu-area Area -->
	<br>
	<br>
	<section class="menu-area " id="menu">
		<div class="container">

			<div class="search_area">
				<form action="listSearch" method="get" id="searchForm">
					<div class="search_ctn">
					
					
						<div class="search_div1">
							<ul style="float:left; ">
								<li class="search_li"  style="float:left; ">음식종류별 :</li>
							
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s1"
									name="foodkind" value="밥류" /><label for="s1">밥류</label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s2"
									name="foodkind" value="빵류" /><label for="s2">빵류</label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s3"
									name="foodkind" value="면류" /><label for="s3">면류</label></li>
							
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s4"
									name="foodkind" value="밑반찬류" /><label for="s4">밑반찬류</label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s5"
									name="foodkind" value="디저트/음료" /><label for="s5">디저트/음료</label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s6"
									name="foodkind" value="기타" /><label for="s6">기타</label></li>
							</ul>
						</div>
						<br>
						<br>
						

						<div class="search_div2">
							<ul  style="float:left; ">
								<li class="search_li"  style="float:left; ">나라별 :</li>
								
								<li style="float:left;"><input type="checkbox" id="r1" name="countrykind"
									value="한식" /> <label for="r1">한식</label></li>
								<li style="float:left;"><input type="checkbox" id="r2" name="countrykind"
									value="중식"  /> <label for="r2">중식</label></li>
								<li style="float:left;"><input type="checkbox" id="r3" name="countrykind"
									value="일식" /> <label for="r3">일식</label></li>
								<li style="float:left;"><input type="checkbox" id="r4" name="countrykind"
									value="양식" /> <label for="r4">양식</label></li>
								<li style="float:left;"><input type="checkbox" id="r5" name="countrykind"
									value="기타"  /> <label for="r5">기타</label></li>
								
							</ul>
						</div>
                        <br>
						<br>
						
						
						<div class="search_div3 ">
							<ul  style="float:left; ">
							     <li class="search_li"  style="float:left; ">조리시간별 :</li>
								<li style="float:left;"><input type="checkbox" id="t1" name="timekind"
									value="초간단 요리" /> <label for="t1">초간단 요리</label></li>
								<li style="float:left;"><input type="checkbox" id="t2" name="timekind"
									value="5분이내"  /> <label for="t2">5분이내</label></li>
								<li style="float:left;"><input type="checkbox" id="t3" name="timekind"
									value="15분이내"  /> <label for="t3">15분이내</label></li>
								<li style="float:left;"><input type="checkbox" id="t4" name="timekind"
									value="30분이내"  /> <label for="t4">30분이내</label></li>
								<li style="float:left;"><input type="checkbox" id="t5" name="timekind"
									value="장시간 요리" /> <label for="t5">장시간 요리</label></li>

							</ul>
						</div>
						<br>
						<br>
						
						
						<script type="text/javascript"
				           src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			            <script type="text/javascript">
			            $(function() {
			            	
			            	//검색창에만 입력했을때
							$("#searchForm").submit(function() {
							
								
								if ($(".search_div1 input:checked").length == 0) {
									alert("음식 종류를 하나 이상 체크해주세요");
									return false;
								}
								
								
							});
						});

			            
			            </script>
						
						

						<div class="search_box">
							<select name="SearchType">
								<option>선택</option>
								<option value="id">ID</option>
								<option value="title">제목</option>
							</select> 
							<input type="text" class="Searchbox" name="SearchWord" /> <br>
				
						</div>


						<div style="float: right; position: relative; bottom: 50px">
							<input type="submit" value="해당조건으로 찾기"
								style="display: inline-block;"
								class="primary-btn text-uppercase">
						</div>

					</div>

				</form>
			</div>


			<hr>


			<!-- 멀델 제이쿼리문 -->

			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<script type="text/javascript">
				//컨트롤러에서 받은 메시지 출력
				var message = '${msg}';
				alert(message);

				function allChk(bool) {
					var chks = document.getElementsByName("chk"); //태그의 name이 chk인것을 변수에 담고
					for (var i = 0; i < chks.length; i++) {
						chks[i].checked = bool;
					}
				}

				//체크를 하나도 안하면 submit 취소
				$(function() {
					$("#muldelform").submit(function() {
						if ($("#muldelform input:checked").length == 0) {
							alert("하나 이상 체크해주세요");
							return false;
						}
					});
				});
				
				

				//정렬기준
				function orderby(str) {
				    alert(str);
					if(str=='1'){
						
						 $.ajax({
							   url: "listSearchreadcount",
				                
				                datatype: "json",
				                success:function(data){
				                	alert("조회수별 정렬");
				                	window.location.href = "listSearchreadcount";

				                },
				                error:function(){
				                	alert("조회수별 정렬 실패");
				                }
					       });	
					}	
				}
				
			//아이디 누르면 작성글보기- html dom 이 다 로딩된 후 실행된다.
			    $(document).ready(function(){
			        // memu 클래스 바로 하위에 있는 a 태그를 클릭했을때
			        $(".madeby").click(function(){
			            // 현재 클릭한 태그가 a 이기 때문에
			            // a 옆의 태그중 ul 태그에 hide 클래스 태그를 넣던지 빼던지 한다.
			            $(this).next("ul").toggleClass("hide");
			        
			        
			        var submenu = $(this).next("ul");
			        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
		            if( submenu.is(":visible") ){
		                submenu.slideUp();
		            }else{
		                submenu.slideDown();
		            }
			        });

			    });
				 
				
			//작성글 보기 누르면 팝업창 뜸
			    function popup(madebyid){
				    alert(madebyid);
				         var url = "popup?madebyid="+madebyid;
			            var name = "popup test";
			            var option = "width = 800, height = 500, top = 100, left = 300, location = no  scrollbars = yes" 
			            window.open(url, name, option);
		            
		        }
				 

			</script>

			<div class="">
				<div class="">
					<form action="muldel" method="post" id="muldelform">
						<input type="checkbox" name="all" onclick="allChk(this.checked);">
						전체선택 <input type="submit" value="삭제">

						<!-- 4. 조회수/댓글수/좋아요수 -->
						<div class="" id="" style="float: right; display: inline-block;">
							<select onchange="orderby(this.value)">
								<option data-display="">정렬기준</option>
								<option value="1">조회수 높은순</option>
								<option value="2">댓글 많은순</option>
								<option value="3">좋아요 많은순</option>
							</select>
						</div>
						<br> <br>

						<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
						<c:choose>
							<c:when test="${empty searchList }">
								<tr>
									<td colspan="4">----작성된 글이 존재하지 않습니다----</td>
								</tr>
							</c:when>

							<c:otherwise>
								<c:forEach items="${searchList }" var="dto">


									<!-- 레시피 하나 시작 -->
									<div class="breakfast">
										<div class="col-lg-4" style="float: left; width: 33%;">
											<input type="checkbox" name="chk" value="${dto.boardno }">
											${dto.boardno }
											<div class="single-service">
												<div class="thumb" onclick="location.href='rboard_detail?boardno=${dto.boardno}'">

													<img src="${pageContext.request.contextPath}/${dto.gdsThumbImg }" />

												</div>
												
													<h4 style="display: inline-block" onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title}</h4>
													
													
													
													
													
													<!-- 프로필사진, 아이디 -->
													
													<h4 class="madeby " 
													style="display: inline-block; float: right;">
													${dto.memberid}
													</h4>
													
													
													<img src="${pageContext.request.contextPath}/${dto.memberImg }" 
													     style="border: 1px solid;
                                                         border-radius: 70px;
                                                         -moz-border-radius: 70px;
                                                         -khtml-border-radius: 70px;
                                                         -webkit-border-radius: 70px; width: 50px;
                                                         display: inline-block; float: right;"/>

													<ul class="hide ">
                                                        <li class="madeby123" onclick="popup('${dto.memberid}');">작성한 글 보기</li>                                     
                                                    </ul>
                                                
                                             
                                             
                                             
                                                    
                                                    <!-- 조회수, 댓글수 -->
													<p class="d-flex justify-content-around mb-2"
														style="width: auto;">
														<div class="meta-bottom d-flex justify-content-between">
										                 <p>
											               <span class="">조회수</span> ${dto.readcount}
										                 </p>
										                 <p>
											                <span class="">댓글수</span> ${dto.commentcount}
										                  </p>
									                    </div>
													</p>
												

											</div>
										</div>



										<!-- 레시피 하나 끝 -->

									</div>
							</c:forEach>
							</c:otherwise>
						</c:choose>
									</form>

		</div>
		</div>	
		
	</div>

	</section>




	<!-- 테이블 -->
	<table class="_1YVaU">
		<thead>
			<tr class="_3JyWO">
				<th class="_2V4iu _3MUx4 forum-text-color"><div class="_1dokf"></div></th>
				<th class="_1tnhq Y-Jqn"><svg
						xmlns="http://www.w3.org/2000/svg" width="17" height="15"
						viewBox="0 0 17 15" fill="none" role="img"
						class="forum-icon-stroke">
						<title>Comments</title><path
							d="M9.48,11.45l-4,2.88a0.84,0.84,0,0,1-1.34-.65V11.45H2.22A1.7,1.7,0,0,1,.5,9.79V2.17A1.7,1.7,0,0,1,2.22.5H14.78A1.7,1.7,0,0,1,16.5,2.17V9.79a1.7,1.7,0,0,1-1.72,1.67H9.48Z"
							transform="translate(0 0)"></path></svg></th>
				<th class="_1tnhq Y-Jqn"><svg
						xmlns="http://www.w3.org/2000/svg" width="16" viewBox="0 0 17 15"
						fill="none" role="img" class="forum-icon-stroke"
						style="fill-rule: evenodd;">
						<title>Likes</title><path
							d="M350,217.365a4.312,4.312,0,0,0-8-2.28,4.309,4.309,0,0,0-8,2.28,4.375,4.375,0,0,0,1.487,3.286l6.12,6.184A0.567,0.567,0,0,0,342,227a0.553,0.553,0,0,0,.4-0.165l6.12-6.184A4.375,4.375,0,0,0,350,217.365Z"
							transform="translate(-333.5 -212.5)"></path></svg></th>
				<th class="_1tnhq Y-Jqn"><svg
						xmlns="http://www.w3.org/2000/svg" width="19" height="12"
						viewBox="0 0 19 12" role="img" class="forum-icon-fill"
						style="fill-rule: evenodd;">
						<title>Views</title><path
							d="M680.408,226c-3.162,0-6.216-1.708-9.079-5.079h0a1.464,1.464,0,0,1,0-1.889c1.259-1.51,4.674-5.024,9.188-5.045h0.04c3.162,0,6.216,1.708,9.079,5.079a1.465,1.465,0,0,1,0,1.889c-1.259,1.51-4.674,5.024-9.188,5.045h-0.039Zm-8.293-5.729c2.659,3.131,5.449,4.717,8.293,4.717h0.035c4.079-.018,7.233-3.276,8.4-4.675a0.463,0.463,0,0,0,.008-0.6c-2.659-3.131-5.448-4.718-8.293-4.718h-0.034c-4.079.019-7.234,3.277-8.4,4.676a0.464,0.464,0,0,0-.008.6h0Zm8.368,3.62a3.9,3.9,0,1,1,3.952-3.9A3.93,3.93,0,0,1,680.483,223.891Zm0-6.783a2.886,2.886,0,1,0,2.926,2.886A2.909,2.909,0,0,0,680.483,217.108Z"
							transform="translate(-671 -214)"></path></svg></th>
				<th class="_1Cmax _3MUx4 forum-text-color">Recent Activity</th>
				<th class="_3R3CQ"><span class="yeoGk">Item option menu</span></th>
			</tr>
		</thead>
		<tbody>
			<tr aria-hidden="true">
				<td class="_2lRkg" colspan="100"><div
						class="_3Cioj _3C_rt forum-separator-background-color"></div></td>
			</tr>
			<tr id="5e9447032e0a95002e92261e"
				class="_38Fer forum-text-color post-list-item forum-content-classic-font"
				data-hook="post-list-item">
				<td><div class="le4VL">
						<a
							href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/where-can-i-a-find-bag-mock-up-for-my-graphic-design"
							class="forum-title-classic-font _1CApn"><h2
								class="_2FqU5 _2rOY9 forum-title-classic-font _2WkBL forum-text-color forum-link-hover-color post-title"
								data-hook="post-title">
								<div class="_33VI0">
									<div class="_3N7Rh">
										<span>Where can I a find bag mock-up for my graphic
											design?</span>
									</div>
								</div>
							</h2></a>
					</div>
					<div class="_146iO forum-links-hashtags-color">
						<div class="_2eFIV">
							<div data-hook="mcl-showable-content"></div>
							<a
								href="https://www.wix.com/demone2/designers-forum/profile/84770f67-ecbd-44b6-b35a-584f2dc15af1"
								class="_8ZDBI forum-text-color forum-link-hover-color"><span>Admin</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="19"
									viewBox="0 0 19 19" aria-label="Admin"
									class="_3LDKX forum-icon-fill" style="fill-rule: evenodd;">
									<path
										d="M15.3812,6.495914 L12.6789333,8.77258837 C12.6191333,8.84477644 12.5099333,8.85722265 12.4354,8.79997005 C12.4215333,8.79001308 12.4094,8.77756686 12.3998667,8.76429089 L9.78686667,6.14327115 C9.67766667,5.99225704 9.46186667,5.95491839 9.305,6.05863687 C9.26946667,6.08186981 9.23913333,6.11091099 9.21573333,6.14493065 L6.60013333,8.81075677 C6.5464,8.88626383 6.43893333,8.90534803 6.3592,8.85390366 C6.34446667,8.84394669 6.33146667,8.83233022 6.32106667,8.81905425 L3.61966667,6.50587098 C3.5018,6.36149485 3.28426667,6.33577266 3.13346667,6.44861837 C3.0494,6.51167921 3,6.60792997 3,6.70998895 L4,14 L15,14 L16,6.70169148 C16,6.51831719 15.8448667,6.36979232 15.6533333,6.36979232 C15.5476,6.36979232 15.4470667,6.41625821 15.3812,6.495914 Z"></path></svg>
								<div class="_1dooA forum-text-color"></div></a>
						</div>
						<div class="_14GJw forum-text-color">
							<span aria-hidden="true" class="forum-text-color"
								style="font-weight: bold;">&nbsp;&nbsp;·&nbsp;&nbsp;</span>Discussion
						</div>
					</div></td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj"><span
					data-hook="post-list-item__view-count">8</span></td>
				<td class="_33Xju ZhoWl"><a
					href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/where-can-i-a-find-bag-mock-up-for-my-graphic-design"
					class="forum-text-color forum-link-hover-color _1n6TA"
					bilocation="post_list_item_recent_activity"
					data-hook="post-list-item__recent-activity"
					aria-label="Navigate to most recent activity"><div>
							<div data-hook="mcl-showable-content"></div>
							<span class="_14_Ju _2JPMk _2X6nY avatar-image"><div
									class="_2LXiY fluid-avatar-image" aria-hidden="true"></div></span>
						</div> <span class="_2udjW _3GzJy time-ago" data-hook="time-ago">Apr
							13</span></a></td>
				<td><div class="LTwPD more-button" data-hook="more-button">
						<button
							class="_2jKCS button-hover-fill forum-icon-fill forum-text-color forum-content-classic-font"
							aria-label="More actions"
							id="more-button-5e9447032e0a95002e92261e" aria-haspopup="true"
							aria-expanded="false">
							<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19"
								viewBox="0 0 19 19" role="img">
								<path
									d="M17.444 6A1.5 1.5 0 1 1 19 4.5 1.528 1.528 0 0 1 17.444 6zm0 5A1.5 1.5 0 1 1 19 9.5a1.528 1.528 0 0 1-1.556 1.5zm0 5A1.5 1.5 0 1 1 19 14.5a1.528 1.528 0 0 1-1.556 1.5z"></path></svg>
						</button>
					</div></td>
			</tr>
			<tr aria-hidden="true">
				<td class="_2lRkg" colspan="100"><div
						class="_3Cioj forum-separator-background-color"></div></td>
			</tr>
			<tr id="5e9447032e0a95002e92261f"
				class="_38Fer forum-text-color post-list-item forum-content-classic-font"
				data-hook="post-list-item">
				<td><div class="le4VL">
						<a
							href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/how-can-i-create-this-graphic-in-photoshop"
							class="forum-title-classic-font _1CApn"><h2
								class="_2FqU5 _2rOY9 forum-title-classic-font _2WkBL forum-text-color forum-link-hover-color post-title"
								data-hook="post-title">
								<div class="_33VI0">
									<div class="_3N7Rh">
										<span>How can I create this graphic in Photoshop?</span>
									</div>
								</div>
							</h2></a>
					</div>
					<div class="_146iO forum-links-hashtags-color">
						<div class="_2eFIV">
							<div data-hook="mcl-showable-content"></div>
							<a
								href="https://www.wix.com/demone2/designers-forum/profile/84770f67-ecbd-44b6-b35a-584f2dc15af1"
								class="_8ZDBI forum-text-color forum-link-hover-color"><span>Admin</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="19"
									viewBox="0 0 19 19" aria-label="Admin"
									class="_3LDKX forum-icon-fill" style="fill-rule: evenodd;">
									<path
										d="M15.3812,6.495914 L12.6789333,8.77258837 C12.6191333,8.84477644 12.5099333,8.85722265 12.4354,8.79997005 C12.4215333,8.79001308 12.4094,8.77756686 12.3998667,8.76429089 L9.78686667,6.14327115 C9.67766667,5.99225704 9.46186667,5.95491839 9.305,6.05863687 C9.26946667,6.08186981 9.23913333,6.11091099 9.21573333,6.14493065 L6.60013333,8.81075677 C6.5464,8.88626383 6.43893333,8.90534803 6.3592,8.85390366 C6.34446667,8.84394669 6.33146667,8.83233022 6.32106667,8.81905425 L3.61966667,6.50587098 C3.5018,6.36149485 3.28426667,6.33577266 3.13346667,6.44861837 C3.0494,6.51167921 3,6.60792997 3,6.70998895 L4,14 L15,14 L16,6.70169148 C16,6.51831719 15.8448667,6.36979232 15.6533333,6.36979232 C15.5476,6.36979232 15.4470667,6.41625821 15.3812,6.495914 Z"></path></svg>
								<div class="_1dooA forum-text-color"></div></a>
						</div>
						<div class="_14GJw forum-text-color">
							<span aria-hidden="true" class="forum-text-color"
								style="font-weight: bold;">&nbsp;&nbsp;·&nbsp;&nbsp;</span>Discussion
						</div>
					</div></td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj"><span
					data-hook="post-list-item__view-count">4</span></td>
				<td class="_33Xju ZhoWl"><a
					href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/how-can-i-create-this-graphic-in-photoshop"
					class="forum-text-color forum-link-hover-color _1n6TA"
					bilocation="post_list_item_recent_activity"
					data-hook="post-list-item__recent-activity"
					aria-label="Navigate to most recent activity"><div>
							<div data-hook="mcl-showable-content"></div>
							<span class="_14_Ju _2JPMk _2X6nY avatar-image"><div
									class="_2LXiY fluid-avatar-image" aria-hidden="true"></div></span>
						</div> <span class="_2udjW _3GzJy time-ago" data-hook="time-ago">Apr
							13</span></a></td>
				<td><div class="LTwPD more-button" data-hook="more-button">
						<button
							class="_2jKCS button-hover-fill forum-icon-fill forum-text-color forum-content-classic-font"
							aria-label="More actions"
							id="more-button-5e9447032e0a95002e92261f" aria-haspopup="true"
							aria-expanded="false">
							<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19"
								viewBox="0 0 19 19" role="img">
								<path
									d="M17.444 6A1.5 1.5 0 1 1 19 4.5 1.528 1.528 0 0 1 17.444 6zm0 5A1.5 1.5 0 1 1 19 9.5a1.528 1.528 0 0 1-1.556 1.5zm0 5A1.5 1.5 0 1 1 19 14.5a1.528 1.528 0 0 1-1.556 1.5z"></path></svg>
						</button>
					</div></td>
			</tr>
			<tr aria-hidden="true">
				<td class="_2lRkg" colspan="100"><div
						class="_3Cioj forum-separator-background-color"></div></td>
			</tr>
			<tr id="5e9447032e0a95002e922629"
				class="_38Fer forum-text-color post-list-item forum-content-classic-font"
				data-hook="post-list-item">
				<td><div class="le4VL">
						<a
							href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/how-to-create-an-illustrator-pattern"
							class="forum-title-classic-font _1CApn"><h2
								class="_2FqU5 _2rOY9 forum-title-classic-font _2WkBL forum-text-color forum-link-hover-color post-title"
								data-hook="post-title">
								<div class="_33VI0">
									<div class="_3N7Rh">
										<span>How to create an Illustrator Pattern?</span>
									</div>
								</div>
							</h2></a>
					</div>
					<div class="_146iO forum-links-hashtags-color">
						<div class="_2eFIV">
							<div data-hook="mcl-showable-content"></div>
							<a
								href="https://www.wix.com/demone2/designers-forum/profile/84770f67-ecbd-44b6-b35a-584f2dc15af1"
								class="_8ZDBI forum-text-color forum-link-hover-color"><span>Admin</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="19"
									viewBox="0 0 19 19" aria-label="Admin"
									class="_3LDKX forum-icon-fill" style="fill-rule: evenodd;">
									<path
										d="M15.3812,6.495914 L12.6789333,8.77258837 C12.6191333,8.84477644 12.5099333,8.85722265 12.4354,8.79997005 C12.4215333,8.79001308 12.4094,8.77756686 12.3998667,8.76429089 L9.78686667,6.14327115 C9.67766667,5.99225704 9.46186667,5.95491839 9.305,6.05863687 C9.26946667,6.08186981 9.23913333,6.11091099 9.21573333,6.14493065 L6.60013333,8.81075677 C6.5464,8.88626383 6.43893333,8.90534803 6.3592,8.85390366 C6.34446667,8.84394669 6.33146667,8.83233022 6.32106667,8.81905425 L3.61966667,6.50587098 C3.5018,6.36149485 3.28426667,6.33577266 3.13346667,6.44861837 C3.0494,6.51167921 3,6.60792997 3,6.70998895 L4,14 L15,14 L16,6.70169148 C16,6.51831719 15.8448667,6.36979232 15.6533333,6.36979232 C15.5476,6.36979232 15.4470667,6.41625821 15.3812,6.495914 Z"></path></svg>
								<div class="_1dooA forum-text-color"></div></a>
						</div>
						<div class="_14GJw forum-text-color">
							<span aria-hidden="true" class="forum-text-color"
								style="font-weight: bold;">&nbsp;&nbsp;·&nbsp;&nbsp;</span>Discussion
						</div>
					</div></td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj"><span
					data-hook="post-list-item__view-count">5</span></td>
				<td class="_33Xju ZhoWl"><a
					href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/how-to-create-an-illustrator-pattern"
					class="forum-text-color forum-link-hover-color _1n6TA"
					bilocation="post_list_item_recent_activity"
					data-hook="post-list-item__recent-activity"
					aria-label="Navigate to most recent activity"><div>
							<div data-hook="mcl-showable-content"></div>
							<span class="_14_Ju _2JPMk _2X6nY avatar-image"><div
									class="_2LXiY fluid-avatar-image" aria-hidden="true"></div></span>
						</div> <span class="_2udjW _3GzJy time-ago" data-hook="time-ago">Apr
							13</span></a></td>
				<td><div class="LTwPD more-button" data-hook="more-button">
						<button
							class="_2jKCS button-hover-fill forum-icon-fill forum-text-color forum-content-classic-font"
							aria-label="More actions"
							id="more-button-5e9447032e0a95002e922629" aria-haspopup="true"
							aria-expanded="false">
							<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19"
								viewBox="0 0 19 19" role="img">
								<path
									d="M17.444 6A1.5 1.5 0 1 1 19 4.5 1.528 1.528 0 0 1 17.444 6zm0 5A1.5 1.5 0 1 1 19 9.5a1.528 1.528 0 0 1-1.556 1.5zm0 5A1.5 1.5 0 1 1 19 14.5a1.528 1.528 0 0 1-1.556 1.5z"></path></svg>
						</button>
					</div></td>
			</tr>
			<tr aria-hidden="true">
				<td class="_2lRkg" colspan="100"><div
						class="_3Cioj forum-separator-background-color"></div></td>
			</tr>
			<tr id="5e9447032e0a95002e92262a"
				class="_38Fer forum-text-color post-list-item forum-content-classic-font"
				data-hook="post-list-item">
				<td><div class="le4VL">
						<a
							href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/how-to-create-a-logo-composed-but-readable"
							class="forum-title-classic-font _1CApn"><h2
								class="_2FqU5 _2rOY9 forum-title-classic-font _2WkBL forum-text-color forum-link-hover-color post-title"
								data-hook="post-title">
								<div class="_33VI0">
									<div class="_3N7Rh">
										<span>How to create a logo composed but readable?</span>
									</div>
								</div>
							</h2></a>
					</div>
					<div class="_146iO forum-links-hashtags-color">
						<div class="_2eFIV">
							<div data-hook="mcl-showable-content"></div>
							<a
								href="https://www.wix.com/demone2/designers-forum/profile/84770f67-ecbd-44b6-b35a-584f2dc15af1"
								class="_8ZDBI forum-text-color forum-link-hover-color"><span>Admin</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="19"
									viewBox="0 0 19 19" aria-label="Admin"
									class="_3LDKX forum-icon-fill" style="fill-rule: evenodd;">
									<path
										d="M15.3812,6.495914 L12.6789333,8.77258837 C12.6191333,8.84477644 12.5099333,8.85722265 12.4354,8.79997005 C12.4215333,8.79001308 12.4094,8.77756686 12.3998667,8.76429089 L9.78686667,6.14327115 C9.67766667,5.99225704 9.46186667,5.95491839 9.305,6.05863687 C9.26946667,6.08186981 9.23913333,6.11091099 9.21573333,6.14493065 L6.60013333,8.81075677 C6.5464,8.88626383 6.43893333,8.90534803 6.3592,8.85390366 C6.34446667,8.84394669 6.33146667,8.83233022 6.32106667,8.81905425 L3.61966667,6.50587098 C3.5018,6.36149485 3.28426667,6.33577266 3.13346667,6.44861837 C3.0494,6.51167921 3,6.60792997 3,6.70998895 L4,14 L15,14 L16,6.70169148 C16,6.51831719 15.8448667,6.36979232 15.6533333,6.36979232 C15.5476,6.36979232 15.4470667,6.41625821 15.3812,6.495914 Z"></path></svg>
								<div class="_1dooA forum-text-color"></div></a>
						</div>
						<div class="_14GJw forum-text-color">
							<span aria-hidden="true" class="forum-text-color"
								style="font-weight: bold;">&nbsp;&nbsp;·&nbsp;&nbsp;</span>Discussion
						</div>
					</div></td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj"><span
					data-hook="post-list-item__view-count">2</span></td>
				<td class="_33Xju ZhoWl"><a
					href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/how-to-create-a-logo-composed-but-readable"
					class="forum-text-color forum-link-hover-color _1n6TA"
					bilocation="post_list_item_recent_activity"
					data-hook="post-list-item__recent-activity"
					aria-label="Navigate to most recent activity"><div>
							<div data-hook="mcl-showable-content"></div>
							<span class="_14_Ju _2JPMk _2X6nY avatar-image"><div
									class="_2LXiY fluid-avatar-image" aria-hidden="true"></div></span>
						</div> <span class="_2udjW _3GzJy time-ago" data-hook="time-ago">Apr
							13</span></a></td>
				<td><div class="LTwPD more-button" data-hook="more-button">
						<button
							class="_2jKCS button-hover-fill forum-icon-fill forum-text-color forum-content-classic-font"
							aria-label="More actions"
							id="more-button-5e9447032e0a95002e92262a" aria-haspopup="true"
							aria-expanded="false">
							<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19"
								viewBox="0 0 19 19" role="img">
								<path
									d="M17.444 6A1.5 1.5 0 1 1 19 4.5 1.528 1.528 0 0 1 17.444 6zm0 5A1.5 1.5 0 1 1 19 9.5a1.528 1.528 0 0 1-1.556 1.5zm0 5A1.5 1.5 0 1 1 19 14.5a1.528 1.528 0 0 1-1.556 1.5z"></path></svg>
						</button>
					</div></td>
			</tr>
			<tr aria-hidden="true">
				<td class="_2lRkg" colspan="100"><div
						class="_3Cioj forum-separator-background-color"></div></td>
			</tr>
			<tr id="5e9447032e0a95002e92262b"
				class="_38Fer forum-text-color post-list-item forum-content-classic-font"
				data-hook="post-list-item">
				<td><div class="le4VL">
						<a
							href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/can-i-use-the-blue-color-for-restaurant-design"
							class="forum-title-classic-font _1CApn"><h2
								class="_2FqU5 _2rOY9 forum-title-classic-font _2WkBL forum-text-color forum-link-hover-color post-title"
								data-hook="post-title">
								<div class="_33VI0">
									<div class="_3N7Rh">
										<span>Can I use the blue color for restaurant design ?</span>
									</div>
								</div>
							</h2></a>
					</div>
					<div class="_146iO forum-links-hashtags-color">
						<div class="_2eFIV">
							<div data-hook="mcl-showable-content"></div>
							<a
								href="https://www.wix.com/demone2/designers-forum/profile/84770f67-ecbd-44b6-b35a-584f2dc15af1"
								class="_8ZDBI forum-text-color forum-link-hover-color"><span>Admin</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="19"
									viewBox="0 0 19 19" aria-label="Admin"
									class="_3LDKX forum-icon-fill" style="fill-rule: evenodd;">
									<path
										d="M15.3812,6.495914 L12.6789333,8.77258837 C12.6191333,8.84477644 12.5099333,8.85722265 12.4354,8.79997005 C12.4215333,8.79001308 12.4094,8.77756686 12.3998667,8.76429089 L9.78686667,6.14327115 C9.67766667,5.99225704 9.46186667,5.95491839 9.305,6.05863687 C9.26946667,6.08186981 9.23913333,6.11091099 9.21573333,6.14493065 L6.60013333,8.81075677 C6.5464,8.88626383 6.43893333,8.90534803 6.3592,8.85390366 C6.34446667,8.84394669 6.33146667,8.83233022 6.32106667,8.81905425 L3.61966667,6.50587098 C3.5018,6.36149485 3.28426667,6.33577266 3.13346667,6.44861837 C3.0494,6.51167921 3,6.60792997 3,6.70998895 L4,14 L15,14 L16,6.70169148 C16,6.51831719 15.8448667,6.36979232 15.6533333,6.36979232 C15.5476,6.36979232 15.4470667,6.41625821 15.3812,6.495914 Z"></path></svg>
								<div class="_1dooA forum-text-color"></div></a>
						</div>
						<div class="_14GJw forum-text-color">
							<span aria-hidden="true" class="forum-text-color"
								style="font-weight: bold;">&nbsp;&nbsp;·&nbsp;&nbsp;</span>Discussion
						</div>
					</div></td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj">0</td>
				<td class="v4Jom IKqJj"><span
					data-hook="post-list-item__view-count">2</span></td>
				<td class="_33Xju ZhoWl"><a
					href="https://www.wix.com/demone2/designers-forum/forum/ask-anything/can-i-use-the-blue-color-for-restaurant-design"
					class="forum-text-color forum-link-hover-color _1n6TA"
					bilocation="post_list_item_recent_activity"
					data-hook="post-list-item__recent-activity"
					aria-label="Navigate to most recent activity"><div>
							<div data-hook="mcl-showable-content"></div>
							<span class="_14_Ju _2JPMk _2X6nY avatar-image"><div
									class="_2LXiY fluid-avatar-image" aria-hidden="true"></div></span>
						</div> <span class="_2udjW _3GzJy time-ago" data-hook="time-ago">Apr
							13</span></a></td>
				<td><div class="LTwPD more-button" data-hook="more-button">
						<button
							class="_2jKCS button-hover-fill forum-icon-fill forum-text-color forum-content-classic-font"
							aria-label="More actions"
							id="more-button-5e9447032e0a95002e92262b" aria-haspopup="true"
							aria-expanded="false">
							<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19"
								viewBox="0 0 19 19" role="img">
								<path
									d="M17.444 6A1.5 1.5 0 1 1 19 4.5 1.528 1.528 0 0 1 17.444 6zm0 5A1.5 1.5 0 1 1 19 9.5a1.528 1.528 0 0 1-1.556 1.5zm0 5A1.5 1.5 0 1 1 19 14.5a1.528 1.528 0 0 1-1.556 1.5z"></path></svg>
						</button>
					</div></td>
			</tr>
		</tbody>
	</table>

	<!-- 인터넷 -->


	<div>
		<ul>
			<c:if test="${pageMaker.prev}">
				<li><a href="listSearch${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li><a href="listSearch${pageMaker.makeQuery(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="listSearch${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
			</c:if>
		</ul>
	</div>


	<!-- 실제로 돌아가는 페이징 -->

	<div class="blog-pagination justify-content-center d-flex">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item"><a class="page-link"
					aria-label="Previous"
					href="listSearch${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전

				</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li class="page-item"><a class="page-link"
					href="listSearch${pageMaker.makeQuery(idx)}">${idx}</a></li>
			</c:forEach>



			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li class="page-item"><a class="page-link" aria-label="Next"
					href="listSearch${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음

				</a></li>
			</c:if>
		</ul>
		<a href="rboard_writeform" class="primary-btn text-uppercase">글쓰기</a>
	</div>







</body>


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

</html>