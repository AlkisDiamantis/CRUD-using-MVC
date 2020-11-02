/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypkg.trainersAssignment.service;

import com.mypkg.trainersAssignment.model.Trainer;
import com.mypkg.trainersAssignment.repository.TrainerRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImplimentation implements TrainerServiceInterface {

    @Autowired
    TrainerRepository trainerRepository;

    @Transactional
    @Override
    public void insertTrainer(Trainer t) {

        trainerRepository.save(t);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public void deleteTrainer(int trainerid) {
        trainerRepository.deleteById(trainerid);
    }



    @Override
    public List<Trainer> searchTrainers(String name) {
        return trainerRepository.getthetrainers(name);
    }

    @Override
    public Trainer findById(int id) {
        
       return trainerRepository.findById(id).get();
    }

}
