package com.zacharadamian.fibonacciapp.repositories;


import com.zacharadamian.fibonacciapp.model.HistoryEntry;
import org.springframework.data.repository.CrudRepository;

public interface HistoryEntryRepository extends CrudRepository<HistoryEntry, Long> {
}
