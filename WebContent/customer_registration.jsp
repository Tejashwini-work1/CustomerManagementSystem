<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<h1>Customer Registration Page</h1>

<form action="regCustomer"  method="post">

    NAME: <input type="text" name="tbName" id="tbName"  />
<br>
    Email: <input type="email" name="tbEmail" id="tbEmail" />
<br>
    Mobile: <input type="tel" name="tbMobile" id="tbMobile" />
<br/>
   Password: <input type="Password" name="tbPass" id="tbPass" />
<br/>
     State: <select name="ddlStates">
         <option value=" ">-----Select----</option>
         <option value="Karnataka">KA</option>
         <option value="Tamil Nadu">TN</option>
         <option value="Andra Pradesh">AP</option>
         <option value="Keral">KL</option>

</select>
<input type="submit" value="Register" />



</form>

</body>
</html>