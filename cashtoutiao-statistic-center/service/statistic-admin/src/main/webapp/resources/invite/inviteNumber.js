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
                data:['师傅数', '徒弟数']
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
                    name : '师傅数',
                    splitArea : {show : true}
                }
            ],
            series : [
                {
                    name:'师傅数',
                    type:'bar',
                    data:['']
                },
                {
                    name:'徒弟数',
                    type:'bar',
                    data:['']
                }
            ]
        }
        myChart.setOption(option, true);
       
    }
);

function loadOption(day)  
{  
    $.ajax({  
        url: '/admincenter/invite/number?day='+day,  
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
                if (result.secondList != null){
                	option.series[1].data = result.secondList;
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

layui.use('laydate', function(){
	 var laydate = layui.laydate;
	 laydate.render({
	    elem: '#startDate' //指定元素
	 });
	 var $ = layui.$;
		$("button[data-type='search']").on('click', function(){
			var startDate = $('#startDate').val();
			loadOption(startDate);
		});
});