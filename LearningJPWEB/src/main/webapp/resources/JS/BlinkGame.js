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
	clearInterval(blinking);
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

var blinking;
function blinkGameStart(userGameInfo, blinkGameWordList) {
	var userHighScore = userGameInfo.highScore;
	var userMaxCombo = userGameInfo.maxCombo;
	var userPlayCount = userGameInfo.playCount;
	var score = 0;
	var gameLife = 3;
	var combo = 0;
	userPlayCount++;
	var blinkCount = 0;
	var cnt = 0;
	var blinkCnt = 1;
	var clearing;
	var counted = 0;
	
	blinking = setInterval(function() {
		var contentForBlinkGameInfo = "";
		contentForBlinkGameInfo += '<table id="gameInfoTable"><tr><td colspan="6" rowspan="5">MAX Combo : ' + userMaxCombo + ' HIGH SCORE : ' + userHighScore + ' SCORE : ';
		contentForBlinkGameInfo += score + ' Combo : ' + combo +' LIFE : ' +  gameLife + '</td></tr></table>';
		$('#gameInfoDiv').html(contentForBlinkGameInfo);		
		if(counted == 0 || counted == 2 || counted == 4) {
			$('#gameContentDiv').html('');
			counted += 1;
		}
		else if(counted == 1 || counted == 3 || counted == 5) {
			console.log("else if 1 "+counted);
			contentForBlinkGame = "";
			contentForBlinkGame += '<table ID="blinkGameTable">';
			contentForBlinkGame += '<tr><td id="blinkGameTD" colspan="6" rowspan="5">';
			contentForBlinkGame +=  ' 단어 : ' + blinkGameWordList[cnt].word + '   뜻 : ' + blinkGameWordList[cnt].meaning + '</td></tr></table>';
			$('#gameContentDiv').html(contentForBlinkGame);
			counted += 1;
		}
		else if(counted == 6) {
			console.log("else if 2 "+counted);
			$('#gameContentDiv').html('');
			var answer = prompt('정답을 입력하여 주세요, 가나 단어는 가나를 그대로 써 주세요');
			if (answer == blinkGameWordList[cnt].yomigana) {
				alert('정답');
				combo++;
				cnt++;
				score = score + 5 + (combo*2);
				counted = 0;
			}	
			else {
				alert('오답');
				combo = 0;
				gameLife--;
				cnt++;
				counted = 0;
			}
		}
		if (score >= userHighScore) {
			userHighScore = score;
		}
		if (combo >= userMaxCombo) {
			userMaxCombo = combo;
		}
		if (gameLife == 0) {
			clearInterval(blinking);
			console.log("gameLife : " + gameLife);
			alert('라이프가 0이 되어 게임을 종료합니다.');
			$.ajax({
				url: 'blinkGameResultUpdate'
				, type: 'post'
				, data: {gameNum: userGameInfo.gameNum
						, userID: userGameInfo.userID
						, playCount: userPlayCount
						, highScore: userHighScore
						, maxCombo: userMaxCombo
				}
				, success: function() {
					closeBlinkGame();
					location.reload();
				}
				, error: function(e) {
					
				}
			});
		}
	}, 2000);
}