package br.com.racl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import br.com.racl.model.Device;
import br.com.racl.repository.DeviceRepository;

@Controller
@Component
public class DeviceController {

	@Autowired
	private DeviceRepository deviceRepository;

	public Device insert(Device device) {
		return deviceRepository.insert(device);
	}
	
	public Device update(Device device) {
		return deviceRepository.save(device);
	}

	public void delete(String id) {
		deviceRepository.delete(id);
	}

	public List<Device> list() {
		return deviceRepository.findAll();
	}

	public Device findById(String id) {
		return deviceRepository.findById(id);
	}
}
