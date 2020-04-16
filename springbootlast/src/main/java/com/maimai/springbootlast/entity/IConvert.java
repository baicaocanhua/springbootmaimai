package com.maimai.springbootlast.entity;
@FunctionalInterface
 interface IConvert<T,F> {
    T convert(F form);
}
