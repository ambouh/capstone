package com.capstoneproject.capstoneproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT * FROM TRANSACTION WHERE PERSON_ID = :person_id " +
            "AND TRANSACTION_ID = :transaction_id", nativeQuery = true)
    String viewTransaction(@Param("person_id") Integer person_id, @Param("transaction_id") long transaction_id);

    @Query(value = "SELECT TRANSACTION_MERCHANT, TRANSACTION_AMOUNT, TRANSACTION_MEMO, TRANSACTION_CATEGORY, TRANSACTION_TYPE, TRANSACTION_ID FROM TRANSACTION WHERE PERSON_ID = :person_id", nativeQuery = true)
    List<String> getAllTransactionHistoryByID(@Param("person_id") Integer person_id);

    @Query(value = "SELECT TRANSACTION_CATEGORY, TRANSACTION_TYPE, TRANSACTION_DATE, TRANSACTION_AMOUNT FROM TRANSACTION WHERE PERSON_ID = :person_id " +
            "ORDER BY TRANSACTION_DATE ASC", nativeQuery = true)
    String getAllTransactionHistoryByIDAscending(@Param("person_id") Integer person_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRANSACTION SET TRANSACTION_CATEGORY = :transaction_category WHERE PERSON_ID = :person_id AND TRANSACTION_ID = :transaction_id", nativeQuery = true)
    String updateTransactionCategory(@Param("transaction_category") String transaction_category,
                                        @Param("person_id") Integer person_id,
                                            @Param("transaction_id") long transaction_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRANSACTION SET TRANSACTION_DATE = :transaction_date WHERE PERSON_ID = :person_id AND TRANSACTION_ID = :transaction_id", nativeQuery = true)
    String updateTransactionDate(@Param("transaction_date") String transaction_date,
                                    @Param("person_id") Integer person_id,
                                        @Param("transaction_id") long transaction_id );
    @Modifying
    @Transactional
    @Query(value = "UPDATE TRANSACTION SET TRANSACTION_AMOUNT = :transaction_amount WHERE PERSON_ID = :person_id AND TRANSACTION_ID = :transaction_id", nativeQuery = true)
    String updateTransactionAmount(@Param("transaction_amount") Double transaction_amount,
                                        @Param("person_id") Integer person_id,
                                            @Param("transaction_id") long transaction_id );

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TRANSACTION (TRANSACTION_AMOUNT,PERSON_ID,TRANSACTION_ID,TRANSACTION_DATE,TRANSACTION_TYPE,TRANSACTION_CATEGORY,TRANSACTION_MEMO,TRANSACTION_MERCHANT,TRANSACTION_ACCOUNT_ID)"+
                    " VALUES (:transaction_amount,:person_id,:transaction_id,:transaction_date,:transaction_type,:transaction_category,:transaction_memo,:transaction_merchant,:transaction_account_id)", nativeQuery = true)
    int addTransaction(@Param("transaction_amount") Double transaction_amount, @Param("person_id") int person_id, @Param("transaction_id") long transaction_id,
                       @Param("transaction_date") String transaction_date, @Param("transaction_type") String transaction_type,
                       @Param("transaction_category") String transaction_category, @Param("transaction_memo") String transaction_memo,
                       @Param("transaction_merchant") String transaction_merchant, @Param("transaction_account_id") int transaction_account_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TRANSACTION WHERE TRANSACTION_ID = :transaction_id AND PERSON_ID = :person_id", nativeQuery = true)
    int removeTransaction(@Param("person_id") int person_id,@Param("transaction_id") long transaction_id);
}
