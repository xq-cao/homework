package com.tw.xqcao.finder;

import com.tw.xqcao.Parkinglot;

import java.util.List;
import java.util.Optional;

public class CommonFinder implements Finder {

    @Override
    public Optional<Parkinglot> findBestParkinglot(List<Parkinglot> parkinglots1) {
        return parkinglots1.stream()
                .filter(parkinglot -> parkinglot.leftSpaceCount() > 0)
                .findFirst();
    }
}