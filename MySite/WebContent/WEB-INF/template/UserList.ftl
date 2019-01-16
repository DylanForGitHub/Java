<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>User List</title>
  </head>
  <body>
	<table>
		<tr>
	 		<th>ID</th>
			<th>name</th>
			<th>age</th>
			<th>action|<a href="addPage.action">Add</a></th>
		</tr>
	
		<#list userList as p>   
			<tr>
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>${p.age }</td>
				<td>
				<a href="queryById.action?id=${p.id}">Modify</a> | <a href="delete.action?id=${p.id}">Delete</a>
				</td>
			</tr>
		</#list>
	</table> 
  </body>
</html>