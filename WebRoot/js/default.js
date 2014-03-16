(function($) {
	/**
	 * ajax向上封装
	 * 
	 */
	ajax = function(method, url, data) {
		var result = $.ajax({
			type : method,
			url : url,
			data : data,
			cache : false
		});
		return result;
	};
	/**
	 * 表单验证
	 */
	valitate_happy = function (url, options, commit, dataName) {
		console.log(options.element[0].value + '+' + dataName);
		ajax('POST', url, {
			dataName : options.element[0].value
		}).success(function(data) {
			if (data.success == true) {
				options.element.parent().addClass('ui-form-item-success');
			} else {
				options.element.parent().removeClass('ui-form-item-success');
				options.element.parent().addClass('ui-form-item-error');
			}
			commit(data.success == true ? 'aaaaaa' : null, data.message);
		});
	};
	/**
	 * 确认订单页的选择地址
	 */
	select_address = function(element){
		$(element).delegate('li','mouseover',function(){
			$(this).css('background-color','#fffae1');
		});
		$(element).delegate('li','mouseout',function(){
			$(this).css('background-color','#fff');
		});
		$(element).delegate('li','click',function(){
			$(this).find('input').attr('checked','checked');
		});
	};
})(jQuery);