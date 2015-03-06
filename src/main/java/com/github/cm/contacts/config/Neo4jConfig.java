package com.github.cm.contacts.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.http.HttpStatus;

/**
 * Created by Ye Yan on 6/03/15.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.github.cm.contacts.db")
public class Neo4jConfig extends Neo4jConfiguration {

    public Neo4jConfig () {
        setBasePackage("com.github.cm.contacts");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("/tmp/graphdb");
    }

}
