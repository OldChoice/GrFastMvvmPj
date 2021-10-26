package com.free.grfastmvvm.binding.command;

import com.free.grfastmvvm.R;

/**
 * Represents a function with zero arguments.
 *
 * @param <T> the result type
 */
public interface BindingFunction<T> {
    T call();
}
