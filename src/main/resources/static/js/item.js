'use strict'
$(function() {

	//	カーソルを合わせると商品名を表示
	$('itemName').hide();
	$('#itemImage').on('hover', function () {
		$('#itemName').show();
	}, function () {
		$('#itemName').hide();
	});
});