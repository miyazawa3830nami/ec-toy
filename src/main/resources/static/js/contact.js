'use strict'
$(function() {
	$(document).on('click','#contact',function sendToSlack(body, channel) {
  	var url = "https://hooks.slack.com/services/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";
  	var data = { "channel" : channel, 
  				"username" : "Googleフォーム Bot", 
  				"text" : body, "icon_emoji" : ":date: " };
  	var payload = JSON.stringify(data);
  	var options = {
    	"method" : "POST",
    	"contentType" : "application/json",
    	"payload" : payload
  	};
  	var response = UrlFetchApp.fetch(url, options);
	}

	// function test() {
  		sendToSlack("テスト通知確認です", "#ec-toy");
	});

	function onFormSubmit(e){

		var body = "Slack通知テストフォームが来たよ！\n"; 
  		var applicant = "";
 	 	var itemResponse = e.response.getItemResponses();

		for (var j = 0; j < itemResponse.length; j++){    
    	var formData = itemResponse[j];
    	var title = formData.getItem().getTitle();
    	var response = formData.getResponse();

    switch (title) {
      case "日付":
        date = response;
        break;
      case "氏名":
        name = response;
        break;
      case "好きな言語":
        language = response;
        break;
      default:
        break;
    }
  }
  var bodyPublic =  body + "日付:" + date + "\n氏名:" + name + "\n好きな言語:" + language ;
  sendToSlack(bodyPublic, "#ec-toy");
}