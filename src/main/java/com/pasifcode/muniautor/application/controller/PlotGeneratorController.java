package com.pasifcode.muniautor.application.controller;

import com.pasifcode.muniautor.domain.entity.AiAnswer;
import com.pasifcode.muniautor.domain.entity.AiQuestion;
import com.pasifcode.muniautor.service.PlotGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlotGeneratorController {

    @Autowired
    private PlotGeneratorService plotGeneratorService;

    @GetMapping("/generate-plot")
    public AiAnswer generatePlot(@RequestParam(value="question", defaultValue = "") String question) {
        return plotGeneratorService.generatePlot(new AiQuestion(question));
    }
}
