package com.zacharadamian.fibonacciapp.services;

import com.zacharadamian.fibonacciapp.model.HistoryEntry;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class FibonacciService {

    public HistoryEntry calculateSequence(long param) {
        Long result;
        Long fib1 = 0L, fib2 = 1L;
        for (long i = 2; i < param; i++) {
            result = fib1;
            fib1 = fib2;
            fib2 = fib2 + result;
        }
        result = fib1 + fib2;
        HistoryEntry historyEntry = new HistoryEntry(new Date().toString(), param, result);
        return historyEntry;
    }
}
