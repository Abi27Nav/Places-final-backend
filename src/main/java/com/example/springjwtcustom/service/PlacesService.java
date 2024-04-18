package com.example.springjwtcustom.service;

import com.example.springjwtcustom.Exceptions.ResourceNotFoundException;
import com.example.springjwtcustom.entity.Places;
import com.example.springjwtcustom.repository.PlacesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesService  {
    private final PlacesRepository placesRepository;

    public PlacesService(PlacesRepository placesRepository) {
        super();
        this.placesRepository = placesRepository;
    }

    //Add places;
    public Places savePlaces(Places places){
        return placesRepository.save(places);
    }

    public Places getPlacesById(int id){
        return placesRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Places","ID",id));
    }

    public Places updatePlaces(Places places,int id){
        Places p = placesRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Places","ID", id));
        p.setName(places.getName());
        p.setCategory(places.getCategory());
        p.setEmail(places.getEmail());
        p.setAddress(places.getAddress());
        p.setReferenceNo(places.getReferenceNo());
        p.setCountry(places.getCountry());
        p.setState(places.getState());
        placesRepository.save(p);
        return p;
    }

    public void deletePlaces(int id){
        placesRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Places","ID",id));
        placesRepository.deleteById(id);
    }





    // Get all places
    public List<Places> getAllPlaces(){
        return placesRepository.findAll();
    }




}
