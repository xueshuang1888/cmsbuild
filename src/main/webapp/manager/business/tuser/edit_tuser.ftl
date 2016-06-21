<@ms.html5>
	<@ms.nav title="人员管理" back=true>
		<@ms.saveButton  id="saveUpdate" /> 
	</@ms.nav>
	<@ms.panel>
		<@ms.form isvalidation=true name="tuserForm" action="${base}/manager/tuser/save.do" >
			<input type="hidden" name="id" value="${tuser.id?default(0)}">
			<@ms.text name="name" width="400" label="姓名"	title="姓名"   placeholder="请输入姓名"  value="${tuser.name?default('')}"  validation={"maxlength":"30","required":"true", "data-bv-notempty-message":"姓名不能为空","data-bv-stringlength-message":"标题在30个字符以内!"}/>
			<@ms.text name="sex"  width="400" label="性别"	title="性别"   placeholder="请输入性别"  value="${tuser.sex?default('')}"/>
			<@ms.text name="mobile" id="mobile" width="400" label="手机号码" placeholder="请输入手机号码" title="" value="${tuser.mobile!}"  validation={"required":"true","maxlength":"18","data-bv-stringlength":"true","data-bv-stringlength-max":"18","data-bv-notempty-message":"手机号码不能为空","data-bv-stringlength-message":"手机号码长度不能超过18个字符","data-bv-regexp":"true", "data-bv-regexp-regexp":'^[1][1-8][0-9]{9}',"data-bv-regexp-message":"手机号码格式错误"}/>
			<@ms.text name="point" width="400" label="积分" placeholder="请输入积分" title="" value="${tuser.point!}"  validation={"maxlength":"8","data-bv-stringlength":"true","data-bv-stringlength-max":"8","data-bv-stringlength-message":"积分长度不能超过8个字符"}/>
		</@ms.form>
	</@ms.panel>
</@ms.html5>	      
<script>
$(document).ready(function(){
	$("#saveUpdate").on("click",function(){
		var vobj = $("#tuserForm").data('bootstrapValidator').validate();
		var actionUrl = $("#tuserForm").attr("action");
		if(vobj.isValid()){
				$(this).request({url:actionUrl,data:$("#tuserForm").serialize(),loadingText:"保存中...",method:"post",type:"json",func:function(obj) {
							alert(obj.msg);
							if("success"==obj.msgCode){
								location.href=base+"/manager/tuser/list.do";
								}
							}});
			}
		//$($("#reservationForm")[0]).submit();
	});
});
</script>