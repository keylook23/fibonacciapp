package com.zacharadamian.fibonacciapp.services;

import com.zacharadamian.fibonacciapp.model.HistoryEntry;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class FibonacciServices {

    public HistoryEntry calculateSequence(long param) {
        Long result;
        Long fib0 = 0L, fib1 = 1L;

        for (long i = 2; i < param; i++) {
            result = fib0;
            fib0 = fib1;
            fib1 = fib1 + result;
        }
        result = fib0 + fib1;
        HistoryEntry historyEntry = new HistoryEntry(new Date().toString(), param, result);
        return historyEntry;
    }
}
