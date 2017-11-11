//查询更多
function checkmore(){
	
	var status=$("#sta").html();
	console.log(status);
	var flag= $("#flag").html();
	var data1={"flag":flag,"status":status};
	console.log("s");
	$.post("/ShoppingWeb/product/Product_checkmore", data1, function(data, statusText) {
		console.log("循环");
		
		var dataString=JSON.stringify(data);		
		var obj= $.parseJSON(dataString);
		var cart=obj.cart;
		var html="";
		var result=obj.result;
		if(result=="true"){
		if(status=="1")
 		{
			for (var i=0;i<cart.length;i++)
			{
				html+="<tr id='"+cart[i].oid+"tr' >";
				html+="<td>";				
				html+="<span style='display: inline-block;'>" +
				"<input type='checkbox' " +
				" class='select checkbox'"+" style='display: inline-block;width:20px;' " +
				" name='checkboxs' " +
				" id='"+cart[i].oid+"'"+
				" onclick='"+"ChangeSum("+cart[i].oid+")"+"'"
				+"></span>";
				html+="<span>"+cart[i].cname+"</span></td>"
				html+="	<td><span><img ";
				html+="	src='../img/"+cart[i].pic+"' width='80px' height='80px'></span> <span>"+cart[i].info+"</span> <br>&nbsp&nbsp&nbsp&nbsp <a style='color: red'> ";
				html+="<span class='glyphicon glyphicon-home'>商家:"+cart[i].merchant+"</span></a></td>";						
			
				html+="<td><span>"+cart[i].classify +"</span></td>";
				
				html+="<td><span>"+cart[i].cost+"</span></td>";
				
				
				html+="<td>" + "<a onclick='reduce("+cart[i].oid+","+cart[i].cost+")'> <span>-</span> </a>";
				html+="<span> <input id='"+cart[i].oid+"num' onblur='changenum("+cart[i].oid+","+cart[i].cost+")'";
				console.log("<span> <input id='"+cart[i].oid+"num' onblur='changenum("+cart[i].oid+","+cart[i].cost+")'");
				html+="	 type='text' value='"+cart[i].num+"' style='width: 20px;' /> </span>";
				html+="<a onclick='add("+cart[i].oid+","+cart[i].cost+")'><span>+</span></a></td>";	
				html+="<td>￥<span id='"+cart[i].oid+"sp"+"'>"+cart[i].sumPrice+"</span>"+"</td>";
				
				html+="<td>";			
				html+="<li id='"+cart[i].oid+"dl' onclick='deleteitem('"+cart[i].oid+"') class='btn btn-danger btn-sm'><span class='glyphicon glyphicon-trash'>" +
						"</span> 删除</li></td>"
				html+="	</tr>";	
//				$(document).ready(function(){
//					  $('.select').iCheck({
//						    checkboxClass: 'icheckbox_square-orange',
//			 			    radioClass: 'iradio_square-orange', 
//			 			    increaseArea: '20%' // optional
//							 
//
//						  }); 
//						 
//						});
			}
		}else{
			for (var i=0;i<cart.length;i++)
			{
				html+="<tr id='"+cart[i].oid+"tr' >";
				
				html+="<td>";
				
				html+="<span>" +
						"<input type='checkbox' " +
						"class='select checkbox' " +"style=' display: inline-block;'"+
						"name='checkboxs' " +
						"id='"+cart[i].oid+"'"+
						"onclick='"+"ChangeSum('"+cart[i].oid+"')"+"'"
						+">"
						" &nbsp&nbsp</span>";
				
				html+="<span>"+cart[i].cname+"</span></td>"
				
				html+="	<td><span><img ";
				html+="	src='../img/"+cart[i].pic+"' width='80px' height='80px'></span> <span>"+cart[i].info+"</span> <br>&nbsp&nbsp&nbsp&nbsp <a style='color: red'> ";
				html+="<span class='glyphicon glyphicon-home'>商家:"+cart[i].merchant+"</span></a></td>";						
			
				html+="<td><span>"+cart[i].classify +"</span></td>";
				
				html+="<td><span>"+cart[i].cost+"</span></td>";
								
				html+="<span> <input id='"+cart[i].oid+"num'"
				html+="	 type='text' value='"+cart[i].num+"' style='width: 20px;' /> </span>";
				
				html+="<td>￥<span id='"+cart[i].oid+"sp"+"'>"+cart[i].sumPrice+"</span>"+"</td>";
				
				html+="<td>";							
				html+="	</tr>";	
			}
		}
			console.log(html);
			$("#tbody").append(html);
			var f=parseInt(flag)+1;
			$("#flag").html(f)
			console.log("flag"+f)
		}else{
			alert("客官，没有更多的数据了！")
		}
	},"json");

}
//////////////////////////////////////////////////////////////////////////////////////////////////
//
//每次刷新内容设置wrap的位置
$(function() {
	var sta = $("#sta").html();
	if (sta == "0") {
		$("#floater").velocity({
			left : "168px"
		}, 200);
		$("#font1").attr("style", "color:#FF4400");
		$("#font0").attr("style", "color:#3C3C3C");
	}
});
// 改变wrap的位置
function changewarp(id) {
	if (id == '1') {
		$("#floater").velocity({
			left : "168px"
		}, 200);
		$("#font1").attr("style", "color:#FF4400");
		$("#font0").attr("style", "color:#3C3C3C");
	} else {
		$("#floater").velocity({
			left : "-1px"
		}, 200);
		$("#font0").attr("style", "color:#FF4400");
		$("#font1").attr("style", "color:#3C3C3C");
	}
}
// 减少商品
function reduce(id, price) {
	console.log("sss");
	var numid = id + 'num';
	var num = parseFloat(document.getElementById(numid).value);
	num--;
	var pid = id + 'sp'
	var sumprice = parseFloat(document.getElementById(pid).innerHTML);
	sumprice -= parseFloat(price);
	document.getElementById(numid).value = num;
	document.getElementById(pid).innerHTML = sumprice;
		console.log("进入ajax");
		var cartitem = {
			"cartitem.Oid" : id,
			"cartitem.Num" : num,
			"cartitem.SumPrice" : sumprice
		}
		console.log("cartitem"+cartitem);
		$.post("ajax_changenum", cartitem, function(data, statusText) {
		}, "json");
}
//输出框改变num数量
function changenum(id,price){
	var num=parseInt($("#"+id+"num").val());
//	console.log(id);
//	console.log(num);
//	console.log(price);
	var pid = id + 'sp';
	var sumprice = parseFloat(document.getElementById(pid).innerHTML);
	sumprice= parseFloat(price)*num;
	$("#"+pid).text(sumprice);
	var cartitem = {
			"cartitem.Oid" : id,
			"cartitem.Num" : num,
			"cartitem.SumPrice" : sumprice
		}
	$.post("ajax_changenum", cartitem, function(data, statusText) {
		
	}, "json");
}

