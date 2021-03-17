package com.Storage.Webflux.Storage.config;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;//BasicAWSCredentials is Deprecated, replaced by AWSStaticCredentialsProvider()
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;

import java.security.Key;
import java.util.Arrays;

import static com.Storage.Webflux.Storage.constants.MainConstants.ENDPOINT_DYNAMO;
import static com.Storage.Webflux.Storage.constants.MainConstants.REGION_DYNAMO;


public class MainData {
    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();


        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Main_Table");
        Item character = new Item()
                .withPrimaryKey("id", "1")
                .withString("name", "Mr 1")
                .withString("franchise", "One Piece")
                .withString("alignment", "Lawful Evil");

        Item character2 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Aslan")
                .withString("franchise", "The Chronicles of Narnia")
                .withString("alignment", "Lawful Good");

        Item character3 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Godzilla")
                .withString("franchise", "Godzilla")
                .withString("alignment", "Chaotic Neutral");

        PutItemOutcome outcome1 = table.putItem(character);
        PutItemOutcome outcome2 = table.putItem(character2);
        PutItemOutcome outcome3 = table.putItem(character3);

    }
}
