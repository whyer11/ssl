(function($){
	ajax = function(method,url,data){
		var result = $.ajax({
			type: method,
			url:url,
			data:data,
			cache : false
		});
		return result;
	};
	function valitate_happy(url,options,commit,dataName){
		console.log(options.element[0].value+'+'+dataName);
		ajax('POST',url,{dataName : options.element[0].value}).success(function(data){
			if (data.success == true) {
				options.element.parent().addClass('ui-form-item-success');
			} else {
				options.element
						.parent()
						.removeClass(
								'ui-form-item-success');
				options.element
						.parent()
						.addClass(
								'ui-form-item-error');
			}
			commit(
					data.success == true ? 'aaaaaa'
							: null,
					data.message);
		});
	};
})(jQuery);



