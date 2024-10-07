package com.daupa.jobapp.company.impl;

import com.daupa.jobapp.company.Company;
import com.daupa.jobapp.company.CompanyRepository;
import com.daupa.jobapp.company.CompanyService;
import com.daupa.jobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company updatedCompany = companyOptional.get();
            updatedCompany.setName(updatedCompany.getName());
            updatedCompany.setDescription(updatedCompany.getDescription());
            updatedCompany.setJobs(updatedCompany.getJobs());
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }
}
