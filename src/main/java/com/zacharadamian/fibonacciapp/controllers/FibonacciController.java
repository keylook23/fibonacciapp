package com.zacharadamian.fibonacciapp.controllers;

import com.zacharadamian.fibonacciapp.model.HistoryEntry;
import com.zacharadamian.fibonacciapp.repositories.HistoryEntryRepository;
import com.zacharadamian.fibonacciapp.services.FibonacciService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FibonacciController {

    private FibonacciService fibonacciService;
    private HistoryEntryRepository historyEntryRepository;

    public FibonacciController(FibonacciService fibonacciService, HistoryEntryRepository historyEntryRepository) {
        this.fibonacciService = fibonacciService;
        this.historyEntryRepository = historyEntryRepository;
    }

    @RequestMapping(value = {"/"})
    public String convert(@RequestParam(name = "number", required = false) Long param) {
        if (param != null) {
            if (param != 0) {
                HistoryEntry historyEntry = fibonacciService.calculateSequence(param);
                historyEntryRepository.save(historyEntry);
            }
        }
        return "convert";
    }

    @RequestMapping(value = "/history")
    public String getHistory(Model model) {
        model.addAttribute("history", historyEntryRepository.findAll());
        return "history";
    }
}
