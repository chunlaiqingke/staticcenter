layui.extend({
	networkmod: '/admincenter/common/networkmod'
})
layui.use(['table','networkmod'], function(){
	var table = layui.table;
	var networkmod = layui.networkmod;
	table.init('menu', {
		url: '/admincenter/menu/list'
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
  table.on('tool(menu)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('真的删除这个菜单吗？', function(index){
    	  var result = networkmod.get('/admincenter/menu/delete');
    	  obj.del();
    	  layer.close(index);
      });
    } else if(obj.event === 'edit'){
      //layer.alert('编辑行：<br>'+ JSON.stringify(data));
    	layer.open({
    		type: 2,
    		title: '菜单编辑',
    		area: ['400px', '360px'],
    		content: ['./menu_edit.html', 'no'],
    		success: function(layero, index){
    			var result = networkmod.get('/admincenter/menu/parents');
    			var doc = $(window.frames["layui-layer-iframe" + index].document);
    			doc.find("#menuId").val(data.id);
    			doc.find("#menuName").val(data.title);
    			doc.find("#menuIcon").val(data.icon);
    			doc.find("#menuUrl").val(data.url);
    			for(var i = 0; i< result.list.length; i++){
    				if(data.parentId == result.list[i].id){
    					doc.find("#parentMenu").append("<option selected value="+ result.list[i].id +">"+result.list[i].title+"</option>");
    				}else{
    					doc.find("#parentMenu").append("<option value="+ result.list[i].id +">"+result.list[i].title+"</option>");
    				}
    			}
    		}
    	});
    }
  });
  
})