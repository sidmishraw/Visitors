/**
 * Project: Visitors
 * Package: visitors
 * File: Maybe.java
 * 
 * @author sidmishraw
 *         Last modified: Jan 9, 2018 8:40:06 PM
 */
package visitors;

import monads.Monad;

/**
 * <p>
 * 
 * </p>
 * 
 * @author sidmishraw
 *
 *         Qualified Name: visitors.Maybe
 *
 */
public abstract class Maybe<T> implements Monad<T> {
    
    /**
     * Used to accept the visitors that are visiting the {@link Maybe} instance.
     * 
     * @param visitor
     *            The visitor visiting this {@link Maybe} instance.
     */
    public abstract void accept(MaybeVisitor<T> visitor);
}
