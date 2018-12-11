$(function () {
    //初始化metisMenu
    $("#side-menu").metisMenu();
    var oLanguageLeoCN = {
        'sProcessing' : ' 处理中... ',
        'sLengthMenu' : ' 显示  _MENU_ 项结果 ',
        'sZeroRecords' : ' 没有匹配结果 ',
        'sInfo' : ' 显示第_START_至_END_项结果，共_TOTAL_项 ',
        'sInfoEmpty' : ' 显示第0至0项结果，共0项 ',
        'sInfoFiltered' : ' (由_MAX_项结果过滤) ',
        'sInfoPostFix' : '  ',
        'sSearch' : ' 搜索: ',
        'sUrl' : ' ',
        'sEmptyTable' : ' 表中数据为空 ',
        'sLoadingRecords' : ' 载入中... ',
        'sInfoThousands' : ' , ',
        'oPaginate' : {
            'sFirst' : ' 首页 ',
            'sPrevious' : ' 上页 ',
            'sNext' : ' 下页 ',
            'sLast' : ' 末页 '
        },
        'oAria' : {
            'sSortAscending' : ' :以升序排列此列',
            'sSortDescending' : ' :以降序排列此列 '
        }
    };
    //$.fn.datepicker.defaults['language'] = 'zh-CN';
    $.fn.DataTable.defaults.oLanguage = oLanguageLeoCN;
    jQuery.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    //设置validate提示信息
    $.extend($.validator.messages, {
        required: "这是必填字段",
        remote: "请修正此字段",
        email: "请输入有效的电子邮件地址",
        url: "请输入有效的网址",
        date: "请输入有效的日期",
        dateISO: "请输入有效的日期 (YYYY-MM-DD)",
        number: "请输入有效的数字",
        digits: "只能输入数字",
        creditcard: "请输入有效的信用卡号码",
        equalTo: "你的输入不相同",
        extension: "请输入有效的后缀",
        maxlength: $.validator.format("最多可以输入 {0} 个字符"),
        minlength: $.validator.format("最少要输入 {0} 个字符"),
        rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
        range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
        max: $.validator.format("请输入不大于 {0} 的数值"),
        min: $.validator.format("请输入不小于 {0} 的数值")
    });
});