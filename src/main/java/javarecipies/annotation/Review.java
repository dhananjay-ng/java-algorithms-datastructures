package javarecipies.annotation;

public @interface Review {
    ReviewStatus status() default ReviewStatus.PENDING;
    String comments() default "";
    enum ReviewStatus { PENDING, FAILED, PASSED, PASSEDWITHCHANGES}
}