// 增加商品数量
function add(id, price) {
	var numid = id + 'num';
	var num = parseFloat(document.getElementById(numid).value);
	num++;
	var pid = id + 'sp'
	var sumprice = parseFloat(document.getElementById(pid).innerHTML);
	sumprice += parseFloat(price);
	document.getElementById(numid).value = num;
	document.getElementById(pid).innerHTML = sumprice;
	console.log("进入ajax添加");
	var cartitem = {
		"cartitem.Oid" : id,
		"cartitem.Num" : num,
		"cartitem.SumPrice" : sumprice
	}
	$.post("ajax_changenum", cartitem, function(data, statusText) {
	}, "json");
}
// 删除一个商品
function deleteitem(id) {
	var cartid = {
		"cartid.Oid" : id
	}
	$.post("ajax_delete", cartid, function(data, statusText) {
		var obj = $.parseJSON(data);
		var result = obj.result;
		console.log(result);
		if (result == "true") {
			$("#" + id + "tr").remove();
		}
	}, "html");
}
// 全选
function selectall() {
	if ($("input.select").is(':checked')) {
		$("#controlcheck").attr("value", "全选");// $("#controlcheck").html("反选")
		$("input.select").iCheck('uncheck');
		$("#sumfont").html(0);
		$("#pfont").html(0);

	} else {
		$("#controlcheck").attr("value", "反选");
		$("input.select").iCheck('check');
		var sum = 0;
		var price;
		var count = 0;
		$("input.select[type='checkbox']:checked").each(function() {
			var arr = $(this)[0].id;
			price = parseInt($("#" + arr + "sp").html());
			console.log("price" + price);
			sum += price;
			count += 1;
		});
		console.log("sum" + sum);
		console.log("count" + count);
		$("#sumfont").html(sum);
		$("#pfont").html(count);
	}
}
// 删除选中的订单详细项
function deleteall() {
	var abid = [];
	$("input.select[type='checkbox']:checked").each(function() {
		var arr = $(this)[0].id;
		abid.push(arr);
	});
	if (abid.length == 0) {
		alert("没有选项哟");
	} else {
		confirm("确定删除?", "", function(isConfirm) {
			if (isConfirm) {
				console.log("确认");
				// 一部传输bid 数组
				console.log(abid);
				console.log("确认");
				console.log(abid[0]);
				$.post('ajax_deleteall', {
					"abid" : abid.join(',')
				}, function(data, statusText) {
					var obj = $.parseJSON(data);
					var result = obj.result;
					console.log(result);
					if (result == "true") {
						console.log("result");
						for (var i = 0; i < abid.length; i++) {
							var id = abid[i] + "tr";
							console.log(id);
							console.log("#" + id);
							$("#" + id).remove();
							$("#sumfont").html(0);
							$("#pfont").html(0);
							$("#controlcheck").attr("value", "全选");
						}
					} else {

						console.log("失败");
					}
				}, "html");

			}

		})
	}
}

