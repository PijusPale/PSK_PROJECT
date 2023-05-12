package com.psk.eshop.service;

import com.psk.eshop.dto.StatisticRequestDTO;
import com.psk.eshop.model.Statistic;

import java.util.List;

public interface StatisticService {
    Statistic createStatistic(StatisticRequestDTO statisticRequest);
    Statistic updateStatistic(Long statisticId, StatisticRequestDTO statisticRequest);
    Statistic getStatisticById(Long statisticId);
    List<Statistic> getStatistics();
}
