package com.tw.xqcao.finder;

import com.tw.xqcao.Parkinglot;

import java.util.List;
import java.util.Optional;

public class BestFinder implements Finder{

    @Override
    public Optional<Parkinglot> findBestParkinglot(List<Parkinglot> parkinglots) {
        return parkinglots.stream()
                .max((a, b) -> Double.compare(a.spaceRate(), b.spaceRate()));
    }
}