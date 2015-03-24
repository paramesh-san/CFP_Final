<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.p1.*" %>
    <%@ page import="java.io.BufferedReader" %>
    <%@ page import="java.io.File"%>
    <%@ page import="java.io.FileReader" %>
    <%@ page import="java.sql.Timestamp" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.LinkedHashSet" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.concurrent.DelayQueue" %>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="javax.xml.bind.JAXBContext" %>
    <%@ page import="javax.xml.bind.JAXBException" %>
    <%@ page import="javax.xml.bind.Marshaller" %>
    <% 
    ThrottledQueue r=new ThrottledQueue(4,1000);
    r.main1();
    Object[] r1=ThrottledQueue.s1.toArray();
    Object[] r2=ThrottledQueue.s2.toArray();
   %>
   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<div id="s" >
<%
int i=0;

for(i=0;i<ThrottledQueue.size1;i++)
{
out.println(ThrottledQueue.s1.get(i));
out.println(",");
}
%></div>
<div id="s1">
<%
int j=0;

for(j=0;j<ThrottledQueue.size2;j++)
{
out.println(ThrottledQueue.s2.get(j));
out.println(",");
}
%></div>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<a href="NewFile.jsp" method="post">CurrencyGraph</a>
<script>
var str=document.getElementById("s").innerHTML;
var c=str.split(",");
var str1=document.getElementById("s1").innerHTML;
var c1=str1.split(",");
document.write(c1);
var s=0;
var cost = [
    0,7.5,2,2
];
for(i=0;i<c1.length-1;i++)
{
cost[i]=parseFloat(c1[i]);
document.write(c1[i]);
}
document.write("Below is the Graph for AmountBuy Versus the Time Placed");
/*Time your Jquery as you demand*/
setTimeout(
		function () {
		    $('#container').highcharts({
		        title: {
		            text: 'AmountBuy( in 1000 mulitples) -Vs- timePlaced',
		            x: -20 //center
		        },
		        subtitle: {
		            text: 'CurrencyFair',
		            x: -20
		        },
		        xAxis: {
		            categories: c
		        },
		        yAxis: {
		            title: {
		                text: 'Amount'
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle',
		            borderWidth: 0
		        },
		        series: [{
		            name: 'Ireland',
		            data: cost
		        }]
		    });
		}, 2000);/*Time your Jquery as you demand*/
</script>
<body>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
</html>
