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
		, success:function(blinkGameContent) {
				var userGameInfo = blinkGameContent.blinkGameUserInfo;
				var blinkGameWordList = blinkGameContent.wordList;
				blinkGameStart(userGameInfo, blinkGameWordList);
		}
		, error: function(e) {
			alert(JSON.stringify(e));
		}
	});
	
}

function blinkGameStart(userGameInfo, blinkGameWordList) {
	var userHighScore = userGameInfo.highScore;
	var userMaxCombo = userGameInfo.maxCombo;
	var userPlayCount = userGameInfo.playCount;
	var gameLife = 10;
	
	userPlayCount++;
	while (gameLife != 0) {
		
		$('#gameContentDiv').html();
	}
}