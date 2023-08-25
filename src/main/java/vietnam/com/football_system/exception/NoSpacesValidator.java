//package vietnam.com.football_system.exception;
//
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//public class NoSpacesValidator implements ConstraintValidator<NoSpaces, String> {
//    @Override
//    public void initialize(NoSpaces constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
//        if(value == null){
//            return true;
//        }
//        return !value.contains(" ");
//    }
//}
