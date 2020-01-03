<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>home</title>
<script src="js/jquery.min.js"></script>
</head>

<body>
	<form action="update" method="post">
		<div>
			<input name="${(_csrf.parameterName)!}" value="${(_csrf.token)!}" type="hidden">
		</div>
		<div>
			<input name="name" value="foo">
		</div>
		<div>
			<input name="label" value="bar">
		</div>
		<div>
			<input type="submit"> <input type="button" value="ajax" onclick="send()" />
		</div>
	</form>
</body>
<script type="text/javascript">
	$(document).ajaxSend(function(e, xhr, opt) {
		xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
	});
	function send() {
		$.post('update', {
			name : "foo",
			label : "bar"
		}, function(data) {
			alert("success")
		});
	}
</script>
</html>