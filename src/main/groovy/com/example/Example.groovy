package com.example

import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import net.sf.json.JSON

class Example {
    static void main(String[] args) {
        def client = new RESTClient("https://jsonplaceholder.typicode.com/")

        // http://stackoverflow.com/a/19552452/4642316
        client.handler.failure = client.handler.success

        HttpResponseDecorator response =
                client.get(path: "posts/1", requestContentType: JSON, query: [:], /*body: [:],*/ headers: [:])

        println response.getData()
    }

}
