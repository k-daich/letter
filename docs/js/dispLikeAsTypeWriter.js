
function disp(){

	var type = msg.substring(0, count);
	// テキストフィールドにデータを渡す処理
	document.form1.field1.innerText = type;

	count ++;
	var rep = setTimeout("disp()", speed);

	if(count > msg.length){
		if(flag == 1){ clearTimeout(rep); }
		else{ count = 0; }
	}

}