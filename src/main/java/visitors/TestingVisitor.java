/**
 * Project: Visitors
 * Package: visitors
 * File: TestingVisitor.java
 * 
 * @author sidmishraw
 *         Last modified: Jan 9, 2018 7:26:33 PM
 */
package visitors;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;

import monads.Monad;

/**
 * @author sidmishraw
 *
 *         Qualified Name: visitors.TestingVisitor
 *
 */
public class TestingVisitor {
    
    /**
     * Just a funky eval method that checks the type of data.
     * Returns {@code true} for {@link Just} instance and {@code false} for {@link Nothing} instance.
     * 
     * @param maybe
     *            The {@link Maybe} instance.
     * @return True or False depending on the concrete type.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T match(Maybe<T> maybe) throws Exception {
        //
        // Pattern matching simulated using Visitor Pattern.
        //
        MaybeVisitor<T> mVisitor = new MaybeVisitor<T>() {
            /**
             * The value used for holding the values for the time-being.
             */
            private T value;
            
            @Override
            public void visit(Nothing<T> nothing) {
                //
                // simulates Haskell's `Nothing -> -- stuff --`
                //
                System.out.println("Visiting a Nothing instance");
                this.value = null;
            }
            
            @Override
            public void visit(Just<T> just) {
                //
                // simulates Haskell's `(Just e) -> -- do stuff --`
                //
                System.out.println("Visiting a Just instance with value = " + just.getTheValue());
                this.value = just.getTheValue();
            }
            
            @SuppressWarnings("unused")
            public T getValue() {
                return this.value;
            }
        };
        //
        // simulates Haskell's `case t of`
        //
        maybe.accept(mVisitor);
        return (T) mVisitor.getClass().getMethod("getValue").invoke(mVisitor);
    }
    
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("---Testing Visitor Pattern---");
        Maybe<Integer> t = new Just<Integer>(56);
        Maybe<Integer> y = new Nothing<Integer>();
        System.out.println(match(t));
        System.out.println(match(y));
    }
    
    //
    // Monad API tests
    //
    
    /**
     * Tests Monads' {@linkplain Monad#shove(java.util.function.Function)} API.
     * 
     * @throws Exception
     */
    @Test
    public void tstMonadMaybeShoves() throws Exception {
        //
        // A Maybe Monad.
        //
        Maybe<Integer> a = new Just<>(3);
        //
        // Transformations using Monads.
        //
        Integer result =
                a
                        //
                        // Transform #1
                        //
                        .shove(v -> {
                            try {
                                return new Just<Integer>(v + 53);
                            } catch (Exception e) {
                                e.printStackTrace();
                                return new Nothing<Integer>();
                            }
                        })
                        //
                        // Transform #2
                        //
                        .shove(v -> {
                            if (Objects.isNull(v)) {
                                return new Nothing<Integer>();
                            }
                            try {
                                return new Just<Integer>(v - 3);
                            } catch (Exception e) {
                                e.printStackTrace();
                                return new Nothing<Integer>();
                            }
                        })
                        //
                        // Extract contents of the Maybe Monad instance.
                        //
                        .extract();
        //
        // Assertion.
        //
        assertEquals(53, result.intValue());
    }
    
    /**
     * Tests Monads' extract APIs.
     * 
     * @throws Exception
     */
    @Test
    @SuppressWarnings({ "unused" })
    public void tstMonadMaybeExtracts() throws Exception {
        Maybe<Integer> b = new Just<>(5);
        Maybe<Integer> c = new Nothing<Integer>();
        Integer b_ = b.extract();
        Integer c_ = c.extract();
        try {
            Integer __b = b_ + c_;
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }
}
