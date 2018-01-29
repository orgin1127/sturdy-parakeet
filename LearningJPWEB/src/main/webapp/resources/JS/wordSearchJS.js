/**
 * 
 */
$(document).ready(function() {
	$('#myWordSearch').on('click', function() {
		$('#userWordSearchModal').css('display', 'block');
		makeWordSearchForm();
		$('#wordSearchCloser').on('click', closeWordSearchForm);
		$('#wordSearchSubmit').on('click', searchWord);
	});
});
function makeWordSearchForm() {
	var contentForWordSearchForm = "";
	
	contentForWordSearchForm += '<p><form action="wordSearch" method="post" id="wordSearchForm"><table id="wordSearchTable">';
	contentForWordSearchForm += '<tr><td>검색할 단어 : </td><td><input type="text" id="inputSearchWord" name="inputSearchWord">';
	contentForWordSearchForm += '<td><input type="button" id="wordSearchSubmit" value="검색"></td></tr>';
	contentForWordSearchForm += '</table></form></p>';
	contentForWordSearchForm += '<div id="searchResultPrintDiv"></div>'
	$('#mySearchWordBody').html(contentForWordSearchForm);
}
function closeWordSearchForm() {
	$('#userWordSearchModal').css('display', 'none');
}
function searchWord() {
	var inputWord = $('#inputSearchWord').val();
	if(inputWord == "") {
		alert('검색어를 입력하여 주세요');
		return;
	}
	else {
		$.ajax({
			url: 'searchingWord'
			, type: 'get'
			, data: {inputWord: inputWord}
			, dataType: 'json'
			, success:function(searchWordResult) {
				if(searchWordResult != null) {
					printSearchingResult(searchWordResult);
				}
				else {
					alert('검색 결과가 없습니다. 한자를 확인해 주세요');
				}
			}
			, error:function(e) {
				alert(JSON.stringify(e));
			}
		});
	}
}
function printSearchingResult(searchWordResult) {
	var contentForSearchResult = '';
	var numbering = 1;
	contentForSearchResult += '<table id="wordSearchResultTable"><tr><th>번호</th><th>한자</th><th>발음</th><th>뜻</th><th>더 보기</th><th>등급</th></tr>';
	$.each(searchWordResult, function(index, values) {
		contentForSearchResult += '<tr><td>'+numbering+'</td><td>'+values.word+'</td><td>'+values.yomigana+'</td>';
		contentForSearchResult += '<td id="wordMeanindTD">'+values.meaning+'</td><td><a '+values.linkAddress+'>더 보기</a></td><td>'+values.wordLevel+'</td></tr>';
		numbering++;
	});
	contentForSearchResult += '</table>';
	$('#searchResultPrintDiv').html(contentForSearchResult);
}

