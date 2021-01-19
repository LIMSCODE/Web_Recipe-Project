<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- 공지사항, 검색기능 추가하기 -->
<!-- elements.html 에 각종 라디오, 체크박스, 목록선택, 표 
about .html : 인스타 1인 창, 네모칸 3개
blog home.html : 이메일입력칸, 검색창, 클라우드 태그, 
blog single.html : 카테고리별 글 개수
context.html :  집, 전화 이모티콘
-->
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
<!-- 검색창 드롭다운 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css2/nested_side_bar_menu.css" />

</head>

<style>
.green_window {
	display: inline-block;
	width: 366px;
	height: 34px;
	border: 3px solid red;
	background: white;
}

.input_text {
	width: 348px;
	height: 21px;
	margin: 6px 0 0 9px;
	border: 0;
	line-height: 21px;
	font-weight: bold;
	font-size: 16px;
	outline: none;
}

.sch_smit {
	width: 54px;
	height: 40px;
	margin: 0;
	border: 0;
	vertical-align: top;
	background: red;
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}

.sch_smit:hover {
	background: #56C82C;
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
								<li><a href="mypage">마이페이지 (${dto.id } 님환영합니다.)</a></li>
								
								<li><a href="originallogout">로그아웃</a></li>
							</c:when>

							<c:when test="${sessionId != null}">

								<li><a href="mypage">마이페이지</a></li>
								<li><a href="mypage">'${sessionId}'님, 네이버 아이디로 로그인됨.</a></li>
								<li><a href="logout">로그아웃</a></li>
								
								
								
								
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
	<section class="banner-area">
		<div class="container ">
			<div
				class="row fullscreen align-items-center justify-content-between">
				<div class="col-lg-12 banner-content">
					<br><br><br><br><br>
					<h1 class="text-white">Delicious Recipes</h1>
					<h6 class="text-white">[Choice Option]</h6>
					
					<br>
				</div>


             <form action="listSearchsendmail123" method="get" id="searchForm">
				<!-- 큰 검색창 -->
				<div class="" style="">
					<!-- 큰 검색창 -->
					<div class="search_div1">
							<ul style=" ">
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
							<ul  style=" ">
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
							<ul  style=" ">
							     <li class="search_li"  style="float:left; ">조리시간별 :</li>
								<li style="float:left;"><input type="checkbox" id="t1" name="timekind"
									value="초간단 요리" /> <label for="t1">초간단 요리</label></li>
								<li style="float:left;"><input type="checkbox" id="t2" name="timekind"
									value="5분이내"  /> <label for="t2">5분이내</label></li>
								<li style="float:left;"><input type="checkbox" id="r3" name="timekind"
									value="15분이내"  /> <label for="t3">15분이내</label></li>
								<li style="float:left;"><input type="checkbox" id="t4" name="timekind"
									value="30분이내"  /> <label for="t4">30분이내</label></li>
								<li style="float:left;"><input type="checkbox" id="t5" name="timekind"
									value="장시간 요리" /> <label for="t5">장시간 요리</label></li>

							</ul>

				        </div>
				   </div>
				   
				   
				<span class='green_window'
					style="width: 700px; height: 70px; margin: 10px; padding: 0px;float: left;">
					<input type='text' class='input_text' />
					<div id="tagarea1"   style="font: italic  ; float:left"></div>
					<div id="tagarea2"   style="font: italic  ; float:left"></div>
					<div id="tagarea3"   style="font: italic  ; float:left"></div>
				</span>
				<button type='submit' id= "mainsearch" class="primary-btn text-uppercase"
					style="width: 100px; height: 70px; margin: 0px; padding: 0px; font-size: 20px; float: left;">찾기</button>
				   
		 </form>
	
			</div>
		</div>
		
		<br><br><br><br><br><br>
	</section>
	<!-- End banner Area -->

			<script type="text/javascript"
				src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			    <script type="text/javascript">
			    //셀렉트한 밸류값 태그에 붙여넣기
                    $(document).ready(function(){
                        $("input:checkbox[name='foodkind']").on('click', function() { 
                        	
                        	
                        	if ( $(this).is(":checked") ==true ) { 

                     		  var tag1 = '<span class="tag1" style="color:black; background-color:gray; font-weight : bold ; font-size: 20px;border-radius: 2px; margin: 10px">'+ this.value +' </span>' ;
      	                   
                     		   $("#tagarea1").append(tag1);
                     		
                           }else if($(this).is(":checked") == false){
                            
                        	   $('.tag1:contains('+this.value+')').remove();
                   		   
                           }
                       });
                        
                      $("input:checkbox[name='countrykind']").on('click', function() { 
                        	
                        	
                        	if ( $(this).is(":checked") ==true ) { 
        
                     		  var tag2 = '<span class="tag2" style="color:black; background-color:gray; font-weight : bold ; font-size: 20px;border-radius: 2px; margin: 10px">'+ this.value +' </span>' ;
      	                   
                     		   $("#tagarea2").append(tag2);
                     		
                           }else if($(this).is(":checked") == false){
                             
                        	 
                        	   $('.tag2:contains('+this.value+')').remove();
                   		   
                           }
                       });
                      
                      $("input:checkbox[name='timekind']").on('click', function() { 
                      	
                      	
                      	if ( $(this).is(":checked") ==true ) { 
      
                   		  var tag3 = '<span class="tag3" style="color:black; background-color:gray; font-weight : bold ; font-size: 20px;border-radius: 2px; margin: 10px">'+ this.value +' </span>' ;
    	                   
                   		   $("#tagarea3").append(tag3);
                   		
                         }else if($(this).is(":checked") == false){
                           
                      	 
                      	   $('.tag3:contains('+this.value+')').remove();
                 		   
                         }
                     });
                   });
			    
			    
                    $(function() {
    					$("#searchForm").submit(function() {
    					
    						
    						if ($(".search_div1 input:checked").length == 0) {
    							alert("음식 종류를 하나 이상 체크해주세요");
    							return false;
    						}
    						
    						
    					});
    				});
             	
                    
                    $(document).ready(function(){
                    	
                    	
                    	$(".latest1").hide();
                    	$(".latest2").hide();
                    	$(".latest3").hide();
                    	$(".latest4").hide();
                    	$(".latest5").hide();
                    	
                    	$("#listclick0").attr({'class' : 'active'});
                    	
                    	$("#listclick0").on('click', function() {
                    		
                    		
                    		$(".latest0").show();
                   		     $(".latest1").hide();
                   		     $(".latest2").hide();
                          	$(".latest3").hide();
                          	$(".latest4").hide();
                          	$(".latest5").hide();
                   	    });
                    	
                       $("#listclick1").on('click', function() {
                    		
                    		
                    		$(".latest0").hide();
                   		     $(".latest1").show();
                   		     $(".latest2").hide();
                          	$(".latest3").hide();
                          	$(".latest4").hide();
                          	$(".latest5").hide();
                   	    });
                    	$("#listclick2").on('click', function() {
                    		
                    		 $(".latest0").hide();
                    		$(".latest1").hide();
                  		     $(".latest2").show();
                  			 $(".latest3").hide();
                           	$(".latest4").hide();
                          	$(".latest5").hide();
                  	    });
                    	$("#listclick3").on('click', function() {
                    		
                    		 $(".latest0").hide();
                    		 
                    		$(".latest1").hide();
                 		     $(".latest2").hide();
                 		    $(".latest3").show();
                          	$(".latest4").hide();
                         	$(".latest5").hide();
                  		     
                  	    });
                    	$("#listclick4").on('click', function() {
                    		
                    		 $(".latest0").hide();
                    		$(".latest1").hide();
                		     $(".latest2").hide();
                		    $(".latest3").hide();
                  		     $(".latest4").show();
                  		   $(".latest5").hide();
                  	    });
                    	$("#listclick5").on('click', function() {
                    		
                    		 $(".latest0").hide();
                    		$(".latest1").hide();
               		        $(".latest2").hide();
               		       $(".latest3").hide();
                 		     $(".latest4").hide();
                  		     $(".latest5").show();
                  	    });
                   	 
                    	
                    
                    });
                    
                  
                    
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
    				    alert(madebyid);
    				         var url = "popup?madebyid="+madebyid;
    			            var name = "popup test";
    			            var option = "width = 800, height = 500, top = 100, left = 300, location = no  scrollbars = yes" 
    			            window.open(url, name, option);
    		            
    		        }
    				 
                    	
                    	 
                    
			    </script>
			    
			    
		<style>
			    .madeby {cursor:pointer;}
			    .hide{display:none;}
       </style>
		

	<!-- Start menu-area Area -->
	<section class="menu-area" style="margin:10px" id="menu">
		<div class="container">

			<div class="row justify-content-center">
				<div class="menu-content">
				<hr><h2 class=""> 최신 레시피</h2>
			
				</div>
			</div>
