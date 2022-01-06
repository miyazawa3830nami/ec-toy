'use strict'
$(function() {
	$(document).on('click','#contact',function sendToSlack(body, channel) {
		var postUrl = 'https://hooks.slack.com/services/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';

	/*
	*　slackへメッセージを送信する
	*　参考
	*　https://qiita.com/chihiro/items/c7b11abc78f5d806c3a8
	*　
	*　@param {string} username - 通知時に表示されるユーザー名
	*　@param {string} icon - 通知時に表示されるアイコン
	*　@param {string} message - 投稿メッセージ
	*/
	function sendSlack(username,icon,message,channel) {
  		var jsonData =
      	{
        	"username" : username,
        	"icon_emoji": icon,
        	"text" : message,
        	"channel": channel,
    	  };
 	var payload = JSON.stringify(jsonData);

  	var options =
      {
        "method" : "post",
        "contentType" : "application/json",
        "payload" : payload
      };

  	UrlFetchApp.fetch(postUrl, options);
	}
	});