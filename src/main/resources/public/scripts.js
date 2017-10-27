$(document).ready(function(){
	$("button").click(function(){
		if(document.getElementById("player").innerHTML == "X has game"){
			$(this).css('background-image', 'url(img/x.png)').attr('disabled','disabled');
			document.getElementById("player").innerHTML = "O has game";
		}else{
			$(this).css('background-image', 'url(img/o.png)').attr('disabled','disabled');
			document.getElementById("player").innerHTML = "X has game";
		}
	});
});