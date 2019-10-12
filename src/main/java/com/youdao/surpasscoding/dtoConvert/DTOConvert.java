package com.youdao.surpasscoding.dtoConvert;

public interface DTOConvert<S,T> {

   T doForward(S s);
   S doBackward(T t);
}
