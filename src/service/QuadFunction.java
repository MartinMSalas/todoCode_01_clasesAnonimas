package service;

/*
 * Author: M
 * Date: 13-Mar-26
 * Project Name: Clases Anonimas
 * Description: beExcellent
 */
@FunctionalInterface
public interface QuadFunction<A,B,C,D,R> {
    public R apply(A a, B b, C c, D d);
}
