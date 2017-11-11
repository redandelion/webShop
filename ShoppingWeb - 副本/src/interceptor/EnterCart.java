package interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import action.ProductAction;

public class EnterCart extends MethodFilterInterceptor
{

	
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		ProductAction action =(ProductAction)invocation.getAction();
		ActionContext ctx = invocation.getInvocationContext();
		Map session =ctx.getSession();
		//取出session里的user属性
		String username = (String)session.get("username");
		if(username!=null)
		{
		
		return invocation.invoke();
		}
		ServletActionContext.getRequest().setAttribute("Tip", "请登录账号再执行這个操作！");
		return "plogin";
	}

}
