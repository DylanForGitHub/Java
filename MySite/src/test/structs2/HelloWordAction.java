package test.structs2;

//import com.opensymphony.xwork2.ActionSupport;

public class HelloWordAction {
	private String name;
	
	public String execute() throws Exception {
		if("sss".equals(name))
		{
			return "success";
		}
		else
		{
			return "failed";
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
