<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'commodityview.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta char-set="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<meta name="description" content="图书，正品行货，低至2折，700多城市货到付款。">
<meta name="keywords" content="网上购物，网上商城，网上买书，购物中心，在线购物，图书">

<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/nav-footer.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="./js/mzp-packed.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<title>网上购书中心</title>



<style>
body {
	clear: both;
	margin: 0;
	padding: 0;
}

#bo	div {
	display: block;
} /* 有的div设了hidden*/
#bo a {
	text-decoration: none;
	color: black;
	cursor: pointer;
}

#bo li a {
	padding: 0 0 0 8px;
	line-height: 22px;
	height: 22px;
	display: block;
}

#bo a:hover {
	color: red;
}

.head_operate {
	width: 1200px;
	margin: 0 auto;
	background-color: #f9f9f9;
	height: 34px;
}

.head_operate_ul {
	float: right;
	padding-top: 2px;
}

#bo ul {
	font-size: 100%;
	zoom: 1;
	margin: 0;
	padding: 0;
	list-style-type: none;
	border: 0;
}

#bo ul :after {
	content: ".";
	height: 0;
	display: block;
	clear: both;
	visibility: hidden;
}

#bo li {
	margin: 0;
	padding: 0;
	list-style-type: none;
	border: 0;
	float: left;
	height: 22px;
	padding-top: 4px;
	line-height: 21px;
	position: relative;
	z-index: 100;
}

.head_welcome {
	padding: 5px 0 0 10px;
	height: 24px;
	line-height: 24px;
	position: relative;
	float: right;
	z-index: 50;
}

.head_welcome a {
	display: inline-block;
	margin-right: 4px;
}

#bo a.login_link {
	color: #ff2832 !important;
}

#s {
	width: 48px;
	height: 40px;
	border: none;
	background: url(./img/s_but.png) no-repeat;
	cursor: pointer;
	position: absolute;
	left: 420px;
	top: 0;
	margin: 0;
	padding: 0;
	font-size: 100%;
	display: inline;
	align-items: flex-start;
}

#bo form {
	display: block;
	height: 50px;
	margin: 0 auto;
	padding: 0;
	list-style-type: none;
	border: 0;
	font: 12px 'Hiragino Sans GB', "simsun", "Arial";
	color: #646464;
}

#key_S {
	width: 398px;
	height: 18px;
	border: 2px solid #ff2832;
	padding: 9px 0 9px 10px;
	position: absolute;
	left: 0;
	top: 0;
	/*z-index: 2;*/
	color: #323232;
	font: 12px/18px 'Hiragino Sans GB', "simsun", Arial;
	outline: 0;
	margin: 0 auto;
	display: inline;
	text-align: start;
}

#sd {
	width: 500px;
	margin: 30px auto;
	position: relative;
	display: inline-block;
}

.navi {
	display: inline-block;
	width: 150px;
	font-size: 20px;
}

.side a {
	text-decoration: none;
	color: #000;
}

.n {
	list-style: none;
}

.box {
	width: 900px;
	height: 500px;
	margin: 0px auto;
	overflow: hidden;
	position: relative;
	text-align: center;
}
/*.box_img{width: 1px;height: 250px;overflow: hidden;padding: 0;}*/
.box_img ul li {
	position: absolute;
	display: none;
	padding: 0;
}

.box_img ul li a {
	display: block;
	width: 346px;
	height: 250px;
	font-size: 100px;
	text-align: center;
	line-height: 250px;
	color: #fff;
}

.box_tab {
	position: absolute;
	left: 267px;
	text-align: center;
	width: 346px;
	bottom: 0;
	z-index: 2000;
}

.box_tab a {
	display: inline-block;
	padding: 2px 10px;
	font-size: 10px;
	background: #fff;
	margin: 0 5px;
	color: #333;
}

.box_tab a.active {
	background: #09b;
	color: #fff;
}

.book {
	width: 150px;
	display: block;
	height: 150px;
}

#product {
	width: 680px;
	padding-top: 25px;
	margin: 0 auto;
	padding: 0;
	list-style-type: none;
	border: 0;
}

.bname {
	display: block;
	padding: 60px 20px 0;
	height: 18px;
	line-height: 18px;
	overflow: hidden;
	margin: 0;
	list-style-type: none;
	border: 0;
	font-size: 100%;
}

