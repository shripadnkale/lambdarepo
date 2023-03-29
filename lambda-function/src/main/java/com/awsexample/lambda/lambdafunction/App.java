package com.awsexample.lambda.lambdafunction;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;

public class App {
	
	public static Object handleRequest(Request request, Context context) throws ResourceNotFoundException {

		AmazonDynamoDB client =  AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		Student student = null;
		switch(request.getHttpMethod()) {
		case "GET":
			student = mapper.load(Student.class, request.getId());
			if (student == null) {
				throw new  ResourceNotFoundException("Resource not found "+request.getId());
			}
			return student;
		case "POST":	
			student = request.getStudent();
			mapper.save(student);
		default:
			break;
		
		}		
		return null;
	}
}
