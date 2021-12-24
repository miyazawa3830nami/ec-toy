'use strict'
$(function() {

  // ［住所検索］ボタンクリックで検索開始
  $(document).on('click', '#get_address', function () {
    $.ajax({
        url: 'https://zipcloud.ibsnet.co.jp/api/search',
        dataType: 'jsonp',
        data: { 
          zipcode: $('#zipcode').val()
        },
        async: true
    }).done(function(data) {
      // 検索成功時にはページに結果を反映
      // コンソールに取得データを表示
      console.log(data);
      console.dir(JSON.stringify(data));
      $('#address').val(data.results[0].address1 + data.results[0].address2 + data.results[0].address3);
    }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
      // 検索失敗時には、その旨をダイアログ表示
      alert('正しい結果を得られませんでした。');
      console.log('XMLHttpRequest : ' + XMLHttpRequest.status);
      console.log('textStatus     : ' + textStatus);
      console.log('errorThrown    : ' + errorThrown.message);
    });
  });
  
  // 紹介コード入力欄を出す
 	$('#usecode').hide();
	$('#code').on('change', function () {
	if($('#code:checked').val()=='on'){
 		$('#usecode').show();
	 } else {
 		$('#usecode').hide();
	 }
	 });

	//	利用区分によって表示項目を変える
	$('#privateForm').hide();
	$('#officialForm').hide();
	$('#purpose').on('change', function () {
	var input_purpose = document.querySelector("input[name=purpose]:checked");
	console.log($('#purpose').val);
	if(input_purpose.value == 'private'){
		$('#privateForm').show();
		$('#officialForm').hide();
	} else if(input_purpose.value == 'official'){
		$('#privateForm').hide();
		$('#officialForm').show();
	}
	});
	
	//	未実装_利用区分が選択されていないと登録ボタンを押せない
	$('#submit').disable = true;
	
});