.line {
	width: 170px;
	margin-right: 47px;
	margin-bottom: 16px;
	height: 250px;
	position: relative;
	overflow: visible;
}

#footer {
	width: 100%;
	text-align: center;
	padding-bottom: 10px;
	position: absolute;
	bottom: 0;
}

#footer a {
	color: #8c8c8c;
	font-size: 12px;
}

#footer span {
	margin: 0 30px;
}

.buy_box a {
	width: 100px;
	height: 28px;
	line-height: 28px;
	background: #ff2832;
	border-radius: 3px;
	display: inline-block;
	zoom: 1;
	color: #fff;
	text-align: center;
	font-family: 'Microsoft Yahei';
	font-size: 14px;
	margin-right: 10px;
}

#in {
	display: inline;
	height: 100px;
	width: 500px;
	margin-left: 500px;
	margin-top: 10px;
	padding-left: 0px;
	margin: 10px -1% 0 -13%;
}

#bu {
	height: 45px;
	width: 100px;
	margin: 40px 60px;
	float: right;
	display: inline-block;
	position: absolute
}

#tbc {
	width: 50%;
	margin: 70px auto;
	padding: 0;
	border-collapse: collapse;
	border-spacing: 0;
	display: block;
	text-align: center;
}

#tbc .t {
	width: 30%;
	height: 50px;
	margin: 0 auto;
	padding: 16px 7px;
	/* border-bottom: 1px solid #e3e3e3; */
	display: table-cell;
	vertical-align: inherit;
}

.mess {
	width: 30%;
	height: 40px;
}

<!--
.time {--><!----><!--
	
}

-->
<!--
#tbc .tu {--><!----><!--
	
}
-->
 /*child strat*/
    #child{
    	width: 100%;
    	/*height: 560px;*/
    	height: 440px;
    	
    	position: relative;
    }
    #child a{
    	cursor: pointer;
    	
    }
     #child #childcontent{
     	width: 1200px;
     	height: auto;
		
		margin: 10px auto;
		text-align: center;
		position: relative;
     }
     #child #childcontent #childpic{
     	box-shadow: 5px 5px 3px #9a8181;     
     	
     }
    #child #childcontent #tips{
    	position: absolute;
    	top: 74px;
    	left: 14px;
    	z-index: 100;
    }
     #child #childcontent #left{
     	margin-top: 35px;
     	width: 350px;
     	height: 400px;
     	/*border: 1px solid #9A8181;*/
		/*position: absolute;
		float: left;*/
     } 
     #child #childcontent #left span{
     	text-align: left;
     	margin: 0 30px;
     }
	#child #childcontent #content{
		position: relative;
		
		width: 600px;
		height: 400px;
		top: -400px;
		left: 360px;
		/*border: 1px solid #0099BB;*/
		text-align: left;
		padding-left:10px;
		font-family: "微软雅黑";
		font-size: 18px;
		line-height: 20px;
	}
	#child #childcontent #content span{
		font-family: "微软雅黑";
		font-size: 16px;
		
	}
 	#child #childcontent #content span a{
 		color: blue;
 	}
 	#child #childcontent #content #prise{
 		margin: 10px 0;
 		position: absolute;
 		border: 1px solid #EBEBEB;
 		width:598px;
 		height: 60px;
 		background: #EBEBEB;
 		border-radius: 4px 4px;
 	}
 	#child #childcontent #content #prise .prisetext{
 		text-align:justify;
 		position: absolute;
 	    color: #FF0000;
 		bottom: 0px;
 		left: 10px;
 	}
 	#child #childcontent #content #prise .prisetext #saleprise{
 		color: #FF0000;
 		font-size: 28px;
 		font-family: "微软雅黑";
 	}
 	#child #childcontent #content #prise .prisetext #oldprise{
 		color: #969696;
 		
 	}
 	#child #childcontent #content #prise .prisetext #oldprise #oldpriseText{
 		text-decoration:line-through;
 		
 	}
 	#child #childcontent #content #prise span{
 	  padding: 5px 5px;	
 	  font-size: 13px;
 		
 	}
 	
 	#child #childcontent #content #service{
 		position: absolute;
 		width: 580px;
		height: 90px; 	
		/*border: 1px solid #0099BB;*/	
		top: 200px;
		left: 10px;
		padding: 0px 10px;
 	}
 	#child #childcontent #content #service .serviceText{
 		color: #969696;
 		margin: 10px;
 		letter-spacing: 2px;
 		
 	}
 	#child #childcontent #content #service #product .productText{
 		display:inline-block;
 		width: auto;
 		height: 28px;
 		border: 1px solid #ddd;
 		line-height: 28px;
 		text-align: center;
 		color: #0e4e63;
 	}
 	#child #childcontent #content #service #product .productText:hover{
 		border: 1px solid #8C8C8C;
 		cursor: pointer;
 		-webkit-transition: all 550ms ease-in-out;
		-moz-transition: all 550ms ease-in-out;
		-o-transition: all 550ms ease-in-out;
		transition: all 550ms ease-in-out; 		
 	}
 	#child #childcontent #content #btn{
 		width: 280px;
 		height: 38px;

 		margin: 20px;
 		top:123px;
 		left: 130px;
 		position: absolute;
 	}
 	#child #childcontent #content #btn button{
 		width:90px;
 		height: 38px;
 		background-color: rgba(237, 40, 53, 0.58);
 		border:0px;
 		line-height: 28px;
 		font-size: 14px;
 		border-radius: 4px 4px;
 		
 	}
 	#child #childcontent #content #btn button:hover{
 		background-color: #53ca97;
 		
 		-webkit-transition: all 550ms ease-in-out;
		-moz-transition: all 550ms ease-in-out;
		-o-transition: all 550ms ease-in-out;
		transition: all 550ms ease-in-out;
		cursor: pointer;
 	}
 	
 	#child #childcontent #content #btn #cart {
 		float: right;
 	}
 		#child #childcontent  #right{
 		top: 100px;
 		left: 987px;
 		position: absolute;
 		width: 160px;
 		height: 400px;	
 		}
 	#child #childcontent  #right .shop{
 		
 	line-height: 34px;
 	width: 76px;
 	height: 34px;
 	display: inline-block;
	border: 1px solid #ddd;
	border-radius: 3px 3px; 
	margin: 10px auto;		
 	}
     /*child end*/
