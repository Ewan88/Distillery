package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    List<Whisky> getWhiskyFromDistilleryByAge(String distillery, int age);

    List<Whisky> getWhiskyFromRegion(String region);

}
