package com.tw.xqcao.finder;

import com.tw.xqcao.Parkinglot;

import java.util.List;
import java.util.Optional;

public interface Finder {
    Optional<Parkinglot> findBestParkinglot(List<Parkinglot> parkinglots1);
}
