package model.services;

import model.entities.Departament;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List<Departament> findAll(){
        List<Departament> list = new ArrayList<>();
        list.add(new Departament(1,"Books"));
        list.add(new Departament(2,"Computters"));
        list.add(new Departament(3,"Electronics"));

        return list;
    }

}
