package com.zacharadamian.fibonacciapp.controllers;

import com.zacharadamian.fibonacciapp.model.HistoryEntry;
import com.zacharadamian.fibonacciapp.repositories.HistoryEntryRepository;
import com.zacharadamian.fibonacciapp.services.FibonacciServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FibonacciController {

    private FibonacciServices fibonacciServices;
    private HistoryEntryRepository historyEntryRepository;

    public FibonacciController(FibonacciServices fibonacciServices, HistoryEntryRepository historyEntryRepository) {
        this.fibonacciServices = fibonacciServices;
        this.historyEntryRepository = historyEntryRepository;
    }

    @RequestMapping(value = {"/"})
    public String convert(@RequestParam(name = "number", required=false) Long param) {
        if (param != null){
            if (param != 0) {
                HistoryEntry historyEntry = fibonacciServices.calculateSequence(param);
                historyEntryRepository.save(historyEntry);
            }
        }
// opcional java
        return "convert";
    }

   @RequestMapping(value = "/history")
    public String getHistory(Model model){
        model.addAttribute("history", historyEntryRepository.findAll());
        return "history";
    }

}
// przekierowanie do strony początkowej
// zainicjowanie obiektu na nowo po wczesniejszym usunięciu go

