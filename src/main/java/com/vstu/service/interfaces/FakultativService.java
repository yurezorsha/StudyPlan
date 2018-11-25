package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Fakultativ;

public interface FakultativService {

	List<Fakultativ> getAllFakultativ();

	List<Fakultativ> getAllByPlanId(Long id);

	Fakultativ getFakultativById(Long id);

	Fakultativ addFakultativ(Fakultativ f);

	Fakultativ updateFakultativ(Fakultativ f);

	void deleteFakultativ(Long id);

	boolean existsFakultativ(Long id);
}
