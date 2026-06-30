package com.portfolio.my_portfolio_backend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.my_portfolio_backend.model.Skill;
import com.portfolio.my_portfolio_backend.service.ISkillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/skill")
public class SkillController {
    private final ISkillService skillService;

    public SkillController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> findAll() {
        return this.skillService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Skill> findById(@PathVariable Long id) {
        return this.skillService.findById(id);
    }

    @GetMapping("/personal-info/{id}")
    public List<Skill> findSkillsByPersonalInfoId(@PathVariable Long id) {
        return this.skillService.findSkillByPersonalInfoId(id);
    }

    @PostMapping
    public Skill save(@RequestBody Skill skill) {
        return this.skillService.save(skill);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill skill) {
        return this.skillService.save(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.skillService.deleteById(id);
    }
    
    
}
