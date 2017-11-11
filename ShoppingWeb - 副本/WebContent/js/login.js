function checklogin() {
	console.log("login");
	$.post("/ShoppingWeb/user/User_checkLogin",
					$("#loginform").serializeArray(),
					function(data, statusText) {
						console.log("login2");
						var datajson=JSON.stringify(data);//将json对象转换为json字符串
						var obj=$.parseJSON(datajson);//将json字符串转换为对象
						console.log("data"+JSON.stringify(data));
						var result=obj.result;//取出对象中的result属性
						var user=obj.user;
						var name=user.uname;
						var rank=user.rank;//取出对象中的name属性
						console.log("rank"+user.rank);
						console.log("user"+user);
						console.log("name"+user.uname);
						console.log("result"+obj.result);
						if(result=="false")
							{		
							console.log("result");
								html="";
								html+="<font color='red'>"+"*登录信息错误，请检查信息"+"</font>"
								$("#show").html(html);
							}else{
								if(rank>=1)
									{
										location="http://localhost:8888/ShoppingWeb/UserManagement/userManager.jsp";
									}else{
								confirm("登录成功！", "", function (isConfirm) {
						            if (isConfirm) {	
						            	console.log("result");
						            	$(".cguname").text(name);
						           
						            	$("#tipspan").empty();
						            	$('#login').modal('hide');
						            	$("#loginli").hide();
						            	if($("#info").length<=0)
						            		{						            			
						            			var html="<li><a href='/ShoppingWeb/user/User_put.action'>退出登录</a></li>";
							            		html+="<li><a href='/ShoppingWeb/user/User_userInfo.action'>修改个人信息</a></li>";
								            	console.log(html);
								            	$("#userli").after(html);
								            	
						            		}
						            	
						            }					            
						            })
								}//if rank>=1
							}
							}, "json");
}
