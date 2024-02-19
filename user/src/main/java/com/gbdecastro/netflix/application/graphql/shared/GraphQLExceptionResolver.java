package com.gbdecastro.netflix.application.graphql.shared;

import com.gbdecastro.netflix.domain.shared.DomainException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQLExceptionResolver implements DataFetcherExceptionResolver {

    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable ex, DataFetchingEnvironment environment) {
        if (ex instanceof ConstraintViolationException constraintViolationException) {
            List<GraphQLError> errors = constraintViolationException.getConstraintViolations().stream()
                    .map(violation -> GraphqlErrorBuilder.newError()
                            .message(violation.getMessage())
                            .errorType(ErrorType.BAD_REQUEST)
                            .build())
                    .collect(Collectors.toList());
            return Mono.just(errors);
        }
        if (ex instanceof DomainException domainException) {
            GraphQLError error = GraphqlErrorBuilder.newError()
                    .message(domainException.getMessage())
                    .errorType(ErrorType.BAD_REQUEST)
                    .build();

            return Mono.just(Collections.singletonList(error));

        }
        return Mono.empty();
    }
}
