package com.arminzheng.spi;

/**
 * SpiServiceImpl
 *
 * @author zy
 * @version 2022/4/12
 */
public class SpiServiceImpl implements SpiService {
    @Override
    public void execute() {
        System.out.println("hello spi");
    }
}
