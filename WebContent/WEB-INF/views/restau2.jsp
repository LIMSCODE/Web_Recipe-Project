<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>

select {

 padding: .8em .5em; /* 여백으로 높이 설정 */ 
 font-family: inherit; /* 폰트 상속 */ 
 background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%; /* 네이티브 화살표 대체 */ 
 border: 1px solid #999; border-radius: 1px; /* iOS 둥근모서리 제거 */ 
 -webkit-appearance: none; /* 네이티브 외형 감추기 */ 
 -moz-appearance: none; appearance: none;


    
    float:left;
    margin: 0 auto;
    width:22%;
    height: 45px;
}

</style>



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
					<h1 class="text-white">Restaurant Place</h1>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	
	
	
	
	<section>
	

	
	<!-- 2.나라별 -->
	<br>
	<br>
	<p style="font-size: 20px;  color: red">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;
	 * 검색 조건</p>
	<br>
	<div style="width: 90% ; margin: 0 auto">
		<select name="sel1" id="sel1" >
		    <option value='' >동선택</option>
            <option value='개포동' >개포동</option>
			<option value='논현동'>논현동</option>
			<option value='대치동'>대치동</option>
			<option value='도곡동'>도곡동</option>
			<option value='삼성동'>삼성동</option>
			<option value='수서동'>수서동</option>
			<option value='세곡동'>세곡동</option>
			<option value='신사동'>신사동</option>
			<option value='압구정동'>압구정동</option>
			<option value='역삼동'>역삼동</option>
			<option value='일원동'>일원동</option>
			<option value='청담동'>청담동</option>
		</select>
		
		<select name="sel2" id="sel2" form="myForm" >
              <option value='' >세부 동 선택</option>
		</select>
		
		
		<select name="restaukind" form="myForm">
            <option value=''> 음식점 분류 </option>
			<option value='한식' >한식</option>
			<option value='일식'>일식</option>
			<option value='중국식'>중국식</option>
			<option value='경양식'>경양식</option>
			<option value='패스트푸드'>패스트푸드</option>
			
			<option value='외국음식전문점'>외국음식전문점</option>
			<option value='뷔페'>뷔페</option>
		</select>

	<form action="restausearch" method="get" id="myForm">
                                
   
						<div style="float: right; position: relative; right:100px">
							<input type="submit" value="해당조건으로 찾기"
								style="display: inline-block;"
								class="primary-btn text-uppercase">
						</div>                 
    </form>
    </div>
	
	<br>
	<br>
	<br>
	<hr>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<script>
	
	$( document ).ready(function(){
		   

	    
	    //sel1이 개포동일 경우
	    var sel2_1 = [
	    	
	    	"개포1동",
	       "개포2동",
	      "개포4동"
	    ];
	    
	    //sel1이 논현동일경우
	    var sel2_2 = [
	    	
	    	"논현1동",
	        "논현2동"
	    ];
	    
	    //sel1이 대치동일경우
	    var sel2_3 = [
	    	
	    	
	    	 "대치1동",
	       "대치2동",
	       "대치4동"
	       ];
	    
	    //sel1이 도곡동일경우
	    var sel2_4 = [
	    	
	    	 "도곡1동",
	        "도곡2동"
	    ];
	    
	    //sel1이 삼성동일경우
	    var sel2_5 = [
	    	
	
	    	"삼성1동",
	         "삼성2동"
	     ];
	    
	    //sel1이 수서동일경우
	    var sel2_6 = [
	    	
	    	 "수서동"
	    		 ];
	    
	    //sel1이 세곡동일경우
	    var sel2_7 =[
	    	 "세곡동"
	    		 ];
	    
	    //sel1이신사동일경우
	    var sel2_8 =[
	    	"신사동"
	    		 ];
	    
	    //sel1이 압구정동일경우
	    var sel2_9 = [
	    	 "압구정동"
	    		 ];
	    
	    //sel1이 역삼동일경우
	    var sel2_10 = [
	    	 "역삼1동",
	       "역삼2동"
	        	 ];
	    //sel1이 일원동일경우
	    var sel2_11 = [
	    	
	    	"일원1동",
	       "일원2동"
	        	 ];
	    //sel1이 역삼동일경우
	    var sel2_12 = [
	    
	    	"청담동"
	    		 ];
	    
	   
	   
	   $("select[id='sel1']").on("change", function(){
	    	var option = $("#sel1 option:selected").val();
	    	
	
	    	
	        var subSelName = '';
	        
	    	if(option == "개포동") {
	        	subSelName = sel2_1;
	        } else if(option == "논현동"){
	        	subSelName = sel2_2;
	        } else if(option == "대치동"){
	        	subSelName = sel2_3;
	        } else if(option == "도곡동"){
	        	subSelName = sel2_4;
	        } else if(option == "삼성동"){
	        	subSelName = sel2_5;
	        } else if(option == "수서동"){
	        	subSelName = sel2_6;
	        } else if(option == "세곡동"){
	        	subSelName = sel2_7;
	        } else if(option == "신사동"){
	        	subSelName = sel2_8;
	        } else if(option == "압구정동"){
	        	subSelName = sel2_9;
	        } else if(option == "역삼동"){
	        	subSelName = sel2_10;
	        } else if(option == "일원동"){
	        	subSelName = sel2_11;
	        }else if(option == "청담동"){
	 	        subSelName = sel2_12;
	 	   
	        } 
	
	       
	        for(var count = 0; count < subSelName.length; count++){                
                var option1 = "<option>"+subSelName[count]+"</option>"
                $('#sel2').append(option1);
            } 
	        
	    });
	});
	

	
	</script>



	
	
	
	<br>
	<br>

	<div id="map" style="width: 90% ; margin: 0 auto; height: 500px;"></div>
	
	
	<br>
	<br>
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
	
		<table class="type09" style="width: 1300px ; margin: 0 auto">
			<thead>
				        <tr>
							<th>업소명</th>
							<th>업종</th>	
							<th>지번 주소</th>	
							<th>도로명 주소</th>	
							<th>전화번호</th>	
							
						</tr>
			</thead>
			
			
			<tbody id="info">
			</tbody>
			
			
		</table>
	
	
	

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5547f6be229990d33003b21ff84d57d4&libraries=services"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.49, 127.05), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };
    
// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

var addr = new Array();

//지오코더객체 생성
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다


<c:forEach items="${list_0}" var="popo" varStatus="status">


     geocoder.addressSearch('${popo.get("address")}', function(result, status, data){
         if (status === daum.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);              
            var marker= new kakao.maps.Marker({ map:map, position:coords }); 
        


      // 인포윈도우를 생성합니다
      var infowindow = new kakao.maps.InfoWindow({ 
      	map : map, position : coords, content : '<div>'+ '${popo.get("upso_nm")}'+
      	'<a href= "https://map.kakao.com/link/to/${popo.get("upso_nm")},'+result[0].y+',' +result[0].x+'"'+ ' style="color:blue; font-size:10px" target="_blank">'
      	 + '길찾기' + '</a>'+
      	
      	'<div>' });
            // 마커를 지도에 표시합니다. 
            marker.setMap(map);
            // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
            infowindow.open(map); 
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	            map.setCenter(coords);   
             //geocorder.adressSearch
             
         }
      });
 </c:forEach>    


 
 
     $(document).ready(function(){
  	  
  	   var results = ${list_1};

  	   $.each(results , function(i){
  		   var str = '<TR>';
             str += '<TD>' + results[i].upso_nm + '</TD><TD>' + results[i].uptae + 
             '</TD><TD>' + results[i].address + '</TD><TD>' + results[i].site_addr_rd + 
             '</TD><TD>' + results[i].telno+ 
             '</TD>' ;
             str += '</TR>';
             
             
             $("#info").append(str); 
        });
     });  
        
 

    




 

</script>
	</section>
	
	
	<!-- 페이징 -->
	<!-- 실제로 돌아가는 페이징 -->

	<div class="blog-pagination justify-content-center d-flex">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item"><a class="page-link"
					aria-label="Previous"
					href="restausearch1${pageMaker.makeQuery(pageMaker.startPage - 1)}&sel2=${admdng}&restaukind=${restaukind}">이전

				</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li class="page-item"><a class="page-link"
					href="restausearch1${pageMaker.makeQuery(idx)}&sel2=${admdng}&restaukind=${restaukind}">${idx}</a></li>
			</c:forEach>



			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li class="page-item"><a class="page-link" aria-label="Next"
					href="restausearch1${pageMaker.makeQuery(pageMaker.endPage + 1)}&sel2=${admdng}&restaukind=${restaukind}">다음

				</a></li>
			</c:if>
		</ul>
		
	</div>




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
		src="${pageContext.request.contextPath}/resources/js2/vendor/bootstrap.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
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

	
</body>
</html>