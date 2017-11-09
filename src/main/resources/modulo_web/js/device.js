	$("form").submit(function(event) {
		event.preventDefault();
	});
	
	var save = function(event) {
		if (validate()) {
			var data = JSON.stringify({
				id: $("#id").val(),
				name: $("#name").val(),
				information: $("#information").val()
			});
			post(DIRECTION_DEVICE, data);
			
			//location.reload();
		}
	}
	
	var callbackGET = function(devices) {
		if (devices) {
			$.each(devices, function(i, device) {
				console.log(device);
				
				var information = device.name + " - " + device.information;
				$('<option value="' + device.id + '" title="' + information + '" '
					+ ' data-id="' + device.id + '" '
					+ ' data-name="' + device.name + '" '
					+ ' data-information="' + device.information + '">' + device.id
					+ '</option>').appendTo( $("select#devices") );
			});
		}
	}

	$(document).ready(function () {
		$("#BTN_ADD,#BTN_UPDATE").on("click", save);
		
		$("#BTN_DELETE").on("click", function(event) {
			del(DIRECTION_DEVICE, JSON.stringify({ id: $("#id").val() }) );
		});
	
		$("select#devices").on("change", function() {
			var option = $(this).children().filter("option:selected");
			
			if (option.val()) {
			
				$("#BTN_ADD,#id").prop("disabled", "disabled");
				$("#BTN_UPDATE,#BTN_DELETE").prop("disabled", "");
				
				$.each($('.field'), function() {
					var id = $(this).prop("id");
					var value = option.data(id);
					$(this).val( value );
				});
				
			} else {
			
				$("#BTN_ADD,#id").prop("disabled", "");
				$("#BTN_UPDATE,#BTN_DELETE").prop("disabled", "disabled");
				$('.field').val("");
				
			}
		}).change();
		
		get(DIRECTION_DEVICE, null, callbackGET);
	});