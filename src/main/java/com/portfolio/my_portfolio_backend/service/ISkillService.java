package com.portfolio.my_portfolio_backend.service;

import java.util.List;
import java.util.Optional;

import com.portfolio.my_portfolio_backend.model.Skill;

public interface ISkillService {
    List<Skill> findAll();
    Optional<Skill> findById(Long id);
    Skill save(Skill skill);
    void deleteById(Long id);
    List<Skill> findSkillByPersonalInfoId(Long personalInfoId);
}
