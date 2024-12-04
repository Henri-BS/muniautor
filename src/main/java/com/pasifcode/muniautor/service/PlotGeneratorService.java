package com.pasifcode.muniautor.service;


import com.pasifcode.muniautor.domain.entity.AiAnswer;
import com.pasifcode.muniautor.domain.entity.AiQuestion;

public interface PlotGeneratorService {
    AiAnswer generatePlot(AiQuestion question);
}
