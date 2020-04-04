function timeOut() {
	var x = document.getElementById("txt");

	setTimeout(function() {
		x.value= " asd "
	}, 2000);

}

window.onload=timeOut()