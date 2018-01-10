/**
 * Project: Visitors
 * Package: monads
 * File: Monad.java
 * 
 * @author sidmishraw
 *         Last modified: Jan 9, 2018 11:08:39 PM
 */
package monads;

import java.util.function.Function;

/**
 * The {@link Monad}.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: monads.Monad
 *
 * @param <T>
 *            The type of contents of the Monad.
 */
public interface Monad<T> {
    /**
     * Extracts the contents of this {@link Monad} instance and shoves that value into the
     * function named {@code fromTtoR}. The {@code fromTtoR} function returns another {@link Monad} instance.
     * 
     * @param fromTtoR
     *            The function that transforms the contents of this {@link Monad} instance.
     * @return The transformed {@link Monad} instance.
     */
    <R extends Monad<?>> R shove(Function<T, R> fromTtoR);
    
    /**
     * Extracts the contents of the {@link Monad} instance.
     * 
     * @return The contents of the {@link Monad} instance.
     */
    T extract();
}
