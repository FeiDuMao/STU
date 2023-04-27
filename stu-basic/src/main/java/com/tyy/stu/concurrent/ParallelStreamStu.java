package com.tyy.stu.concurrent;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamStu {


    private List<String> fakeData;

    @BeforeEach
    public void init() {

        fakeData = IntStream.range(0, 10000).boxed().map(Object::toString).collect(Collectors.toList());
    }


}