<br><br>
			<!-- 밥,빵,면,육류,채소선택 -->
			<ul class="filter-wrap filters col-lg-12 " style="height:10px">

			
                <li id="listclick0" data-filter=".000">전체</li>
				<li id="listclick1" data-filter=".111">밥종류</li>
				<li id="listclick2" data-filter=".222">빵종류</li>
				<li id="listclick3" data-filter=".333">면종류</li>
				<li id="listclick4" data-filter=".444">밑반찬</li>
				<li id="listclick5" data-filter=".555">디저트/음료</li>
			</ul>

			<div class="latest0">
				<div class="row ">


					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty mainlatest0}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${mainlatest0 }" var="dto">

								<div class="col-lg-3 col-md-6 col-sm-6 single-blog all 000"  
						style="float: left; width: 24%;"
									>

									<div class="thumb">
										<img onclick="location.href='rboard_detail?boardno=${dto.boardno}'"
											src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
											style="width: 420px; height: 210px"  />
									</div>

	

									<p>
									<h4 style="display: inline-block"
										onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title}</h4>


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
									</p>



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

				<!-- 레시피 하나 끝 -->

		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

			</c:forEach>
			</c:otherwise>
			</c:choose>
         </div>
		</div>
		
		
		
		
			<div class="latest1">
				<div class="row ">


					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty mainlatest1}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${mainlatest1}" var="dto">

								<div class="col-lg-3 col-md-6 col-sm-6 single-blog all 111"  
						style="float: left; width: 24%;"
									onclick="location.href='rboard_detail?boardno=${dto.boardno}'">

									<div class="thumb">
										<img
											src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
											style="width: 420px; height: 210px"  />
									</div>

	
 
  
  
									<p>
									<h4 style="display: inline-block"
										onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title}</h4>


									
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

				<!-- 레시피 하나 끝 -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		

			</c:forEach>
			</c:otherwise>
			</c:choose>
