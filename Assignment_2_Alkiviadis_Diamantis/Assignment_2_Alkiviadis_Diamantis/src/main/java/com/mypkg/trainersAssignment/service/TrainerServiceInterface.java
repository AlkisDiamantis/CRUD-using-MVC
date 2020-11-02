package com.mypkg.trainersAssignment.service;

import com.mypkg.trainersAssignment.model.Trainer;
import java.util.List;
import java.util.Optional;

public interface TrainerServiceInterface {

    public void insertTrainer(Trainer t);

    public List<Trainer> getAllTrainers();

    public void deleteTrainer(int trainerid);

    public Trainer findById(int id);

    public List<Trainer> searchTrainers(String name);

}
