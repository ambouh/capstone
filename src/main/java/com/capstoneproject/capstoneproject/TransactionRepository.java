package com.capstoneproject.capstoneproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT TRANSACTION_CATEGORY FROM TRANSACTION WHERE PERSON_ID = :person_id", nativeQuery = true)
    List<String> getAllTransactionHistoryByID(@Param("person_id") Integer person_id);

    @Query(value = "SELECT TRANSACTION_CATEGORY, TRANSACTION_TYPE, TRANSACTION_DATE FROM TRANSACTION WHERE PERSON_ID = :person_id " +
            "ORDER BY TRANSACTION_DATE ASC", nativeQuery = true)
    String getAllTransactionHistoryByIDAscending(@Param("person_id") Integer person_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRANSACTION SET TRANSACTION_CATEGORY = :transaction_category WHERE PERSON_ID = :person_id", nativeQuery = true)
    String updateTransactionCategory(@Param("transaction_category") String transaction_category,
                                        @Param("person_id") Integer person_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRANSACTION SET TRANSACTION_DATE = :transaction_date WHERE PERSON_ID = :person_id", nativeQuery = true)
    String updateTransactionDate(@Param("transaction_date") String transaction_date,
                                        @Param("person_id") Integer person_id);
}
