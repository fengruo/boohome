<%@ page contentType="text/html; charset=UTF-8"%>
<html>
  <head>
    <title>Easy UI</title>
	<jsp:include page="${contextPage.request.contextPath }/head.jsp"></jsp:include>
  </head>
  <body>
    <table id="tbbb-default" class="easyui-datagrid">
    </table>
    <div id="tbbb-toolbar" >
    		<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="gridAdd()">新增</a>
    		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="gridMod()">修改</a>
    		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="gridDel()">删除</a>
    </div>
    <div id="tbbb-form-div" class="easyui-dialog" style="width:400px;height:420px;padding:10px 20px;top: 20%;" closed="true" buttons="#tbbb-form-but">
    	<div class="ftitle"></div>
    	<form method="post" id="tbbb-form" >
    		<div class="fitem">
    			<label>姓名：</label>
    			<input name="account" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>密码：</label>
    			<input name="password" type="password" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>真实姓名：</label>
    			<input name="nameTrue" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>性别：</label>
    			<input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女
    		</div>
    		<div class="fitem">
    			<label>出生日期：</label>
    			<input id="dd" name="birthday" type="text" class="easyui-datebox" required="required">
    		</div>
    		<div class="fitem">
    			<label>身份证号：</label>
    			<input name="idCard" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>移动电话：</label>
    			<input name="tel" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>学院：</label>
    			<input name="college" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>年级：</label>
    			<input name="grade" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>专业：</label>
    			<input name="specialy" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>班级：</label>
    			<input name="classes" type="text" class="easyui-validatebox" required="true">
    		</div>
    		<div class="fitem">
    			<label>角色：</label>
    			<input name="role" type="text" class="easyui-validatebox" required="true">
    		</div>
    	</form>
	</div>
    <div id="tbbb-form-but" >
    	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="form_save()">提交</a>
    	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#tbbb-form-div').dialog('close')">取消</a>
    </div>
    <script type="text/javascript">
    	  $('#tbbb-default').datagrid({
	    		url:'userinfo_queryUserinfoAll',
	    		width:'85%',
	    		toolbar:'#tbbb-toolbar', 
	    		idField: 'id',
	    		rownumber:true, 
	    		fitColumns:true, 
	    		singleSelect:true,
	    		pagination:true, 
	    		pageNumber:1,
	    		pageSize:10, 
	    		pageList:[10,20,50,100],
			    columns:[[    
			        {field:'id',title:'编号',align:'center',hidden:true},    
			        {field:'account',title:'姓名',align:'center',width:'7.15%'},    
			        {field:'password',title:'密码',align:'center',width:'9%'},    
			        {field:'nameTrue',title:'真实姓名',align:'center',width:'7%'},   
			        {field:'sex',title:'性别',align:'center',width:'4%'},    
			        {field:'birthday',title:'出生日期',align:'center',width:'10%',
			        	formatter : function(value){
	                        var date = new Date(value);
	                        var y = date.getFullYear();
	                        var m = date.getMonth() + 1;
	                        var d = date.getDate();
	                        return y + '-' +m + '-' + d;
                    	}
                    },    
			        {field:'idCard',title:'身份证号',align:'center',width:'15%'},    
			        {field:'tel',title:'移动电话',align:'center',width:'11%'},    
			        {field:'college',title:'学院',align:'center',width:'10%'},    
			        {field:'grade',title:'年级',align:'center',width:'8%'},    
			        {field:'specialy',title:'专业',align:'center',width:'8%'},    
			        {field:'classes',title:'班级',align:'center',width:'8%'},    
			        {field:'role',title:'角色',align:'center',width:'5%'}    
			    ]]    
	    	
	    	
    	}); 
    	function gridAdd(){
    		$("#tbbb-form-div").dialog("open").dialog("setTitle","新增");
    		$("#tbbb-form").form("clear");
    		url="userinfo_userAdd.action";
    	}
    	function form_save(){
    		$("#tbbb-form").form('submit',{
    			url:url,
    			onSubmit:function(){
    				return $(this).form('validate');
    			},
    			success:function(result){
					var result=eval('('+result+')');
					if(result.success){
						$.messager.show({
							title:'提示',
							msg:result.message
						});
						$('#tbbb-default').datagrid('clearSelections'); 
						$('#tbbb-default').datagrid('reload');
						//$("#tbbb-form-div").dialog("close");
					}else{
						$.messager.show({
							title:'提示',
							msg:result.message
						});
					}    			
    			
    			}
    		
    		})
    	}
    	function gridMod(){
    		var row=$("#tbbb-default").datagrid("getSelected");
    		if(row){
    			$("#tbbb-form-div").dialog("open").dialog("setTitle","修改");
    			$("#tbbb-form").form("load",row);
    			url='userinfo_userAdd.action?id='+row.id;
    		}
    	}
    	function gridDel(){
    		var row=$("#tbbb-default").datagrid("getSelected");
    		if(row){
    			$.messager.confirm('确认','您确认要删除吗？',function(r){
    				if(r){
    					$.post('userinfo_userDel.action',{id:row.id},function(result){
    						if(result.success){
    							$.messager.show({
    								title:'提示',
									msg:result.message
    							});
    							row.id=null;
    							$('#tbbb-default').datagrid('reload');
    						}else{
    							$.messager.show({
    								title:'提示',
									msg:result.message
    							});
    						}
    					},'json');
    				}
    			
    			});
    		}//end if(row)
    	}
    </script>
  </body>
</html>
