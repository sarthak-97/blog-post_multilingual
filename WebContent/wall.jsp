<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("t2");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "task";
String userId = "root";
String password = "sar115";
%>
<center><table width="100%" border="0" align="center">

<tr>


<td width="250" bgcolor="#33ddff"><height=50 width=90><SPAN STYLE="FONT-FAMILY:COMIC SANS MS ; COLOR:WHITE;VERTICAL-ALIGN:SUPER;FONT-SIZE:30"> <input type="text" size="35"  name="t3" id="t5" value="  WELCOME  <%= request.getAttribute("t2") %> TO THE EDITOR" readonly style=" FONT-FAMILY:COMIC SANS MS ; COLOR:WHITE;VERTICAL-ALIGN:bottom ;FONT-SIZE:30 ;border: none;

 background-color: #33ddff; border-color: #33ddff" > </SPAN>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="home.html" STYLE="FONT-FAMILY:COMIC SANS MS ; COLOR:WHITE;VERTICAL-ALIGN:super;FONT-SIZE:20 ; text-decoration:none ; align:right">Home</a>
<a href="dash.jsp?t3=<%= request.getAttribute("t2") %>"  STYLE="FONT-FAMILY:COMIC SANS MS ; COLOR:WHITE;VERTICAL-ALIGN:super;FONT-SIZE:20 ; text-decoration:none ; align:right">Add post </a>
<a href="addrec1.html" STYLE="FONT-FAMILY:COMIC SANS MS ; COLOR:WHITE;VERTICAL-ALIGN:super;FONT-SIZE:20 ; text-decoration:none ; align:right">Register</a>
<a href="contact.asp" STYLE="FONT-FAMILY:COMIC SANS MS ; COLOR:WHITE;VERTICAL-ALIGN:super;FONT-SIZE:20 ; text-decoration:none ; align:right">Contact</a>

 <a  STYLE="FONT-FAMILY:COMIC SANS MS ; COLOR:WHITE;VERTICAL-ALIGN:super;FONT-SIZE:20 ; align:right;text-decoration:none " href=h.html >Logout</a>

 </td>
</tr>
</table>
<br><div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE, autoDisplay: false}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script><br>



<%

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in wall</strong></font></h2>

<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();%>
<% 
 System.out.println(request.getAttribute("t2")); 


String sql ="SELECT * FROM post where mob='"+ request.getAttribute("t2")  +"'";

resultSet = statement.executeQuery(sql); 
while(resultSet.next()){

%>
<p>
<%=resultSet.getString("posts") %>

</p>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
