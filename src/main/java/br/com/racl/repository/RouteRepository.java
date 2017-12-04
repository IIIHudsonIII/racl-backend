package br.com.racl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.racl.model.Route;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {

	public Route findByName(String name);
}
