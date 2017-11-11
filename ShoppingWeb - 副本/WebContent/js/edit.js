//实现表单字符串srialize()转化为json
$.ajaxSetup({  
    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
});  
var DataDeal = {  
// 将从form中通过$('#form').serialize()获取的值转成json
           formToJson: function (data) {  
               data=data.replace(/&/g,"\",\"");  
               data=data.replace(/=/g,"\":\"");  
               data="{\""+data+"\"}";  
               return data;  
            },  
};  

// 改变li的颜色
$(function change()
{
	console.log("ss"+$(".menu li"));
	$(".menu li").each(function(e){
		$(this).click(function(){						
			$(".menu a").removeClass();			
			$(this).find("a").addClass("active");				
		});			
	})
});
function hidemodal(){	
	$('#myModal').modal('hide');
	
}

function changeInfo(){
	var data1=$("#forminfo").serialize()
	data= decodeURIComponent(data1,true);// 防止中文乱码
	var userjson=DataDeal.formToJson(data);// 转化为json
	var user=JSON.parse(userjson);	
//	console.log("uname"+$("#uname").val());
//	console.log("size"+$("#uname").val().length);
	
	if($("#uname").val().length<=0)
		{
			alert("请输入昵称！");
			return false;
		}
	else if($("#pass").val().length<=0)
		{
			alert("请输入密码！");
			return false;
		}
	else if($("#tele").val().length<=0)
	{
		alert("请输入电话！");
		return false;
	}
	else if($("#address").val().length<=0)
	{
		alert("请输入地址！");
		return false;
	}else{
	$.post("/ShoppingWeb/user/User_changeuinfo",user,function(data,statusText){
				var data1=JSON.stringify(data);
				var obj=$.parseJSON(data1);
				var result=obj.result;
				var user=obj.user;
				console.log(user);
				if(result=="no")
				{
					alert("您没有修改任何数据！");
				}else{
					
					if(result=="true")
					{
					alert("修改成功！");
					//
					if(user.uname!=null)
					{
						 $(".cguname").each(function() {
						      var n= $(this);					   
						      n.text(user.uname);
						    });
					}
					
					//
					if(user.PassWord!=null)
					{
					$("#passdiv").html(user.PassWord);
					console.log(user.PassWord);
					}
						
					//
					if(user.tele!=null)
					{
					$("#telediv").html(user.tele);	
					console.log("t");
					}
						
					//
					if(user.address!=null)
					{
					$("#addressdiv").html(user.address);	
					console.log("a");
					}
						
					// $("#myModal").modal('hide');
					}else{
						alert("修改失败！");
					}
				}
				
	},"json");
		}
}