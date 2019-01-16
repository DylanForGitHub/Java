<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>test</title>
  </head>
  <body>
	<h1>Hello FMWorld, ${name}</h1>
	<@s.form action="reg" >
		<@s.textfield label="name" name="name" />
		<@s.submit />
	</@s.form>    
  </body>
</html>