function boardCheack() {
	var obj = document.getElementById('content');
	var con = obj.value;
	if (con != '') {
		con = con.replace(/&/g, "&amp;");
	    con = con.replace(/</g, "&lt;");
	    con = con.replace(/>/g, "&gt;");
	    con = con.replace(/\"/g, "&quot;");
	    con = con.replace(/(\r\n|\n)/g, "<br />$1");
	    obj.value = con;
	}
}