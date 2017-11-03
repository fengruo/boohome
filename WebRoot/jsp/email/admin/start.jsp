<%@ page contentType="text/html; charset=UTF-8"%>
<html>
  <head>
    <title>Easy UI</title>
	<jsp:include page="${contextPage.request.contextPath }/head.jsp"></jsp:include>
  </head>
  <body>
    <!-- 邮件地址     时间    标题   内容      -->
    <table id="tbbb-default" class="easyui-datagrid">
    </table>
    <script type="text/javascript">
    /* 	$.ajax({
    		url:"mail_testFun",
    		type:"post",
    		dataType:"json",
    		success:function(data){
    			alert(JSON.stringify(data));
    		}
    	
    	}); */
      $('#tbbb-default').datagrid({
	    		url:'mail_testFun',
	    		width:'80%',
	    		toolbar:'#tbbb-toolbar', 
	    		idField: 'zid',
	    		rownumber:true, 
	    		fitColumns:true, 
	    		singleSelect:true,
	    		pagination:true, 
	    		pageNumber:1,
	    		pageSize:10, 
	    		pageList:[10,20,50,100],
			    columns:[[    
			        {field:'zid',title:'编号',align:'center',hidden:true},    
			        {field:'zemail',title:'邮箱地址',align:'center',width:'25%'},    
			        {field:'zdate',title:'预约发送日期',align:'center',width:'15%',
			        formatter : function(value){
	                        var date = new Date(value);
	                        var y = date.getFullYear();
	                        var m = date.getMonth() + 1;
	                        var d = date.getDate();
	                       	var h = date.getHours(); //获取当前小时数(0-23)
							var	M =	date.getMinutes(); //获取当前分钟数(0-59)
							var s =	date.getSeconds(); //获取当前秒数(0-59)
	                        return y + '-' +m + '-' + d +' '+ h+':'+M+':'+s;
                    	}},    
			        {field:'zsenddate',title:'发布信息日期',align:'center',width:'15%',
			        	formatter : function(value){
	                        var date = new Date(value);
	                        var y = date.getFullYear();
	                        var m = date.getMonth() + 1;
	                        var d = date.getDate();
	                       	var h = date.getHours(); //获取当前小时数(0-23)
							var	M =	date.getMinutes(); //获取当前分钟数(0-59)
							var s =	date.getSeconds(); //获取当前秒数(0-59)
	                        return y + '-' +m + '-' + d +' '+ h+':'+M+':'+s;
                    	}},   
			        {field:'zstate',title:'当前状态',align:'center',width:'15%'},    
			        {field:'zemailtitle',title:'邮件标题',align:'center',width:'31.7%'}    
			    ]]    
	    	
	    	
    	}); 
    
    </script>
  </body>
</html>
