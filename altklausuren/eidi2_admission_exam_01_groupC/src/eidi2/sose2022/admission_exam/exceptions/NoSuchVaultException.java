package eidi2.sose2022.admission_exam.exceptions;

public class NoSuchVaultException extends RuntimeException {
    public NoSuchVaultException(String reason) {
        super("NoSuchVaultException: " + reason);
    }
}
