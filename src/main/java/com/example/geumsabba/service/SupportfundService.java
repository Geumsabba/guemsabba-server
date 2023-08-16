package com.example.geumsabba.service;

import com.example.geumsabba.entity.Supportfund;
import com.example.geumsabba.repository.SupportfundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportfundService {
    private final SupportfundRepository supportfundRepository;

    @Autowired
    public SupportfundService(SupportfundRepository supportfundRepository) {
        this.supportfundRepository = supportfundRepository;
    }

    public List<Supportfund> getAllSupportfund() {

        return supportfundRepository.findAll();
    }


}
