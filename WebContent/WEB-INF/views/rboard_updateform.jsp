<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	response.setHeader("Set-Cookie", "HttpOnly;Secure;SameSite=Strict");
%>


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

select {

 padding: .8em .5em; /* 여백으로 높이 설정 */ 
 font-family: inherit; /* 폰트 상속 */ 
 background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%; /* 네이티브 화살표 대체 */ 
 border: 1px solid #999; border-radius: 1px; /* iOS 둥근모서리 제거 */ 
 -webkit-appearance: none; /* 네이티브 외형 감추기 */ 
 -moz-appearance: none; appearance: none;


    
    float:left;
    width:30%;
    height: 45px;
}

</style>

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
					<h1 class="text-white">Rboard update</h1>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->







	<section class="single-post-area">
		<div class="container">
			<!-- 게시글양식/ 이미지 등 기능 추가 -->
			<div class="comment-form">
				<h4>레시피 글 수정</h4>



				<form action="rboard_update" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="boardno" value="${dto.boardno}">
					 <input type="hidden" id="page" name="page" value="${scri.page} ">
	                <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"/>
	                
	                <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"/>
	                <input type="hidden" id="searchWord" name="searchWord" value="${scri.searchWord}"/>
	

					<!-- 제목, 아이디 -->
					 <p style="font-size : 1.2em ; color : black ;float:left "> *제목 </p>
                    <br><br>
					<div class="form-group" style="float:left">

							<input type="text" class="" id="title" name="title"
							style="border-color: black; border-style: solid; border-width:0.3px;
							width: 800px ; height: 45px; float:left"
								placeholder="제목" value="${dto.title }"/>
								
			 
			               
							<img src="${pageContext.request.contextPath}/${dto2.memberImg }" 
						         style=" border: 1px solid; 
                                 border-radius: 300px;
                                 -moz-border-radius: 300px;
                                 -khtml-border-radius: 300px;
                                 -webkit-border-radius: 300px; width:50px ; float:left;"/>
                                 
					        <input type="text" class="" id="id" name="memberid"
					              style=" border-color: black; border-style: solid; border-width:0.3px;
					              font-size : 1.2em ; color : black ; width: 100px ; height: 45px; float:left"						     
								placeholder="${dto.memberid}" value="${dto.memberid}" readonly />
			

					</div>
					
					
	
					
					<!-- 글분류 -->
					<!-- 1. 음식종류별 -->
					<br><br><br>
					<p style="font-size : 1.2em ; color : black ;float:left; ">*레시피 분류 선택 </p>
					<br>
					<p>
					<div class="" id=""
						style="">
						<select name="foodkind" >
							<option data-display="">음식종류별</option>
							<option value="밥류">밥류</option>
							<option value="빵류">빵류</option>
							<option value="면류">면류</option>
							<option value="밑반찬류">밑반찬류</option>
							<option value="디저트/음료">디저트/음료</option>
							<option value="기타">기타</option>
						</select>
					</div>
			

					<!-- 2.나라별 -->
					<div class="" id=""
						style="">
						<select name="countrykind" >
							<option data-display="">나라별</option>
							<option value="한식">한식</option>
							<option value="중식">중식</option>
							<option value="일식">일식</option>
							<option value="양식">양식</option>
							<option value="기타">기타</option>
						</select>
					</div>
				
					<!-- 3.조리시간별 -->
					<div class="" id=""
						style="">
						<select name="timekind" >
							<option data-display="">조리시간별</option>
							<option value="초간단 요리">초간단 요리</option>
							<option value="5분이내">5분이내</option>
							<option value="15분이내">15분이내</option>
							<option value="30분이내">30분이내</option>
							<option value="장시간 요리">장시간 요리</option>
						</select>
					</div>
					</p>


					<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
					<script>
					var foodkind = "${dto.foodkind}";	
					$("select[name=foodkind]").val(foodkind).prop("selected",true);
					
					
					var countrykind = "${dto.countrykind}";		
					$("select[name=countrykind]").val(countrykind).prop("selected",true);
					
					
					var timekind = "${dto.timekind}";
					$("select[name=timekind]").val(timekind).prop("selected",true);
					
					</script>





					<br> <br> <br> <br>
					<!-- 사용한 재료 -->
					
					<p  style="font-size : 1.2em ; color : black ;float:left"> *주요 재료</p>

					<div class="form-group">
						<textarea class="form-control mb-10" 
						    style="border-color: black; border-style: solid; border-width:0.3px; width:1000px"
						    rows="2" 
						    name="majormat" 
							placeholder="꼭필요한재료" onfocus="this.placeholder = ''"
							onblur="this.placeholder = '꼭필요한 재료'" required="">${dto.majormat }</textarea>
					</div>
					
					<p  style="font-size : 1.2em ;float:left ; color : black"; > *기타 재료</p>

					<div class="form-group">
						<textarea class="form-control mb-10" rows="2" 
						    style="border-color: black; border-style: solid; border-width:0.3px; width:1000px"
						    name="minormat"
							placeholder="기타 추가 재료" onfocus="this.placeholder = ''"
							onblur="this.placeholder = '기타 추가 재료'" required="">${dto.minormat }</textarea>
					
					<br><br><hr>
					</div>





					<!-- 썸네일  -->
					<div class="inputArea">
						<label for="gdsImg" style="font-size : 1.2em ; color : black; float:left"> *대표사진 첨부</label> 
						
						<input type="file" id="gdsImg" name="file" style="float:left" />
						<div class="select_img">
						<br><br>
						
							<img src="${pageContext.request.contextPath}/${dto.gdsImg}"
							   style="width:500px; height:350px" />
						  <input type="hidden" name="gdsImg" value="${dto.gdsImg}" />
                          <input type="hidden" name="gdsThumbImg" value="${dto.gdsThumbImg}" /> 
						
						</div>

					</div>
					
					<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
					<script>
                          $("#gdsImg").change(function(){
                             if(this.files && this.files[0]) {
                             var reader = new FileReader;
                             reader.onload = function(data) {
                             $(".select_img img").attr("src", data.target.result).width(500);        
                             }
                            reader.readAsDataURL(this.files[0]);
                             }
                          });
                     </script>


					<!-- 이미지 등록 두번째방법 : 멀티파일, 본문이미지들  -->
					<br><br>
                    <p style="font-size : 1.2em ; color : black; float:left">*내용</p>
              

					<div class="inputArea">
						 <label for="uploadFile"  style="font-size : 1.2em ; color : black; float:left"></label> 
						<input multiple="multiple"
							type="file" id="uploadFile" name="uploadFile"
							onchange="setThumbnail(event);" style="float:left">

						<div class="select_img2">
							<img src="" />
						</div>
					</div>

					<!-- 이미지 첨부 끝  -->


					<!-- div태그 : contentEditable  -->
					<div id="image_container" placeholder="내용"
						onfocus="this.placeholder = ''" onblur="this.placeholder = '내용'"
						contentEditable="true"
						style="width: 1050px; height: 500px; background-color: white; border: 1px solid; overflow: scroll">


					</div>


                    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
					<script>
					 $(document).ready(function(){
						
					   
						 $("#image_container").html('${dto.content}');
						  
					 });
					
					
					  </script>

					<input type="hidden" class="form-control" id="contenta"
						name="contenta" placeholder="제목"  />

					<!-- contentEditable의 html을 히든인풋태그로 옮김 -->
					<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
					<script>
					  $(document).ready(function(){
						  
						  //마지막 버튼 클릭시
						  $('#submit').click(function(){
							  
							  //contentEditable안의 이미지들을 태그로 변환시킨다.
							  //성공
							  var xxx= $('#image_container').html();
							  alert(xxx);
							  
							  
							  $('#contenta').val($('#image_container').html());
							  
							  
							  
							 /* var txtBox =$('#image_container').text();
							  var lines= txtBox.split("\n");
							  
							  var resultString  = "<p>";
							  for (var i = 0; i < lines.length; i++) {
							      resultString += lines[i] + "<br>";
							  }
							  resultString += "</p>";
							  
							  alert(resultString);
							  //document.getElementById('contenta').innerHTML += resultString;
							  
							  //var   blk= $('#contentaa');
							  //blk.innerHTML = resultString;
							  
							  //$('#contenta').val($('#image_container').text());
							  $('#contenta').val(resultString);*/
						  });
						  
					  });
					</script>


					<!--contentEditable에서 다중파일 미리보기 -->


					<script> 
                     
                     function setThumbnail(event) { 	 
                    	 for (var image of event.target.files) { 
                    		 
                    		 var reader = new FileReader(); 
                    		 reader.onload = function(event) { 
                    			 
                    			 //img태그 생성후 contentEditable에 붙임.
                    			 var img = document.createElement("img"); 
                    			 img.setAttribute("src", event.target.result); 
                    			 img.setAttribute("height", 100); 
                    			 document.querySelector("div#image_container").appendChild(img); 
                    		 }; 
                    		 
         
                    		 reader.readAsDataURL(image); 
                    		 //이미지를 html로 내용에 저장시키자.
                    	} 
                    } 
                     
                     </script>


					<!-- 글작성버튼 -->
					<input type="submit" id="submit" class="primary-btn text-uppercase"
						value="수정"> <input type="button" value="취소"
						class="primary-btn text-uppercase"
						onclick="location.href='rboard_detail?boardno=' +${dto.boardno}  +'&page=' + ${scri.page} +'&perPageNum=' +${scri.perPageNum}">
				</form>
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