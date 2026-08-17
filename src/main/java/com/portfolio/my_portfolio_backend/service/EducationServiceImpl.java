package com.portfolio.my_portfolio_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.my_portfolio_backend.exception.ValidationException;
import com.portfolio.my_portfolio_backend.model.Education;
import com.portfolio.my_portfolio_backend.repository.IEducationRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository educationRepository;
    private final Validator validator;


    @Override
    @Transactional(readOnly = true)
    public List<Education> findAll() {
        return educationRepository.findAll();    
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    @Transactional
    public Education save(Education education) {
        Set<ConstraintViolation<Education>> results = validator.validate(education);

        if (!results.isEmpty()) {
            throw new ValidationException(results);
        }

        // if (education.getStartDate() == null) {
        //     throw new IllegalArgumentException("La fecha de inicio de la educacion no puede estar vacia");
        // }  

        // if (education.getEndDate() != null && education.getStartDate().isAfter(education.getEndDate())) {
        //     throw new IllegalArgumentException("La fecha de inicio de la educacion no puede ser posterior a la fecha de fin");
        // }

        return educationRepository.save(education);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        System.out.println("Eliminando decucación por ID: " + id + "en el servicio...");
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> findEducationByPersonalInfoId(Long personalInfoId) {
        return educationRepository.findByPersonalInfoId(personalInfoId);
    }

}
