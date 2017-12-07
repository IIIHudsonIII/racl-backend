package br.com.racl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.racl.model.Device;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {

	Device findById(String id);
}
