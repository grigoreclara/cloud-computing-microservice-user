package ro.unibuc.fmi.dietapp.microservice.user.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}
