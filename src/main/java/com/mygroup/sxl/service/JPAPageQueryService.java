package com.mygroup.sxl.service;

import java.util.List;

@FunctionalInterface
public interface JPAPageQueryService<E> {

    List<E> getData(int current, int size);
}
