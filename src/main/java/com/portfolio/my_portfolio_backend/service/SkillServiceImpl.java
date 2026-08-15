package com.portfolio.my_portfolio_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.my_portfolio_backend.exception.ValidationException;
import com.portfolio.my_portfolio_backend.model.Skill;
import com.portfolio.my_portfolio_backend.repository.ISkillRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService {

    private final ISkillRepository skillRepository;
    private final Validator validator;

    @Override
    @Transactional(readOnly = true)
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Skill save(Skill skill) {
        Set< ConstraintViolation<Skill> > violations = validator.validate(skill);

        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }

        if (skill.getLevelPercentage() < 0 || skill.getLevelPercentage() > 100) {
            throw new IllegalArgumentException("El porcentaje es incorrecto debe estar entre 0  y 100");
        }

        return skillRepository.save(skill);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    @Transactional( readOnly = true )
    public List<Skill> findSkillByPersonalInfoId(Long personalInfoId) {
        return skillRepository.findByPersonalInfoId(personalInfoId);
    }

}