</div>
		</div>
		
			<div class="latest2">
				<div class="row ">


					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty mainlatest2}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${mainlatest2}" var="dto">

								<div class="col-lg-3 col-md-6 col-sm-6 single-blog all 222"  
						style="float: left; width: 24%;"
									onclick="location.href='rboard_detail?boardno=${dto.boardno}'">

									<div class="thumb">
										<img
											src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
											style="width: 420px; height: 210px"  />
									</div>

	

									<p>
									<h4 style="display: inline-block"
										onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title}</h4>


									
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

				<!-- 레시피 하나 끝 -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

			</c:forEach>
			</c:otherwise>
			</c:choose>
        </div>
		</div>
		
		
		
			<div class="latest3">
				<div class="row ">


					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty mainlatest3}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${mainlatest3}" var="dto">

								<div class="col-lg-3 col-md-6 col-sm-6 single-blog all 333"  
						style="float: left; width: 24%;"
									onclick="location.href='rboard_detail?boardno=${dto.boardno}'">

									<div class="thumb">
										<img
											src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
											style="width: 420px; height: 210px"  />
									</div>

	

									<p>
									<h4 style="display: inline-block"
										onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title}</h4>


								
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

				<!-- 레시피 하나 끝 -->

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

			</c:forEach>
			</c:otherwise>
			</c:choose>
          </div>
		</div>
		
		
		
		
			<div class="latest4">
				<div class="row ">


					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty mainlatest4}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${mainlatest4}" var="dto">

								<div class="col-lg-3 col-md-6 col-sm-6 single-blog all 444"  
						style="float: left; width: 24%;"
									onclick="location.href='rboard_detail?boardno=${dto.boardno}'">

									<div class="thumb">
										<img
											src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
											style="width: 420px; height: 210px"  />
									</div>

	

									<p>
									<h4 style="display: inline-block"
										onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title}</h4>


									
													
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
									</p>



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

				<!-- 레시피 하나 끝 -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

			</c:forEach>
			</c:otherwise>
			</c:choose>
         </div>
		</div>
		
		
		
		
			<div class="latest5">
				<div class="row ">


					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty mainlatest5}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${mainlatest5}" var="dto">

								<div class="col-lg-3 col-md-6 col-sm-6 single-blog all 555"  
						style="float: left; width: 24%;"
									onclick="location.href='rboard_detail?boardno=${dto.boardno}'">

									<div class="thumb">
										<img
											src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
											style="width: 420px; height: 210px"  />
									</div>

	

									<p>
									<h4 style="display: inline-block"
										onclick="location.href='rboard_detail?boardno=${dto.boardno}'">${dto.title}</h4>


									
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
									</p>



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

				<!-- 레시피 하나 끝 -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

			</c:forEach>
			</c:otherwise>
			</c:choose>
