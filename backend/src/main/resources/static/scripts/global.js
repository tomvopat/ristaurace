/* CHANGE THIS TO WHATEVER DOMAIN THE PROJECT RUNS ON! */
let baseUrl = "http://localhost:8080/"

/* calls increaseTimer every second */
let timer = function() {
	setInterval("increaseTimer()", 1000);
}

/* adds one second and replaces timer HTML */
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

/* creates list element of one specific menu item */
let createMenuItemHtml = function(item) {
	let menuItemHtml =
		'<li data-id="' + item.id + '" class="menuList-item">'
		+	'<label class="menuList-label" for="item-' + item.id + '">' + item.nazev + ' <span class="menuList-price">(' + item.cena + 'Kč)</span></label>'
		+	'<input class="menuList-input" type="number" value=0 min="0" max="100" name="item-' + item.id + '">'
		+ '</li>';
	return menuItemHtml;
}

/* returns JSON with items in specific order */
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

/* creates order HTML element based on recieved JSON containing order data */
let createOrderItemHtml = function(item) {
	let creationDate = new Date(item.ucetByIdUcet.datumVytvoreni);
	let currentDate = new Date();
	let difference = Math.abs(currentDate - creationDate);
	let differenceString = Math.floor(difference / 60000) + ':' + Math.ceil((difference % 60000) / 1000);
	let foodItemsHtml = '';
	let drinkItemsHtml = '';
	getOrderItemsById(item.ucetByIdUcet.id, function(foodItems) {
		fetch(baseUrl + 'menu-items/category/2')
		.then(response => {
			return response.json();
		})
		.then(drinks => {
			let closedCnt = 0;
			foodItems.forEach((food) => {
				if(food.stav === 'zavreny') {
					closedCnt++;
				}
			});
			/* do not show if thera are no items or all items are closed in bill */
			if(foodItems.length < 1 || closedCnt === foodItems.length) {
				return;
			}
			foodItems.forEach((food) => {
				let isDrink = false;
				drinks.forEach((drink => {
					if(food.polozkaMenuByIdPolozkaMenu.id === drink.id) {
						drinkItemsHtml = drinkItemsHtml
						+ '<li data-itemId="' + food.id + '" class="menuList-item">'
						+	'<span class="ordersList-foodName">' + food.polozkaMenuByIdPolozkaMenu.nazev + '</span>'
						+	'<span class="ordersList-foodState ' + food.stav + '"></span>'
						+ '</li>';
						isDrink = true;
					}
				}));
				if(!isDrink) {
					foodItemsHtml = foodItemsHtml
					+ '<li data-itemId="' + food.id + '" class="menuList-item">'
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
				+		'<button class="button button-ready">Označit vše jako připravené</button>'
				+		'<button class="button button-done">Označit vše jako vyřízené</button>'
				+	'</div>'
				+ '</li>';
				$("#ordersList").append(menuItemHtml);
			});
	
	});
}

/* creates table select HTML element based on received table data */
let createTableOptionHtml = function(item) {
	return '<option class="table-option" value=' + item.id + '>' + item.cisloStolu + '</option>';
}

/* recieved JSON with all tables. Calls function to create table option element on success */
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

/* receive items from all five categories */
for (let index = 1; index <= 5; index++) {
	$.ajax({ 
		type: "GET",
		url: baseUrl + "menu-items/category/" + index,
		dataType: "json",
		success: function(data){
			data.forEach(item => {
				if(index === 1) {
					$("#daily-items").append(createMenuItemHtml(item));
				} else if(index == 2) {
					$("#drinks").append(createMenuItemHtml(item));
				} else {
					$("#permanent-items").append(createMenuItemHtml(item));
				}
			});
		}
	});
}

/* reveive all opened bills. Calls createOrderItemHtml function on success */
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

/* Post form data on form submit */
$(document).on('submit', '#orderForm', function(event) {
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
							//
						}
					});
				}
			});
		}
	});
});

$(document).ready(function() {
	timer();

	/* change all menu items status to ready */
	$("#ordersList").on("click", ".button-ready", function() {
		let itemElement = $(this.closest(".ordersList-item"));
		let itemId = $(itemElement).attr("data-itemId");
		
		$.ajax({ 
			type: "POST",
			url: baseUrl + "order/setAllReady/bill/" + itemId,
			dataType: "json",
			success: function(data) {
				itemElement.find(".otevreny").each(function() {
					$(this).removeClass("otevreny");
					$(this).addClass("pripraveny");
				});
			}
		});
	});
	
	/* toggle menu item status */
	$("#ordersList").on("click", ".ordersList-foodState", function() {
		let stateElement = $(this);
		let itemElement = $(this.closest(".menuList-item"));
		let itemId = $(itemElement).attr("data-itemId");
		let requestType = '';
		if($(this).hasClass("otevreny")) {
			requestType = "setReady";
		} else if($(this).hasClass("pripraveny")) {
			requestType = "setOpened";
		}
		
		$.ajax({
			type: "POST",
			url: baseUrl + "order/" + requestType + "/" + itemId,
			dataType: "json",
			success: function(data) {
				$(stateElement).removeClass("otevreny");
				$(stateElement).removeClass("pripraveny");
				if(requestType === "setReady") {
					$(stateElement).addClass("pripraveny");
				} else {
					$(stateElement).addClass("otevreny");
				}
			}
		});
	});
	
	/* set all menu items in order as done */
	$("#ordersList").on("click", ".button-done", function() {
		let itemElement = $(this.closest(".ordersList-item"));
		let itemId = $(itemElement).attr("data-itemId");
		
		$.ajax({
			type: "POST",
			url: baseUrl + "order/setAllClosed/bill/" + itemId,
			dataType: "json",
			success: function(data) {
				$(itemElement).remove();
			}
		});
	});
});
