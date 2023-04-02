package com.bilgeadam.service.JoinServices;

import com.bilgeadam.entity.JoinEntities.DateNameBrandCompany;

import com.bilgeadam.repository.JoinRepositories.IDateNameBrandCompany;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateNameBrandCompanyService extends ServiceManager<DateNameBrandCompany, Long> {
    private final IDateNameBrandCompany dateNameBrandCompany;

    public DateNameBrandCompanyService(IDateNameBrandCompany dateNameBrandCompany) {
        super(dateNameBrandCompany);
        this.dateNameBrandCompany = dateNameBrandCompany;
    }

    public List<DateNameBrandCompany> findDateNameBrandCompany() {
        List<DateNameBrandCompany> dnbc = dateNameBrandCompany.findDateNameBrandCompany();
        return dnbc;
    }
}