</div>
		</div>
		
		
		
		
		</div>


	</section>


	<!-- End menu-area Area -->
<hr>

	<!-- Start 랭킹 1~3위-->
	<section class="review-area">
		<div class="container">
			<div class="row justify-content-center">
			
			<div class="menu-content">
			
			<hr style="color:black">
			<h2 class=""> Point Ranking</h2>
			
			
			</div>
			</div>
			
<br>
				<div  >
				<div  class="row" style=" width: 770px; margin:0 auto">

					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty ranking}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${ranking }" var="dto">

								<!-- 계정하나 -->
								<div class="single-review">
							
								<div>
									
									<br>
									
									<img src="${pageContext.request.contextPath}/${dto.memberImg }"
										style="border: 1px solid; border-radius: 70px; -moz-border-radius: 70px; 
										-khtml-border-radius: 70px; -webkit-border-radius: 70px; 
										width: 150px; height: 150px; display: inline-block" />
										<br><br>


                                                   <h4 class="madeby" style="display: inline-block;  z-index: 1;">
													${dto.id}
													</h4>
													
													<h4 class="hide" style=" float: right; background-color:green;
													      position: relative; right:10px; bottom:1px; z-index: 2;
													      width:70px; height:30px ;  border-radius:10px ;font-size:5px">
													<ul >
                                                        <li class="madeby123" style="position: relative; left:10px;top:13px;" onclick="popup('${dto.id}');">작성글 보기</li>                                     
                                                    </ul>
                                                    </h4>
                                                    
                                                    
                                                    
								
                                    <h4 style="font-size:20px; color:red">${dto.point} </h4>포인트 보유
									
								</div>
								
							
								</div>
								
								

							</c:forEach>
						</c:otherwise>
					</c:choose>

					<!-- 계정하나 끝 -->

				</div>
				</div>	
				</div>
	
	
	</section>
	<!-- End 랭킹 -->

<br><br><br>

	<!-- 맛집탐방 -->
	<section class="gallery-area " id="gallery">
		<div class="container">
			<div class="row justify-content-center">
				<div class="menu-content pb-70 col-lg-8">
					<div class="title text-center">
					<br><br>
						<h1 class="mb-10">리뷰 게시판</h1>
						<p>맛집 탐방</p>
					</div>
				</div>
			</div>


           <div class="latest0">
				<div class="row grid">

					<!-- 썬으로 뿌려줌 , 컨트롤러에서 전체를 담은 list를 dto로 -->
					<c:choose>
						<c:when test="${empty reviews}">
							<tr>
								<td colspan="4"></td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach items="${reviews}" var="dto">

								
									<div class="thumb">
										<img
											src="${pageContext.request.contextPath}/${dto.gdsThumbImg }"
											style="width: 230px; height: 160px" 
											onclick="location.href='reviewboard_detail?reviewboardno=${dto.reviewboardno}'" />
									</div>
									
									<br><br><br><br><br><br><br><br><br><br><br><br>

			                </c:forEach>
			          </c:otherwise>
			     </c:choose>
         </div>
		</div>



<br><br><br><br><br><br><br><br><br><br><br><br>


		</div>
	</section>
	<!-- End 맛집탐방 -->



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