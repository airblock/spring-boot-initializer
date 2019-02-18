package com.example.demo;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    public String test(){
        return "test";
    }

    @Autowired
    private GraphQLProvider graphQLProvider;
    @Autowired
    private GraphQL graphQL;


    @RequestMapping("search")
    public Object search(){

        ExecutionResult bookById = graphQL.execute("bookById: book-1");
        Object data = bookById.getData();

        return data;
    }
}