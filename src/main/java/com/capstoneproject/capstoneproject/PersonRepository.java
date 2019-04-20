package com.capstoneproject.capstoneproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT CHECKING_BALANCE FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    int getCheckingBalanceFromFirstUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT SAVINGS_BALANCE FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    int getSavingsBalanceFromFirstUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT TOTAL_BALANCE FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    int getTotalBalanceFromUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT USERNAME FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    String getUsernameFromFirstUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT NUMBER_OF_WITHDRAWALS FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    int getTotalWithdrawalsFromUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT NUMBER_OF_DEPOSITS FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    int getTotalDepositsFromUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT NUMBER_OF_TRANSFERS FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    int getTotalTransfersFromUser(@Param("person_id") Integer person_id);

    @Query(value = "SELECT PASSWORD FROM PERSON WHERE PERSON_ID = :person_id", nativeQuery = true)
    String getPasswordFromFirstUSer(@Param("person_id") Integer person_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PERSON SET TOTAL_BALANCE = :total_balance WHERE PERSON_ID = :person_id", nativeQuery = true)
    int updateTotalBalanceForUser(@Param("total_balance") Integer total_balance, @Param("person_id") Integer person_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PERSON SET NUMBER_OF_DEPOSITS = :number_of_deposits WHERE PERSON_ID = :person_id", nativeQuery = true)
    int updateTotalNumberOfDeposits(@Param("number_of_deposits") Integer number_of_deposits, @Param("person_id") Integer person_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PERSON SET NUMBER_OF_WITHDRAWALS = :number_of_withdrawals WHERE PERSON_ID = :person_id", nativeQuery = true)
    int updateTotalNumberOfWithdrawals(@Param("number_of_withdrawals") Integer number_of_withdrawals, @Param("person_id") Integer person_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PERSON SET NUMBER_OF_TRANSFERS = :number_of_transfers WHERE PERSON_ID = :person_id", nativeQuery = true)
    int updateTotalNumberOfTransfers(@Param("number_of_transfers") Integer number_of_transfers, @Param("person_id") Integer person_id);


}
