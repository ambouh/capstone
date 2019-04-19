package com.capstoneproject.capstoneproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT CHECKING_BALANCE FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    public int getCheckingBalanceFromFirstUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT SAVINGS_BALANCE FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    public int getSavingsBalanceFromFirstUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT TOTAL_BALANCE FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    public int getTotalBalanceFromFirstUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT USERNAME FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    public String getUsernameFromFirstUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT PASSWORD FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    public String getPasswordFromFirstUSer(@Param("person_id") Integer person_id);

}
