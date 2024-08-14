package com.joowon.spring.test.mvc.realtor.repository;

import org.apache.ibatis.annotations.Mapper;

import com.joowon.spring.test.mvc.realtor.domain.Realtor;
import com.joowon.spring.test.realEstate.domain.RealEstate;

@Mapper
public interface RealtorRepository {

	public int insertRealtor(Realtor realtor);
}
