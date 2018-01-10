/**
 * Project: Visitors
 * Package: visitors
 * File: Nothing.java
 * 
 * @author sidmishraw
 *         Last modified: Jan 9, 2018 8:51:05 PM
 */
package visitors;

import java.util.function.Function;

import monads.Monad;

/**
 * @author sidmishraw
 *
 *         Qualified Name: visitors.Nothing
 *
 * @param <T>
 *            The type of data for which we have {@link Nothing}.
 */
public class Nothing<T> extends Maybe<T> {
    /**
     * 
     */
    public Nothing() {}
    
    /**
     * Accepts the visitor for {@link Nothing} instance.
     * 
     * @param visitor
     *            The visitor visiting {@link Nothing} instance.
     */
    @Override
    public void accept(MaybeVisitor<T> visitor) {
        visitor.visit(this);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see monads.Monad#shove(java.util.function.Function)
     */
    @Override
    public <R extends Monad<?>> R shove(Function<T, R> fromTtoR) {
        return fromTtoR.apply(null);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see monads.Monad#extract()
     */
    @Override
    public T extract() {
        return null;
    }
}
