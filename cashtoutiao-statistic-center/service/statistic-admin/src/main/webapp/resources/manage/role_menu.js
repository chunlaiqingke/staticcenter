layui.extend({
	networkmod: '/admincenter/common/networkmod'
})
layui.use(['table', 'form', 'networkmod'], function(){
	var table = layui.table;
	var form = layui.form;
	var networkmod = layui.networkmod;
	
	table.render({
	    elem: '#role_menu'
	    ,url: '/admincenter/role/menu/list/permitted'
	    ,cellMinWidth: 100
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field: 'id', title: 'ID', width:80, fixed: 'left'}
	      ,{field: 'title', title: '菜单名', width:150}
	      ,{field: 'url', title: '菜单链接', width:300}
	      ,{field: 'permitted', title:'是否允许', width:150, templet: '#checkboxTpl', unresize: true}
	    ]]
		,response: {
			statusName: 'statusCode'
			,statusCode: 200
			,countName: 'total'
			,dataName: 'list'
		}
	});
  
})