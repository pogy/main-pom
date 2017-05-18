package test.com.shigu.search.utils;

import org.junit.Test;

import java.util.Random;

/**
 * Created by zhaohongbo on 17/5/18.
 */
public class T {
    @Test
    public void t(){
        Random random = new Random();
        for(int i=0;i<100;i++){
            System.out.println(random.nextInt(3));
        }
    }
}
