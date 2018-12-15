/**
 * @file File containing all neccessaty methods to generate HTML and manipulate with page's HTML content
 * @author Lukáš Chalupa <chaluluk@fit.cvut.cz>
 */

/**
 * variable contaning base URL the project runs on.
 * CHANGE THIS TO WHATEVER DOMAIN THE PROJECT RUNS ON!
 */
let baseUrl = "http://localhost:8080/"

/**
 *  function that calls increaseTimer() every second
 */
let timer = function() {
	setInterval("increaseTimer()", 1000);
}

/**
 * Adds one second to all HTML elements with "orderList-item" class
 */
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

/**
 * Function that creates new list item HTML of one specific menu item
 * @return menu item HTML
 */
let createMenuItemHtml = function(item) {
	let menuItemHtml =
		'<li data-id="' + item.id + '" class="menuList-item">'
		+	'<label class="menuList-label" for="item-' + item.id + '">' + item.nazev + ' <span class="menuList-price">(' + item.cena + 'Kč)</span></label>'
		+	'<input class="menuList-input" type="number" value=0 min="0" max="100" name="item-' + item.id + '">'
		+ '</li>';
	return menuItemHtml;
}

/**
 * Function that retrieves JSON with order items in specific order.
 * On request success, items are pushed to items array
 */
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

/**
 * Function that creates order HTML element based on recieved JSON containing order data.
 * Foods and drinks contained in an order are separated according to their category.
 * @param {object} item - one specific order item
 */
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

/**
 * Function that creates table select HTML element based on received table data
 * @param {object} item - JSON object containing id and table number
 */
let createTableOptionHtml = function(item) {
	return '<option class="table-option" value=' + item.id + '>' + item.cisloStolu + '</option>';
}

/**
 * GET request that receives JSON with all tables.
 * On success createTableOptionHtml() is called for each table
 */
let getAllTables = function() {
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
}
getAllTables();

/**
 * Receive items from all five categories. Creates menu item in given category HTML item on request success.
 * Needs improvement. Call request to get all categories first. This won't work if there aren't five categories
 */
let getMenuItems = function() {
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
}
getMenuItems();

/**
 * Request that reveives all opened bills. Calls createOrderItemHtml function on success
 */
let getOpenedBills = function() {
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
}
getOpenedBills();

/**
 * Post form data on form submit. Creates bill first, then links it with menu items
 */
let submitOrderForm = function() {
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
}
$(document).on('submit', '#orderForm', function(event) {
	submitOrderForm();
});


/**
 * Change status for all menu items in order to ready.
 * @param {HTMLElement} orderButtonElement - button HTML element
 */
let setAllReady = function(orderButtonElement) {
	let itemElement = $(orderButtonElement.closest(".ordersList-item"));
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
}

/**
 * Change status for all menu items in order to done.
 * @param {HTMLElement} orderButtonElement - button HTML element
 */
let setAllDone = function(orderButtonElement) {
	let itemElement = $(orderButtonElement.closest(".ordersList-item"));
	let itemId = $(itemElement).attr("data-itemId");
	
	$.ajax({
		type: "POST",
		url: baseUrl + "order/setAllClosed/bill/" + itemId,
		dataType: "json",
		success: function(data) {
			$(itemElement).remove();
		}
	});
}

/**
 * Toggle menu item status. From ready to opened or vice versa.
 * @param {HTMLElement} foodStateElement - HTML element showing menu item's state
 */
let toggleMenuItemStatus = function(foodStateElement) {
	let stateElement = $(foodStateElement);
	let itemElement = $(foodStateElement.closest(".menuList-item"));
	let itemId = $(itemElement).attr("data-itemId");
	let requestType = '';
	if($(foodStateElement).hasClass("otevreny")) {
		requestType = "setReady";
	} else if($(foodStateElement).hasClass("pripraveny")) {
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
}

$(document).ready(function() {
	timer();

	$("#ordersList").on("click", ".button-ready", function() {
		setAllReady(this);
	});
	
	$("#ordersList").on("click", ".ordersList-foodState", function() {
		toggleMenuItemStatus(this);
	});

	$("#ordersList").on("click", ".button-done", function() {
		setAllDone(this);
	});
});
