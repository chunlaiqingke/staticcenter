layui.define(function(exports){
	
	var obj = {
		get: function(url){
			var result;
			$.ajax({  
		        url: url,  
		        type: 'get',  
		        dataType: 'json',  
		        async: false,  
		        success: function (data) {  
		            if (data)  
		            {  
		                result = data;
		            }
		        },  
		        error: function ()  
		        {  
		            alert("不好意思请求失败了");  
		        }  
		    });
			return result;
		},
		post: function(url, params){
			var result;
			$.ajax({  
		        url: url,  
		        type: 'post',  
		        dataType: 'json',  
		        data: params,
		        async: false,  
		        success: function (data) {  
		            if (data)  
		            {  
		                result = data;
		            }
		        },  
		        error: function ()  
		        {  
		            alert("不好意思请求失败了");  
		        }  
		    });
			return result;
		}
	};
	exports('networkmod', obj);
});
