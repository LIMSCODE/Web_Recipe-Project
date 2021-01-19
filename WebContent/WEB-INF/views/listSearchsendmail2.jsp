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
					<h1 class="text-white">Recipe Board</h1>
					
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
				<form action="listSearchsendmail123" method="get" id="searchForm">
					<div class="search_ctn">
						<div style="font-size:15px ; color:red" >* 검색 조건</div>
					<br><br>
						<div class="search_div1">
							<ul style="float:left; ">
								<li class="search_li"  style="float:left;font-size: 15px ">음식종류별 : &nbsp;&nbsp; </li>
							
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s1"
									name="foodkind" value="밥류" style="width:15px; height:15px; font-size: 15px" /><label for="s1" style="font-size: 15px; ">밥류 &nbsp;&nbsp;     </label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s2"
									name="foodkind" value="빵류" style="width:15px; height:15px; font-size: 15px" /><label for="s2" style="font-size: 15px">빵류  &nbsp;&nbsp; </label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s3"
									name="foodkind" value="면류" style="width:15px; height:15px;font-size: 15px "/><label for="s3" style="font-size: 15px">면류 &nbsp;&nbsp; </label></li>
							
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s4"
									name="foodkind" value="밑반찬류" style="width:15px; height:15px;font-size: 15px" /><label for="s4" style="font-size: 15px">밑반찬류 &nbsp;&nbsp; </label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s5"
									name="foodkind" value="디저트/음료" style="width:15px; height:15px;font-size: 15px" /><label for="s5" style="font-size: 15px">디저트/음료 &nbsp;&nbsp; </label></li>
								<li class="check_li"  style="float:left; "><input type="checkbox" id="s6"
									name="foodkind" value="기타"  style="width:15px; height:15px;font-size:15px"/><label for="s6" style="font-size: 15px">기타 &nbsp;&nbsp; </label></li>
							</ul>
						</div>
						<br>
						<br>
						

						<div class="search_div2">
							<ul  style="float:left; ">
								<li class="search_li"  style="float:left; font-size: 15px">나라별 :  &nbsp;&nbsp;</li>
								
								<li style="float:left;"><input type="checkbox" id="r1" name="countrykind"
									value="한식"  style="width:15px; height:15px;  font-size: 15px"/> <label for="r1" style="font-size: 15px">한식  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="r2" name="countrykind"
									value="중식"  style="width:15px; height:15px; font-size: 15px"/> <label for="r2" style="font-size: 15px">중식  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="r3" name="countrykind"
									value="일식" style="width:15px; height:15px; font-size: 15px" /> <label for="r3" style="font-size: 15px">일식  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="r4" name="countrykind"
									value="양식" style="width:15px; height:15px ; font-size: 15px" /> <label for="r4 " style="font-size: 15px">양식  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="r5" name="countrykind"
									value="기타" style="width:15px; height:15px ; font-size:15px"  /> <label for="r5 " style="font-size: 15px">기타  &nbsp;&nbsp;</label></li>
								
							</ul>
						</div>
                        <br>
						<br>
						
						
						<div class="search_div3 ">
							<ul  style="float:left; ">
							     <li class="search_li"  style="float:left;font-size: 15px ">조리시간별 : &nbsp;&nbsp;</li>
								<li style="float:left;"><input type="checkbox" id="t1" name="timekind"
									value="초간단 요리" style="width:15px; height:15px; font-size: 15px" /> <label for="t1" style="font-size: 15px">초간단 요리  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="t2" name="timekind"
									value="5분이내"  style="width:15px; height:15px; font-size: 15px" /> <label for="t2" style="font-size: 15px">5분이내  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="r3" name="timekind"
									value="15분이내"  style="width:15px; height:15px; font-size:15px" /> <label for="t3" style="font-size: 15px">15분이내  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="t4" name="timekind"
									value="30분이내"  style="width:15px; height:15px; font-size: 15px" /> <label for="t4" style="font-size: 15px">30분이내  &nbsp;&nbsp;</label></li>
								<li style="float:left;"><input type="checkbox" id="t5" name="timekind"
									value="장시간 요리" style="width:15px; height:15px; font-size: 15px" /> <label for="t5" style="font-size: 15px">장시간 요리  &nbsp;&nbsp;</label></li>

							</ul>


						</div>
					
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
						
						<br>
						<br>

						<div class="">
							<select name="SearchType" style="width:200px">
								<option>선택</option>
								<option value="id">ID</option>
								<option value="title">제목</option>
							</select> 
							<input type="text" class="" style="width: 300px ; height:45px" placeholder="검색어를 입력하세요" name="SearchWord" /> <br>
				
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
			
         	//검색창에만 입력했을때
			   $(function() {
					$("#searchForm").submit(function() {
					
						
						if ($(".search_div1 input:checked").length == 0) {
							alert("음식 종류를 하나 이상 체크해주세요");
							return false;
						}
						
						
					});
				});
         	
         	
				//컨트롤러에서 받은 메시지 출력
				//var message = '${msg}';
				//alert(message);

				function allChk(bool) {
					//전체 선택
					var chks = document.getElementsByName("chk"); 
					
					//체크한것만 선택
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
						
						//전체 선택
						var chks = document.getElementsByName("chk"); 
						//게시글 번호를 넣을 배열
						var chks123 = new Array;
						
						for(var i =0; i<$("#muldelform input:checked").length; i++) {
							
							
							

							chks123.push(  $("#muldelform input:checked").eq(i).val()  );

	
						}
						
			

						   $.ajax({
						        url: "listSearchpopup123",
				                type: "GET",
				                data: {
				                    "chks123" :  chks123
				                    
				                },
				                datatype: "json",
				                success:function(data){
				                	alert("체크한 게시글번호 전송됨");
				                	window.location.href = "listSearchpopup";
				                },
				                error:function(){
				                	alert("게시글번호 전송 실패");
				                }
					        });
						
						
						
					});
				});
				
				

				//정렬기준
				function orderby(str) {
		
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
			            $(this).next("h4").toggleClass("hide");
			        
			        
			           
			        });
			        
			  
			    });
				 
				
			//작성글 보기 누르면 팝업창 뜸
			    function popup(madebyid){
			
				         var url = "popup?madebyid="+madebyid;
			            var name = "popup test";
			            var option = "width = 800, height = 500, top = 100, left = 300, location = no  scrollbars = yes" 
			            window.open(url, name, option);
		            
		        }
				 

			</script>

			<div class="">
				<div class="">
					<form action="listSearchpopup" method="get" id="muldelform">
					<div >
						<input type="checkbox" style="width:20px; height:20px; float:left" name="all" onclick="allChk(this.checked);">
						<p style="font-size:20px;float:left">  &nbsp;&nbsp;전체선택  &nbsp;&nbsp;</p>
					
						
						<input type="submit" class="primary-btn text-uppercase" style="float:left" value="메일로 보내기">

						
					</div>
					<!-- 4. 조회수/댓글수/좋아요수 -->
						<div class="" id="" style="float:right; position: relative; left:490px; bottom: 20px; width:700px ;height:35px ;">
							<select onchange="orderby(this.value)">
								<option data-display="">정렬기준</option>
								<option value="1">조회수 높은순</option>
							
							</select>
						</div>	
						<br> <br>	<br> 
					

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
										<div class="col-lg-4" style="float: left;z-index: 1; width: 33%;">
											<input type="checkbox" name="chk" value="${dto.boardno }" style="width:20px; height:20px;">
											${dto.boardno } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
											&nbsp;&nbsp;&nbsp; * ${dto.foodkind }&nbsp;&nbsp;&nbsp; * ${dto.countrykind }&nbsp;&nbsp;&nbsp; * ${dto.timekind }
											<div class="single-service">
											
												<a class="thumb" href="rboard_detail?boardno=${dto.boardno} 
													 &page= ${scri.page} &perPageNum=${scri.perPageNum}
													  &foodkind= ${scri.foodList[0]} &foodkind= ${scri.foodList[1]}
                                                    &foodkind= ${scri.foodList[2]}&foodkind= ${scri.foodList[3]}
                                                     &foodkind= ${scri.foodList[4]} &foodkind= ${scri.foodList[5]}
                                                      &countrykind= ${scri.countryList[0]} &countrykind= ${scri.countryList[1]}
                                                     &countrykind= ${scri.countryList[2]} &countrykind= ${scri.countryList[3]}
                                                    &countrykind= ${scri.countryList[4]}
                                                    &timekind= ${scri.timeList[0]}&timekind= ${scri.timeList[1]}
                                                      &timekind= ${scri.timeList[2]}&timekind= ${scri.timeList[3]}
                                                      &timekind= ${scri.timeList[4]}
                                                      &SearchType= ${scri.searchType}&SearchWord= ${scri.searchWord}">
                

													<img src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
													style="width: 350px; height: 210px" />

												</a>
												
													<h4 style="display: inline-block" 
													href="rboard_detail?boardno=${dto.boardno} 
													 &page= ${scri.page} &perPageNum=${scri.perPageNum}
													  &foodkind= ${scri.foodList[0]} &foodkind= ${scri.foodList[1]}
                                                    &foodkind= ${scri.foodList[2]}&foodkind= ${scri.foodList[3]}
                                                     &foodkind= ${scri.foodList[4]} &foodkind= ${scri.foodList[5]}
                                                      &countrykind= ${scri.countryList[0]} &countrykind= ${scri.countryList[1]}
                                                     &countrykind= ${scri.countryList[2]} &countrykind= ${scri.countryList[3]}
                                                    &countrykind= ${scri.countryList[4]}
                                                    &timekind= ${scri.timeList[0]}&timekind= ${scri.timeList[1]}
                                                      &timekind= ${scri.timeList[2]}&timekind= ${scri.timeList[3]}
                                                      &timekind= ${scri.timeList[4]}
                                                      &SearchType= ${scri.searchType}&SearchWord= ${scri.searchWord}">${dto.title}</h4>
													
													
													
													
												<!-- 프로필사진, 아이디 -->
													
													<h4 class="madeby" style="display: inline-block; float: right; z-index: 1;">
													${dto.memberid}
													</h4>
													
													<h4 class="hide" style=" float: right; background-color:green;
													      position: relative; right:10px; bottom:1px; z-index: 2;
													      width:70px; height:30px ;  border-radius:10px ;font-size:5px">
													<ul >
                                                        <li class="madeby123" style="position: relative; left:10px;top:13px;" onclick="popup('${dto.memberid}');">작성글 보기</li>                                     
                                                    </ul>
                                                    </h4>
                                                    
                                                  
													
													<img src="${pageContext.request.contextPath}/${dto.memberImg }" 
													     style="border: 1px solid; z-index: 1;
                                                         border-radius: 70px;
                                                         -moz-border-radius: 70px;
                                                         -khtml-border-radius: 70px;
                                                         -webkit-border-radius: 70px; width: 50px;
                                                         display: inline-block; float: right;"/>

                                             
                                             
                                             
                                                    
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

  <style>
			    .madeby {cursor:pointer;}
			    .hide{display:none;}
  </style>

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


