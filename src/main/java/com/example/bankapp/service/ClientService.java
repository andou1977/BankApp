package com.example.bankapp.service;

import com.example.bankapp.entity.ClientEntity;
import com.example.bankapp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity addclient(ClientEntity clientEntity){
        return clientRepository.save(clientEntity);
    }

    public ClientEntity updateclient(ClientEntity clientEntity) {
        ClientEntity entity = clientRepository.getReferenceById(clientEntity.getId());
        entity.setNomClient(clientEntity.getNomClient());
        entity.setAge(clientEntity.getAge());
        entity.setDate(clientEntity.getDate());
        entity.setComptes(clientEntity.getComptes());
        return clientRepository.save(entity);
    }

    public List<ClientEntity> lister(){
        return clientRepository.findAll();
    }
    public Optional<ClientEntity> listbyid(int id){
        return clientRepository.findById(id);
    }

    public void deleteclient(int id){
        clientRepository.deleteById(id);
    }

    public int factoriel(int id){
        ClientEntity clientEntity=clientRepository.findById(id).orElse(null);
        int fact=fact(clientEntity.getAge());
        return fact;
    }

    public int fact(int n){
        if(n<=1){
            return n;
        }
        return n*fact(n-1);

    }

    public ClientEntity savebyid(int id,String nomclient,int age){
        ClientEntity entity =clientRepository.findById(id).orElse(null);
        if(entity!=null){
            entity.setNomClient(nomclient);
            entity.setAge(age);
            entity.setDate(new Date());
        }
        else{
            entity=new ClientEntity();
            entity.setId(id);
            entity.setNomClient(nomclient);
            entity.setAge(age);
            entity.setDate(new Date());
        }
        return clientRepository.save(entity);
    }

  public ClientEntity saveavecinfo(String nomclient,int age){
        ClientEntity entity=new ClientEntity();
        entity.setNomClient(nomclient);
        entity.setAge(age);
        entity.setDate(new Date());
       return clientRepository.save(entity);
  }

  public ClientEntity updatesave(int id,String nomclient,int age){
        ClientEntity entity = clientRepository.findById(id).orElse(null);

        if(entity!=null){
            entity.setNomClient(nomclient);
            entity.setAge(age);
            entity.setDate(new Date());
        }else{
            entity=new ClientEntity();
            entity.setId(id);
            entity.setNomClient(nomclient);
            entity.setAge(age);
            entity.setDate(new Date());
        }
        return clientRepository.save(entity);
  }



}


