layui.extend({
	networkmod: '/admincenter/common/networkmod',
	alert: '/admincenter/common/alert'
})
layui.use(['networkmod', 'alert'], function(){
	function loadOption(menuId, menuName, menuIcon, menuUrl, parentMenu)  
	{  
		var networkmod = layui.networkmod;
		var alert = layui.alert;
		var url = '/admincenter/menu/save';
		var params = {'menuId': menuId, 'menuName': menuName,'menuIcon': menuIcon, 'menuUrl': menuUrl, 'parentId': parentMenu};
		var result = networkmod.post(url, params);
		alert.msg(result.statusCode, result.msg);
	}
	var $ = layui.$;
	$("button[data-type='search']").on('click', function(){
		var menuId = $('#menuId').val();
		var menuName = $('#menuName').val();
		var menuIcon = $('#menuIcon').val();
		var menuUrl = $('#menuUrl').val();
		var parentMenu = $('#parentMenu').val();
		loadOption(menuId, menuName, menuIcon, menuUrl, parentMenu);
	});
})