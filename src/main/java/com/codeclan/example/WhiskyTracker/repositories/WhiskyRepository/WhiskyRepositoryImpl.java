package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Autowired
    DistilleryRepository distilleryRepository;

    @Transactional
    public List<Whisky> getWhiskyFromDistilleryByAge(String distillery, int age){
        List<Distillery> distilleries = distilleryRepository.getDistilleryByName(distillery);
        List<Whisky> whiskies = distilleries.get(0).getWhiskies();
        List<Whisky> results = new ArrayList<Whisky>();
        for (Whisky whisky : whiskies){
            if (whisky.getAge() == age){
                results.add(whisky);
            }
        }
        return results;
    }

    @Transactional
    public List<Whisky> getWhiskyFromRegion(String region){
        List<Distillery> distilleries = distilleryRepository.getDistilleryByRegion(region);
        return distilleries.get(0).getWhiskies();
    }

}
