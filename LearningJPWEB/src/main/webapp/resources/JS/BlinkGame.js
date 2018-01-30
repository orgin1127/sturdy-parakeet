/**
 * 
 */
$(document).ready(function() {
	$('#myBlinkGame').on('click', function() {
		$('#myBlinkModal').css('display', 'block');
		$('#blinkGameCloser').on('click', closeBlinkGame);
		$('#blinkGameStartBT').on('click', function() {
			var gameType = $('#gameType').val();
			startBlinkGame(gameType);
		});
	});
});

function closeBlinkGame() {
	$('#myBlinkModal').css('display', 'none');
}
function startBlinkGame(gameType) {
	alert(gameType);
	var contentForBlinkGame = "";
	$.ajax({
		url: 'getBlinkGameContent'
		, type: 'get'
		, data: {gameType: gameType}
		, dataType: 'json'
		, success:function(gameContent) {
				
		}
		, error: function(e) {
			alert(JSON.stringify(e));
		}
	});
	
}