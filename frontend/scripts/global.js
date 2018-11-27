let timer = function() {
	setInterval("increaseTimer()", 1000);
}

let increaseTimer = function() {
	$(".ordersList-item").each(function() {
		let $counter = $(this).find(".ordersList-timer");
		let minutes = $counter.text().split(":")[0];
		let seconds = $counter.text().split(":")[1];
		seconds++;
		if(seconds >= 60) {
			seconds = 0;
			minutes++;
		}
		$counter.html(minutes + ":" + seconds);
	});
}

let createMenuItemHtml = function(item) {
	let menuItemHtml =
		'<li class=\"menuList-item\">'
		+	'<label class="menuList-label" for="item-' + item.id + '">' + item.name + ' <span class="menuList-price">(' + item.price + 'Kč)</span></label>'
		+	'<input class="menuList-input" type=\"number\" value=0 min="0" max="100" name=\"item-' + item.id + '\">'
		+ '</li>';
	return menuItemHtml;
}

let createOrderItemHtml = function(item) {
	let created = item.created;
	let currentDate = new Date();
	let creationDate = new Date(created.year, created.month - 1, created.day, created.hours, created.minutes);
	let difference = Math.abs(currentDate - creationDate);
	let differenceString = Math.floor(difference / 60000) + ':' + Math.ceil((difference % 60000) / 1000);
	
	let foodItemsHtml = '';
	item.food.forEach((food) => {
		foodItemsHtml = foodItemsHtml
		+ '<li class="menuList-item">'
		+	'<span class="ordersList-foodName">' + food.name + '</span>'
		+	'<span class="ordersList-foodCount">' + food.amount + '</span>'
		+ '</li>'
	});

	let drinkItemsHtml = '';
	item.drinks.forEach((drink) => {
		drinkItemsHtml = drinkItemsHtml
		+ '<li class="menuList-item">'
		+	'<span>' + drink.name + '</span>'
		+	'<span>' + drink.amount + '</span>'
		+ '</li>'
	});
	
	let menuItemHtml =
		'<li class="ordersList-item itemBox">'
		+	'<h3 class="itemBox-heading">Stůl č. ' + item.table + '</h3>'
		+	'<span class="ordersList-timer">' + differenceString + '</span>'
		+	'<div class="ordersList-content">'
		+		'<div class="ordersList-food">'
		+			'<h4>Pokrmy</h4>'
		+			'<ul class="menuList">'
		+				foodItemsHtml
		+			'</ul>'
		+		'</div>'
		+		'<div class="ordersList-drinks">'
		+			'<h4>Nápoje</h4>'
		+			'<ul class="menuList">'
		+				drinkItemsHtml
		+			'</ul>'
		+		'</div>'
		+	'</div>'
		+	'<div class="itemBox-buttons">'
		+		'<button class="button">Označit jako připravené</button>'
		+		'<button class="button">Označit jako vyřízené</button>'
		+	'</div>'
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

$.ajax({ 
	type: "GET",
	url: "http://www.mocky.io/v2/5bfa662e3200004b00bee336",
	dataType: "jsonp",
	success: function(data){
		data.result.forEach(item => {
			$("#drinks").append(createMenuItemHtml(item));
		});
	}
});

$.ajax({ 
	type: "GET",
	url: "http://www.mocky.io/v2/5bfd515331000075002cf881",
	dataType: "jsonp",
	success: function(data){
		data.result.forEach(item => {
			$("#ordersList").append(createOrderItemHtml(item));
		});
	}
});

$(document).ready(function() {
	timer();
});
