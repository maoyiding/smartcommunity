package com.service.Impl;

import com.domain.People;
import com.mapper.PeopleMapper;
import com.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maoyiding on 6/29/17.
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public boolean addCustomer(People people) {
        return this.peopleMapper.addCustomer(people);
    }

    @Override
    public boolean updataPeoplePasswordByPhone(People people) {
        return this.peopleMapper.updataPeoplePasswordByPhone(people);
    }

    @Override
    public People selectPeopleByPhone(People people) {
        return this.peopleMapper.selectPeopleByPhone(people);
    }

    @Override
    public List<People> selectPeople() {
        return this.peopleMapper.selectPeople();
    }
}
