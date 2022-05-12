package ea.lab.exercise_16.client.controller;

import ea.lab.exercise_16.client.model.Country;
import ea.lab.exercise_16.client.service.CountryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CountryController {

    @Autowired
    private CountryServiceClient service;

}
