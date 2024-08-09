package com.keyin.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class AgencyService {
    @Autowired
    private AgencyRepository repo;
    private Agency current;
    public AgencyService() {}
    /**
     * @name    getAll
     * @desc    Get all agencies
     * @route   GET /api/agencies
     * @access  private
     */
    public List<Agency> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get an agency by its primary key
     * @route   GET /api/agencies/{pk}
     * @access  private
     */
    public Agency getByPk(long pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByName
     * @desc    Get an agency by its name
     * @route   GET /api/agencies/{name}
     * @access  private
     */
    public Agency getByName(String name) {
        return repo.findByName(name);
    }
    /**
     * @name    getByWebsite
     * @desc    Get an agency by its website
     * @route   GET /api/agencies/{website}
     * @access  private
     */
    public Agency getByWebsite(String website) {
        return repo.findByWebsite(website);
    }

    /**
     * @name    getActive
     * @desc    Get all active agencies
     * @route   GET /api/agencies/active
     * @access  private
     */
    public List<Agency> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive agencies
     * @route   GET /api/agencies/inactive
     * @access  private
     */
    public List<Agency> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add an agency
     * @route   POST /api/agencies
     * @access  private
     */
    public Agency add(Agency agency) {
        return repo.save(agency);
    }
    /**
     * @name    rename
     * @desc    Rename an agency
     * @route   PATCH /api/agencies/{pk}/name
     * @access  private
     */
    public Agency rename(
            long pk,
            String name
    ) {
        this.current = repo.findById(pk).get();
        current.setName(name);
        return repo.save(current);
    }
    /**
     * @name    editWebsite
     * @desc    Edit an agency's website address
     * @route   PATCH /api/agencies/{pk}/website
     * @access  private
     */
    public Agency editWebsite(
            long pk,
            String website
    ) {
        this.current = repo.findById(pk).get();
        current.setWebsite(website);
        return repo.save(current);
    }
}
