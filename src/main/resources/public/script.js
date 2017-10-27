$(document).ready(function(){
    $("button").click(function(){
		if(document.getElementById("status").innerHTML == "Player X"){
			$(this).css('background-image', 'url(img/x.png)').attr('disabled','disabled');
			document.getElementById("status").innerHTML = "Player O";
		}else{
			$(this).css('background-image', 'url(img/o.png)').attr('disabled','disabled');
			document.getElementById("status").innerHTML = "Player X";
		}

		$.ajax({url: "/makeMove/" + this.id, success: function(result) {
			var object = JSON.parse(result);
			var player = object.player;
			if (object.status == "win") {
        document.getElementById("status").innerHTML = player + " WINS!";
        setTimeout(function(){ alert(player + " Won!");
        resetGame();
      }, 100);

			}
			if (object.status == "draw") {
        document.getElementById("status").innerHTML = "DRAW";
        setTimeout(function(){ alert("DRAW");
        resetGame();
      }, 100);
			}
		}});
    });
});

function resetGame() {
	for(var i = 1; i <= 9; i++){
		$(document.getElementById(i)).css('background-image', 'none').removeAttr('disabled')
    document.getElementById("status").innerHTML = "Player X";
	}
}