</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	
<br><br><br><br><br><br><br><br><br><br><br>
<!-- 실제로 돌아가는 페이징 -->

	<div class="blog-pagination justify-content-center d-flex">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item"><a class="page-link"
					aria-label="Previous"
					href="listSearchsendmail2${pageMaker.makeQuery(pageMaker.startPage - 1)}
					&foodkind=${scri.foodList[0]}&foodkind=${scri.foodList[1]} &foodkind=${scri.foodList[2]} &foodkind=${scri.foodList[3]} &foodkind=${scri.foodList[4]} &foodkind=${scri.foodList[5]}  
					&countrykind=${scri.countryList[0]}&countrykind=${scri.countryList[1]}&countrykind=${scri.countryList[2]}&countrykind=${scri.countryList[3]}&countrykind=${scri.countryList[4]}
					&timekind=${scri.timeList[0]}&timekind=${scri.timeList[1]}&timekind=${scri.timeList[2]}&timekind=${scri.timeList[3]}&timekind=${scri.timeList[4]}
					&SearchType=${scri.searchType}
					&SearWord=${scri.searchWord}">이전

				</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li class="page-item"><a class="page-link"
					href="listSearchsendmail2${pageMaker.makeQuery(idx)}
					&foodkind=${scri.foodList[0]}&foodkind=${scri.foodList[1]} &foodkind=${scri.foodList[2]} &foodkind=${scri.foodList[3]} &foodkind=${scri.foodList[4]} &foodkind=${scri.foodList[5]}  
					&countrykind=${scri.countryList[0]}&countrykind=${scri.countryList[1]}&countrykind=${scri.countryList[2]}&countrykind=${scri.countryList[3]}&countrykind=${scri.countryList[4]}
					&timekind=${scri.timeList[0]}&timekind=${scri.timeList[1]}&timekind=${scri.timeList[2]}&timekind=${scri.timeList[3]}&timekind=${scri.timeList[4]}
					&SearchType=${scri.searchType}
					&SearWord=${scri.searchWord}">${idx}</a></li>
			</c:forEach>



			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li class="page-item"><a class="page-link" aria-label="Next"
					href="listSearchsendmail2${pageMaker.makeQuery(pageMaker.endPage + 1)}
					&foodkind=${scri.foodList[0]}&foodkind=${scri.foodList[1]} &foodkind=${scri.foodList[2]} &foodkind=${scri.foodList[3]} &foodkind=${scri.foodList[4]} &foodkind=${scri.foodList[5]}  
					&countrykind=${scri.countryList[0]}&countrykind=${scri.countryList[1]}&countrykind=${scri.countryList[2]}&countrykind=${scri.countryList[3]}&countrykind=${scri.countryList[4]}
					&timekind=${scri.timeList[0]}&timekind=${scri.timeList[1]}&timekind=${scri.timeList[2]}&timekind=${scri.timeList[3]}&timekind=${scri.timeList[4]}
					&SearchType=${scri.searchType}
					&SearWord=${scri.searchWord}">다음

				</a></li>
			</c:if>
		</ul>
		<a href="rboard_writeform" class="primary-btn text-uppercase">글쓰기</a>
	</div>

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