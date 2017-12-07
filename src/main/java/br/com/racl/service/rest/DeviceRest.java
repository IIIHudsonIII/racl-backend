package br.com.racl.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.racl.controller.DeviceController;
import br.com.racl.model.Device;

@RestController
@RequestMapping("/device")
@CrossOrigin(origins = "*") // Evita problemas de consistência de segurança em navegadores (como o Chrome)
public class DeviceRest {

	@Autowired
	private DeviceController deviceController;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Device save(@RequestBody Device device) {
		if (!device.validate()) {
			return null;
		}
		return deviceController.update(device);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Device> list() {
		try {
			return deviceController.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}

	@RequestMapping(method = RequestMethod.GET, params = "id")
	public @ResponseBody Device findById(String id) {
		try {
			return deviceController.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteById(@RequestBody Device device) {
		try {
			deviceController.delete(device.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}
}
