<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<s:action name="updateDeal_SlidesDisplay" executeResult="true"
	namespace="/admin">
</s:action>
<div id="goods" class="main">
	<div class="floor">
		<s:action name="productArea_getAllAreashouye" executeResult="true"
			namespace="/area">
		</s:action>	
	</div>
</div>
<%@include file="/WEB-INF/pages/common/footer.jsp"%>
<script>
	$('.cover').hover(function() {
		$(this).find('#trade-geo').stop().fadeIn();
	}, function() {
		$(this).find('#trade-geo').stop().fadeOut();
	});
	$(function() {
		seajs.use([ '$', 'slide', 'tab', 'dialog', 'validator' ], function($,
				Slide, Tabs, Dialog, Validator) {
			slide1 = new Slide({
				element : '#box',
				panels : '#box .inner li',
				effect : 'fade',
				easing : 'easeOutStrong',
				interval : 2000
			}).render();
		});
		$('#images > div').each(function() {
			var $cfs = $(this);
			$cfs.carouFredSel({
				direction : 'down',
				circular : false,
				infinite : false,
				auto : false,
				scroll : {
					queue : 'last'
				},
				items : {
					visible : 1,
					width : 278,
					height : 145
				}
			});
			$cfs.hover(function() {
				$cfs.trigger('next');
			}, function() {
				$cfs.trigger('prev');
			});
		});

	});
</script>