package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Fakultativ;

public interface FakultativService {

	List<Fakultativ> getAllByPlanId(Long id);

	Fakultativ getFakultativById(Long id);

	List<Fakultativ> addListFakultativByPlanId(Long id, List<Fakultativ> f);

	List<Fakultativ> updateListFakultativByPlanId(Long id, List<Fakultativ> f);

	void deleteFakultativ(Long id);

	boolean existsFakultativ(Long id);
}
