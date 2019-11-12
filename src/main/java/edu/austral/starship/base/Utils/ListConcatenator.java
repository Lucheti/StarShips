package edu.austral.starship.base.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListConcatenator {
    public static<T> List<T> concatenate(List<T>... lists)
    {
        List<T> result = new ArrayList<>();
        Stream.of(lists).forEach(result::addAll);
        return result;
    }
}
