package service.impl;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IProvinceRepo;
import service.ProvinceServiceInterface;

import java.util.List;
import java.util.Optional;


public class ProvinceService implements ProvinceServiceInterface {
    @Autowired
    IProvinceRepo iProvinceRepo;

    @Override
    public List<Province> findAll() {
        return (List<Province>) iProvinceRepo.findAll();
    }

    @Override
    public void save(Province province) {
        iProvinceRepo.save(province);
    }

    public ProvinceService(IProvinceRepo iProvinceRepo) {
        this.iProvinceRepo = iProvinceRepo;
    }

    public ProvinceService() {
    }

    @Override
    public void remove(String name) {

    }

    @Override
    public Optional<Province> findByName(String name) {
        return iProvinceRepo.findById(name);
    }

}
