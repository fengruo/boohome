<%@ page contentType="text/html; charset=UTF-8"%>
<html>
  <head>
 	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>Fail</title>
	<jsp:include page="${contextPage.request.contextPath }/head.jsp"></jsp:include>
  </head>
  <body>
   <div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;">
<img src="${pageContext.request.contextPath }/images/fail.png" width="100%" height="100%"/></div>
  </body>
</html>
