require.config({
        paths: {
            echarts: '../echart/js'
        }
    });
var myChart;
// Step:4 require echarts and use it in the callback.
// Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
require(
    [
        'echarts',
        'echarts/chart/bar',
        'echarts/chart/line',
        'echarts/chart/map'
    ],
    function (ec) {
        //--- 折柱 ---
        myChart = ec.init(document.getElementById('chart'));
        var option = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['每日签到用户数']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['']
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    name : '每日签到用户数',
                    splitArea : {show : true}
                }
            ],
            series : [
                {
                    name:'每日签到用户数',
                    type:'bar',
                    data:['']
                }
            ]
        }
        myChart.setOption(option, true);
    }
);

function loadOption(startDate, endDate)  
{  
    $.ajax({  
        url: '/admincenter/sign?startDate='+startDate+'&endDate='+endDate,  
        type: 'get',  
        dataType: 'json',  
        async: false,  
        success: function (result) {  
            if (result)  
            {  
                var option = myChart._option;  //e2中感觉这个命名十分奇怪，居然要这样获取，必须先设置才有这个属性  
                debugger  
                if (result.categories != null) {  
                    option.xAxis[0].data = result.categories;
                }  
                if (result.firstList != null){
                	option.series[0].data = result.firstList;
                }
                myChart.setOption(option,true);  
            }  
        },  
        error: function ()  
        {  
            alert("不好意思请求失败了");  
        }  
    })  
}

layui.use(['laydate','layer'], function(){
	 var laydate = layui.laydate;
	 var layer = layui.layer;
	 var $ = layui.$;
	 laydate.render({
	    elem: '#startDate' //指定元素
	 });
	 laydate.render({
	    elem: '#endDate' //指定元素
	 });
	 $("button[data-type='search']").on('click', function(){
		var startDate = $('#startDate').val();
		var endDate = $('#endDate').val();
		var othis = $(this), method = othis.data('method');
		if(startDate != null && endDate != null && startDate != '' && endDate != ''){
			if((new Date(endDate).getTime() - new Date(startDate).getTime()) / 86400000 <= 10){
				loadOption(startDate, endDate);
			}else{
				active[method] ? active[method].call(this, '时间差不能超过10天') : '';
			}
		}else{
		    active[method] ? active[method].call(this, '时间不能为空') : '';
		}
	 });
	 
	 var active = {
		confirmTrans: function(msg){
	      layer.msg(msg, {
	        time: 20000, //20s后自动关闭
	        btn: ['哦','知道了']
	      });
	    }
	 }
});