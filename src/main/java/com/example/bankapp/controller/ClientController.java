package com.example.bankapp.controller;

import com.example.bankapp.entity.ClientEntity;
import com.example.bankapp.repository.ClientRepository;
import com.example.bankapp.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/client")

public class ClientController {

    ClientRepository clientRepository;
    ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ClientEntity saveclient(ClientEntity entity){
        return clientService.addclient(entity);
    }


    @PutMapping("/update")
    public ClientEntity updateclient(ClientEntity entity){
        return clientService.updateclient(entity);
    }

    @GetMapping("/listall")
    public List<ClientEntity> lister(){
        return clientService.lister();
    }

    @GetMapping("/list/{id}")
    public Optional<ClientEntity> listebyid(@PathVariable int id){
        return  clientService.listbyid(id);
    }
    @GetMapping("/delete/{id}")
    public void deletebyid(int id){
        clientService.deleteclient(id);
    }

    @GetMapping("/factoriel/{id}")
        public int factoriel(int id){
         return   clientService.factoriel(id);
        }

        @PostMapping("all/{id}")
    public ClientEntity savebyid(int id,String nomclient,int age){
        return clientService.savebyid(id,nomclient,age);
        }


        @PostMapping("/savewithinfo")
public ClientEntity save(String nomclient,int age){
        return clientService.saveavecinfo(nomclient,age);
        }

        @PostMapping("/updatesave/{id}")
        public ClientEntity updatesave(int id,String nomclient,int age){
        return clientService.updatesave(id,nomclient,age);
        }
    @PutMapping("/depot/{id}")
    public ClientEntity depot(@RequestParam int id,double montant){
        ClientEntity depot=clientRepository.findById(id).orElse(null);
        depot.setCompte(depot.getCompte()+montant);
      return   clientRepository.save(depot);
    }

    @GetMapping("/search")
    public List<ClientEntity>mysearch(String nomclient) {
        return clientRepository.findByNomClientStartsWith(nomclient);
    }

    }