// 结算选中的订单详细项
function payall() {

	var abid = [];
	$("input.select[type='checkbox']:checked").each(function() {
		var arr = $(this)[0].id;
		abid.push(arr);
	});
	
	
	if (abid.length == 0) {
		alert("没有选项哟");
	} else {
		confirm("确定购买选中的物品?", "", function(isConfirm) {
			if (isConfirm) {
				console.log("确认");
				// 一部传输bid 数组
				console.log(abid);
				console.log("确认pppp");
				var count=parseInt(abid.length);				
				var items=parseInt($("#allitems").text());
				items=items-count;
				console.log(abid[0]);
				console.log("items"+items)
				$("#allitems").text(items);
				var sale=parseInt($("#soldfont").text());
				sale=sale+count;
				console.log("sale"+sale)
				$("#soldfont").text(sale);
				$.post('ajax_payall', {
					"abid" : abid.join(',')
				}, function(data, statusText) {
					var obj = $.parseJSON(data);
					var result = obj.result;
					console.log(result);
					if (result == "true") {
						console.log("result");
						for (var i = 0; i < abid.length; i++) 
						{
							var id = abid[i] + "tr";
							console.log(id);
							console.log("#" + id);
							$("#" + id).remove();
							$("#sumfont").html(0);
							$("#pfont").html(0);
							$("#controlcheck").attr("value", "全选");
						}
					} else {

						console.log("失败");
					}
				}, "html");

			}

		})
	}
}
// 改变选择商品结算金额
function ChangeSum(id) {
	console.log(id);
	if (document.getElementById(id).checked == true) {
		
		var i = parseInt($("#pfont").html());
		i++;
		var sumprice = parseInt($("#sumfont").html());
		var price = parseInt($("#" + id + "sp").html());
		sumprice += price;
		$("#pfont").html(i);
		$("#sumfont").html(sumprice);

	} else {
		var i = parseInt($("#pfont").html());
		i--;
		var sumprice = parseInt($("#sumfont").html());
		sumprice -= parseInt($("#" + id + "sp").html());
		$("#pfont").html(i);
		$("#sumfont").html(sumprice);
	}
}


//$(function(){
//		$(document).ready(function(){
//		  $('.select').iCheck({							 		  
//			    checkboxClass: 'icheckbox_square-orange',
//			    radioClass: 'iradio_square-orange', 
//			    increaseArea: '20%', // optional						 			     
//	  }); 						 		
//	});
//}
//)