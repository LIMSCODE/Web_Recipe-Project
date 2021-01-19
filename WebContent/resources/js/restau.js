$(function(){
	getJson();  //아래의 함수를 실행한다.
});
// json 내용을 읽어 오는 함수
function getJson(){

	$.getJSON("./resources/json/서울시 강남구 일반음식점 식품위생업소 현황.json",function(data){  //파일 가져와서 펑션안에 넣어줌 .getJSON은 jquery가 제공하는 함수임.
		$.each(data, function(key,val){
			if(key=="DESCRIPTION"){
				$("table").attr("border","1");
				$("thead").append(
						"<tr>"+
							"<th>"+val.UPSO_NM+"</th>"+
							"<th>"+val.ADMDNG_NM+"</th>"+
							"<th>"+val.SITE_ADDR+"</th>"+
							"<th>"+val.SITE_ADDR_RD+"</th>"+
							"<th>"+val.UPSO_SITE_TELNO+"</th>"+
							"<th>"+val.SNT_UPTAE_NM+"</th>"+
							"<th>"+val.DCB_YMD+"</th>"+
							
						"</tr>"
				);
			}else {
				//list : 배열
				//str : 배열 안에 있는 하나의 json
				var list = val;
				for(var i=0; i<list.length; i++){
					var str = list[i];
					$("tbody").append(
							"<tr>"+
								"<td>"+str.upso_nm+"</td>"+
								"<td>"+str.admdng_nm+"</td>"+
								"<td>"+str.site_addr+"</td>"+
								"<td>"+str.site_addr_rd+"</td>"+
								"<td>"+str.upso_site_telno+"</td>"+
								"<td>"+str.snt_uptae_nm+"</td>"+
								"<td>"+str.dcb_ymd+"</td>"+
								"<input type='hidden' name='restau' value='"+
								str.upso_nm+"/"+str.admdng_nm+"/"+
								str.site_addr+"/"+str.site_addr_rd+"/"+
								str.upso_site_telno+"/"+str.snt_uptae_nm+"/"+str.dcb_ymd+"'>"+
							"</tr>"
								
								//밸류값을 hidden 인풋태그로  숨겨서 전송함. name='bike'
					);
				}
			}
		});
	});
}














