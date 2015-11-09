function refreshCode() {
	$.ajax({
		url: getCaptchaUrl,
		type: 'POST',
		success: function(newImgSrc) {
			$(".refreshCode").attr("src", newImgSrc);
		}
	});
}