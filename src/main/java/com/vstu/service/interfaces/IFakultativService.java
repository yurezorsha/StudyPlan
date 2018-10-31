package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Fakultativ;

public interface IFakultativService {

	List<Fakultativ> getAllFakultativ();

	List<Fakultativ> getAllByPlanId(Long id);

	Fakultativ getFakultativById(Long id);

	boolean addFakultativ(Fakultativ f);

	void updateFakultativ(Fakultativ f);

	void deleteFakultativ(Long id);

	boolean existsFakultativ(Long id);
}
