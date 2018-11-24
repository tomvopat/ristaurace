let createMenuItemHtml = function(item) {
	let menuItemHtml =
		'<li class=\"menuList-item\">'
		+	'<label class="menuList-label" for="item-' + item.id + '">' + item.name + '</label>'
		+	'<input type=\"number\" value=0 min="0" max="100" name=\"item-' + item.id + '\">'
		+ '</li>';
	return menuItemHtml;
}

$.ajax({
	type: "GET",
	url: "http://www.mocky.io/v2/5bf990203200006200f22560",
	dataType: "jsonp",
	success: function(data){
		data.result.forEach(item => {
			$("#daily-items").append(createMenuItemHtml(item));
		});
	}
 });

 $.ajax({ 
	type: "GET",
	url: "http://www.mocky.io/v2/5bf9a01a3200006e00f2256f",
	dataType: "jsonp",
	success: function(data){
		data.result.forEach(item => {
			$("#permanent-items").append(createMenuItemHtml(item));
		});
	}
 });
