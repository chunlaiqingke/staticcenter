layui.define(['layer'], function(exports){
	var layer = layui.layer;
	var obj = {
		msg: function(flag, msg){
			if(flag == 200){
				layer.msg(msg, {icon: 6});
			}else{	
				layer.msg(msg, {icon: 5});
			}
		}
	};
	exports('alert', obj);
});
