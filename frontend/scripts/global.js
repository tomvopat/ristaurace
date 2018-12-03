let baseUrl = "http://localhost:8080/"


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
		$counter.html(minutes + ":" + (seconds + '').padStart(2, '0'));
	});
}

let createMenuItemHtml = function(item) {
	let menuItemHtml =
		'<li data-id="' + item.id + '" class="menuList-item">'
		+	'<label class="menuList-label" for="item-' + item.id + '">' + item.nazev + ' <span class="menuList-price">(' + item.cena + 'Kč)</span></label>'
		+	'<input class="menuList-input" type="number" value=0 min="0" max="100" name="item-' + item.id + '">'
		+ '</li>';
	return menuItemHtml;
}

let getOrderItemsById = function(id, callback) {
	let items = [];
	$.ajax({
		type: "GET",
		url: baseUrl + "order/all/",
		dataType: "json",
		success: function(data){
			data.forEach(item => {
				if(item.ucetByIdUcet.id == id) {
					items.push(item);
				}
			});
			callback(items);
		}
	});
}

let createOrderItemHtml = function(item) {
	let creationDate = new Date(item.ucetByIdUcet.datumVytvoreni);
	let currentDate = new Date();
	let difference = Math.abs(currentDate - creationDate);
	let differenceString = Math.floor(difference / 60000) + ':' + Math.ceil((difference % 60000) / 1000);
	let foodItemsHtml = '';
	let drinkItemsHtml = '';
	getOrderItemsById(item.ucetByIdUcet.id, function(foodItems) {
		console.log(foodItems);
		fetch(baseUrl + 'menu-items/category/2')
		.then(response => {
			return response.json();
		})
		.then(drinks => {
			foodItems.forEach((food) => {
				let isDrink = false;
				drinks.forEach((drink => {
					if(food.polozkaMenuByIdPolozkaMenu.id === drink.id) {
						drinkItemsHtml = drinkItemsHtml
						+ '<li id="drink-' + food.polozkaMenuByIdPolozkaMenu.id + '" class="menuList-item">'
						+	'<span class="ordersList-foodName">' + food.polozkaMenuByIdPolozkaMenu.nazev + '</span>'
						+	'<span class="ordersList-foodState ' + food.stav + '"></span>'
						+ '</li>';
						isDrink = true;
					}
				}));
				if(!isDrink) {
					foodItemsHtml = foodItemsHtml
					+ '<li id="food-' + food.polozkaMenuByIdPolozkaMenu.id + '" class="menuList-item">'
					+	'<span class="ordersList-foodName">' + food.polozkaMenuByIdPolozkaMenu.nazev + '</span>'
					+	'<span class="ordersList-foodState ' + food.stav + '"></span>'
					+ '</li>';
				}
			});
			
			let menuItemHtml =
				'<li class="ordersList-item itemBox" data-itemId="' + item.id + '">'
				+	'<h3 class="itemBox-heading">Stůl č. ' + item.stulByIdStul.cisloStolu + '</h3>'
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
				+		'<button class="button button-ready">Označit jako připravené</button>'
				+		'<button class="button button-done">Označit jako vyřízené</button>'
				+	'</div>'
				+ '</li>';
				$("#ordersList").append(menuItemHtml);
			});
	
	});
}

let createTableOptionHtml = function(item) {
	return '<option class="table-option" value=' + item.id + '>' + item.cisloStolu + '</option>';
}

$.ajax({
	type: "GET",
	url: baseUrl + "tables/all",
	dataType: "json",
	success: function(data){
		data.forEach(item => {
			$("#tableSelect").append(createTableOptionHtml(item));
		});
	}
});

$.ajax({
	type: "GET",
	url: baseUrl + "menu-items/category/1/",
	dataType: "json",
	success: function(data){
		data.forEach(item => {
			$("#daily-items").append(createMenuItemHtml(item));
		});
	}
});

$.ajax({ 
	type: "GET",
	url: baseUrl + "menu-items/category/3/",
	dataType: "json",
	success: function(data){
		data.forEach(item => {
			$("#permanent-items").append(createMenuItemHtml(item));
		});
	}
});

$.ajax({ 
	type: "GET",
	url: baseUrl + "menu-items/category/2/",
	dataType: "json",
	success: function(data){
		data.forEach(item => {
			$("#drinks").append(createMenuItemHtml(item));
		});
	}
});


$.ajax({ 
	type: "GET",
	url: baseUrl + "bill/opened",
	dataType: "json",
	success: function(data){
		data.forEach(item => {
			createOrderItemHtml(item);
		});
	}
});


$(document).on('submit', '#orderForm', function(event) {
	event.preventDefault();
	const tableId = $("#tableSelect").val();
	let orderId;
	$.ajax({ 
		type: "POST",
		url: baseUrl + "bill/new/" + tableId,
		dataType: "json",
		success: function(data) {
			orderId = data.id;
			let $allItems = $(".menuList-item");
			$allItems.each((i, item) => {
				const amount = $(item).find("input").val();
				let itemId = ($(item).data("id"));
				for (let index = 0; index < amount; index++) {
					$.ajax({ 
						type: "POST",
						url: baseUrl + "menu-items/order/" + orderId + "/" + itemId,
						dataType: "json",
						success: function() {
							console.log("here");
						}
					});
				}
			});
		}
	});
});

$(document).ready(function() {
	timer();

	$("#ordersList").on("click", ".button-ready", function() {
		let itemId = $(this.closest(".ordersList-item")).attr("data-itemId");
		// TODO PUT request
	});
});
