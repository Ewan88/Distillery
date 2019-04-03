package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @Transactional
    public List<Distillery> getDistilleriesWith12YearOldWhisky(){
        List<Distillery> results = new ArrayList<Distillery>();
        List<Distillery> distilleries = distilleryRepository.findAll();
        for (Distillery distillery : distilleries){
            List<Whisky> whiskies = distillery.getWhiskies();
            for (Whisky whisky : whiskies){
                if (whisky.getAge() == 12){
                    results.add(distillery);
                }
            }
        }
        return results;
    }


}
