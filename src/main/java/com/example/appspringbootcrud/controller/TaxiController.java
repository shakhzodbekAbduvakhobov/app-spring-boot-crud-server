package com.example.appspringbootcrud.controller;

import com.example.appspringbootcrud.model.Taxi;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TaxiController {

    List<Taxi> taxiList = new ArrayList<>(Arrays.asList(
            new Taxi(1, "Nexia 2 ", "60A995BB", "Sarvar", "+998977476545"),
            new Taxi(2, "Nexia 2 ", "60A351BA", "Sherzod", "+998935684526"),
            new Taxi(3, "Nexia 2 ", "60A995BB", "Sarvar", "+998977476545")
    ));

    @RequestMapping(value = "/taxi", method = RequestMethod.GET)
    public List<Taxi> getAllTaxi(){
        return taxiList;
    }

    @RequestMapping(value = "/taxi/{id}", method = RequestMethod.GET)
    public Taxi getOneTaxi(@PathVariable Integer id){
        for (Taxi taxi : taxiList) {
            if (taxi.getId() == id){
                return taxi;
            }
        }
        return new Taxi();
    }

    @RequestMapping(value = "/taxi", method = RequestMethod.POST)
    public List<Taxi> addTaxi(@RequestBody Taxi taxi){

        for (Taxi taxi1 : taxiList) {
            if (taxi1.getDriverNumber().equals(taxi.getDriverNumber())){

                return new ArrayList<>();
            }
        }
            taxi.setId(taxiList.get(taxiList.size()-1).getId()+1);
            taxiList.add(taxi);
       return taxiList;
    }

    @RequestMapping(value = "taxi/{id}", method = RequestMethod.DELETE)
    public List<Taxi> deleteTaxi(@PathVariable Integer id){
        for (Taxi taxi : taxiList) {
            if (taxi.getId() == id){
                taxiList.remove(taxi);
                break;
            }
            return new ArrayList<>();
        }
        return taxiList;
    }

    @RequestMapping(value = "/taxi/{id}", method = RequestMethod.PUT)
    public List<Taxi> updateTaxi(@PathVariable Integer id,
                                 @RequestBody Taxi taxi){
        for (Taxi taxi1 : taxiList) {
            if (taxi1.getId() == id){
                taxi1.setCarName(taxi.getCarName());
                taxi1.setCarNumber(taxi.getCarNumber());
                taxi1.setDriverName(taxi.getDriverName());
                taxi1.setDriverNumber(taxi.getDriverNumber());
//                taxiList.add(taxi1);
                break;
            }
        }
        return taxiList;
    }
}
