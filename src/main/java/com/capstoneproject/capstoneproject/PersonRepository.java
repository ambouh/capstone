package com.capstoneproject.capstoneproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT CHECKING_BALANCE FROM PERSON", nativeQuery = true)
    public int getCheckingBalance();

    @Query(value = "SELECT SAVINGS_BALANCE FROM PERSON", nativeQuery = true)
    public int getSavingsBalance();

    @Query(value = "SELECT TOTAL_BALANCE FROM PERON", nativeQuery = true)
    public int getTotalBalance();

}
