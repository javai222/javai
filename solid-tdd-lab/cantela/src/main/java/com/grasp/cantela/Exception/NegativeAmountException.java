package com.grasp.cantela.Exception;

// GRASP: Pure Fabrication — Dedicated type for a specific failure mode (invalid money / amount rules), not a domain entity.
// OOP: Custom exception — Lets callers and tests distinguish “bad amount” from ResourceNotFoundException or generic RuntimeException.
// SOLID: SRP — Represents only the “amount is not allowed” case (e.g. non-positive settlement); keeps error semantics explicit at boundaries.
// KISS — Thin wrapper around message-only RuntimeException (no extra fields until you truly need them).
public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String message) {
        super(message);
    }
}
