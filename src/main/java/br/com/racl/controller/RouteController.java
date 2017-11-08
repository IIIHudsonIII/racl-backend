package br.com.racl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.racl.model.Route;
import br.com.racl.repository.RouteRepository;

@Component
public class RouteController {

	@Autowired
	private RouteRepository routeRepository;

	public Route save(Route master) {
		return routeRepository.save(master);
	}

	public List<Route> list() {
		return routeRepository.findAll();
	}
	
	public Route findByName(String name) {
		return routeRepository.findByName(name);
	}
}
