<%@ page import="java.util.Map" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>服务器线程信息</title>
</head>
<body>
	<pre>
		<%
			for(Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
				Thread thread = (Thread)stackTrace.getKey();
				StackTraceElement[] stack = (StackTraceElement[])stackTrace.getValue();
				
				if(thread.equals(Thread.currentThread())){
					continue;	
				}	
				out.print("\n线程：" + thread.getName() + "\n");
				for(StackTraceElement e : stack){
					out.print("\t" + e + "\n");
				}
			}
		 %>
	</pre>
</body>
</html>