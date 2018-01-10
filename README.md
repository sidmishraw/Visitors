# Pattern Matching in Java using Visitor Design Pattern

\- Sid

## Motivation

Simulate Haskell like Algebraic Data Types and pattern matching in Java. Follow it up with Monads.

```haskell
test :: Maybe Int -> Int
test x = case x of
	Nothing -> error "Nothing"
	(Just y) -> y
```

```java
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
public static <T> T test(Maybe<T> maybe) throws Exception {
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
```

## Verdict

* Java version is very verbose. 

* Scala's case classes are very good for this scenario. I might move over to Scala to design Monads and Pattern matching DSLs.