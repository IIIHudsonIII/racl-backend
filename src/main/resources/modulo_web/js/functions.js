if (!String.prototype.format) {
  String.prototype.format = function() {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function(match, number) { 
      return typeof args[number] != 'undefined' ? args[number] : match;
    });
  };
}

var DEFAULT_URL = "http://localhost:8080";

var DIRECTION_DEVICE = "/device";
var DIRECTION_ROUTE = "/route";

var validate = function(id) {
	var response = true;
	var query = $(".field.mandatory");
	if (id) {
		query = $("#" + id).find(".mandatory");
	}
	$.each($(query), function() {
		var value = $(this).val() || $(this).val().replace(" ","") || this.innerText;
		if (!value) {
			var description = $('label[for*=' + $(this).prop("id") + ']').first().text().trim();
			alert("Informar '" + description + "' !");
			return response = false;
		}
	});
	return response;
}

// del(DIRECTION_DEVICE, [{key: "id", value: "1"}]);
function del(direction, data) {
	var listener = function () {
	  if (this.readyState == 4) {
		  if (this.status == 200) {
			console.log("success DELETE");
			console.log(this.responseText);
			
			location.reload();
		  } else {
			console.log("error DELETE");
		  }
	  }
	}

	var url = DEFAULT_URL + direction;
	console.log("DELETE >>> " + url);
	send("DELETE", url, listener, data);
}

// post(DIRECTION_DEVICE, data);	
function post(direction, data) {
	var listener = function () {
	  if (this.readyState == 4) {
		  if (this.status == 200) {
			console.log("success POST");
			console.log(this.responseText);
			
			location.reload();
		  } else {
			console.log("error POST");
		  }
	  }
	}

	var url = DEFAULT_URL + direction;
	console.log("POST >>> " + url);
	send("POST", url, listener, data);
}

// get(DIRECTION_DEVICE, [{key: "id", value: "1"}]);
function get(direction, parameters, callback) {
	var listener = function () {
	  if (this.readyState == 4) {
		  if (this.status == 200) {
			console.log("success GET");
			if (callback) {
				callback(JSON.parse(this.response));
			} else {
				console.log(this.responseText);
			}
		  } else {
			console.log("error GET");
		  }
	  }
	}

	var url = evaluatedUrl(DEFAULT_URL + direction, parameters);
	console.log("GET >>> " + url);
	send("GET", url, listener);
}

function send(method, url, listener, data) {
	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;
	
	if (listener) {
		xhr.addEventListener("readystatechange", listener);
	}

	xhr.open(method, url, true, 'admin', 'admin');
	xhr.setRequestHeader('Accept', 'application/json, text/javascript'); 
	xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
	xhr.setRequestHeader("content-type", "application/json", "text/javascript");
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token", "6ec4f59e-1a02-5df4-e002-eb1b1de56ddb");
	xhr.send(data);
}

function evaluatedUrl(url, parameters) {
	if (parameters) {
		url += "?";
		
		if (!parameters.length) {
			url += parameters.key + "=" + parameters.value;
		} else if (parameters.length > 0) {
			var parameter;
			for (i = 0; i < parameters.length; i++) {
				parameter = parameters[i];
				url += parameter.key + "=" + parameter.value;
			}
		}
	}
	return url;
}