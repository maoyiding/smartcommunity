package com.service.Impl;

import com.domain.City;
import com.domain.Community;
import com.mapper.CommunityMapper;
import com.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maoyiding on 17-7-2.
 */
@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    CommunityMapper communityMapper;

    @Override
    public List<Community> getAllCommunityByCityId(int cityId) {
        return this.communityMapper.getAllCommunityByCityId(cityId);
    }

    @Override
    public boolean addCommunity(Community community) {
        return this.communityMapper.addCommunity(community);
    }
}
