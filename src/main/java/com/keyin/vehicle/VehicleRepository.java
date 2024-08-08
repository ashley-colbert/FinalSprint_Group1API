package com.keyin.vehicle;

import com.keyin.agency.Agency;
import com.keyin.location.Location;
import com.keyin.rental.Rental;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    List<Vehicle> findAllByManufacturer(String manufacturer);
    List<Vehicle> findAllByModel(String model);
    List<Vehicle> findAllByYear(int year);
    List<Vehicle> findAllByCapacity(int capacity);
    List<Vehicle> findAllByCategory(String category);
    List<Vehicle> findAllByStdRate(float stdRate);
    List<Vehicle> findAllByPremRate(float premRate);
    List<Vehicle> findAllByStdIns(float stdIns);
    List<Vehicle> findAllByPremIns(float premIns);
    Vehicle findByPlates(String plates);
    List<Vehicle> findAllByAgency(Agency agency);
    List<Vehicle> findAllByLocation(Location location);
//    Vehicle findByRental(Rental rental);
    List<Vehicle> findAllByRented(boolean rented);
    List<Vehicle> findAllByActive(boolean active);
    @Query("SELECT v FROM Vehicle v WHERE v.stdRate < :max")
    List<Vehicle> findAllWithStdUnder(@Param("max") float max);
    @Query("SELECT v FROM Vehicle v WHERE v.premRate < :max")

    List<Vehicle> findAllWithPremUnder(@Param("max") float max);
    List<Vehicle> findByCategoryAndAgencyPkAndManufacturerAndModel(
            String category, Long agency_pk, String manufacturer, String model);

    List<Vehicle> findByCategoryAndAgencyPk(String category, Long agency_pk);

    List<Vehicle> findByCategoryAndAgencyPkAndManufacturer(
            String category, Long agency_pk, String manufacturer);

    List<Vehicle> findByCategoryAndAgencyPkAndModel(
            String category, Long agency_pk, String model);

    List<Vehicle> findByAgencyAndCategory(Agency agency, String category);
}
