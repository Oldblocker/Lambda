/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author Luke
 */
public class LambdaApp
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<Integer> lst = new ArrayList<>();
        int num = 10;
        Random r = new Random();
        generate(lst, num,() -> r.nextInt());
        print(lst, l -> System.out.println(l));
        System.out.println(" ");
        remove(lst, x -> x%2 == 0);
        print(lst, l -> System.out.println(l));
    }
    
    private static <T> void generate(List<T> l, int n, Supplier<T> sup)
    {
        for(int i = 0; i < n; i++)
        {
            l.add(sup.get());
        }
    }
    
    private static <T> void print(List<T> l, Consumer<T> consumer)
    {
        for(T t: l)
        {
            consumer.accept(t);
        }
    }
    
    private static <T> void remove(List<T> l, Predicate<T> predicate)
    {
        Iterator<T> it = l.iterator();
        while(it.hasNext())
        {
            T tmp = it.next();
            if(predicate.test(tmp)) 
            {
                it.remove();
            }
        }
    }
}
