/**
 * Project: Visitors
 * Package: visitors
 * File: Just.java
 * 
 * @author sidmishraw
 *         Last modified: Jan 9, 2018 9:05:01 PM
 */
package visitors;

import java.util.Objects;
import java.util.function.Function;

import lombok.Getter;
import monads.Monad;

/**
 * {@link Just} some value. Represents the concrete value of type T.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: visitors.Just
 *
 * @param <T>
 *            The concrete value of type T.
 */
public class Just<T> extends Maybe<T> {
    
    /**
     * The concrete value of type T.
     */
    private @Getter T theValue;
    
    /**
     * Creates a new {@link Just} instance holding the given value.
     * 
     * @param val
     *            The concrete value.
     */
    public Just(T val) throws Exception {
        if (Objects.isNull(val)) {
            throw new Exception("Concrete Values only!");
        }
        this.theValue = val;
    }
    
    /**
     * Accepts the visitor that is visiting this instance.
     * 
     * @param visitor
     *            The visitor visiting this {@link Just} instance.
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
        return fromTtoR.apply(this.theValue);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see monads.Monad#extract()
     */
    @Override
    public T extract() {
        return this.theValue;
    }
}
