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
                data:['总返现']
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
                    name : '总返现',
                    splitArea : {show : true}
                }
            ],
            series : [
                {
                    name:'总返现',
                    type:'bar',
                    data:['']
                }
            ]
        }
        myChart.setOption(option, true);
        var myDate=new Date();
        myDate.setDate(myDate.getDate()-30);
        var y = myDate.getFullYear();
        var m = myDate.getMonth() + 1;
        var d = myDate.getDate();
        loadOption(y + '-' + checkTime(m) + '-' + checkTime(d));
       
    }
);
function checkTime(i)
{
if (i<10) 
  {i="0" + i}
  return i
}
function loadOption(day)  
{  
    $.ajax({  
        url: '/admincenter/credit/cash/back?day='+day,  
        type: 'get',  
        dataType: 'json',  
        async: false,  
        success: function (result) {  
            if (result)  
            {  
                var option = myChart._option;  //e2中感觉这个命名十分奇怪，居然要这样获取，必须先设置才有这个属性  
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