/**
 * Project: Visitors
 * Package: visitors
 * File: MaybeVisitor.java
 * 
 * @author sidmishraw
 *         Last modified: Jan 9, 2018 8:43:31 PM
 */
package visitors;

/**
 * {@code MaybeVisitor<T>} is the visitor.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: visitors.MaybeVisitor
 *
 * @param <T>
 */
public interface MaybeVisitor<T> {
    
    /**
     * Visited an instance of {@link Nothing}.
     * 
     * @param nothing
     *            The {@link Nothing} instance being visited.
     */
    void visit(Nothing<T> nothing);
    
    /**
     * Visited an instance of {@link Just}.
     * 
     * @param just
     *            The {@link Just} instance being visited.
     */
    void visit(Just<T> just);
}
