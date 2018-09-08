layui.extend({
	networkmod: '/admincenter/common/networkmod',
	alert: '/admincenter/common/alert'
})
layui.use(['table', 'form', 'networkmod', 'alert', 'layer'], function(){
	var table = layui.table;
	var form = layui.form;
	var networkmod = layui.networkmod;
	var alert = layui.alert;
	var layer = layui.layer;
	table.init('role', {
		url: '/admincenter/role/list'
		,page: true
		,limit: 10
		,response: {
			statusName: 'statusCode'
			,statusCode: 200
			,countName: 'total'
			,dataName: 'list'
		}
	});
	//监听工具条
	table.on('tool(role)', function(obj){
		var data = obj.data;
		if(obj.event === 'del'){
			layer.confirm('真的删除这个菜单吗？', function(index){
				var result = networkmod.get('/admincenter/role/delete');
				obj.del();
				layer.close(index);
			});
		} else if(obj.event === 'edit'){
			
		} else if(obj.event === 'detail'){
			layer.open({
				type: 2,
				title: '菜单权限',
				btn: ['修改'],
				area: ['43%', '90%'],
				skin: 'layui-layer-rim', //加上边框
				content: './role_menu.html',
				yes: function(index, layero){
					var doc = $(window.frames["layui-layer-iframe" + index].document).find(".layui-table-main");
					var trs = $(doc).find("tr");
					var ids = "";
					for(var i = 0; i < trs.length; i++){
						var flag=$(trs[i]).find("input").prop("checked");
						if(flag){
							var id = $(trs[i]).find("td:eq(1)>div").text();
							if(ids == ""){
								ids = id;
							} else{
								ids = ids + "," + id;
							}
						}
					}
					var result=networkmod.post('/admincenter/role/menu/save', {'ids': ids, 'roleId': data.id});
					alert.msg(result.statusCode, result.msg);
				}
			});
		}
	});
})