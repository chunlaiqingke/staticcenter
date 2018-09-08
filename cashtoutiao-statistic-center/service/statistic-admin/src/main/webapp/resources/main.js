require.config({
        paths: {
            echarts: './echart/js'
        }
    });
var myChartOne;
var myChartTwo;
var myChartThree;
var myChartFour;
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
        myChartOne = ec.init(document.getElementById('one'));
        myChartTwo = ec.init(document.getElementById('two'));
        myChartThree = ec.init(document.getElementById('three'));
        myChartFour = ec.init(document.getElementById('four'));
        var optionOne = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['每天活跃用户','每天新增用户']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: false}
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
                    name : '每天活跃用户',
                    splitArea : {show : true}
                },
                {
                    type : 'value',
                    name : '每天新增用户',
                    splitArea : {show : true}
                }
            ],
            series : [
                {
                    name:'每天活跃用户',
                    type:'bar',
                    data:['']
                },
                {
                    name:'每天新增用户',
                    type:'line',
                    yAxisIndex: 1,
                    data:['']
                }
            ]
        };
        var optionTwo = {
        		tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['新闻浏览时长','视频浏览时长']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: false},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: false}
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
                        name : '新闻浏览时长',
                        splitArea : {show : true}
                    },
                    {
                        type : 'value',
                        name : '视频浏览时长',
                        splitArea : {show : true}
                    }
                ],
                series : [
                    {
                        name:'新闻浏览时长',
                        type:'line',
                        data:['']
                    },
                    {
                        name:'视频浏览时长',
                        type:'line',
                        yAxisIndex: 1,
                        data:['']
                    }
                ]
        };
        var optionThree = {
        		tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['每天邀请支出']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: false},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: false}
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
                        name : '每天邀请支出',
                        splitArea : {show : true}
                    }
                ],
                series : [
                    {
                        name:'每天邀请支出',
                        type:'bar',
                        data:['']
                    }
                ]
            };
            var optionFour = {
            		tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['总返现']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: false},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: false}
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
        myChartOne.setOption(optionOne, true);
        myChartTwo.setOption(optionTwo, true);
        myChartThree.setOption(optionThree, true);
        myChartFour.setOption(optionFour, true);
        var myDate=new Date();
        myDate.setDate(myDate.getDate()-10);
        var y = myDate.getFullYear();
        var m = myDate.getMonth() + 1;
        var d = myDate.getDate();
        loadOption('/admincenter/user/active?day=' + y + '-' + checkTime(m) + '-' + checkTime(d), myChartOne);
        loadOption('/admincenter/read?day=' + y + '-' + checkTime(m) + '-' + checkTime(d), myChartTwo);
        loadOption('/admincenter/invite/payout?day=' + y + '-' + checkTime(m) + '-' + checkTime(d), myChartThree);
        loadOption('/admincenter/credit/cash/back?day=' + y + '-' + checkTime(m) + '-' + checkTime(d), myChartFour);
    }
);

function checkTime(i)
{
if (i<10) 
  {i="0" + i}
  return i
}

function loadOption(url, myChart)  
{  
    $.ajax({  
        url: url,  
        type: 'get',  
        dataType: 'json',  
        async: false,  
        success: function (result) {  
            if (result)  
            {  
                var option = myChart._option;  //e2中感觉这个命名十分奇怪，居然要这样获取，必须先设置才有这个属性  
                //debugger  
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