/*start pro_comment  */
#pro_comment{
	position:relative;

}
#user_com{
	height:160px;
	text-align: center;
	width: 100%;
}
</style>

<script type="text/javascript">
	function addcart(cid, uid) {
		//var num=$("#numinput").val();
		$.post('/ShoppingWeb/product/Commodity_addToCart', {
			"addc" : cid,
			"addu" : uid
		}, function() {
			alert("成功加入购物车")
		});
	}
</script>

</head>

<body>
	<%@ include file="/inc/nav.jsp"%>
	<div id="bo">
		<div>
			<s:iterator value="#session.cdy">
		</div>
		<div id="child">
	
	<div id="childcontent" style="  margin-top: 116px;">
<!-- 		<div id="childpic"><img src="img/13.jpg"/></div> -->
			
		<!--文艺-->
		<%-- <span id="tips">图书>儿童读物>我是花木兰</span> --%>
		<div id="left"><img src="${pageContext.request.contextPath}/img/<s:property value="pic"/>" width="320px" height="320px"/>
			
		  <%-- <span><a>分享</a></span> 
		  <span><a>收藏商品</a></span>  --%>
		</div>
		<div id="content">
			<p><strong><s:property value="cname"/></strong></p>
			<span><s:property value="info"/><a>查看>></a></span>
			<div id="prise">
				<span> &nbsp; &nbsp;价格</span><br />
				<span class="prisetext">￥<span id="saleprise"></span> (7折) <span id="oldprise">定价：￥<i id="oldpriseText"><s:property value="cost"/></i></span> </span>	
				<script type="text/javascript">
					$(function(){
						var p=parseInt($("#oldpriseText").text());
						p=p*0.7;
						$("#saleprise").text(p);
						console.log(p)
						$
						})
				</script>
			</div>
			<div id="service">
				<div id="adress" class="serviceText">
					<span>配&nbsp;送&nbsp;至</span>&nbsp;&nbsp;
							<select>
							<option>北京</option>
							<option>珠海

							
							</option>
							<option>广州</option>
							<option>湖北</option>
							<option>天津</option>
							<option>茂名</option>
						</select>&nbsp;&nbsp;
						<span style="color: #000000;">有货&nbsp;免邮</span>
						<span style="color: #000000;">
							<!-- 加减商品个数 -->																													
							数量<input id="numinput"type="text" value="1"style="width: 20px;"/>
						</span>
				</div>
				<div id="sever" class="serviceText">
					<span>服 &nbsp;&nbsp;&nbsp;&nbsp;务</span>&nbsp;&nbsp;
					<span style="font-size:14px ;">由<s:property value="merchant"/>商家发货，并提供售后服务。22:15前完成下单<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;预计明天(5月15日)可送达</span>

					
				</div>
