package com.bilgeadam.service.JoinServices;

import com.bilgeadam.entity.JoinEntities.DateNameBrandCompany;

import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.RentaCarException;
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
        if(dnbc.isEmpty()){
            throw new RentaCarException(ErrorType.CAR_NOT_FOUND);
        }
        return dnbc;
    }
}
