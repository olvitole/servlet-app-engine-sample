//IIFE pattern 
(function() {

	$(document).ready(function() {
		init();
	});

	function init() {
		$('#submitName').click(
				function() {
					$.ajax({
						type : "POST",
						url : '/api/hello',
						data : {
							name : $('#name').val()
						},
						success : function(responseText) {
							$('#ajaxGetUserServletResponse').text("Hello: " + responseText.name);
						}
					});
				});
	}

})();
