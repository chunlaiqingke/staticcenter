layui.use(['table'], function(){
	var table = layui.table;
	table.init('role', {
		url: '/admincenter/user/list'
		,page: true
		,limit: 10
		,response: {
			statusName: 'statusCode'
			,statusCode: 200
			,countName: 'total'
			,dataName: 'list'
		}
	});
})