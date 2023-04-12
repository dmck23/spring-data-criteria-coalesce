package com.example.spring_data_rounding;

import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.utility.DockerImageName;

public abstract class AbstractIntegrationTest {

    static final MSSQLServerContainer database;

    static {
        DockerImageName myImage  = DockerImageName.parse("mcr.microsoft.com/azure-sql-edge")
                .asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");

        database = new MSSQLServerContainer<>(myImage).acceptLicense().withInitScript("sql/init.sql");

        database.start();

        System.setProperty("spring.datasource.url", String.format("%s;%s", database.getJdbcUrl(), "database=TestDb"));
        System.setProperty("spring.datasource.password", "A_Str0ng_Required_Password");
    }

}
