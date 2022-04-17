package com.arminzheng.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SpiMain
 *
 * @author zy
 * @version 2022/4/12
 */
public class SpiMain {

    public static void main(String[] args) {
        ServiceLoader<SpiService> loaders = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> it = loaders.iterator();
        while (it.hasNext()) {
            SpiService spiSer = it.next();
            spiSer.execute();
        }
    }
}