<!-- 				<div id="product" class="serviceText"> -->
<%-- 					<span>关联商品</span> --%>
<%-- 					&nbsp;&nbsp;<span class="productText">《我们的太阳》</span> --%>
<%-- 					<span class="productText">《狼国女王》</span> --%>
<%-- 					<span class="productText">《如果恐龙还活着》</span> --%>
<!-- 				 </div> -->
				
				 <div id="btn">
					<div id="cart"> 
						<button id="cartbtn" value="加入购物车" onclick="addcart('<s:property value="cid"/>','${uid}')">加入购物车</button>
						
					</div>
					<div id="buynow">
						<button id="buy" value="立即购买">立即购买</button>
					</div>					
				</div>
			</div>
			
		</div>			
<%-- 		<div id="right">	
		<div id="logo"><img src="img/11_1.jpg"/></div>
		<span class="shop"><a>进入店铺</a></span>
		<span class="shop"><a>收藏店铺</a></span>
        </div> --%>
	</div>
</div>
		
<%-- 		<div id="pro_content">
		<div class="box"
			style="width: 630px; display: inline-block; margin: 60px auto;">

			<div class="left-pro">

				<div class="t2">

					<img
						src="${pageContext.request.contextPath}/img/<s:property value="pic"/>" />

				</div>
			</div>
		</div>



		<div
			style="display: inline-block; position: absolute; float: right; width: 500px; margin: 90px auto;">
			<div>
				<h2>
					<s:property value="cname" />
				</h2>
				<p>
					<span><s:property value="info" /></span>
				</p>
			</div>
			<p style="color: red; font-size: 25px;">
				<span class="yen">¥</span>
				<s:property value="cost" />
			</p>
		</div>
		</div> --%>
<%-- 		<div class="buy_box"
			style="display: inline-block; position: absolute; float: right; width: 1000px; margin: 300px auto;">

			<div>
				<a onclick="addcart('<s:property value="cid"/>','uid')"
					style="display: inline-block; margin: 0 auto;">加入购物车</a> <a
					style="display: inline-block; margin: 0 auto;">立即购买</a> <a
					style="display: inline-block; margin: 0 auto;">购买电子书</a> <a
					style="display: inline-block; margin: 0 auto;">收藏商品</a>
			</div>
		</div> --%>


		<div id="pro_comment">
			<div
				style="width: 800px; height: 70px; border-bottom: 1px solid red; margin: 0 auto">
				<p style="float: left; font: 20px 'arial rounded mt bold';">商品评价：</p>
			</div>
			<s:form action="Comment_addComment" method="post"
				namespace="/product">
				<div style=" padding: 0px" id="user_com">
					<textarea id="in" name="message"></textarea>
					<input type="hidden" name="prt_val"
						value="<s:property value="cid"/>"> <input type="submit"
						id="bu">
				</div>
			</s:form>
			<div>
				</s:iterator>
			</div>
			<table id="tbc">
				<tbody>
					<s:iterator value="#session.cmt">
						<tr class="t">
							<td class="mess"><s:property value="message" /></td>
						</tr>
						<tr class="tu" style="border-bottom: 1px solid #b5a5a5; ">
							<td class="time" style="float: right;    margin-bottom: 5px;"><s:property value="com_time" />用户：${username}
							</td>
							
							<!--<td><s:property value="evaluate"/></td>-->
						</tr>
						
					</s:iterator>
				</tbody>
			</table>
		</div>


<%-- 		<div style="position: relative; clear: both;">
			<div style="height: 200px;"></div>
			<div style="width: 100%; height: 50px; border-top: 1px solid red;"></div>
			<div id="footer">
				<a href="#">关注我们</a><span>|</span> <a href="#">问题反馈</a><span>|</span>
				<a href="#">广告入驻</a>
			</div>
		</div> --%>
	</div>
</body>
</html>

