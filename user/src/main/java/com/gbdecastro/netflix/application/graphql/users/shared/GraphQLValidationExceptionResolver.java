package com.gbdecastro.netflix.application.graphql.users.shared;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.stereotype.Component;
import org.springframework.graphql.execution.ErrorType;

import jakarta.validation.ConstraintViolationException;
import graphql.schema.DataFetchingEnvironment;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQLValidationExceptionResolver implements DataFetcherExceptionResolver {

    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable ex, DataFetchingEnvironment environment) {
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex;
            List<GraphQLError> errors = constraintViolationException.getConstraintViolations().stream()
                    .map(violation -> GraphqlErrorBuilder.newError()
                            .message(violation.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .build())
                    .collect(Collectors.toList());
            return Mono.just(errors);
        }
        return Mono.empty();
    }
}
