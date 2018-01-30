/**
 * 
 */
$(document).ready(function() {
	$('#myWordSearch').on('click', function() {
		$('#searchResultPrintDiv').html(' ');
		$('#userWordSearchModal').css('display', 'block');
		$('#wordSearchCloser').on('click', closeWordSearchForm);
	});
});

function closeWordSearchForm() {
	$('#userWordSearchModal').css('display', 'none');
	$('#pageNavigator').css('display', 'none');
}
function searchWord(pnum) {
	var inputWord = $('#inputhWord').val();
	$('#page').val(pnum);
	
	if(inputWord == "") {
		alert('검색어를 입력하여 주세요');
		return;
	}
	else {
		$.ajax({
			url: 'searchingWord'
			, type: 'post'
			, data: $('#wordSearchForm').serialize()
			, dataType: 'json'
			, success:function(searchResult) {
				if(searchResult != null) {
					var searchedList = searchResult.searchWordResult
					var pn = searchResult.pn
					printSearchingResult(searchedList, pn);
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
function printSearchingResult(searchedList, pn) {
	var contentForSearchResult = '';
	var numbering = 1;
	contentForSearchResult += '<table id="wordSearchResultTable"><tr><th id="wordNumTH">단어번호</th><th id="wordTH">한자</th><th id="yomiganaTH">발음</th><th>뜻</th><th id="linkAddressTH">더 보기</th><th>등급</th></tr>';
	
	
	$.each(searchedList, function(index, values) {
		contentForSearchResult += '<tr><td>No. '+values.wordNum+'</td><td>'+values.word+'</td><td>'+values.yomigana+'</td>';
		contentForSearchResult += '<td id="wordMeanindTD">'+values.meaning+'</td><td><a href="http://jpdic.naver.com'+values.linkAddress+'" target=_blank>더 보기</a></td><td id="wordLevelTD">'+values.wordLevel+'</td></tr>';
		numbering++;
	});
	$('#pageNavigator').css('display', 'block');
	contentForSearchResult += '</table>';
	$('#searchResultPrintDiv').html(contentForSearchResult);
	var contentForPageNavi = "";
	if (pn != null) {

		contentForPageNavi += '<a href="javascript:searchWord('+(pn.currentPage - pn.pagePerGroup)+')">◁◁ </a> &nbsp;&nbsp;';
		contentForPageNavi += '<a href="javascript:searchWord('+(pn.currentPage - 1)+')">◀</a> &nbsp;&nbsp;';
		for (var i = pn.startPageGroup; i <= pn.endPageGroup; i++) {
			if (i == pn.currentPage) {
				contentForPageNavi += '<b>';
			}
			contentForPageNavi += '<a href="javascript:searchWord(' + i +')">'+i+'</a>&nbsp;';
			if (i == pn.currentPage) {
				contentForPageNavi += '</b>';
			}
		}
		contentForPageNavi += '&nbsp;&nbsp;';
		contentForPageNavi += '<a href="javascript:searchWord('+ (pn.currentPage + 1) +')">▶</a> &nbsp;&nbsp;'
		contentForPageNavi += '<a href="javascript:searchWord('+(pn.currentPage + pn.pagePerGroup)+')">▷▷ </a>';
	$('#pageNavigator').html(contentForPageNavi);
	}
}