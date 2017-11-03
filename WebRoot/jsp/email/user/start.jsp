<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BooHome Future</title>
	<jsp:include page="${contextPage.request.contextPath }/head.jsp"></jsp:include>
  </head>
  <body>
  <audio autoplay="" loop=""><source src="${pageContext.request.contextPath }/music/1.mp3"></audio>
  	   <div id="background" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;">
<img src="${pageContext.request.contextPath }/images/back.png" width="100%" height="100%"/></div>
  	<div class="container text-center">
  		<div><h3>To Your Future</h3></div>
  	<div class="text-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这是一封给未来的信,你可以选择任何时间,它会准时送达的,不过你要提前写好这些信息哦！</div>
		<div>&nbsp;</div>
		<div class="container">  	
			<form method="post" id="tbbb-form" >
		    		<div class="fitem">
		    			<label>邮箱地址：</label>
		    			<input name="mailto.zemail" maxlength="50" class="easyui-validatebox" required="true"  validType="email">
		    		</div>
		    		<div class="fitem">
		    			<label>邮件标题：</label>
		    			<input name="mailto.zemailtitle" maxlength="30" class="easyui-validatebox" required="true">
		    		</div>
		    		<div class="fitem">
		    			<label>邮件内容</label>
		    			<textarea name="mailto.zemailtext" maxlength="3000" style="height:200px;width: 100%;resize:none;"></textarea>
		    		</div>
		    		<div class="fitem">
		    			<label>到达时间：</label>
		    			<input name="mailto.zdate" class="Wdate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" onfocus="WdatePicker({minDate:'%y-%M-%d 00:00:00',startDate:'%y-%M-01 00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" id="planRunDt" maxlength="25"   required="true">
		    		</div>
		    		<div>&nbsp;</div>
		    		<div>
						<input type="submit" class="btn btn-info" id="noclick"  value="确认提交">
					</div>
		    </form>
	    </div>
  	</div>
  	<div id="showalert" class="alert alert-success text-center" style="
  		font-size: 20px;
  		font-family:'楷体';
  		position:absolute;
	    left:0px;
	    top:0px;
	    width:100%;
	    height:100%;
	    z-index:9999;"> 
	    <div>&nbsp;</div>
		<div>在星光里遗忘昨天的伤害</div>
		<div>一觉醒来还有期待</div>
		<div>我不放弃爱的勇气</div>
		<div>我不怀疑会有真心</div>
		<div>我要握住一个最美的梦</div>
		<div>给未来的自己</div>
		<div>一天一天一天推翻一天</div>
		<div>坚持的信仰</div>
		<div>我会记住自己现在的模样</div>
		<div>&nbsp;</div>
		<a class="btn btn-primary" onclick="noshow()">点我继续</a>
	</div>
    <!-- 邮件地址     时间    标题   内容      -->
    <script type="text/javascript">
    	//alert("当前页面，你只能来一次哦！");
    	$('#tbbb-form').form({
			url:'mail_addEmailto',
			onSubmit:function(){
				$("#noclick").attr("disabled","true");
				return $(this).form('validate');
			},
			success:function(data){
				$("#noclick").attr("disabled","true");
    			window.location.href="/BoHome/jsp/email/user/success.jsp";
    		}
		});
		function noshow(){
			$("#showalert").hide();
		}
    </script>
  </body>
</html>
