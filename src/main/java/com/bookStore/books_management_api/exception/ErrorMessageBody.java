package com.bookStore.books_management_api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ErrorMessageBody {

    private HttpStatus status;
    private String message;

}