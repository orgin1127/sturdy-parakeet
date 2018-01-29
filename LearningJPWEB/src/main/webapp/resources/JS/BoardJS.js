/*$(document).ready(function() {
	$('#myUserBoard').on('click', function() {
		$.ajax({
			url: 'getUserBoardList'
			, type: 'get'
			, dataType: 'json'
			, success: function(boardList) {
				if (boardList != null) {
					printUserBoardList(boardList);
				}
			}
			, error: function(e) {
				alert(JSON.stringify(e));
			}
		});
		
	
	});
	function printUserBoardList(boardList) {
		var contentForBoardTable ='<table><tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>';
		$.each(boardList, function(index, values) {
			contentForBoardTable += '<tr><td>'+values.boardNum+'</td>';
			contentForBoardTable += '<td>'+values.title+'</td>';
			contentForBoardTable += '<td>'+values.userName+'</td>';
			contentForBoardTable += '<td>'+values.writedDate+'</td>';
			conetntForBoardTable += '<td>'+values.hits+'</td></tr>';
		});
		contentForBoardTable += '</table>';
		$('#divForBoardList').html(contentForBoardTable);
	}
});*/