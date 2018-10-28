package com.example.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// SOURCE - only in source file (not in byte code) Examples: Override
// CLASS - in byte code, but cannot be accessed via Reflection (by default)
// RUNTIME - in byte code (in runtime)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomLevel {

    int min();

    int max();
}
